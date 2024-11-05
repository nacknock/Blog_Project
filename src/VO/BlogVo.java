package VO;

public class BlogVo {
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	private int b_idx;
	private String one_liner;
	private String b_title;
	private String created_at;
	private String header_clr;
	private String nav_clr;
	private String body_clr;
	private String img_path;
	private int b_u_idx;
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public String getOne_liner() {
		return one_liner;
	}
	public void setOne_liner(String one_liner) {
		this.one_liner = one_liner;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getHeader_clr() {
		return header_clr;
	}
	public void setHeader_clr(String header_clr) {
		this.header_clr = header_clr;
	}
	public String getNav_clr() {
		return nav_clr;
	}
	public void setNav_clr(String nav_clr) {
		this.nav_clr = nav_clr;
	}
	public String getBody_clr() {
		return body_clr;
	}
	public void setBody_clr(String body_clr) {
		this.body_clr = body_clr;
	}
	public int getB_u_idx() {
		return b_u_idx;
	}
	public void setB_u_idx(int b_u_idx) {
		this.b_u_idx = b_u_idx;
	}
}