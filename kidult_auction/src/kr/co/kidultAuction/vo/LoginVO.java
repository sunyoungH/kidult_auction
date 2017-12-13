package kr.co.kidultAuction.vo;

public class LoginVO {
private String admin_id, admin_pass, user_id, user_pass;


public LoginVO() {
	super();
}

public LoginVO(String admin_id, String admin_pass, String user_id, String user_pass) {
	super();
	this.admin_id = admin_id;
	this.admin_pass = admin_pass;
	this.user_id = user_id;
	this.user_pass = user_pass;
}

public String getAdmin_id() {
	return admin_id;
}

public void setAdmin_id(String admin_id) {
	this.admin_id = admin_id;
}

public String getAdmin_pass() {
	return admin_pass;
}

public void setAdmin_pass(String admin_pass) {
	this.admin_pass = admin_pass;
}

public String getUser_id() {
	return user_id;
}

public void setUser_id(String user_id) {
	this.user_id = user_id;
}

public String getUser_pass() {
	return user_pass;
}

public void setUser_pass(String user_pass) {
	this.user_pass = user_pass;
}

@Override
public String toString() {
	return "LoginVO [admin_id=" + admin_id + ", admin_pass=" + admin_pass + ", user_id=" + user_id + ", user_pass="
			+ user_pass + "]";
}

}
