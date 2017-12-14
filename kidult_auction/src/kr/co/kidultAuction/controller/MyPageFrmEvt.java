package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.MyAuctionFrm;
import kr.co.kidultAuction.view.MyPageFrm;
import kr.co.kidultAuction.view.UserEditFrm;

public class MyPageFrmEvt implements ActionListener {
	private MyPageFrm mpf;
	private AuctionMainFrm amf;

	public MyPageFrmEvt(MyPageFrm mpf) {
		this.mpf = mpf;
	}// MyPageFrmEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mpf.getBtnMyAuction()) {
			new MyAuctionFrm(amf);
		} // end if

		if (ae.getSource() == mpf.getBtnEdit()) {
			passMsg();
		} // end if

	}// actonPerformed

	JButton btn1;

	public void passMsg() {
		
		JFrame p = new JFrame("비밀번호 입력");
		JPasswordField jp = new JPasswordField(10);
		JLabel lb=new JLabel("비밀번호를 입력하세요");
		btn1 = new JButton("입력");

		p.setLayout(null);
		p.setBounds(100, 100, 255, 200);
		lb.setBounds(56, 30, 180, 30);
		jp.setBounds(50, 70, 150, 30);
		btn1.setBounds(90, 115, 60, 30);
		p.add(jp);
		p.add(btn1);
		p.add(lb);
		p.setVisible(true);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String t = String.valueOf(jp.getPassword());
				if (t.equals("11")) {
					new UserEditFrm(amf);
					p.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호를 확인해 주세요");
				}

			}
		});

	}// passMsg

}// class
