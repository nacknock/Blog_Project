package VO;

public class BlogVo {
	public int getR_cnt() {
		return r_cnt;
	}
	public void setR_cnt(int r_cnt) {
		this.r_cnt = r_cnt;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public int getP_cnt() {
		return p_cnt;
	}
	public void setP_cnt(int p_cnt) {
		this.p_cnt = p_cnt;
	}
	public int getB_hit() {
		return b_hit;
	}
	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
	public int getP_pri_yn() {
		return p_pri_yn;
	}
	public void setP_pri_yn(int p_pri_yn) {
		this.p_pri_yn = p_pri_yn;
	}
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
	private int p_pri_yn;
	private int p_cnt;
	private int b_hit;
	private int b_num;
	private int r_cnt;
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