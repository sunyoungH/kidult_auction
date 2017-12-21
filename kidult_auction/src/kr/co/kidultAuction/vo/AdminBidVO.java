package kr.co.kidultAuction.vo;

public class AdminBidVO {
	private String user_id, auc_code, item_name, start_date, bid_end_date;
	private int bid_price, start_price;
	
	public AdminBidVO() {
		super();
	}

	public AdminBidVO(String user_id, String auc_code, String item_name, String start_date, String bid_end_date,
			int bid_price, int start_price) {
		super();
		this.user_id = user_id;
		this.auc_code = auc_code;
		this.item_name = item_name;
		this.start_date = start_date;
		this.bid_end_date = bid_end_date;
		this.bid_price = bid_price;
		this.start_price = start_price;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getAuc_code() {
		return auc_code;
	}

	public void setAuc_code(String auc_code) {
		this.auc_code = auc_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getBid_end_date() {
		return bid_end_date;
	}

	public void setBid_end_date(String bid_end_date) {
		this.bid_end_date = bid_end_date;
	}

	public int getBid_price() {
		return bid_price;
	}

	public void setBid_price(int bid_price) {
		this.bid_price = bid_price;
	}

	public int getStart_price() {
		return start_price;
	}

	public void setStart_price(int start_price) {
		this.start_price = start_price;
	}


	
	
}
