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

//	private boolean chkPassEqual() { // �Էµ� ��й�ȣȮ�ΰ� ��й�ȣ�� ������ Ȯ���ϴ� �ż���
//		boolean result = false;
//		return result;
//	}// chkPassEqual

	public void addUser() throws IOException {
		u_dao = UserDAO_JR.getInstance();
		auv = new AddUserVO();
	}// addUser

	private boolean overlapID() throws SQLException { // �ߺ� id�� �ִ����� �ѱ� id�Է��� Ȯ���� �ż���
		u_dao = UserDAO_JR.getInstance();
		id = auf.getTfId().getText().trim();
		char chrInput;
		// ���̵� �ߺ� üũ
		boolean chkId = u_dao.checkId(id);

		for (int i = 0; i < id.length(); i++) {
			chrInput = id.charAt(i); // �Է¹��� �ؽ�Ʈ���� ���� �ϳ��ϳ� �����ͼ� üũ
			if (!((chrInput >= 0x61 && chrInput <= 0x7A) || (chrInput >= 0x41 && chrInput <= 0x5A)
					|| (chrInput >= 0x30 && chrInput <= 0x39))) {
				JOptionPane.showMessageDialog(auf, "�ѱ��� �Է��Ҽ� �����ϴ�.");
				// flag = false; // �����ڵ� �ƴϰ� ���ڵ� �ƴ�!
				return true;
			} // end if
		} // end for
		return chkId;
	}// checkedId

	private boolean overlapKakao() throws SQLException { // �ߺ� kakao_id�� �ִ����� �ѱ� id�Է��� Ȯ���� �ż���
		u_dao = UserDAO_JR.getInstance();
		kakao_id = auf.getTfKakao().getText().trim();
		char chrInput;
		// īī�����̵� �ߺ� üũ
		boolean chkKakao = u_dao.kakaoCheck(kakao_id);

		for (int i = 0; i < kakao_id.length(); i++) {
			chrInput = kakao_id.charAt(i); // �Է¹��� �ؽ�Ʈ���� ���� �ϳ��ϳ� �����ͼ� üũ
			if (!((chrInput >= 0x61 && chrInput <= 0x7A) || (chrInput >= 0x41 && chrInput <= 0x5A)
					|| (chrInput >= 0x30 && chrInput <= 0x39))) {
				JOptionPane.showMessageDialog(auf, "�ѱ��� �Է��Ҽ� �����ϴ�.");
				// flag = false; // �����ڵ� �ƴϰ� ���ڵ� �ƴ�!
				return true;
			} // end if
		} // end for

		return chkKakao;

	}// checkedId

//	// id�Է½� �ѱ��Է� ����
//	public boolean checkedIdOption() throws SQLException {
//		u_dao = UserDAO_JR.getInstance();
//		String id = auf.getTfId().getText().trim();
//		char chrInput;
//
//		for (int i = 0; i < id.length(); i++) {
//			chrInput = id.charAt(i); // �Է¹��� �ؽ�Ʈ���� ���� �ϳ��ϳ� �����ͼ� üũ
//			if (!((chrInput >= 0x61 && chrInput <= 0x7A) || (chrInput >= 0x41 && chrInput <= 0x5A)
//					|| (chrInput >= 0x30 && chrInput <= 0x39))) {
//				JOptionPane.showMessageDialog(auf, "�ѱ��� �Է��Ҽ� �����ϴ�.");
//				flag = false; // �����ڵ� �ƴϰ� ���ڵ� �ƴ�!
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
					JOptionPane.showMessageDialog(auf, "��й�ȣ�� �Է��ϼ���.");
					auf.getPfPass().requestFocus();
					return;
				} // end if(pass)

				if (passcon.equals("")) {
					JOptionPane.showMessageDialog(auf, "Ȯ���� ��й�ȣ�� �Է��ϼ���.");
					auf.getPfPassCon().requestFocus();
					return;
				} // end if(passcon)

				if (!pass.equals(passcon)) {
					JOptionPane.showMessageDialog(auf, "��й�ȣ�� ��ġ���� �ʽ��ϴ�. Ȯ�����ּ���.");
					auf.getPfPass().requestFocus();
					return;
				}
				if (name.equals("")) {
					JOptionPane.showMessageDialog(auf, "�̸��� �Է��ϼ���.");
					auf.getTfName().requestFocus();
					return;
				} // end if(name)

				if (birth.equals("")) {
					JOptionPane.showMessageDialog(auf, "��������� �Է��ϼ���.");
					auf.getTfBirth().requestFocus();
					return;
				} // end if(birth)

				for (int i = 0; i < birth.length(); i++) {
					char c1 = birth.charAt(i);
					if ((c1 < 48 || c1 > 57) || (birth.length() != 8)) {// // ������� 8�ڸ� + ���ڷ� �Է����� �ʾ�����
						JOptionPane.showMessageDialog(auf, "�ùٸ��� ���� ������� �Դϴ�.");
						return;

					} // end if
				} // end for

				if (addr.equals("")) {
					JOptionPane.showMessageDialog(auf, "�ּҸ� �Է��ϼ���.");
					auf.getTfAddr().requestFocus();
					return;
				} // end if(addr)

				if (email.equals("")) {
					JOptionPane.showMessageDialog(auf, "�̸����� �Է��ϼ���.");
					auf.getTfEmail().requestFocus();
					return;
				} // end if(email)

				if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {
					JOptionPane.showMessageDialog(auf, "�ùٸ��� ���� �̸����Դϴ�.");
					return;
				} // end if

				if (phone.equals("")) {
					JOptionPane.showMessageDialog(auf, "��ȣ�� �Է��ϼ���.");
					auf.getTfPhone().requestFocus();
					return;
				} // end if(phone)

				for (int i = 0; i < phone.length(); i++) {
					char c1 = phone.charAt(i);
					if ((c1 < 48 || c1 > 57) || (phone.length() != 11)) {// ����ȣ�� ���ڰ� �ƴϰ� 11�ڸ��� �ƴѰ��
						JOptionPane.showMessageDialog(auf, "�ڵ��� ��ȣ�� '-'�� ������ 11�ڸ� ���ڸ� �Է����ּ���");
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
				JOptionPane.showMessageDialog(auf, "������ ȯ���մϴ�.");
				auf.dispose();
				auf.getAmf().dispose();

				new AuctionMainFrm();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} // end catch
			
		} else if (!flag) {
			JOptionPane.showMessageDialog(auf, "���̵� �ߺ�üũ �ϼ���.");
		} else {
			JOptionPane.showMessageDialog(auf, "īī�����̵� �ߺ�üũ �ϼ���.");

		}
	}// submitUser

	public void Cancel() {
		int cancelFlag = JOptionPane.showConfirmDialog(auf, "������ ����Ͻðڽ��ϱ�?");
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
					JOptionPane.showMessageDialog(auf, id + "��(��) �̹� ��� ���� ���̵� �Դϴ�.");

				} else if (!id.equals("")) {
					JOptionPane.showMessageDialog(auf, id + "��(��) ��� ������ ���̵� �Դϴ�.");
					flag = true; // �ؿ� �Է¾��������� if���� Ÿ������ ���
				} else {// ���̵� �Է� ���� �ʾ�����
					JOptionPane.showMessageDialog(auf, "���̵� �Էµ��� �ʾҽ��ϴ�.");
				} // end if

			} catch (SQLException e) {
				e.printStackTrace();
			} // end catch
		} // end if

		if (ae.getSource() == auf.getBtnKakaoCheck()) {
			try {
				if (overlapKakao()) {
					JOptionPane.showMessageDialog(auf, kakao_id + "��(��) �̹� ��� ���� īī�����̵� �Դϴ�.");

				} else if (!kakao_id.equals("")) {
					JOptionPane.showMessageDialog(auf, kakao_id + "��(��) ���� ������ īī�����̵� �Դϴ�.");
					flag1 = true; // �ؿ� �Է¾��������� if���� Ÿ������ ���
				} else {// ���̵� �Է� ���� �ʾ�����
					JOptionPane.showMessageDialog(auf, "īī�����̵� �Էµ��� �ʾҽ��ϴ�.");
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
