package kr.co.kidultAuction.vo;

public class AdminUserVO {
	String user_id, name, phone, kakao_id, birth_date, email, addr, user_joindate;

	public AdminUserVO() {
		super();
	}

	public AdminUserVO(String user_id, String name, String phone, String kakao_id, String birth_date, String email,
			String addr, String user_joindate) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.phone = phone;
		this.kakao_id = kakao_id;
		this.birth_date = birth_date;
		this.email = email;
		this.addr = addr;
		this.user_joindate = user_joindate;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getUser_joindate() {
		return user_joindate;
	}

	public void setUser_joindate(String user_joindate) {
		this.user_joindate = user_joindate;
	}

	@Override
	public String toString() {
		return "AdminUserVO [user_id=" + user_id + ", name=" + name + ", phone=" + phone + ", kakao_id=" + kakao_id
				+ ", birth_date=" + birth_date + ", email=" + email + ", addr=" + addr + ", user_joindate="
				+ user_joindate + "]";
	}
	
}
