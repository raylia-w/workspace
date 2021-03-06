package mvc.dto;

import java.util.Date;

public class UploadFile {
	private int boardNo;
	private int fileno;
	private String original_filename;
	private String stored_filename;
	private long file_size;
	private Date upload_date;

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getFileno() {
		return fileno;
	}
	public void setFileno(int fileno) {
		this.fileno = fileno;
	}
	public String getOriginal_filename() {
		return original_filename;
	}
	public void setOriginal_filename(String original_filename) {
		this.original_filename = original_filename;
	}
	public String getStored_filename() {
		return stored_filename;
	}
	public void setStored_filename(String stored_filename) {
		this.stored_filename = stored_filename;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	
	@Override
	public String toString() {
		return "fileNo : "+fileno+" | stored_filename : "+stored_filename+" | original_filename : "+original_filename+" | filesize : "+file_size+" | upload date : "+upload_date;
	}
}
