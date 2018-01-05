package kr.co.kidultAuction.view;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import kr.co.kidultAuction.controller.DetailOfAuctionsEvt;
import kr.co.kidultAuction.dao.UserDAO_YW;
import kr.co.kidultAuction.vo.DetailOfAuctionVO;

@SuppressWarnings("serial")
public class DetailOfAuctionsFrm extends JDialog {
	
	private ListOfAuctionsFrm loaf;
	
	private JLabel lblStatus,lblDlmg, lblDItemName, lblDSeller, lblDSellerId, lblDsPrice, lblUserPrice, lblDDay;
	
	private JTextArea taDItemInfo;
	
	private JButton btnBid, btnFrontImg, btnBackImg, btnRightImg, btnLeftImg;
	
	public static String AUC_CODE;//경매코드
	
	private ImageIcon defultImg;

	public DetailOfAuctionsFrm(ListOfAuctionsFrm loaf) throws SQLException {
		super(loaf,"경매 상세 페이지",true);
		this.loaf=loaf;
		
		AUC_CODE=loaf.AUC_CODE;
		UserDAO_YW u_dao=UserDAO_YW.getInstance();
		List<DetailOfAuctionVO> doav=u_dao.detail(AUC_CODE);
		defultImg=new ImageIcon(doav.get(0).getFront_img());
		
	lblDlmg=new JLabel(defultImg);
	lblDItemName=new JLabel(doav.get(0).getItem_name());
	lblStatus=new JLabel(doav.get(0).getStatus());
	lblDSeller=new JLabel("판매자");
	lblDSellerId=new JLabel(doav.get(0).getUser_id());
	lblDsPrice=new JLabel("시작가격");
	lblUserPrice=new JLabel(new DecimalFormat("#,###원").format(doav.get(0).getStart_price()));
	lblDDay=new JLabel(doav.get(0).getPeriod()+"일");
	
	taDItemInfo=new JTextArea(doav.get(0).getDetail_info());
	
	btnBid=new JButton("입찰");
	btnFrontImg=new JButton("정면");
	btnBackImg=new JButton("후면");
	btnRightImg=new JButton("좌측면");
	btnLeftImg=new JButton("우측면");
	
	setLayout(null);
	
	lblDlmg.setBounds(90, 10, 400, 300); //이미지
	
	btnFrontImg.setBounds(95, 310, 75, 30); //전면 이미지 버튼
	btnBackImg.setBounds(199, 310, 75, 30); //후면 이미지 버튼
	btnRightImg.setBounds(304, 310, 75, 30); //좌측면 이미지 버튼
	btnLeftImg.setBounds(409, 310, 75, 30); //우측면 이미지 버튼
	
	
	// 경매 물품명
	lblDItemName.setBounds(10, 350, 300, 60); 
	lblDItemName.setFont(new Font("Serif", Font.BOLD, 40)); 
	
	// 상품 상태
	lblStatus.setBorder(new TitledBorder(""));
	lblStatus.setBounds(515, 350, 60, 40);
	lblStatus.setFont(new Font("Serif", Font.BOLD, 15)); 
	
	// 경매 시작가, 가격
	lblDsPrice.setBounds(10, 390, 300, 60);
	lblDsPrice.setFont(new Font("Serif", Font.BOLD, 25));
	lblUserPrice.setBounds(180, 390, 300, 60);
	lblUserPrice.setFont(new Font("Serif", Font.BOLD, 25));
	
	// 경매자, 경매자 ID
	lblDSeller.setBounds(10, 430, 100, 60);
	lblDSeller.setFont(new Font("Serif", Font.BOLD, 25));
	lblDSellerId.setBounds(180, 430, 300, 60);
	lblDSellerId.setFont(new Font("Serif", Font.BOLD, 25));
	
	// 경매 마감일
	lblDDay.setBounds(10, 490, 565, 60);
	lblDDay.setFont(new Font("Serif", Font.BOLD, 40));
	
	//상세 정보
	taDItemInfo.setBounds(10, 560, 565, 200);
	taDItemInfo.setEditable(false);
	
	//입찰 버튼
	btnBid.setBounds(10, 770, 565, 50);
	
	JPanel jp = new JPanel();

	jp.setBackground(new Color(0xFFFFCE));

	jp.setBounds(0, 0, 600, 868);
	
	add(lblDlmg);
	add(btnFrontImg);
	add(btnBackImg);
	add(btnRightImg);
	add(btnLeftImg);
	add(lblDItemName);
	add(lblStatus);
	add(lblDsPrice);
	add(lblUserPrice);
	add(lblDSeller);
	add(lblDSellerId);
	add(lblDDay);
	add(taDItemInfo);
	add(btnBid);
	add(jp);
	
	DetailOfAuctionsEvt doae=new DetailOfAuctionsEvt(this);
	btnBid.addActionListener(doae);
	btnFrontImg.addActionListener(doae);
	btnBackImg.addActionListener(doae);
	btnRightImg.addActionListener(doae);
	btnLeftImg.addActionListener(doae);
	
	setBounds(100, 20, 600, 868);
	setVisible(true);
	setResizable(false);
	setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	
	
	}//DetailOfAuctionsFrm
	

	public JButton getBtnBid() {
		return btnBid;
	}

	public JButton getBtnFrontImg() {
		return btnFrontImg;
	}

	public JButton getBtnBackImg() {
		return btnBackImg;
	}

	public JButton getBtnRightImg() {
		return btnRightImg;
	}

	public JButton getBtnLeftImg() {
		return btnLeftImg;
	}
	
	public JLabel getLblDItemName() {
		return lblDItemName;
	}

	public JLabel getLblUserPrice() {
		return lblUserPrice;
	}

	public JLabel getLblDsPrice() {
		return lblDsPrice;
	}

	public JLabel getLblDlmg() {
		return lblDlmg;
	}

}//class
