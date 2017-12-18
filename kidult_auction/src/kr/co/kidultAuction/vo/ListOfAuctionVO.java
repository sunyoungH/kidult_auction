package kr.co.kidultAuction.vo;

public class ListOfAuctionVO {
	String front_img, status, item_name, end_date, user_id,auc_code;
	int start_price;
	
	public ListOfAuctionVO() {
		super();
	}

	public ListOfAuctionVO(String front_img, String status, String item_name, String end_date, String user_id,
			String auc_code, int start_price) {
		super();
		this.front_img = front_img;
		this.status = status;
		this.item_name = item_name;
		this.end_date = end_date;
		this.user_id = user_id;
		this.auc_code = auc_code;
		this.start_price = start_price;
	}

	public String getFront_img() {
		return front_img;
	}

	public void setFront_img(String front_img) {
		this.front_img = front_img;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
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

	public int getStart_price() {
		return start_price;
	}

	public void setStart_price(int start_price) {
		this.start_price = start_price;
	}

	@Override
	public String toString() {
		return "ListOfAuctionVO [front_img=" + front_img + ", status=" + status + ", item_name=" + item_name
				+ ", end_date=" + end_date + ", user_id=" + user_id + ", auc_code=" + auc_code + ", start_price="
				+ start_price + "]";
	}
	
	
	
}
