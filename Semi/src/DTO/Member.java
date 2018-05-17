package DTO;

public class Member {
	
	private String ID;
	private String password;
	private String uName;
	private String uPNo;
	private String uAddr;
	private String uEmail;
	private String uNick;
	private int uGender;
	private int uGrade;
	private String uId;
	private int uNo;
	
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPNo() {
		return uPNo;
	}
	public void setuPNo(String uPNo) {
		this.uPNo = uPNo;
	}
	public String getuAddr() {
		return uAddr;
	}
	public void setuAddr(String uAddr) {
		this.uAddr = uAddr;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuNick() {
		return uNick;
	}
	public void setuNick(String uNick) {
		this.uNick = uNick;
	}
	public int getuGender() {
		return uGender;
	}
	public void setuGender(int uGender) {
		this.uGender = uGender;
	}
	public int getuGrade() {
		return uGrade;
	}
	public void setuGrade(int uGrade) {
		this.uGrade = uGrade;
	}
	
}
