package VO;

public class BlockVo {
	private int bl_idx;
	private String blocker;
	private String blocked;
	public int getBl_idx() {
		return bl_idx;
	}
	public void setBl_idx(int bl_idx) {
		this.bl_idx = bl_idx;
	}
	public String getBlocker() {
		return blocker;
	}
	public void setBlocker(String blocker) {
		this.blocker = blocker;
	}
	public String getBlocked() {
		return blocked;
	}
	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}
}