package mvc.DAO;

import java.util.List;

import mvc.DTO.Board;
import mvc.DTO.Groups;

public interface GroupDAO {
		
	public List getGroupList();
	
	public Groups getGroupInfo();

	public void createGroup();
	
	public void deleteGroup();
	
	public void memberRegistration();
	
	public void memberSecession(); 
	
}
