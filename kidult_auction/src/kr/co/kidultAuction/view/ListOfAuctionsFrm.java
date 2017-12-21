package kr.co.kidultAuction.view;

import java.awt.Button;
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


@SuppressWarnings("serial")
public class ListOfAuctionsFrm extends JDialog {
	
	private AuctionMainFrm amf;

	private JComboBox cbCategory; 
	
	private JButton btnSearch;
	
	private ArrayList<JButton> btnShowDetail;
	
	private ArrayList<JLabel> lbItemName, lbSeller, lbSellerId, lbSPrice, lbUserPrice, lbImg, lbDday;
	
	private ArrayList<JPanel> arrAuctionitem, jpImg, jpSpac, jpAuctionitem, jpSpacprice;
	
	private JPanel jp, jpAuctionList;
	
	public ListOfAuctionsFrm(AuctionMainFrm amf) throws SQLException {
		super(amf,"Kidult Auction - 경매목록",true);
		
		UserDAO_YW u_dao=UserDAO_YW.getInstance();
		
////////////////////////////////// 리스트 구성 //////////////////////////////////
		
		jpAuctionList=new JPanel(); //전체 틀 패널
		int cnt=0;
		arrAuctionitem=new ArrayList<>();
//		jpSpacprice=null;
//		for(int i=0;i<5;i++) {
			jpAuctionitem=new ArrayList<>();	//innerPanel
			
//			btnShowDetail=new JButton("상세정보");
			
			JLabel[][] jl=new JLabel[2][7];
			for(int i=0; i<jl.length;i++) {
				JButton[][] jb=new JButton[2][2];
				for(int j=0; j<jl[i].length;j++) {
					jl[i][j]=new JLabel(i+"1");
					jp.add(jl[i][j]);
				}
				jpAuctionList.add(arrAuctionitem.get(i));
			}
//			lbSeller=new ArrayList<>();
//			lbSellerId=new ArrayList<>();
//			lbSPrice=new ArrayList<>();
//			lbUserPrice=new ArrayList<>();
//			lbImg=new ArrayList<>(new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/addImg.png"));
//			lbDday=new ArrayList<>();
			
			jpSpacprice=new ArrayList<>();
//			jpSpacprice.add(lbSeller);
//			jpSpacprice.add(lbSellerId);
//			jpSpacprice.add(lbSPrice);
//			jpSpacprice.add(lbUserPrice);
			
			jpSpac=new ArrayList<>();
//			jpSpac.setPreferredSize(new Dimension(290, 212));
//			jpSpac.add(lbItemName);
//			jpSpac.add(jpSpacprice);
//			jpSpac.add(lbDday);
//			jpSpac.add(btnShowDetail);
			
			
			jpImg=new ArrayList<>();
//			jpImg.add(lbImg);
			
//			jpAuctionitem.setBorder(new TitledBorder(""));
//			jpAuctionitem.add(jpImg);
//			jpAuctionitem.add(jpSpac);
			cnt++;
			
////////////////////////////////// 수정 //////////////////////////////////
			arrAuctionitem.add(jp);
			
			jpAuctionList.setPreferredSize(new Dimension(300, cnt*200));
			
//		}//end while
		
////////////////////////////////// 수정 //////////////////////////////////
		
////////////////////////////////// 리스트 구성 //////////////////////////////////
		
		List<String> list=u_dao.selectCategory();
		
		DefaultComboBoxModel<String> dcbm=new DefaultComboBoxModel<>();
		
		dcbm.addElement("전체상품");
		for(int i=0; i<list.size(); i++) {
			switch(list.get(i)) {
			case "F" : dcbm.addElement("피규어");
			break;
			case "P" : dcbm.addElement("프라모델");
			break;
			case "L" : dcbm.addElement("레고");
			}//end switch
		}//end for
		
		
		cbCategory=new JComboBox<>(dcbm);
		
		btnSearch=new JButton("검색");
		
		JScrollPane jspAuction=new JScrollPane(jpAuctionList);
		
		
		JPanel jpsearch=new JPanel();
		jpsearch.add(cbCategory);
		jpsearch.add(btnSearch);
		
		setLayout(null);
		
		
		//수동배치
		
		jpsearch.setBounds(200, 10, 200, 40);
		jspAuction.setBounds(10, 56, 565, 797);
		add(jpsearch);
		add(jspAuction);
		
		//이벤트 등록
		ListOfAuctionsEvt loae=new ListOfAuctionsEvt(this);
//		btnShowDetail.addActionListener(loae);
		cbCategory.addActionListener(loae);
		btnSearch.addActionListener(loae);
		
		
		
		setBounds(100, 100, 600, 900);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		
		
	}//ListOfAuctionsFrm


	public JComboBox getCbCategory() {
		return cbCategory;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

}//class
