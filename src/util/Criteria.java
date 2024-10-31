package util;

public class Criteria {
	
	private int pageNum;//페이지번호
	private int amount;//1페이지 출력하는 레코드 개수
	private String type;//검색 조건 title, content
	private String keyword;//검색 키워드
	
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
