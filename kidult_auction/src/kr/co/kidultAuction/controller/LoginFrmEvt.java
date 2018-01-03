package kr.co.kidultAuction.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.kidultAuction.dao.AdminDAO;
import kr.co.kidultAuction.dao.UserDAO;
import kr.co.kidultAuction.dao.UserDAO_JR;
import kr.co.kidultAuction.view.AdminPageFrm;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.LoginFrm;
import kr.co.kidultAuction.vo.LoginVO;
import kr.co.kidultAuction.vo.RejectVO;

public class LoginFrmEvt implements ActionListener {
	private LoginFrm lf;
	private boolean flag = false;
	private AuctionMainFrm amf;

	public LoginFrmEvt(LoginFrm lf) {
		this.lf = lf;

	}// LoginFrmEvt

	public void adminLogin() {
		String pass = String.valueOf(lf.getPfPass().getPassword());

		LoginVO lv = new LoginVO();

		lv.setAdmin_id(lf.getTfId().getText().trim());
		lv.setAdmin_pass(pass.trim());

		System.out.println(lv.getAdmin_id() + "/" + lv.getAdmin_pass());
		AdminDAO a_dao = AdminDAO.getInstance();
		try {
			// System.out.println(a_dao.listAdminLogin(lv));
			if (a_dao.selectAdminLogin(lv)) {
				System.out.println("관리자 로그인 성공!");
				JOptionPane.showMessageDialog(null, "관리자 로그인 성공!");
				AuctionMainFrm.Admin_id = lf.getTfId().getText().trim();
				System.out.println(AuctionMainFrm.Admin_id);
				lf.dispose();
				new AdminPageFrm(amf);
			} else {
				JOptionPane.showMessageDialog(lf, "로그인 실패 아이디,비번확인");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// adminLogin

	public void userLogin() {
		String user_pass = String.valueOf(lf.getPfPass().getPassword());

		LoginVO lv = new LoginVO();

		lv.setUser_id(lf.getTfId().getText().trim());
		lv.setUser_pass(user_pass.trim());

		UserDAO a_dao = UserDAO.getInstance();

		try {
			if (a_dao.selectUserLogin(lv)) {
				JOptionPane.showMessageDialog(null, "사용자 로그인 성공!");
//				lf.getAmf().getBtnLogin().setIcon(
//						new ImageIcon(getClass().getClassLoader().getResource("kidultAuction_img/logout.png")));

				AuctionMainFrm.User_id = lf.getTfId().getText().trim();
				lf.dispose();
				flag = true;
				

			} else {
				JOptionPane.showMessageDialog(lf, "로그인 실패 아이디,비번확인");
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end else
		
		
	}// userLogin

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lf.getBtnAdmin()) {
			adminLogin();
		} // end if

		if (ae.getSource() == lf.getBtnLogin()) {
			userLogin();
			
		} // end if

		if (ae.getSource() == lf.getBtnCancel()) {
			lf.dispose();
		} // end if

	}// actionPerformed

	public boolean isFlag() {
		return flag;
	}

}// class
