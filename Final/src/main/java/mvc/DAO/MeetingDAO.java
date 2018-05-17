package mvc.DAO;

import java.util.List;

import mvc.DTO.Meeting_reservation;

public interface MeetingDAO {
	
	public List getMeetingList();
	
	public Meeting_reservation getMeetingInfo();
	
	public void insertMeeting();
	
	public void updateMeeting();
	
	public void deleteMeeting();
}
