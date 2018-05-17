package web.dto;

import java.util.Date;

public class Member {
	private int idx;
	private String name;
	private String email;
	private String phone;
	private Date join_date;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getjoin_date() {
		return join_date;
	}
	public void setjoin_date(Date join_date) {
		this.join_date = join_date;
	}
	
	@Override
	public String toString() {
		return "member idx : "+idx+" , name : "+name+", email : "+email+", phone : "+phone+", join date : "+join_date;
	}
	
}
