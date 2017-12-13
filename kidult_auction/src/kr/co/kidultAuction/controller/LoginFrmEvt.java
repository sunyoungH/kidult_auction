package kr.co.kidultAuction.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.kidultAuction.dao.AdminDAO;
import kr.co.kidultAuction.view.AdminPageFrm;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.LoginFrm;
import kr.co.kidultAuction.vo.LoginVO;
	
public class LoginFrmEvt implements ActionListener {
private LoginFrm lf;
private AuctionMainFrm amf;

	public LoginFrmEvt(LoginFrm lf) {
		this.lf=lf;
		
	}//LoginFrmEvt
	
	public void adminLogin() {
		String pass=String.valueOf(lf.getPfPass().getPassword());
		
		LoginVO lv=new LoginVO();
		
		lv.setAdmin_id(lf.getTfId().getText().trim());
		lv.setAdmin_pass(pass.trim());
		
		System.out.println(lv.getAdmin_id()+"/"+lv.getAdmin_pass());
		AdminDAO a_dao=AdminDAO.getInstance();
		try {
//			System.out.println(a_dao.listAdminLogin(lv));
			if(a_dao.selectAdminLogin(lv)) {
				System.out.println("로그인 성공!");
				JOptionPane.showMessageDialog(null, "로그인 성공!");
				AuctionMainFrm.User_id=lf.getTfId().getText().trim();
				lf.dispose();
				new AdminPageFrm(amf);
			}else {
				System.out.println("로그인 실패 아이디,비번확인");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//adminLogin
	
	public void userLogin() {
		String user_pass=String.valueOf(lf.getPfPass().getPassword());
		
		LoginVO lv=new LoginVO();
		
		lv.setUser_id(lf.getTfId().getText().trim());
		lv.setUser_pass(user_pass.trim());
		
		AdminDAO a_dao=AdminDAO.getInstance();
		
		try {
			if(a_dao.selectUserLogin(lv)) {
				System.out.println("사용자 로그인 성공!");
				JOptionPane.showMessageDialog(null, "사용자 로그인 성공!");
//				AuctionMainFrm.User_id=lf.getTfId().getText().trim();
				lf.dispose();
			}else {
				System.out.println("사용자 실패");
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end else
	}//userLogin
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==lf.getBtnAdmin()) {
			adminLogin();
		}//end if
		
		if(ae.getSource()==lf.getBtnLogin()) {
			userLogin();
		}//end if
		
	}//actionPerformed
	
}//class
