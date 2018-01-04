package kr.co.kidultAuction.vo;

public class AddAuctionItemVO {
	private String front_img, back_img, left_img, right_img;
	private String category, item_name, status, detail_info;
	private int start_price, period;
	private String user_id;
	
	
	public AddAuctionItemVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AddAuctionItemVO(String front_img, String back_img, String left_img, String right_img, String category,
			String item_name, String status, String detail_info, int start_price, int period, String user_id) {
		super();
		this.front_img = front_img;
		this.back_img = back_img;
		this.left_img = left_img;
		this.right_img = right_img;
		this.category = category;
		this.item_name = item_name;
		this.status = status;
		this.detail_info = detail_info;
		this.start_price = start_price;
		this.period = period;
		this.user_id = user_id;
	}


	public String getFront_img() {
		return front_img;
	}
	public void setFront_img(String front_img) {
		this.front_img = front_img;
	}
	public String getBack_img() {
		return back_img;
	}
	public void setBack_img(String back_img) {
		this.back_img = back_img;
	}
	public String getLeft_img() {
		return left_img;
	}
	public void setLeft_img(String left_img) {
		this.left_img = left_img;
	}
	public String getRight_img() {
		return right_img;
	}
	public void setRight_img(String right_img) {
		this.right_img = right_img;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDetail_info() {
		return detail_info;
	}


	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}


	public int getStart_price() {
		return start_price;
	}


	public void setStart_price(int start_price) {
		this.start_price = start_price;
	}


	public int getPeriod() {
		return period;
	}


	public void setPeriod(int period) {
		this.period = period;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	@Override
	public String toString() {
		return "AddAuctionItemVO [front_img=" + front_img + ", back_img=" + back_img + ", left_img=" + left_img
				+ ", right_img=" + right_img + ", category=" + category + ", item_name=" + item_name + ", status="
				+ status + ", detail_info=" + detail_info + ", start_price=" + start_price + ", period=" + period
				+ ", user_id=" + user_id + "]";
	}
	
	
	
	
	
}