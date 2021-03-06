package kr.co.kidultAuction.view;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.kidultAuction.controller.AdminPageFrmEvt;
import kr.co.kidultAuction.controller.ApproveFrmEvt;

/**
 * 승인대기 상세정보
 * @author user
 */
@SuppressWarnings("serial")
public class ApproveFrm extends JDialog {
	private AdminPageFrm apf;
	private AdminPageFrmEvt apfe;
	
	private JLabel lblImgRight, lblImgLeft, lblImgFront, lblImgBack, lblUserId, lblCategory
	           , lblStatus, lblItemName, lblSPrice, lblPeriod, lblItemInfo;
	private JTextField tfUserId, tfCategory, tfStatus, tfItemName, tfSPrice, tfPeriod;
	private JTextArea taItemInfo;
	private JButton btnCommit, btnReject;
	private JScrollPane jsp;
	
	private JPanel jp;
	
	public ApproveFrm(AdminPageFrm apf) throws SQLException {
		super(apf,"승인대기 상세정보",true);
		setLayout(null);
		
		lblImgRight = new JLabel("우측이미지");
		lblImgRight.setBorder(new TitledBorder(""));
		lblImgLeft = new JLabel("좌측이미지");
		lblImgLeft.setBorder(new TitledBorder(""));
		lblImgFront = new JLabel("전면 이미지");
		lblImgFront.setBorder(new TitledBorder(""));
		lblImgBack = new JLabel("후면 이미지");
		lblImgBack.setBorder(new TitledBorder(""));
		lblUserId = new JLabel("판매자ID");
		lblCategory = new JLabel("카테고리");
		lblStatus = new JLabel("상태");
		lblItemName = new JLabel("경매 물품명");
		lblSPrice = new JLabel("경매 시작가격");
		lblPeriod = new JLabel("경매 기간");
		lblItemInfo = new JLabel("상세정보");
		
		tfUserId=new JTextField("하이");
		tfCategory=new JTextField();
		tfStatus=new JTextField();
		tfItemName=new JTextField();
		tfSPrice=new JTextField();
		tfPeriod=new JTextField();
		
		taItemInfo=new JTextArea();
		taItemInfo.setBorder(new TitledBorder(""));
		jsp=new JScrollPane(taItemInfo);
		
		btnCommit=new JButton("승인완료");
		btnReject=new JButton("승인거부");
		
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
		
		jsp.setBounds(550,300,200,100);
		
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
		
		add(jsp);
		
		add(btnCommit);
		add(btnReject);
		
		add(jp);
		
		//이벤트 등록
    	ApproveFrmEvt afe=new ApproveFrmEvt(this);
		btnCommit.addActionListener(afe);
		btnReject.addActionListener(afe);
		
//		apfe=new AdminPageFrmEvt();
		
		 setBounds(700, 300, 810, 520);
         setVisible(true);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}//PermitFrm

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
