package VO;

public class B_replyVo {
	private int r_idx;
	private String r_content;
	private String created_at;
	private String modified_at;
	private B_userVo r_u_idx;
	private PostVo r_p_idx;
	private int r_grade;
	private B_replyVo r_parent;
	public int getR_idx() {
		return r_idx;
	}
	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
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
	public B_userVo getR_u_idx() {
		return r_u_idx;
	}
	public void setR_u_idx(B_userVo r_u_idx) {
		this.r_u_idx = r_u_idx;
	}
	public PostVo getR_p_idx() {
		return r_p_idx;
	}
	public void setR_p_idx(PostVo r_p_idx) {
		this.r_p_idx = r_p_idx;
	}
	public int getR_grade() {
		return r_grade;
	}
	public void setR_grade(int r_grade) {
		this.r_grade = r_grade;
	}
	public B_replyVo getR_parent() {
		return r_parent;
	}
	public void setR_parent(B_replyVo r_parent) {
		this.r_parent = r_parent;
	}
	
}
