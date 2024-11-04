package DTO;

import VO.B_userVo;
import VO.BlogVo;

public class ManageUserDTO {
	public B_userVo getUser() {
		return user;
	}
	public void setUser(B_userVo user) {
		this.user = user;
	}
	public BlogVo getBlog() {
		return blog;
	}
	public void setBlog(BlogVo blog) {
		this.blog = blog;
	}
	private B_userVo user;
	private BlogVo blog;
}
