package kr.co.kidultAuction.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.kidultAuction.controller.AddAuctionItemFrmEvt;
import kr.co.kidultAuction.controller.MyPageFrmEvt;

@SuppressWarnings("serial")
public class AddAuctionItemFrm extends JDialog {
	
	private JLabel jlbItemImg, jlbCategory, jlbItemName, jlbItemStatus, jlbStartPrice, jlbAuctionPeriod, jlbItemInfo,
			jlbWon;
	private JTextField jtfItemName, jtfStartPrice;
	private DefaultComboBoxModel<String> dcbmCategory, dcbmStatus, dcbmPeriod;
	private JComboBox<String> jcbCategory, jcbStatus, jcbPeriod;
	private JButton btnAddImg, btnPermit, btnCancel;
	private JTextArea jtaItemInfo;

	public AddAuctionItemFrm(AuctionMainFrm amf) {
		super(amf,"경매 등록");
		
		ImageIcon itemImg = new ImageIcon(
				"C:/dev/workspace/kidult_auction/src/kr/co/kidultAuction/img/addImg.png");

		jlbItemImg = new JLabel(itemImg);
		jlbCategory = new JLabel("카테고리 선택");
		jlbItemName = new JLabel("경매 물품명");
		jlbItemStatus = new JLabel("물품 상태");
		jlbStartPrice = new JLabel("경매 시작 가격");
		jlbAuctionPeriod = new JLabel("경매 시간");
		jlbWon = new JLabel("원");
		jlbItemInfo = new JLabel("물품 소개");

		jtfItemName = new JTextField();
		jtfStartPrice = new JTextField();

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

		jtaItemInfo = new JTextArea();

		JScrollPane jspItemInfo = new JScrollPane(jtaItemInfo);

		btnAddImg = new JButton("이미지 등록");
		btnPermit = new JButton("승인 신청");
		btnCancel = new JButton("취소");

		///////////////////////////////////////////////////

		setLayout(null);
		setBounds(500, 200, 600, 600);

		jlbItemImg.setBounds(20, 20, 225, 225);
		jlbCategory.setBounds(275, 30, 90, 30);
		jlbItemName.setBounds(275, 75, 90, 30);
		jlbItemStatus.setBounds(275, 120, 90, 30);
		jlbStartPrice.setBounds(275, 165, 90, 30);
		jlbAuctionPeriod.setBounds(275, 210, 90, 30);
		jlbWon.setBounds(552, 165, 30, 30);
		jlbItemInfo.setBounds(20, 280, 60, 30);

		jtfItemName.setBounds(400, 75, 150, 30);
		jtfStartPrice.setBounds(400, 165, 150, 30);

		jcbCategory.setBounds(400, 30, 150, 30);
		jcbStatus.setBounds(400, 120, 150, 30);
		jcbPeriod.setBounds(400, 210, 150, 30);

		btnAddImg.setBounds(20, 250, 110, 30);

		jspItemInfo.setBounds(20, 310, 545, 200);

		btnPermit.setBounds(400, 520, 90, 30);
		btnCancel.setBounds(500, 520, 60, 30); 

		/////////////////////////////////////////////////

		add(jlbItemImg);
		add(jlbCategory);
		add(jlbItemName);
		add(jlbItemStatus);
		add(jlbStartPrice);
		add(jlbAuctionPeriod);
		add(jlbWon);
		add(jlbItemInfo);

		add(jtfItemName);
		add(jtfStartPrice);

		add(jcbCategory);
		add(jcbStatus);
		add(jcbPeriod);

		add(btnAddImg);

		add(jspItemInfo);

		add(btnPermit);
		add(btnCancel);

		///////////////////////////////////////////////////

		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		AddAuctionItemFrmEvt aaife=new AddAuctionItemFrmEvt(this);
		btnAddImg.addActionListener(aaife);
		btnCancel.addActionListener(aaife);
		btnPermit.addActionListener(aaife);
		
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

	
	
	

}// class
