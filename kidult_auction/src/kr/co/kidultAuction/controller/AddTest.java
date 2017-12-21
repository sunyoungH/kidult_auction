package kr.co.kidultAuction.controller;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import kr.co.kidultAuction.controller.AddAuctionItemFrmEvt;
import kr.co.kidultAuction.controller.AddItemImageFrmEvt;

public class AddTest extends JDialog {
	private JLabel lbFront, lbBack, lbLeft, lbRight, lbFrontImg, lbBackImg, lbLeftImg, lbRightImg;
	private JButton btnFront, btnBack, btnLeft, btnRight, btnAdd, btnCancel;
	private JPanel jpBackground;
	
	public AddTest() {
		
		ImageIcon itemImg = new ImageIcon(
				"C:/dev/workspace/kidult_auction/src/kr/co/kidultAuction/img/addImg.png");
		ImageIcon itemAdd = new ImageIcon("C:/dev/workspace/kidult_auction/src/kr/co/kidultAuction/img/addImgBtn.JPG");
		ImageIcon itemCancel = new ImageIcon("C:/dev/workspace/kidult_auction/src/kr/co/kidultAuction/img/cancel.JPG");
		ImageIcon imgRegister = new ImageIcon("C:/dev/workspace/kidult_auction/src/kr/co/kidultAuction/img/img_register.JPG");
		
		jpBackground = new JPanel(); 
		jpBackground.setBackground(Color.white);
		
		lbFrontImg = new JLabel(itemImg);
		lbFrontImg.setBorder(new TitledBorder(""));
		lbLeftImg = new JLabel(itemImg);
		lbLeftImg.setBorder(new TitledBorder(""));
		lbRightImg = new JLabel(itemImg);
		lbRightImg.setBorder(new TitledBorder(""));
		lbBackImg = new JLabel(itemImg);
		lbBackImg.setBorder(new TitledBorder(""));
		
		lbFront = new JLabel("전면이미지");
		lbLeft = new JLabel("좌측이미지");
		lbRight = new JLabel("우측이미지");
		lbBack = new JLabel("후면이미지");
		
		btnFront = new JButton(imgRegister);
		btnLeft = new JButton(imgRegister);
		btnRight = new JButton(imgRegister);
		btnBack = new JButton(imgRegister);
		//이미지관련
		
		btnAdd = new JButton(itemAdd);
		btnCancel = new JButton(itemCancel);
		
		setLayout(null);
		setBounds(250, 50, 560, 670);
		
		jpBackground.setBounds(0, 0, 560, 640);
		
		lbFrontImg.setBounds(20, 20, 225, 225);
		lbLeftImg.setBounds(300, 20, 225, 225);
		lbRightImg.setBounds(300, 300, 225, 225);
		lbBackImg.setBounds(20, 300, 225, 225);
		
		lbFront.setBounds(100, 245, 70, 30);
		lbLeft.setBounds(380, 245, 70, 30);
		lbRight.setBounds(380, 525, 70, 30);
		lbBack.setBounds(100, 525, 70, 30);
		
		btnFront.setBounds(200, 250, 30, 25);
		btnLeft.setBounds(480, 250, 30, 25);
		btnRight.setBounds(480, 530, 30, 25);
		btnBack.setBounds(200, 530, 30, 25);
		
		btnAdd.setBounds(395, 575, 45, 45);
		btnCancel.setBounds(465, 575, 45, 45);
		
		add(lbFrontImg);
		add(lbLeftImg);
		add(lbRightImg);
		add(lbBackImg);
		
		add(lbFront);
		add(lbLeft);
		add(lbRight);
		add(lbBack);
		
		add(btnFront);
		add(btnLeft);
		add(btnRight);
		add(btnBack);
		
		add(btnAdd);
		add(btnCancel);
		
		add(jpBackground);
		
		setVisible(true);
		
		AddTestEvt aiife=new AddTestEvt(this);
		btnAdd.addActionListener(aiife);
		btnBack.addActionListener(aiife);
		btnCancel.addActionListener(aiife);
		btnFront.addActionListener(aiife);
		btnLeft.addActionListener(aiife);
		btnRight.addActionListener(aiife);
		
	}//addItemImageFrm

	public JButton getBtnFront() {
		return btnFront;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JButton getBtnLeft() {
		return btnLeft;
	}

	public JButton getBtnRight() {
		return btnRight;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JLabel getLbFrontImg() {
		return lbFrontImg;
	}

	public JLabel getLbBackImg() {
		return lbBackImg;
	}

	public JLabel getLbLeftImg() {
		return lbLeftImg;
	}

	public JLabel getLbRightImg() {
		return lbRightImg;
	}
	
	
	
	public static void main(String args[]) {
		new KidultServer();
		new AddTest();
	}
	



}//class
