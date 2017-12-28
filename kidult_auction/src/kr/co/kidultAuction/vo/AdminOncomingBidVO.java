package kr.co.kidultAuction.vo;

public class AdminOncomingBidVO {

	private String auc_code, expected_end_date;

	public AdminOncomingBidVO() {
		super();
	}

	public AdminOncomingBidVO(String auc_code, String expected_end_date) {
		super();
		this.auc_code = auc_code;
		this.expected_end_date = expected_end_date;
	}

	public String getAuc_code() {
		return auc_code;
	}

	public void setAuc_code(String auc_code) {
		this.auc_code = auc_code;
	}

	public String getExpected_end_date() {
		return expected_end_date;
	}

	public void setExpected_end_date(String expected_end_date) {
		this.expected_end_date = expected_end_date;
	}

	@Override
	public String toString() {
		return "AdminEndBidVO [auc_code=" + auc_code + ", expected_end_date=" + expected_end_date + "]";
	}
	
	
}
