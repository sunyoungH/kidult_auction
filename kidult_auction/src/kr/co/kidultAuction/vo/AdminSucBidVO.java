package kr.co.kidultAuction.vo;

public class AdminSucBidVO {
	private String user_id, item_name, auc_code, start_date, ended_date;
	private int ended_price, start_price;
	
	public AdminSucBidVO() {
		super();
	}

	public AdminSucBidVO(String user_id, String item_name, String auc_code, String start_date, String ended_date,
			int ended_price, int start_price) {
		super();
		this.user_id = user_id;
		this.item_name = item_name;
		this.auc_code = auc_code;
		this.start_date = start_date;
		this.ended_date = ended_date;
		this.ended_price = ended_price;
		this.start_price = start_price;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getAuc_code() {
		return auc_code;
	}

	public void setAuc_code(String auc_code) {
		this.auc_code = auc_code;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnded_date() {
		return ended_date;
	}

	public void setEnded_date(String ended_date) {
		this.ended_date = ended_date;
	}

	public int getEnded_price() {
		return ended_price;
	}

	public void setEnded_price(int ended_price) {
		this.ended_price = ended_price;
	}

	public int getStart_price() {
		return start_price;
	}

	public void setStart_price(int start_price) {
		this.start_price = start_price;
	}

}
