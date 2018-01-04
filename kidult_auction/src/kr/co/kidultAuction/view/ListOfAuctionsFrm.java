package kr.co.kidultAuction.view;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import kr.co.kidultAuction.vo.ListOfAuctionVO;


@SuppressWarnings("serial")
public class ListOfAuctionsFrm extends JDialog {
	
	private AuctionMainFrm amf;

	private JComboBox cbCategory; 
	
	private JButton btnSearch, btnShowDetail;
	
	private JLabel lbItemName, lbSeller, lbSellerId, lbSPrice, lbUserPrice, lbImg, lbDday;
	
	private ArrayList<JButton> arrbtn=new ArrayList<JButton>();
	
	private ArrayList<JPanel> arrjp=new ArrayList<JPanel>();
	
	private ArrayList<JLabel> arrjl=new ArrayList<JLabel>();
	
	DefaultComboBoxModel<String> dcbm;
	
	UserDAO_YW u_dao=UserDAO_YW.getInstance();
	List<ListOfAuctionVO> lloav=null;
	
	public static String AUC_CODE;
	
	String auc_code;
	

	public List<ListOfAuctionVO> getLloav;

	public ListOfAuctionsFrm(AuctionMainFrm amf,String category) throws SQLException {
		
		super(amf,"Kidult Auction - 경매목록",true);
		
		List<String> cg=u_dao.categoryList();
		
		dcbm=new DefaultComboBoxModel<>();
		
		dcbm.addElement("전체상품");
		for(int i=0; i<cg.size(); i++) {
			switch(cg.get(i)) {
			case "F" : dcbm.addElement("figure");
			break;
			case "P" : dcbm.addElement("plamodel");
			break;
			case "L" : dcbm.addElement("lego");
			}//end switch
		}//end for
		
		if(category==null) {
			category="전체상품";
		}//end if
		
		lloav=u_dao.selectCategory(category);
		
		
////////////////////////////////// 리스트 구성 //////////////////////////////////
		
		
		JPanel jpAuctionList=new JPanel(); //전체 틀 패널
		int cnt=0; //스크롤바 길이
		JPanel ijp; //상품별 패널
		btnShowDetail=null;
		
		System.out.println("listfrm "+lloav);
			
		for(int i=0; i<lloav.size();i++) {
			ijp=new JPanel();
			ijp.setLayout(null);
			btnShowDetail=new JButton("상세정보");
			btnShowDetail.setBounds(250, 160, 277, 40);
			arrbtn.add(btnShowDetail);
			
			
			// 경매코드 저장
			arrjl.add(new JLabel(lloav.get(i).getAuc_code()));
			ImageIcon img=new ImageIcon(/*lloav.get(i).getFront_img()*/"C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/cancel.JPG");
			
			ijp.add(lbImg=new JLabel(img));
			ijp.add(lbItemName=new JLabel(lloav.get(i).getItem_name()));
			ijp.add(lbSeller=new JLabel("판매자"));
			ijp.add(lbSellerId=new JLabel(lloav.get(i).getUser_id()));
			ijp.add(lbSPrice=new JLabel("시작가격"));
			ijp.add(lbUserPrice=new JLabel(new DecimalFormat("#,###원").format(lloav.get(i).getStart_price())));
			ijp.add(lbDday=new JLabel(lloav.get(i).getPeriod()+"일"));
				
			lbImg.setBounds(10, 10, 265, 190);
			lbImg.setPreferredSize(new Dimension(100, 100));
			lbItemName.setBounds(250, 10, 265, 40);
			lbItemName.setFont(new Font("Serif", Font.BOLD, 40)); 
			lbSeller.setBounds(250, 50, 100, 25);
			lbSeller.setFont(new Font("Serif", Font.BOLD, 25)); 
			lbSellerId.setBounds(380, 50, 150, 25);
			lbSellerId.setFont(new Font("Serif", Font.BOLD, 25)); 
			lbSPrice.setBounds(250, 80, 100, 25);
			lbSPrice.setFont(new Font("Serif", Font.BOLD, 25)); 
			lbUserPrice.setBounds(380, 80, 400, 25);
			lbUserPrice.setFont(new Font("Serif", Font.BOLD, 25)); 
			lbDday.setBounds(370, 120, 100, 25);
			lbDday.setFont(new Font("Serif", Font.BOLD, 25)); 
			
			ijp.setBorder(new TitledBorder(""));
			ijp.setPreferredSize(new Dimension(535, 212));
			ijp.add(arrbtn.get(i));
			arrjp.add(ijp);
			jpAuctionList.add(arrjp.get(i));
			cnt++;
		}//end for i
		JScrollPane jspAuction=new JScrollPane(jpAuctionList);
		
		jpAuctionList.setPreferredSize(new Dimension(350, cnt*218));
		
		
		cbCategory=new JComboBox<>(dcbm);
		cbCategory.setSelectedItem(category);
		
		btnSearch=new JButton("검색");
		
		
		JPanel jpsearch=new JPanel();
		jpsearch.add(cbCategory);
		jpsearch.add(btnSearch);
		
		setLayout(null);
		
		
		//수동배치
		
		jpsearch.setBounds(200, 10, 200, 40);
		jspAuction.setBounds(10, 56, 565, 657);
		add(jpsearch);
		add(jspAuction);
		
		//이벤트 등록
		ListOfAuctionsEvt loae=new ListOfAuctionsEvt(this,amf);
		
		for(int i=0 ; i < arrbtn.size();i++) {
			arrbtn.get(i).addActionListener(loae);
		}//end for
		cbCategory.addActionListener(loae);
		btnSearch.addActionListener(loae);
		
		
		
		setBounds(100, 100, 590, 750);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		
		
	}//ListOfAuctionsFrm


	public ArrayList<JButton> getArrbtn() {
		return arrbtn;
	}

	public JComboBox getCbCategory() {
		return cbCategory;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}


	public JButton getBtnShowDetail() {
		return btnShowDetail;
	}


	public ArrayList<JLabel> getArrjl() {
		return arrjl;
	}


	public String getAuc_code() {
		return auc_code;
	}

}//class
