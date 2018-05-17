package mvc.service;

import java.util.List;

import mvc.DTO.Board;
import mvc.DTO.Groups;

public interface GroupService {
	
	public List getGroupList();
	
	public Groups getGroupInfo();
	
	public void memberRegistration();
	
	public void memberSecession();
	
	public void createGroup();
	
	public void deleteGroup();
	
	
}
