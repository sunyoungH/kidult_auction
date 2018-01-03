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
	 * ���� �� ���� �ҷ�����
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
	 * ���� �۾�
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
			JOptionPane.showMessageDialog(uef, "��й�ȣ�� �Է��� �ּ���");
			return;
		}
		if ("".equals(passcon)) {
			JOptionPane.showMessageDialog(uef, "��й�ȣ�� Ȯ���� �ּ���");
			return;
		}
		if ("".equals(name)) {
			JOptionPane.showMessageDialog(uef, "�̸��� �Է��� �ּ���");
			return;
		}
		if ("".equals(birth)) {
			JOptionPane.showMessageDialog(uef, "��������� �Է��� �ּ���");
			return;
		}
		if ("".equals(addr)) {
			JOptionPane.showMessageDialog(uef, "�ּҸ� �Է��� �ּ���");
			return;
		}
		if ("".equals(email)) {
			JOptionPane.showMessageDialog(uef, "�̸����� �Է��� �ּ���");
			return;
		}
		if ("".equals(phone)) {
			JOptionPane.showMessageDialog(uef, "�ڵ�����ȣ�� �Է��� �ּ���");
			return;
		}

		try {
			boolean flag = u_dao1.updateUser(uev);
			if (flag) {
				JOptionPane.showMessageDialog(uef, "ȸ�������� �����Ǿ����ϴ�.");
				uef.dispose();
			} else {
				JOptionPane.showMessageDialog(uef, "ȸ�������� �������� �ʾҽ��ϴ�.");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(uef, "���� ��� �߻�");
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
