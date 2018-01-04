package kr.co.kidultAuction.vo;

public class ListOfAuctionVO {
	String auc_code, item_name, front_img, category, status, period, detail_info, add_date, permit, permit_date, start_date, user_id, category_num;
	int start_price;
	
	public ListOfAuctionVO() {
		super();
	}

	public ListOfAuctionVO(String auc_code, String item_name, String front_img, String category, String status,
			String period, String detail_info, String add_date, String permit, String permit_date, String start_date,
			String user_id, int start_price) {
		super();
		this.auc_code = auc_code;
		this.item_name = item_name;
		this.front_img = front_img;
		this.category = category;
		this.status = status;
		this.period = period;
		this.detail_info = detail_info;
		this.add_date = add_date;
		this.permit = permit;
		this.permit_date = permit_date;
		this.start_date = start_date;
		this.user_id = user_id;
		this.start_price = start_price;
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

	public String getFront_img() {
		return front_img;
	}

	public void setFront_img(String front_img) {
		this.front_img = front_img;
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

	public String getAdd_date() {
		return add_date;
	}

	public void setAdd_date(String add_date) {
		this.add_date = add_date;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public String getPermit_date() {
		return permit_date;
	}

	public void setPermit_date(String permit_date) {
		this.permit_date = permit_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
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
		return "ListOfAuctionVO [auc_code=" + auc_code + ", item_name=" + item_name + ", front_img=" + front_img
				+ ", category=" + category + ", status=" + status + ", period=" + period + ", detail_info="
				+ detail_info + ", add_date=" + add_date + ", permit=" + permit + ", permit_date=" + permit_date
				+ ", start_date=" + start_date + ", user_id=" + user_id + ", start_price=" + start_price + "]";
	}

	
	
}
