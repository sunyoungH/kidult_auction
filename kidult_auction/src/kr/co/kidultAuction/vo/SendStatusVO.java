package kr.co.kidultAuction.vo;

public class SendStatusVO {
	String send_status;

	public SendStatusVO() {
		super();
	}

	public SendStatusVO(String send_status) {
		super();
		this.send_status = send_status;
	}

	public String getSend_status() {
		return send_status;
	}

	public void setSend_status(String send_status) {
		this.send_status = send_status;
	}

	@Override
	public String toString() {
		return "SendStatusVO [send_status=" + send_status + "]";
	}

}//class
