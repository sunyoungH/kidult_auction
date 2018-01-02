package kr.co.kidultAuction.vo;

public class MyAuctionAddVO {
	
	private String item_name, category, period, add_date, permit,auc_code;
	private int start_price;

	
	public MyAuctionAddVO() {
		super();
	}


	public MyAuctionAddVO(String item_name, String category, String period, String add_date, String permit,
			String auc_code, int start_price) {
		super();
		this.item_name = item_name;
		this.category = category;
		this.period = period;
		this.add_date = add_date;
		this.permit = permit;
		this.auc_code = auc_code;
		this.start_price = start_price;
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


	public String getPeriod() {
		return period;
	}


	public void setPeriod(String period) {
		this.period = period;
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
		return "MyAuctionAddVO [item_name=" + item_name + ", category=" + category + ", period=" + period
				+ ", add_date=" + add_date + ", permit=" + permit + ", auc_code=" + auc_code + ", start_price="
				+ start_price + "]";
	}


}