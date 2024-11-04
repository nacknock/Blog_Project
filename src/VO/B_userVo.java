package VO;

public class B_userVo {
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	private int idx;
	private String user_id;
	private String pw;
	private String email;
	private String nickname;
	private int role;
	private String created_at;
	private String modified_at;
	private String img_path;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getModified_at() {
		return modified_at;
	}
	public void setModified_at(String modified_at) {
		this.modified_at = modified_at;
	}
	public String getLogin_at() {
		return login_at;
	}
	public void setLogin_at(String login_at) {
		this.login_at = login_at;
	}
	public String getLogout_at() {
		return logout_at;
	}
	public void setLogout_at(String logout_at) {
		this.logout_at = logout_at;
	}
	private String login_at;
	private String logout_at;
	
}
