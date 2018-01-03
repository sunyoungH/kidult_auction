package kr.co.kidultAuction.vo;

public class RejectVO2 {
	private String reject_reason, reject_date, auc_code, admin_id;

	public RejectVO2() {
		super();
	}

	public RejectVO2(String reject_reason, String reject_date, String auc_code, String admin_id) {
		super();
		this.reject_reason = reject_reason;
		this.reject_date = reject_date;
		this.auc_code = auc_code;
		this.admin_id = admin_id;
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

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	@Override
	public String toString() {
		return "RejectVO [reject_reason=" + reject_reason + ", reject_date=" + reject_date + ", auc_code=" + auc_code
				+ ", admin_id=" + admin_id + "]";
	}
}