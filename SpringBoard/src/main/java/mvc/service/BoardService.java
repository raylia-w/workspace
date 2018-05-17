package mvc.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mvc.dao.BoardDao;
import mvc.dao.FileDao;
import mvc.dto.Board;
import mvc.dto.Comments;
import mvc.dto.UploadFile;
import mvc.dto.User;
import mvc.util.Paging;

@Service
public class BoardService {
	
	@Autowired BoardDao boardDao;
	@Autowired FileDao fileDao;
	
	public List getList() {
		return boardDao.selectAll();
	}
	
	public int getTotal() {
		return boardDao.getTotal();
	}
	
	public List getPagingList(Paging paging) {
		return boardDao.getPagingList(paging);
	}
	
	public int write(Board board) {
		return boardDao.write(board);
	}
	
	public Board boardView(Board board) {
		return boardDao.boardView(board);
	}
	
	public void updateHit(Board board) {
		boardDao.updateHit(board);
	}
	
	public void deleteBoard(Board board) {
		boardDao.deleteBoard(board);
	}
	
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}
	
	public int recommendSelect(Board board) {
		return boardDao.recommendSelect(board);
	}
	
	public void recommendProc(Board board) {
		boardDao.recommendProc(board);
	}
	
	public void recommendBoard(Board board) {
		boardDao.recommendBoard(board);
	}
	
	public int getSearchTotal(String keyword) {
		return boardDao.getSearchTotal(keyword);
	}
	
	public List search(HashMap<String, Object> map) {
		return boardDao.getSearchResult(map);
	}
	
	public void insertComments(Comments comments) {
		boardDao.insertComments(comments);
	}
	
	public List selectComments(Board board) {
		return boardDao.selectComments(board);
	}
	
	public boolean deleteComment(Comments comments) {
		boardDao.deleteComment(comments); 
		
		if( boardDao.countComment(comments) > 0 ) {
			return false;
		} else {
			return true;
		}
	}
	
	public void boardListDelete(String names) {
		boardDao.deleteBoardList(names);
		
	}
	
	public void insertFile(UploadFile file) {
		boardDao.insertFile(file);
	}
	
	public UploadFile selectFile(Board board) {
		return boardDao.selectFile(board);
	}
	
	public String getStoredFileName(UploadFile boardFile) {
		return boardDao.getStoredFileName(boardFile);
	}
	
}
