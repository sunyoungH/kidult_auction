package kr.co.kidultAuction.view;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.kidultAuction.controller.AddAuctionItemFrmEvt;
import kr.co.kidultAuction.controller.MyPageFrmEvt;

@SuppressWarnings("serial")
public class AddAuctionItemFrm extends JDialog {
	
	private JLabel lbItemImg, lbCategory, lbItemName, lbItemStatus, lbStartPrice, lbAuctionPeriod, lbItemInfo,
			lbWon;
	private JTextField tfItemName, tfStartPrice;
	private DefaultComboBoxModel<String> dcbmCategory, dcbmStatus, dcbmPeriod;
	private JComboBox<String> jcbCategory, jcbStatus, jcbPeriod;
	private JButton btnAddImg, btnPermit, btnCancel;
	private JTextArea taItemInfo;

	public AddAuctionItemFrm(AuctionMainFrm amf) {
		super(amf,"경매 등록",true); 
		
		String path = System.getProperty("user.dir");
		System.out.println(path);
		
		ImageIcon itemImg = new ImageIcon(
				path+"/src/kr/co/kidultAuction/img/addImg.png");

		lbItemImg = new JLabel(itemImg);
		lbCategory = new JLabel("카테고리 선택");
		lbItemName = new JLabel("경매 물품명");
		lbItemStatus = new JLabel("물품 상태");
		lbStartPrice = new JLabel("경매 시작 가격");
		lbAuctionPeriod = new JLabel("경매 시간");
		lbWon = new JLabel("원");
		lbItemInfo = new JLabel("물품 소개");

		tfItemName = new JTextField();
		tfStartPrice = new JTextField();

		dcbmCategory = new DefaultComboBoxModel<>();
		String[] categoryType = { "카테고리 선택", "레고", "프라모델", "피규어", "기타" };
		for (String type : categoryType) {
			dcbmCategory.addElement(type);
		} // end for
		jcbCategory = new JComboBox<String>(dcbmCategory);

		dcbmStatus = new DefaultComboBoxModel<>();
		String[] statusType = { "미개봉", "개봉" };
		for (String type : statusType) {
			dcbmStatus.addElement(type);
		} // end for
		jcbStatus = new JComboBox<String>(dcbmStatus);

		dcbmPeriod = new DefaultComboBoxModel<>();
		String[] periodType = { "1일", "2일", "3일" };
		for (String type : periodType) {
			dcbmPeriod.addElement(type);
		} // end for
		jcbPeriod = new JComboBox<String>(dcbmPeriod);

		taItemInfo = new JTextArea();

		JScrollPane jspItemInfo = new JScrollPane(taItemInfo);

		btnAddImg = new JButton("이미지 등록");
		btnPermit = new JButton("승인 신청");
		btnCancel = new JButton("취소");
		
		JPanel jp=new JPanel();	
		jp.setBackground(new Color(0xFFFBF6));

		///////////////////////////////////////////////////

		setLayout(null);
		setBounds(500, 200, 600, 600);

		lbItemImg.setBounds(20, 20, 225, 225);
		lbCategory.setBounds(275, 30, 90, 30);
		lbItemName.setBounds(275, 75, 90, 30);
		lbItemStatus.setBounds(275, 120, 90, 30);
		lbStartPrice.setBounds(275, 165, 90, 30);
		lbAuctionPeriod.setBounds(275, 210, 90, 30);
		lbWon.setBounds(552, 165, 30, 30);
		lbItemInfo.setBounds(20, 280, 60, 30);

		tfItemName.setBounds(400, 75, 150, 30);
		tfStartPrice.setBounds(400, 165, 150, 30);

		jcbCategory.setBounds(400, 30, 150, 30);
		jcbStatus.setBounds(400, 120, 150, 30);
		jcbPeriod.setBounds(400, 210, 150, 30);

		btnAddImg.setBounds(20, 250, 110, 30);

		jspItemInfo.setBounds(20, 310, 545, 200);

		btnPermit.setBounds(400, 520, 90, 30);
		btnCancel.setBounds(500, 520, 60, 30);
		
		jp.setBounds(0, 0, 600, 600);

		/////////////////////////////////////////////////

		add(lbItemImg);
		add(lbCategory);
		add(lbItemName);
		add(lbItemStatus);
		add(lbStartPrice);
		add(lbAuctionPeriod);
		add(lbWon);
		add(lbItemInfo);

		add(tfItemName);
		add(tfStartPrice);

		add(jcbCategory);
		add(jcbStatus);
		add(jcbPeriod);

		add(btnAddImg);

		add(jspItemInfo);

		add(btnPermit);
		add(btnCancel);
		
		add(jp);

		///////////////////////////////////////////////////

		AddAuctionItemFrmEvt aaife=new AddAuctionItemFrmEvt(this);
		btnAddImg.addActionListener(aaife);
		btnCancel.addActionListener(aaife);
		btnPermit.addActionListener(aaife);
		
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
	}// addAuctionItemFrm

	public JButton getBtnAddImg() {
		return btnAddImg;
	}

	public JButton getBtnPermit() {
		return btnPermit;
	}

	public JButton getBtnCancel() {
		return btnCancel; 
	}

	public JLabel getLbItemImg() {
		return lbItemImg;
	}
	/*-----------------------------------------------------------------------------------------*/	

	public JTextField getTfItemName() {
		return tfItemName;
	}

	public JTextField getTfStartPrice() {
		return tfStartPrice;
	}

	public JComboBox<String> getJcbCategory() {
		return jcbCategory;
	}

	public JComboBox<String> getJcbStatus() {
		return jcbStatus;
	}

	public JComboBox<String> getJcbPeriod() {
		return jcbPeriod;
	}

	public JTextArea getTaItemInfo() {
		return taItemInfo;
	}


	
	

	
	
	
	
	

}// class
