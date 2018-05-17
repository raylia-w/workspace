package mvc.dao;

import mvc.dto.UploadFile;

public interface FileDao {
	/**
	 * 파일 업로드 기록
	 * @param uploadFile - 업로드한 파일의 정보
	 * 		property : original_filename - 원본파일명
	 * 		property : stored_filename - 저장파일명
	 * 		property : file_size - 파일 크기
	 */
	public void insert(UploadFile uploadFile);
}
