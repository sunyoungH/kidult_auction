package kr.co.kidultAuction.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import kr.co.kidultAuction.dao.UserDAO_YW;


public class ListOfAuctionsFrm extends JDialog {
	
	private AuctionMainFrm amf;

	private JComboBox cbCategory; 
	
	private JButton btnSearch, btnShowDetail;
	
	private JLabel lbItemName, lbSeller, lbSellerId, lbSPrice, lbUserPrice, lbImg, lbDday;
	
	private JPanel jpImg, jpSpac, jpAuctionitem, jpAuctionList;
	
	
	public ListOfAuctionsFrm(AuctionMainFrm amf) throws SQLException {
		super(amf,"Kidult Auction - 경매목록",true);
		
////////////////////////////////// 리스트 구성 //////////////////////////////////
		
		jpAuctionList=new JPanel(); //전체 틀 패널
		int cnt=0;
		ArrayList<JPanel> arrAuctionitem=new ArrayList<>();
		JPanel jpSpacprice=null;
		for(int i=0;i<5;i++) {
			jpAuctionitem=new JPanel();	//innerPanel
			
			btnShowDetail=new JButton("상세정보");
			
			lbItemName=new JLabel("lbItemName");
			lbSeller=new JLabel("lbSeller");
			lbSellerId=new JLabel("lbSellerId");
			lbSPrice=new JLabel("lbSPrice");
			lbUserPrice=new JLabel("lbUserPrice");
			lbImg=new JLabel(new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/addImg.png"));
			lbDday=new JLabel("lbDday");
			
			jpSpacprice=new JPanel(new GridLayout(2,2));
			jpSpacprice.add(lbSeller);
			jpSpacprice.add(lbSellerId);
			jpSpacprice.add(lbSPrice);
			jpSpacprice.add(lbUserPrice);
			
			jpSpac=new JPanel(new GridLayout(4, 1));
			jpSpac.setPreferredSize(new Dimension(290, 212));
			jpSpac.add(lbItemName);
			jpSpac.add(jpSpacprice);
			jpSpac.add(lbDday);
			jpSpac.add(btnShowDetail);
			
			
			jpImg=new JPanel();
			jpImg.add(lbImg);
			
			jpAuctionitem.setBorder(new TitledBorder(""));
			jpAuctionitem.add(jpImg);
			jpAuctionitem.add(jpSpac);
			cnt++;
			
////////////////////////////////// 수정 //////////////////////////////////
			arrAuctionitem.add(jpAuctionitem);
			jpAuctionList.add(arrAuctionitem.get(i));
			jpAuctionList.setPreferredSize(new Dimension(300, cnt*200));
		}//end while
		
////////////////////////////////// 수정 //////////////////////////////////
		
////////////////////////////////// 리스트 구성 //////////////////////////////////
		
		UserDAO_YW u_dao=UserDAO_YW.getInstance();
		
		cbCategory=new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(u_dao.selectCategory().toArray()));
		
//		for(int i=0; i<categorylist.size(); i++) {
//			dbcm.addElement(categorylist.get(i));
//			
//		}//end for
		
		
//		cbCategory.setSelectedItem(categorylist);

		
		btnSearch=new JButton("검색");
		
		JScrollPane jspAuction=new JScrollPane(jpAuctionList);
		
		
		JPanel jpsearch=new JPanel();
		jpsearch.add(cbCategory);
		jpsearch.add(btnSearch);
		
        JPanel jp1=new JPanel();
		
		jp1.setBackground(new Color(0xFFFBF6));
		
		setLayout(null);
		
		
		//수동배치
		
		jpsearch.setBounds(200, 10, 200, 40);
		jspAuction.setBounds(10, 56, 565, 797);
		jp1.setBounds(0,0,600,900);
		add(jpsearch);
		add(jspAuction);
		add(jp1);
		
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
