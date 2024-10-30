package VO;

public class AnswerVo {
	private int a_idx;
	private String a_content;
	private String created_at;
	private int raiting;
	private int a_q_idx;
	public int getA_idx() {
		return a_idx;
	}
	public void setA_idx(int a_idx) {
		this.a_idx = a_idx;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getRaiting() {
		return raiting;
	}
	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}
	public int getA_q_idx() {
		return a_q_idx;
	}
	public void setA_q_idx(int a_q_idx) {
		this.a_q_idx = a_q_idx;
	}
}