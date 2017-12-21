package kr.co.kidultAuction.vo;

public class MyAuctionReceiveVO {
	
	private String  item_name, permit_date, add_date, kakao_id, receive_status;
	private int start_price, bid_price;
	
	public MyAuctionReceiveVO() {
		super();
	}

	public MyAuctionReceiveVO(String item_name, String permit_date, String add_date, String kakao_id,
			String receive_status, int start_price, int bid_price) {
		super();
		this.item_name = item_name;
		this.permit_date = permit_date;
		this.add_date = add_date;
		this.kakao_id = kakao_id;
		this.receive_status = receive_status;
		this.start_price = start_price;
		this.bid_price = bid_price;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getPermit_date() {
		return permit_date;
	}

	public void setPermit_date(String permit_date) {
		this.permit_date = permit_date;
	}

	public String getAdd_date() {
		return add_date;
	}

	public void setAdd_date(String add_date) {
		this.add_date = add_date;
	}

	public String getKakao_id() {
		return kakao_id;
	}

	public void setKakao_id(String kakao_id) {
		this.kakao_id = kakao_id;
	}

	public String getReceive_status() {
		return receive_status;
	}

	public void setReceive_status(String receive_status) {
		this.receive_status = receive_status;
	}

	public int getStart_price() {
		return start_price;
	}

	public void setStart_price(int start_price) {
		this.start_price = start_price;
	}

	public int getBid_price() {
		return bid_price;
	}

	public void setBid_price(int bid_price) {
		this.bid_price = bid_price;
	}

	@Override
	public String toString() {
		return "MyAuctionReceiveVO [item_name=" + item_name + ", permit_date=" + permit_date + ", add_date=" + add_date
				+ ", kakao_id=" + kakao_id + ", receive_status=" + receive_status + ", start_price=" + start_price
				+ ", bid_price=" + bid_price + "]";
	}

}