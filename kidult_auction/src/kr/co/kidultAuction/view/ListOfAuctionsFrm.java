package kr.co.kidultAuction.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import kr.co.kidultAuction.controller.ListOfAuctionsEvt;


public class ListOfAuctionsFrm extends JDialog {
	
	private AuctionMainFrm amf;

	private JComboBox<String> cbCategory; 
	
	private JButton btnSearch, btnShowDetail;
	
	private JLabel lbItemName, lbSeller, lbSellerId, lbSPrice, lbUserPrice, lbImg, lbDday;
	
	private JPanel jpImg, jpSpac, jpAuctionitem, jpAuctionList;
	
	
	public ListOfAuctionsFrm(AuctionMainFrm amf) {
		super(amf,"Kidult Auction - 경매목록",true);
		
		btnShowDetail=new JButton("상세정보");
		
		lbItemName=new JLabel("lbItemName");
		lbSeller=new JLabel("lbSeller");
		lbSellerId=new JLabel("lbSellerId");
		lbSPrice=new JLabel("lbSPrice");
		lbUserPrice=new JLabel("lbUserPrice");
		lbImg=new JLabel(new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/addImg.png"));
		lbDday=new JLabel("lbDday");
		
		JPanel jpSpacprice=new JPanel(new GridLayout(2,2));
		jpSpacprice.add(lbSeller);
		jpSpacprice.add(lbSellerId);
		jpSpacprice.add(lbSPrice);
		jpSpacprice.add(lbUserPrice);
		
		
		jpSpac=new JPanel(new GridLayout(4, 1));
		jpSpac.setPreferredSize(new Dimension(300, 212));
		jpSpac.add(lbItemName);
		jpSpac.add(jpSpacprice);
		jpSpac.add(lbDday);
		jpSpac.add(btnShowDetail);
		
		
		jpImg=new JPanel();
//		jpImg.setPreferredSize(new Dimension(225, 225));
		jpImg.add(lbImg);
		
		ArrayList<JPanel> arrAuctionitem=new ArrayList<JPanel>();
		jpAuctionitem=new JPanel();
		jpAuctionitem.setBorder(new TitledBorder(""));
		jpAuctionitem.add(jpImg);
		jpAuctionitem.add(jpSpac);
		
		//무한루프 돌리면 될듯
		
		arrAuctionitem.add(jpAuctionitem);
		
		
		jpAuctionList=new JPanel();
		jpAuctionList.add(arrAuctionitem.get(0));
		
		
		DefaultComboBoxModel<String> dbcm=new DefaultComboBoxModel<String>();
		
		cbCategory=new JComboBox<String>(dbcm);
		cbCategory.addItem("카테고리 선택");
		cbCategory.addItem("레고");
		cbCategory.addItem("프라모델");
		cbCategory.addItem("피규어");
		cbCategory.addItem("기타");
		
		btnSearch=new JButton("검색");
		
		setLayout(null);
		
		JPanel jpsearch=new JPanel();
		jpsearch.add(cbCategory);
		jpsearch.add(btnSearch);
		
		JScrollPane jspAuction=new JScrollPane(jpAuctionList);
		
		//수동배치
		
		jpsearch.setBounds(200, 10, 200, 40);
		jspAuction.setBounds(10, 56, 565, 797);
		add(jpsearch);
		add(jspAuction);
		
		//이벤트 등록
		ListOfAuctionsEvt loae=new ListOfAuctionsEvt(this);
		btnShowDetail.addActionListener(loae);
		cbCategory.addActionListener(loae);
		
		
		setBounds(100, 100, 600, 900);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		
		
	}//ListOfAuctionsFrm
	

	public JButton getBtnShowDetail() {
		return btnShowDetail;
	}


	public JComboBox<String> getCbCategory() {
		return cbCategory;
	}

	
}//class
