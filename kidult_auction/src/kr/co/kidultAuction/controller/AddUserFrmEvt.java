package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.kidultAuction.dao.UserDAO_JR;
import kr.co.kidultAuction.view.AddUserFrm;
import kr.co.kidultAuction.vo.AddUserVO;

public class AddUserFrmEvt implements ActionListener {
	
	private AddUserFrm auf;
	private AddUserVO auv;
	private UserDAO_JR u_dao;
	private String[] ex;
	
	public AddUserFrmEvt(AddUserFrm auf) {
		this.auf=auf;
	}//AddUserFrmEvt
	
	public void addUser() throws IOException{
		u_dao = UserDAO_JR.getInstance();
		ex = new String[9];
		
		if(new String(auf.getTfId().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "���̵� �Է��ϼ���.");
			auf.getTfId().requestFocus();
			ex[0] = String.valueOf(auf.getTfId().getText().trim());
			return;
		}
		if(new String(auf.getPfPass().getPassword()).equals("")) {
			JOptionPane.showMessageDialog(auf, "��й�ȣ�� �Է��ϼ���.");
			auf.getPfPass().requestFocus();
			return;
		}
		if(new String(auf.getPfPassCon().getPassword()).equals("")) {
			JOptionPane.showMessageDialog(auf, "Ȯ���� ��й�ȣ�� �Է��ϼ���.");
			auf.getPfPassCon().requestFocus();
			return;
		}
		/*if(auf.getPfPass().getPassword().equals(obj)!=auf.getPfPassCon().getPassword()) {
			JOptionPane.showMessageDialog(auf, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			auf.getPfPass().requestFocus();
			return;
		}*/
		if(new String(auf.getTfName().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "�̸��� �Է��ϼ���.");
			auf.getTfName().requestFocus();
			return;
		}
		if(new String(auf.getTfBirth().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "��������� �Է��ϼ���.");
			auf.getTfBirth().requestFocus();
			return;
		}
		if(new String(auf.getTfAddr().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "�ּҸ� �Է��ϼ���.");
			auf.getTfAddr().requestFocus();
			return;
		}
		if(new String(auf.getTfEmail().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "�̸����� �Է��ϼ���.");
			auf.getTfEmail().requestFocus();
			return;
		}
		if(new String(auf.getTfPhone().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "�ڵ�����ȣ�� �Է��ϼ���.");
			auf.getTfPhone().requestFocus();
			return;
		}
		if(new String(auf.getTfKakao().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "īī�����̵� �Է��ϼ���.");
			auf.getTfKakao().requestFocus();
			return;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == auf.getBtnIdCheck()) {
			
		}
		
		if(ae.getSource() == auf.getBtnSubmit()) {
			u_dao = UserDAO_JR.getInstance();
			try {
				u_dao.insertUser(ex);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			System.out.println("��ϿϷ�");
		}
		
		if(ae.getSource() == auf.getBtnCancel()) {
			auf.dispose();
		}
	}//actionPerformed
	
	

}//class
