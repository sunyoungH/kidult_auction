package kr.co.kidultAuction.vo;

public class DetailOfAuctionVO {
	String front_img, back_img, left_img, right_img, category, status, item_name, period, detail_info, user_id;
	int start_price;
	
	public DetailOfAuctionVO() {
		super();
	}

	public DetailOfAuctionVO(String front_img, String back_img, String left_img, String right_img, String category,
			String status, String item_name, String period, String detail_info, String user_id, int start_price) {
		super();
		this.front_img = front_img;
		this.back_img = back_img;
		this.left_img = left_img;
		this.right_img = right_img;
		this.category = category;
		this.status = status;
		this.item_name = item_name;
		this.period = period;
		this.detail_info = detail_info;
		this.user_id = user_id;
		this.start_price = start_price;
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

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getDetail_info() {
		return detail_info;
	}

	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getStart_price() {
		return start_price;
	}

	public void setStart_price(int start_price) {
		this.start_price = start_price;
	}

	@Override
	public String toString() {
		return "DetailOfAuctionVO [front_img=" + front_img + ", back_img=" + back_img + ", left_img=" + left_img
				+ ", right_img=" + right_img + ", category=" + category + ", status=" + status + ", item_name="
				+ item_name + ", period=" + period + ", detail_info=" + detail_info + ", user_id=" + user_id
				+ ", start_price=" + start_price + "]";
	}
}
