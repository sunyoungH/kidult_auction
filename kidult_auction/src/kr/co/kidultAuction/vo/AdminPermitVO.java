package kr.co.kidultAuction.vo;

public class AdminPermitVO {
private String user_id, auc_code, category, status, item_name, period;
private int start_price;
public AdminPermitVO() {
	super();
}
public AdminPermitVO(String user_id, String auc_code, String category, String status, String item_name, String period,
		int start_price) {
	super();
	this.user_id = user_id;
	this.auc_code = auc_code;
	this.category = category;
	this.status = status;
	this.item_name = item_name;
	this.period = period;
	this.start_price = start_price;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getAuc_code() {
	return auc_code;
}
public void setAuc_code(String auc_code) {
	this.auc_code = auc_code;
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
public String getItem_name() {
	return item_name;
}
public void setItem_name(String item_name) {
	this.item_name = item_name;
}
public String getPeriod() {
	return period;
}
public void setPeriod(String period) {
	this.period = period;
}
public int getStart_price() {
	return start_price;
}
public void setStart_price(int start_price) {
	this.start_price = start_price;
}
@Override
public String toString() {
	return "AdminPermitVO [user_id=" + user_id + ", auc_code=" + auc_code + ", category=" + category + ", status="
			+ status + ", item_name=" + item_name + ", period=" + period + ", start_price=" + start_price + "]";
}

}
