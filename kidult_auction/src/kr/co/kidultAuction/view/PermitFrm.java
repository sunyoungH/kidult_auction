package kr.co.kidultAuction.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * ���δ�� ������
 * @author user
 */
@SuppressWarnings("serial")
public class PermitFrm extends JDialog {
	private AuctionMainFrm amf;
	
	private JLabel lblImgRight, lblImgLeft, lblImgFront, lblImgBack, lblUserId, lblCategory
	           , lblStatus, lblItemName, lblSPrice, lblPeriod, lblItemInfo;
	private JTextField tfUserId, tfCategory, tfStatus, tfItemName, tfSPrice, tfPeriod;
	private JTextArea taItemInfo;
	private JButton btnCommit, btnReject;
	
	private JPanel jp;
	
	public PermitFrm(AuctionMainFrm amf) {
		super(amf,"���δ�� ������");
		setLayout(null);
		
		lblImgRight = new JLabel("���̹���");
		lblImgRight.setBorder(new TitledBorder(""));
		lblImgLeft = new JLabel("���̹���");
		lblImgLeft.setBorder(new TitledBorder(""));
		lblImgFront = new JLabel("���̹���");
		lblImgFront.setBorder(new TitledBorder(""));
		lblImgBack = new JLabel("���̹���");
		lblImgBack.setBorder(new TitledBorder(""));
		lblUserId = new JLabel("�Ǹ���ID");
		lblCategory = new JLabel("ī�װ�");
		lblStatus = new JLabel("����");
		lblItemName = new JLabel("��� ��ǰ��");
		lblSPrice = new JLabel("��� ���۰���");
		lblPeriod = new JLabel("��� �Ⱓ");
		lblItemInfo = new JLabel("������");
		
		tfUserId=new JTextField();
		tfCategory=new JTextField();
		tfStatus=new JTextField();
		tfItemName=new JTextField();
		tfSPrice=new JTextField();
		tfPeriod=new JTextField();
		
		taItemInfo=new JTextArea();
		taItemInfo.setBorder(new TitledBorder(""));
		
		btnCommit=new JButton("���οϷ�");
		btnReject=new JButton("���ΰź�");
		
		jp=new JPanel();
		jp.setBackground(Color.WHITE);
		
		lblImgRight.setBounds(40,30,200,200);
		lblImgLeft.setBounds(280,30,200,200);
		lblImgFront.setBounds(40,250,200,200);
		lblImgBack.setBounds(280,250,200,200);
		lblUserId.setBounds(550,30,100,30);
		lblCategory.setBounds(550,70,100,30);
		lblStatus.setBounds(550,110,100,30);
		lblItemName.setBounds(550,150,100,30);
		lblSPrice.setBounds(550,190,100,30);
		lblPeriod.setBounds(550,230,100,30);
		lblItemInfo.setBounds(550,270,100,30);
		
		tfUserId.setBounds(650,30,100,30);
		tfCategory.setBounds(650,70,100,30);
		tfStatus.setBounds(650,110,100,30);
		tfItemName.setBounds(650,150,100,30);
		tfSPrice.setBounds(650,190,100,30);
		tfPeriod.setBounds(650,230,100,30);
		
		taItemInfo.setBounds(550,300,200,100);
		
		btnCommit.setBounds(550,420,90,30);
		btnReject.setBounds(660,420,90,30);
		jp.setBounds(0,0,810,520);
		
		add(lblImgRight);
		add(lblImgLeft);
		add(lblImgFront);
		add(lblImgBack);
		add(lblUserId);
		add(lblCategory);
		add(lblStatus);
		add(lblItemName);
		add(lblSPrice);
		add(lblPeriod);
		add(lblItemInfo);
		
		add(tfUserId);
		add(tfCategory);
		add(tfStatus);
		add(tfItemName);
		add(tfSPrice);
		add(tfPeriod);
		
		add(taItemInfo);
		
		add(btnCommit);
		add(btnReject);
		
		add(jp);
		
		//�̺�Ʈ ���
//    	PermitFrmEvt pfe=new PermitFrmEvt(this);
//		btnCommit.addActionListener(pfe);
//		btnReject.addActionListener(pfe);
		
		
		 setBounds(700, 300, 810, 520);
         setVisible(true);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//PermitFrm

	public AuctionMainFrm getAmf() {
		return amf;
	}

	public JLabel getLblImgRight() {
		return lblImgRight;
	}

	public JLabel getLblImgLeft() {
		return lblImgLeft;
	}

	public JLabel getLblImgFront() {
		return lblImgFront;
	}

	public JLabel getLblImgBack() {
		return lblImgBack;
	}

	public JLabel getLblUserId() {
		return lblUserId;
	}

	public JLabel getLblCategory() {
		return lblCategory;
	}

	public JLabel getLblStatus() {
		return lblStatus;
	}

	public JLabel getLblItemName() {
		return lblItemName;
	}

	public JLabel getLblSPrice() {
		return lblSPrice;
	}

	public JLabel getLblPeriod() {
		return lblPeriod;
	}

	public JLabel getLblItemInfo() {
		return lblItemInfo;
	}

	public JTextField getTfUserId() {
		return tfUserId;
	}

	public JTextField getTfCategory() {
		return tfCategory;
	}

	public JTextField getTfStatus() {
		return tfStatus;
	}

	public JTextField getTfItemName() {
		return tfItemName;
	}

	public JTextField getTfSPrice() {
		return tfSPrice;
	}

	public JTextField getTfPeriod() {
		return tfPeriod;
	}

	public JTextArea getTaItemInfo() {
		return taItemInfo;
	}

	public JButton getBtnCommit() {
		return btnCommit;
	}

	public JButton getBtnReject() {
		return btnReject;
	}

	public JPanel getJp() {
		return jp;
	}

}//class
