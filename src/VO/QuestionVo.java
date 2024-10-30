package VO;

public class QuestionVo {
	private int q_idx;
	private int q_ctgr;
	private String q_title;
	private String q_content;
	private int a_yn;
	private String created_at;
	private int q_u_idx;
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
}