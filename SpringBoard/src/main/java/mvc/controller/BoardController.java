package mvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mvc.dto.Board;
import mvc.dto.Comments;
import mvc.dto.UploadFile;
import mvc.service.BoardService;
import mvc.util.Paging;

@Controller
public class BoardController {
	
	@Autowired ServletContext context;
	@Autowired BoardService boardService;
	
	@RequestMapping(value="/board/list.do", method=RequestMethod.GET)
	public String list(
			@RequestParam(value="pageNo", defaultValue="0") int curPage
			, Model model, HttpSession session) {
		String nick=(String) session.getAttribute("usernick");
		session.setAttribute("writer", nick);

		int totalCount = boardService.getTotal();
		Paging paging = new Paging(totalCount, curPage);
		model.addAttribute("paging", paging);

		List list = boardService.getPagingList(paging);
		model.addAttribute("list", list);

		return "board/list";
	}
	
	@RequestMapping(value="/board/write.do", method=RequestMethod.GET)
	public String write(HttpSession session) {

		return "board/write";
	}
	
	@RequestMapping(value="/board/write.do", method=RequestMethod.POST)
	public String writeProc(Board board, MultipartFile file) {
		
		boardService.write(board);
		int boardNo = board.getBoardNo();
		if(!file.isEmpty()) {
			
			String uID = UUID.randomUUID().toString().split("-")[0];
			String realpath = context.getRealPath("upload");
			String stored = file.getOriginalFilename()+"-"+uID;
			System.out.println(realpath);
			File dest = new File(realpath, stored);
			
			try {
				file.transferTo(dest);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			UploadFile uploadFile = new UploadFile();
			uploadFile.setBoardNo(boardNo);
			uploadFile.setOriginal_filename(file.getOriginalFilename());
			uploadFile.setStored_filename(stored);
			uploadFile.setFile_size(file.getSize());
			
			boardService.insertFile(uploadFile);
		}
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/board/writeFail.do")
	public String fail() {
		return "board/writeFail";
	}
	
	@RequestMapping(value="/board/view.do")
	public String view(Board board, Model model) {
		boardService.updateHit(board);
		model.addAttribute("boardFile",  boardService.selectFile(board));
		model.addAttribute("list", boardService.selectComments(board));
		model.addAttribute("board", boardService.boardView(board));
		return "board/view";
	}
	
	@RequestMapping(value="/board/update.do", method=RequestMethod.GET)
	public String update(Board board, Model model) {
		model.addAttribute("board", boardService.boardView(board));
		return "board/update";
	}
	
	@RequestMapping(value="/board/update.do", method=RequestMethod.POST)
	public String updateProc(Board board) {
		boardService.updateBoard(board);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/board/delete.do")
	public String delete(Board board) {
		boardService.deleteBoard(board);
		return "redirect:/board/list.do";
	}
	
	@ResponseBody
	@RequestMapping(value="/board/recommendCheck.do", method=RequestMethod.POST)
	public String recommendCheck(Board board) {
		if(boardService.recommendSelect(board)>0){
			return "false";
		}
		return "true";
	}
	
	@RequestMapping(value="/board/recommend.do")
	public String recommend(Board board, HttpSession session) {

		boardService.recommendProc(board);
		boardService.recommendBoard(board);

		return "redirect:/board/view.do?boardNo="+board.getBoardNo();
	}
	
	@RequestMapping(value="/board/search.do", method=RequestMethod.GET)
	public String search(@RequestParam(value="pageNo", defaultValue="0") int curPage
			,String keyword, Model model) {
		int searchTotal = boardService.getSearchTotal(keyword);
		Paging paging = new Paging(searchTotal, curPage);
		HashMap<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("paging", paging);
		model.addAttribute("list", boardService.search(map));
		model.addAttribute("keyword", keyword);
		model.addAttribute("paging", paging);
//			System.out.println(paging.toString());
		return "board/search";
	}
	
//	@RequestMapping(value="/board/search.do", method=RequestMethod.POST)
//	
//	}
	
	@RequestMapping(value="/board/comments.do", method=RequestMethod.POST)
	public String comments(Comments comments) {
		boardService.insertComments(comments);
		return "redirect:/board/view.do?boardNo="+comments.getBoardNo();
	}
	
	@RequestMapping(value="/board/deleteComment.do"
			, method=RequestMethod.POST)
	public void deleteComment(Comments comments, Writer out) {
		
		boolean success = boardService.deleteComment(comments);;
		
		try {
			out.append("{\"success\":"+success+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/board/deleteList.do"
			, method=RequestMethod.POST)
	public String deleteList(String names) {
		
		if( !"".equals(names) && names != null) {
			boardService.boardListDelete(names);
		}
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/board/download.do", method=RequestMethod.GET)
	public ModelAndView download(UploadFile boardFile) {
		String path = context.getRealPath("upload");
		String filename = boardService.getStoredFileName(boardFile);
		File file = new File(path, filename);
		return new ModelAndView("download", "downFile", file);
	}

}









