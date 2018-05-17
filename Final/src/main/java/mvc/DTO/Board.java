package mvc.DTO;

import lombok.Data;

@Data
public class Board {

	private int board_no;

	private String title;
	
	private String content;
	
	private String user_nick;

	private String written_date;

	private int hit;

	private int recommend;

	private int group_no;
}
