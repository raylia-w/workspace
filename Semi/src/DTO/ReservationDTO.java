package DTO;

import java.sql.Date;

public class ReservationDTO {
	private String res_id; // 예약한 날짜의 예약순번
	private String u_id; // 예약한 회원의 아이디
	private String s_id_no; // 예약한 음식점
	private String res_time; // 예약한 시간
	private String res_person; // 예약 인원
	private String s_name; // 가게 이름
	private String imp_uid;
	private String res_date;
	
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}
	public String getImp_uid() {
		return imp_uid;
	}
	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getRes_id() {
		return res_id;
	}
	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getS_id_no() {
		return s_id_no;
	}
	public void setS_id_no(String s_id_no) {
		this.s_id_no = s_id_no;
	}
	public String getRes_time() {
		return res_time;
	}
	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}
	public String getRes_person() {
		return res_person;
	}
	public void setRes_person(String res_person) {
		this.res_person = res_person;
	}
	
}
