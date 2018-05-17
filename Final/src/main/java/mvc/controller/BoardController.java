package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService service;
	
	@RequestMapping(value="/group/board.do")
	public void groupBoard() {
		service.getBoardList();
	}
	
	@RequestMapping(value="/group/board/detail.do")
	public void groupBoardDetail() {
		service.getBoardView();
	}
	
	@RequestMapping(value="/group/board/write.do")
	public void groupBoardWrite() {
		service.boardWrite();
	}
	
	@RequestMapping(value="/group/board/mod.do")
	public void groupBoardMod() {
		service.boardMod();
	}
	
	@RequestMapping(value="/group/board/delete.do")
	public void groupBoardDelete() {
		service.boardDelete();
	}
	
	@RequestMapping(value="/group/notice.do")
	public void groupNotice() {
		service.getNoticeList();
	}
	
	@RequestMapping(value="/group/notice/detail.do")
	public void groupNoticeDetail() {
		service.getNoticeView();
	}
	
	@RequestMapping(value="/group/notice/write.do")
	public void groupNoticeWrite() {
		service.noticeWrite();
	}
	
	@RequestMapping(value="/group/notice/mod.do")
	public void groupNoticeMod() {
		service.noticeMod();
	}
	
	@RequestMapping(value="/group/notice/delete.do")
	public void groupNoticeDelete() {
		service.noticeDelete();
	}
	
	@RequestMapping(value="/group/photo.do")
	public void groupPhoto() {
		service.getPhotoList();
	}
	
	@RequestMapping(value="/group/photo/detail.do")
	public void groupPhotoDetail() {
		service.getPhotoView();
	}
	
	@RequestMapping(value="/group/photo/upload.do")
	public void groupPhotoUpload() {
		service.photoUpload();
	}
	
	@RequestMapping(value="/group/photo/delete.do")
	public void groupPhotoDelete() {
		service.photoDelete();
	}
	
}
