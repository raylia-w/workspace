package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mvc.DAO.MeetingDAO;
import mvc.DTO.Meeting_reservation;

public class MeetingServiceImpl implements MeetingService{

	@Autowired MeetingDAO dao;
	
	@Override
	public List getMeetingList() {
		return dao.getMeetingList();
	}
	
	@Override
	public Meeting_reservation getMeetingInfo() {
		return dao.getMeetingInfo();
	}

	@Override
	public void insertMeeting() {
		dao.insertMeeting();
	}

	@Override
	public void updateMeeting() {
		dao.updateMeeting();
	}

	@Override
	public void deleteMeeting() {
		dao.deleteMeeting();
	}

}
