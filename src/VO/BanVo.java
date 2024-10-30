package VO;

public class BanVo {
	private int ban_id;
	private int total;
	private String reason;
	private String start_date;
	private String end_date;
	private int ban_user;
	public int getBan_id() {
		return ban_id;
	}
	public void setBan_id(int ban_id) {
		this.ban_id = ban_id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getBan_user() {
		return ban_user;
	}
	public void setBan_user(int ban_user) {
		this.ban_user = ban_user;
	}
}