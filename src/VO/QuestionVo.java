package VO;

public class QuestionVo {
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getQ_num() {
		return q_num;
	}
	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}
	private int q_idx;
	private int q_ctgr;
	private String q_title;
	private String q_content;
	private int a_yn;
	private String created_at;
	private int q_u_idx;
	private String user_id;
	private String q_img;
	private String a_content;
	private int q_num;
	public int getQ_idx() {
		return q_idx;
	}
	public void setQ_idx(int q_idx) {
		this.q_idx = q_idx;
	}
	public int getQ_ctgr() {
		return q_ctgr;
	}
	public void setQ_ctgr(int q_ctgr) {
		this.q_ctgr = q_ctgr;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public int getA_yn() {
		return a_yn;
	}
	public void setA_yn(int a_yn) {
		this.a_yn = a_yn;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getQ_u_idx() {
		return q_u_idx;
	}
	public void setQ_u_idx(int q_u_idx) {
		this.q_u_idx = q_u_idx;
	}
	public String getQ_img() {
		return q_img;
	}
	public void setQ_img(String q_img) {
		this.q_img = q_img;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
}