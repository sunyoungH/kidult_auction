package kr.co.kidultAuction.vo;

public class AdminItemPriceVO {
	private String user_id, bid_date;
	private int bid_price;
	public AdminItemPriceVO() {
		super();
	}
	public AdminItemPriceVO(String user_id, String bid_date, int bid_price) {
		super();
		this.user_id = user_id;
		this.bid_date = bid_date;
		this.bid_price = bid_price;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBid_date() {
		return bid_date;
	}
	public void setBid_date(String bid_date) {
		this.bid_date = bid_date;
	}
	public int getBid_price() {
		return bid_price;
	}
	public void setBid_price(int bid_price) {
		this.bid_price = bid_price;
	}
	@Override
	public String toString() {
		return "AdminItemPriceVO [user_id=" + user_id + ", bid_date=" + bid_date + ", bid_price=" + bid_price + "]";
	}
	
	

}
