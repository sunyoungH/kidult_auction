package kr.co.kidultAuction.controller;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;

import kr.co.kidultAuction.dao.UserDAO;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.MyAuctionFrm;
import kr.co.kidultAuction.view.MyPageFrm;
import kr.co.kidultAuction.view.UserEditFrm;
import kr.co.kidultAuction.vo.LoginVO;

public class MyPageFrmEvt implements ActionListener {
	private MyPageFrm mpf;
	private AuctionMainFrm amf;

	public MyPageFrmEvt(MyPageFrm mpf) {
		this.mpf = mpf;
	}// MyPageFrmEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mpf.getBtnMyAuction()) {
			try {
				new MyAuctionFrm(amf);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "sql잘못");
			}
		} // end if

		if (ae.getSource() == mpf.getBtnEdit()) {
			passMsg();
		} // end if
		
		if(ae.getSource()==mpf.getBtnExit()) {
			mpf.dispose();
		}

	}// actonPerformed

	JButton btn1;

	public void passMsg() {

		JFrame p = new JFrame("비밀번호 입력");
		JPasswordField jp = new JPasswordField(10);
		JLabel lb = new JLabel("비밀번호를 입력하세요");
		btn1 = new JButton("입력");
		btn1.setBackground(new Color(0xD0E5FF));
		JTable jt= new JTable();
		jt.setBackground(new Color(0xFFFBF6));

		p.setLayout(null);
		p.setBounds(770, 400, 255, 200);
		lb.setBounds(56, 30, 180, 30);
		jp.setBounds(50, 70, 150, 30);
		btn1.setBounds(90, 115, 60, 30);
		jt.setBounds(0,0,255,200);
		p.add(jp);
		p.add(btn1);
		p.add(lb);
		p.add(jt);
		p.setVisible(true);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String t = String.valueOf(jp.getPassword());
				LoginVO lv = new LoginVO();
				lv.setUser_id(AuctionMainFrm.User_id);
				lv.setUser_pass(t.trim());

				UserDAO u_dao = UserDAO.getInstance();

				try {
					if (u_dao.confirmPass(lv)) {
						new UserEditFrm(amf);
						p.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호를 확인해 주세요");
						jp.setText("");
					} // end else
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} // end catch

			}// actionPerformed
		});

	}// passMsg

}// class
