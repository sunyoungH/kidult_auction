package kr.co.kidultAuction.vo;

public class MyAuctionAddVO {
	
	private String item_name, category, period, add_date, permit, reject_reason, reject_date;
	private int start_price;

	
	public MyAuctionAddVO() {
		super();
	}


	public MyAuctionAddVO(String item_name, String category, String period, String add_date, String permit,
			String reject_reason, String reject_date, int start_price) {
		super();
		this.item_name = item_name;
		this.category = category;
		this.period = period;
		this.add_date = add_date;
		this.permit = permit;
		this.reject_reason = reject_reason;
		this.reject_date = reject_date;
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


	public String getReject_reason() {
		return reject_reason;
	}


	public void setReject_reason(String reject_reason) {
		this.reject_reason = reject_reason;
	}


	public String getReject_date() {
		return reject_date;
	}


	public void setReject_date(String reject_date) {
		this.reject_date = reject_date;
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
				+ ", add_date=" + add_date + ", permit=" + permit + ", reject_reason=" + reject_reason
				+ ", reject_date=" + reject_date + ", start_price=" + start_price + "]";
	}


}