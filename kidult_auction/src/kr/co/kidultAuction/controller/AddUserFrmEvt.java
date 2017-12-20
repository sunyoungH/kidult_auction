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
			JOptionPane.showMessageDialog(auf, "아이디를 입력하세요.");
			auf.getTfId().requestFocus();
			ex[0] = String.valueOf(auf.getTfId().getText().trim());
			return;
		}
		if(new String(auf.getPfPass().getPassword()).equals("")) {
			JOptionPane.showMessageDialog(auf, "비밀번호를 입력하세요.");
			auf.getPfPass().requestFocus();
			return;
		}
		if(new String(auf.getPfPassCon().getPassword()).equals("")) {
			JOptionPane.showMessageDialog(auf, "확인할 비밀번호를 입력하세요.");
			auf.getPfPassCon().requestFocus();
			return;
		}
		/*if(auf.getPfPass().getPassword().equals(obj)!=auf.getPfPassCon().getPassword()) {
			JOptionPane.showMessageDialog(auf, "비밀번호가 일치하지 않습니다.");
			auf.getPfPass().requestFocus();
			return;
		}*/
		if(new String(auf.getTfName().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "이름을 입력하세요.");
			auf.getTfName().requestFocus();
			return;
		}
		if(new String(auf.getTfBirth().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "생년월일을 입력하세요.");
			auf.getTfBirth().requestFocus();
			return;
		}
		if(new String(auf.getTfAddr().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "주소를 입력하세요.");
			auf.getTfAddr().requestFocus();
			return;
		}
		if(new String(auf.getTfEmail().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "이메일을 입력하세요.");
			auf.getTfEmail().requestFocus();
			return;
		}
		if(new String(auf.getTfPhone().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "핸드폰번호를 입력하세요.");
			auf.getTfPhone().requestFocus();
			return;
		}
		if(new String(auf.getTfKakao().getText()).equals("")) {
			JOptionPane.showMessageDialog(auf, "카카오아이디를 입력하세요.");
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
			
			
			System.out.println("등록완료");
		}
		
		if(ae.getSource() == auf.getBtnCancel()) {
			auf.dispose();
		}
	}//actionPerformed
	
	

}//class
