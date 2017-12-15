package kr.co.kidultAuction.vo;

public class UserShowVO {
	
	private String user_id, name, birth_date, addr, email, phone, kakao_id;

	public UserShowVO() {
		super();
	}

	public UserShowVO(String user_id, String name, String birth_date, String addr, String email, String phone,
			String kakao_id) {
		super();
		this.user_id = user_id;
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
		return "UserShowVO [user_id=" + user_id + ", name=" + name + ", birth_date=" + birth_date + ", addr=" + addr
				+ ", email=" + email + ", phone=" + phone + ", kakao_id=" + kakao_id + "]";
	}
	
}