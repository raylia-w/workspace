package mvc.DTO;

import lombok.Data;

@Data
public class Photo {
	
	private int photo_no;
	
	private String stored_name;
	
	private String original_name;
	
	private int file_size;
	
	private String upload_date;
	
	private String user_nick;
	
	private int group_no;
	
}
