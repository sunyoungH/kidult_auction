package kr.co.kidultAuction.vo;

public class RejectVO {
	private String reject_reason, reject_date, auc_code;

	public RejectVO() {
		super();
	}

	public RejectVO(String reject_reason, String reject_date, String auc_code) {
		super();
		this.reject_reason = reject_reason;
		this.reject_date = reject_date;
		this.auc_code = auc_code;
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

	public String getAuc_code() {
		return auc_code;
	}

	public void setAuc_code(String auc_code) {
		this.auc_code = auc_code;
	}

	@Override
	public String toString() {
		return "RejectVO [reject_reason=" + reject_reason + ", reject_date=" + reject_date + ", auc_code=" + auc_code
				+ "]";
	}

}