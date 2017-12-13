package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.MyAuctionFrm;
import kr.co.kidultAuction.view.MyPageFrm;
import kr.co.kidultAuction.view.UserEditFrm;

public class MyPageFrmEvt implements ActionListener{
	private MyPageFrm mpf;
	private AuctionMainFrm amf;
	
	
	public MyPageFrmEvt(MyPageFrm mpf) {
		this.mpf=mpf;
	}//MyPageFrmEvt
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mpf.getBtnMyAuction()) {
			new MyAuctionFrm(amf);
		}//end if
		
		if(ae.getSource() == mpf.getBtnEdit()){
			 passMsg();
			 //////����� ���̵� �������⼭ �޾ƿ��� ���////
			 ///System.out.println("myPage���� �޾ƿ��� ������ ���̵�: "+AuctionMainFrm.User_id); �ȴ�!!!!!!!!!! 
			 ///////////////////////////
		}//end if
		
	}//actonPerformed

	JButton btn1;
	public void passMsg() {
		JPanel p=new JPanel();
		JPasswordField jp=new JPasswordField(10);
		btn1=new JButton("�Է�");
		p.add(jp);
		p.add(btn1);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String passConfirm=String.valueOf(jp.getPassword());
					if(passConfirm.equals("11")) {
						System.out.println("Ȯ�οϷ�");
						new UserEditFrm(amf);
					}//end if
			}//actionPerformed
		});
		JOptionPane.showMessageDialog(null,p);
	}//passMsg
		

}//class
