package kr.co.kidultAuction.vo;

public class AddBidVO {
	String auction_code, user_id;
	int bid_price;
	public AddBidVO() {
		super();
	}
	public AddBidVO(String auction_code, String user_id, int bid_price) {
		super();
		this.auction_code = auction_code;
		this.user_id = user_id;
		this.bid_price = bid_price;
	}
	public String getAuction_code() {
		return auction_code;
	}
	public void setAuction_code(String auction_code) {
		this.auction_code = auction_code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getBid_price() {
		return bid_price;
	}
	public void setBid_price(int bid_price) {
		this.bid_price = bid_price;
	}
	@Override
	public String toString() {
		return "AddBidVO [auction_code=" + auction_code + ", user_id=" + user_id + ", bid_price=" + bid_price + "]";
	}
}
