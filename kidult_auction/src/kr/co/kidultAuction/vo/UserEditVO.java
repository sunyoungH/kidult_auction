package kr.co.kidultAuction.vo;

public class UserEditVO {
 private String user_id, user_pass, user_validpass, 
 name, birth_date, addr, email, phone, kakao_id;

public UserEditVO() {
	super();
}

public UserEditVO(String user_id, String user_pass, String user_validpass, String name, String birth_date, String addr,
		String email, String phone, String kakao_id) {
	super();
	this.user_id = user_id;
	this.user_pass = user_pass;
	this.user_validpass = user_validpass;
	this.name = name;
	this.birth_date = birth_date;
	this.addr = addr;
	this.email = email;
	this.phone = phone;
	this.kakao_id = kakao_id;
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

public String getUser_validpass() {
	return user_validpass;
}

public void setUser_validpass(String user_validpass) {
	this.user_validpass = user_validpass;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getBirth_date() {
	return birth_date;
}

public void setBirth_date(String birth_date) {
	this.birth_date = birth_date;
}

public String getAddr() {
	return addr;
}

public void setAddr(String addr) {
	this.addr = addr;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getKakao_id() {
	return kakao_id;
}

public void setKakao_id(String kakao_id) {
	this.kakao_id = kakao_id;
}

@Override
public String toString() {
	return "UserEditVO [user_id=" + user_id + ", user_pass=" + user_pass + ", user_validpass=" + user_validpass
			+ ", name=" + name + ", birth_date=" + birth_date + ", addr=" + addr + ", email=" + email + ", phone="
			+ phone + ", kakao_id=" + kakao_id + "]";
}


}//UserEditVO
