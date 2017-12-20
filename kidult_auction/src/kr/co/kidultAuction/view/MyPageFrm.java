package kr.co.kidultAuction.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import kr.co.kidultAuction.controller.MyPageFrmEvt;


@SuppressWarnings("serial")
public class MyPageFrm extends JDialog {
	private JButton btnMyAuction, btnEdit;
	
	
	public MyPageFrm(AuctionMainFrm amf) {
		super(amf,"내 페이지");
		btnMyAuction=new JButton("내 경매");
		btnEdit=new JButton("회원정보 수정");
		
		setLayout(null);
		btnMyAuction.setBounds(60,50,180,180);
		btnEdit.setBounds(250,50,180,180);
		
		add(btnMyAuction);
		add(btnEdit);
	
		setBounds(650,330,500,300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		MyPageFrmEvt mpfe=new MyPageFrmEvt(this);
		btnMyAuction.addActionListener(mpfe);
		btnEdit.addActionListener(mpfe);
		
	}//MyPageFrm


	public JButton getBtnMyAuction() {
		return btnMyAuction;
	}

	public void setBtnMyAuction(JButton btnMyAuction) {
		this.btnMyAuction = btnMyAuction;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}
	
}
