package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kr.co.kidultAuction.dao.UserDAO;
import kr.co.kidultAuction.view.UserEditFrm;
import kr.co.kidultAuction.vo.UserEditVO;
import kr.co.kidultAuction.vo.UserShowVO;

public class UserEditFrmEvt implements ActionListener {
	private UserEditFrm uef;
	private UserDAO u_dao1;
	private UserEditVO uev;

	public UserEditFrmEvt(UserEditFrm uef) throws SQLException {
		this.uef = uef;
		UserEditFrmEvt();
	}

	/**
	 * 수정 전 정보 불러오기
	 */
	public void UserEditFrmEvt() throws SQLException {

		UserDAO u_dao = UserDAO.getInstance();
		List<UserShowVO> list = new ArrayList<UserShowVO>();
		list = u_dao.selectUserInfo();
		UserShowVO usv = null;

		for (int i = 0; i < list.size(); i++) {

			usv = list.get(i);

			uef.getTfId().setText(usv.getUser_id());
			uef.getTfName().setText(usv.getName());
			uef.getTfBirth().setText(usv.getBirth_date());
			uef.getTfAddr().setText(usv.getAddr());
			uef.getTfEmail().setText(usv.getEmail());
			uef.getTfPhone().setText(usv.getPhone());
			uef.getTfKakao().setText(usv.getKakao_id());

		}

	}// UserEditFrmEvt

	/**
	 * 수정 작업
	 */
	private void updateUser() throws SQLException {
		u_dao1 = UserDAO.getInstance();
		uev = new UserEditVO();
		JTextField tfPfPass = uef.getPfPass();
		JTextField tfPfPassCon = uef.getPfPassCon();
		JTextField tfName = uef.getTfName();
		JTextField tfBirth = uef.getTfBirth();
		JTextField tfAddr = uef.getTfAddr();
		JTextField tfEmail = uef.getTfEmail();
		JTextField tfPhone = uef.getTfPhone();

		String pass = tfPfPass.getText().trim();
		String passcon = tfPfPassCon.getText().trim();
		String name = tfName.getText().trim();
		String birth = tfBirth.getText().trim();
		String addr = tfAddr.getText().trim();
		String email = tfEmail.getText().trim();
		String phone = tfPhone.getText().trim();

		uev.setUser_pass(pass);
		uev.setUser_validpass(passcon);
		uev.setName(name);
		uev.setBirth_date(birth);
		uev.setAddr(addr);
		uev.setEmail(email);
		uev.setPhone(phone);

		if ("".equals(pass)) {
			JOptionPane.showMessageDialog(uef, "비밀번호를 입력해 주세요");
			return;
		}
		if ("".equals(passcon)) {
			JOptionPane.showMessageDialog(uef, "비밀번호를 확인해 주세요");
			return;
		}
		if ("".equals(name)) {
			JOptionPane.showMessageDialog(uef, "이름을 입력해 주세요");
			return;
		}
		if ("".equals(birth)) {
			JOptionPane.showMessageDialog(uef, "생년월일을 입력해 주세요");
			return;
		}
		if ("".equals(addr)) {
			JOptionPane.showMessageDialog(uef, "주소를 입력해 주세요");
			return;
		}
		if ("".equals(email)) {
			JOptionPane.showMessageDialog(uef, "이메일을 입력해 주세요");
			return;
		}
		if ("".equals(phone)) {
			JOptionPane.showMessageDialog(uef, "핸드폰번호를 입력해 주세요");
			return;
		}

		try {
			boolean flag = u_dao1.updateUser(uev);
			if (flag) {
				JOptionPane.showMessageDialog(uef, "회원정보가 수정되었습니다.");
				uef.dispose();
			} else {
				JOptionPane.showMessageDialog(uef, "회원정보가 수정되지 않았습니다.");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(uef, "서비스 장애 발생");
			e.printStackTrace();
		} // end catch
	}// updateUser

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == uef.getBtnSubmit()) {
			try {
				updateUser();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end if
		if (ae.getSource() == uef.getBtnCancel()) {
			uef.dispose();
		} // end if

	}// actonPerformed

}
