package kr.co.kidultAuction.vo;

public class AdminBidVO {
	private String user_id, auc_code, item_name, category, permit_date, ended_date;
	private int bid_price, start_price;
	public AdminBidVO() {
		super();
	}
	public AdminBidVO(String user_id, String auc_code, String item_name, String category, String permit_date,
			String ended_date, int bid_price, int start_price) {
		super();
		this.user_id = user_id;
		this.auc_code = auc_code;
		this.item_name = item_name;
		this.category = category;
		this.permit_date = permit_date;
		this.ended_date = ended_date;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPermit_date() {
		return permit_date;
	}
	public void setPermit_date(String permit_date) {
		this.permit_date = permit_date;
	}
	public String getEnded_date() {
		return ended_date;
	}
	public void setEnded_date(String ended_date) {
		this.ended_date = ended_date;
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
	@Override
	public String toString() {
		return "AdminBidVO [user_id=" + user_id + ", auc_code=" + auc_code + ", item_name=" + item_name + ", category="
				+ category + ", permit_date=" + permit_date + ", ended_date=" + ended_date + ", bid_price=" + bid_price
				+ ", start_price=" + start_price + "]";
	}
	
	
}
