package util;

public class Criteria {
	
	private int pageNum;//��������ȣ
	private int amount;//1������ ����ϴ� ���ڵ� ����
	private String type;//�˻� ���� title, content
	private String keyword;//�˻� Ű����
	
	public Criteria() {
		this(1,5);
	}
	public Criteria(int pageNum,int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
