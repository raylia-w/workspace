package mvc.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import mvc.dto.Board;
import mvc.dto.Comments;
import mvc.dto.UploadFile;
import mvc.dto.User;
import mvc.util.Paging;

public interface BoardDao {
	public List selectAll();
	public int getTotal();
	public List getPagingList(Paging paging);
	public int write(Board board);
	public Board boardView(Board boardNo);
	public void updateHit(Board board);
	public void updateBoard(Board board);
	public void deleteBoard(Board board);
	public int recommendSelect(Board board);
	public void recommendProc(Board board);
	public void recommendBoard(Board board);
	public int getSearchTotal(String keyword);
	public List getSearchResult(HashMap<String, Object> map);
	public void insertComments(Comments comments);
	public List selectComments(Board board);
	public boolean deleteComment(Comments comments);
	public void deleteBoardList(String names);
	public int countComment(Comments comments);
	public void insertFile(UploadFile file);
	public UploadFile selectFile(Board board);
	public String getStoredFileName(UploadFile file);
}
