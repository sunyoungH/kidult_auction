package kr.co.kidultAuction.vo;

public class MyAuctionReceiveVO {
	
	private String  item_name, ended_date, start_date, kakao_id, send_status;
	private int start_price, bid_price;
	
	public MyAuctionReceiveVO() {
		super();
	}

	public MyAuctionReceiveVO(String item_name, String ended_date, String start_date, String kakao_id,
			String send_status, int start_price, int bid_price) {
		super();
		this.item_name = item_name;
		this.ended_date = ended_date;
		this.start_date = start_date;
		this.kakao_id = kakao_id;
		this.send_status = send_status;
		this.start_price = start_price;
		this.bid_price = bid_price;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getEnded_date() {
		return ended_date;
	}

	public void setEnded_date(String ended_date) {
		this.ended_date = ended_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getKakao_id() {
		return kakao_id;
	}

	public void setKakao_id(String kakao_id) {
		this.kakao_id = kakao_id;
	}

	public String getSend_status() {
		return send_status;
	}

	public void setSend_status(String send_status) {
		this.send_status = send_status;
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
		return "MyAuctionReceiveVO [item_name=" + item_name + ", ended_date=" + ended_date + ", start_date="
				+ start_date + ", kakao_id=" + kakao_id + ", send_status=" + send_status + ", start_price="
				+ start_price + ", bid_price=" + bid_price + "]";
	}

}