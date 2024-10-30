package VO;

public class ImgVo {
	private int img_id;
	private String img_path;
	private int user_img;
	private int post_img;
	public int getImg_id() {
		return img_id;
	}
	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public int getUser_img() {
		return user_img;
	}
	public void setUser_img(int user_img) {
		this.user_img = user_img;
	}
	public int getPost_img() {
		return post_img;
	}
	public void setPost_img(int post_img) {
		this.post_img = post_img;
	}
	public int getBlog_img() {
		return blog_img;
	}
	public void setBlog_img(int blog_img) {
		this.blog_img = blog_img;
	}
	public int getQ_img() {
		return q_img;
	}
	public void setQ_img(int q_img) {
		this.q_img = q_img;
	}
	private int blog_img;
	private int q_img;
}