package DTO;

import java.util.ArrayList;

public class PageDTO {
	
    ArrayList<PostDTO> list ;
    int curPage;
	int perPage = 5;
	int totalPost;
	
	public ArrayList<PostDTO> getList() {
		return list;
	}
	public void setList(ArrayList<PostDTO> list) {
		this.list = list;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalPost() {
		return totalPost;
	}
	public void setTotalPost(int totalPost) {
		this.totalPost = totalPost;
	}
	
}
