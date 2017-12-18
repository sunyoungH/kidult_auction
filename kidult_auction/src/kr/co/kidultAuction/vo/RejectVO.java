package kr.co.kidultAuction.vo;

public class RejectVO {
	private String reject_reason, auc_code, admin_id;

	public RejectVO() {
		super();
	}

	public RejectVO(String reject_reason, String auc_code, String admin_id) {
		super();
		this.reject_reason = reject_reason;
		this.auc_code = auc_code;
		this.admin_id = admin_id;
	}

	public String getReject_reason() {
		return reject_reason;
	}

	public void setReject_reason(String reject_reason) {
		this.reject_reason = reject_reason;
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
		return "RejectVO [reject_reason=" + reject_reason + ", auc_code=" + auc_code + ", admin_id=" + admin_id + "]";
	}
	
}
