package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kr.co.kidultAuction.dao.UserDAO_JR;
import kr.co.kidultAuction.view.AddUserFrm;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.vo.AddUserVO;

public class AddUserFrmEvt implements ActionListener {
	private AddUserFrm auf;
	private AddUserVO auv;
	private UserDAO_JR u_dao;
	private boolean flag = false;
	private boolean flag1 = false;
	private String id, kakao_id;

	public AddUserFrmEvt(AddUserFrm auf) {
		this.auf = auf;
	}// AddUserFrmEvt

//	private boolean chkPassEqual() { // 입력된 비밀번호확인과 비밀번호와 같은지 확인하는 매서드
//		boolean result = false;
//		return result;
//	}// chkPassEqual

	public void addUser() throws IOException {
		u_dao = UserDAO_JR.getInstance();
		auv = new AddUserVO();
	}// addUser

	private boolean overlapID() throws SQLException { // 중복 id가 있는지와 한글 id입력을 확인할 매서드
		u_dao = UserDAO_JR.getInstance();
		id = auf.getTfId().getText().trim();
		char chrInput;
		// 아이디 중복 체크
		boolean chkId = u_dao.checkId(id);

		for (int i = 0; i < id.length(); i++) {
			chrInput = id.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체크
			if (!((chrInput >= 0x61 && chrInput <= 0x7A) || (chrInput >= 0x41 && chrInput <= 0x5A)
					|| (chrInput >= 0x30 && chrInput <= 0x39))) {
				JOptionPane.showMessageDialog(auf, "한글은 입력할수 없습니다.");
				// flag = false; // 영문자도 아니고 숫자도 아님!
				return true;
			} // end if
		} // end for
		return chkId;
	}// checkedId

	private boolean overlapKakao() throws SQLException { // 중복 kakao_id가 있는지와 한글 id입력을 확인할 매서드
		u_dao = UserDAO_JR.getInstance();
		kakao_id = auf.getTfKakao().getText().trim();
		char chrInput;
		// 카카오아이디 중복 체크
		boolean chkKakao = u_dao.kakaoCheck(kakao_id);

		for (int i = 0; i < kakao_id.length(); i++) {
			chrInput = kakao_id.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체크
			if (!((chrInput >= 0x61 && chrInput <= 0x7A) || (chrInput >= 0x41 && chrInput <= 0x5A)
					|| (chrInput >= 0x30 && chrInput <= 0x39))) {
				JOptionPane.showMessageDialog(auf, "한글은 입력할수 없습니다.");
				// flag = false; // 영문자도 아니고 숫자도 아님!
				return true;
			} // end if
		} // end for

		return chkKakao;

	}// checkedId

//	// id입력시 한글입력 방지
//	public boolean checkedIdOption() throws SQLException {
//		u_dao = UserDAO_JR.getInstance();
//		String id = auf.getTfId().getText().trim();
//		char chrInput;
//
//		for (int i = 0; i < id.length(); i++) {
//			chrInput = id.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체크
//			if (!((chrInput >= 0x61 && chrInput <= 0x7A) || (chrInput >= 0x41 && chrInput <= 0x5A)
//					|| (chrInput >= 0x30 && chrInput <= 0x39))) {
//				JOptionPane.showMessageDialog(auf, "한글은 입력할수 없습니다.");
//				flag = false; // 영문자도 아니고 숫자도 아님!
//			} // end if
//		} // end for
//
//		return true;
//	}

	private void submitUser() {
		u_dao = UserDAO_JR.getInstance();
		auv = new AddUserVO();

		JTextField tfId = auf.getTfId();
		JTextField pfPass = auf.getPfPass();
		JTextField pfPassCon = auf.getPfPassCon();
		JTextField tfName = auf.getTfName();
		JTextField tfBirth = auf.getTfBirth();
		JTextField tfAddr = auf.getTfAddr();
		JTextField tfEmail = auf.getTfEmail();
		JTextField tfPhone = auf.getTfPhone();
		JTextField tfKakao = auf.getTfKakao();

		String id = tfId.getText().trim();
		String pass = pfPass.getText().trim();
		String passcon = pfPassCon.getText().trim();
		String name = tfName.getText().trim();
		String birth = tfBirth.getText().trim();
		String addr = tfAddr.getText().trim();
		String email = tfEmail.getText().trim();
		String phone = tfPhone.getText().trim();
		String kakao = tfKakao.getText().trim();

		if (flag && flag1) {
			try {

				if (pass.equals("")) {
					JOptionPane.showMessageDialog(auf, "비밀번호를 입력하세요.");
					auf.getPfPass().requestFocus();
					return;
				} // end if(pass)

				if (passcon.equals("")) {
					JOptionPane.showMessageDialog(auf, "확인할 비밀번호를 입력하세요.");
					auf.getPfPassCon().requestFocus();
					return;
				} // end if(passcon)

				if (!pass.equals(passcon)) {
					JOptionPane.showMessageDialog(auf, "비밀번호가 일치하지 않습니다. 확인해주세요.");
					auf.getPfPass().requestFocus();
					return;
				}
				if (name.equals("")) {
					JOptionPane.showMessageDialog(auf, "이름을 입력하세요.");
					auf.getTfName().requestFocus();
					return;
				} // end if(name)

				if (birth.equals("")) {
					JOptionPane.showMessageDialog(auf, "생년월일을 입력하세요.");
					auf.getTfBirth().requestFocus();
					return;
				} // end if(birth)

				for (int i = 0; i < birth.length(); i++) {
					char c1 = birth.charAt(i);
					if ((c1 < 48 || c1 > 57) || (birth.length() != 8)) {// // 생년월일 8자리 + 숫자로 입력하지 않았을때
						JOptionPane.showMessageDialog(auf, "올바르지 않은 생년월일 입니다.");
						return;

					} // end if
				} // end for

				if (addr.equals("")) {
					JOptionPane.showMessageDialog(auf, "주소를 입력하세요.");
					auf.getTfAddr().requestFocus();
					return;
				} // end if(addr)

				if (email.equals("")) {
					JOptionPane.showMessageDialog(auf, "이메일을 입력하세요.");
					auf.getTfEmail().requestFocus();
					return;
				} // end if(email)

				if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {
					JOptionPane.showMessageDialog(auf, "올바르지 않은 이메일입니다.");
					return;
				} // end if

				if (phone.equals("")) {
					JOptionPane.showMessageDialog(auf, "번호를 입력하세요.");
					auf.getTfPhone().requestFocus();
					return;
				} // end if(phone)

				for (int i = 0; i < phone.length(); i++) {
					char c1 = phone.charAt(i);
					if ((c1 < 48 || c1 > 57) || (phone.length() != 11)) {// 폰번호가 숫자가 아니고 11자리가 아닌경우
						JOptionPane.showMessageDialog(auf, "핸드폰 번호는 '-'을 제외한 11자리 숫자만 입력해주세요");
						return;
					} // end if
				} // end for

				auv.setUser_id(id);
				auv.setUser_pass(pass);
				auv.setUser_pass(passcon);
				auv.setName(name);
				auv.setBirth_date(birth);
				auv.setAddr(addr);
				auv.setEmail(email);
				auv.setPhone(phone);
				auv.setKakao_id(kakao);

				u_dao.insertUser(auv);
				JOptionPane.showMessageDialog(auf, "가입을 환영합니다.");
				auf.dispose();
				auf.getAmf().dispose();

				new AuctionMainFrm();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} // end catch
			
		} else if (!flag) {
			JOptionPane.showMessageDialog(auf, "아이디 중복체크 하세요.");
		} else {
			JOptionPane.showMessageDialog(auf, "카카오아이디 중복체크 하세요.");

		}
	}// submitUser

	public void Cancel() {
		int cancelFlag = JOptionPane.showConfirmDialog(auf, "가입을 취소하시겠습니까?");
		switch (cancelFlag) {
		case JOptionPane.OK_OPTION:
			auf.dispose();
		}// end switch
	}// checkCancel

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == auf.getBtnIdCheck()) {
			try {

				if (overlapID()) {
					JOptionPane.showMessageDialog(auf, id + "는(은) 이미 사용 중인 아이디 입니다.");

				} else if (!id.equals("")) {
					JOptionPane.showMessageDialog(auf, id + "는(은) 사용 가능한 아이디 입니다.");
					flag = true; // 밑에 입력안했을때의 if문을 타기위해 사용
				} else {// 아이디 입력 하지 않았을때
					JOptionPane.showMessageDialog(auf, "아이디가 입력되지 않았습니다.");
				} // end if

			} catch (SQLException e) {
				e.printStackTrace();
			} // end catch
		} // end if

		if (ae.getSource() == auf.getBtnKakaoCheck()) {
			try {
				if (overlapKakao()) {
					JOptionPane.showMessageDialog(auf, kakao_id + "는(은) 이미 사용 중인 카카오아이디 입니다.");

				} else if (!kakao_id.equals("")) {
					JOptionPane.showMessageDialog(auf, kakao_id + "는(은) 가입 가능한 카카오아이디 입니다.");
					flag1 = true; // 밑에 입력안했을때의 if문을 타기위해 사용
				} else {// 아이디 입력 하지 않았을때
					JOptionPane.showMessageDialog(auf, "카카오아이디가 입력되지 않았습니다.");
				} // end if
			} catch (SQLException e) {
				e.printStackTrace();
			} // end catch
		} // end if

		if (ae.getSource() == auf.getBtnSubmit()) {
			submitUser();
		} // end if

		if (ae.getSource() == auf.getBtnCancel()) {
			Cancel();
		} // end if
	}// actionPerformed

}// class
