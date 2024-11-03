package VO;

public class PostVo {
	
	private int p_idx;
	private String p_title;
	private String p_content;
	private int p_private;
	private String created_at;
	private String modified_at;
	private int hit;
	private int p_b_idx;
	private int p_ctgr;
	private String img_path;
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public int getP_private() {
		return p_private;
	}
	public void setP_private(int p_private) {
		this.p_private = p_private;
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getP_b_idx() {
		return p_b_idx;
	}
	public void setP_b_idx(int p_b_idx) {
		this.p_b_idx = p_b_idx;
	}
	public int getP_ctgr() {
		return p_ctgr;
	}
	public void setP_ctgr(int p_ctgr) {
		this.p_ctgr = p_ctgr;
	}
}