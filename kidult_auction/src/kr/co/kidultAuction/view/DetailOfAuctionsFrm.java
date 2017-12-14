package kr.co.kidultAuction.view;

import java.awt.Font;

import javax.swing.ImageIcon; 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import kr.co.kidultAuction.controller.DetailOfAuctionsEvt;

public class DetailOfAuctionsFrm extends JDialog {
	
	private ListOfAuctionsFrm loaf;
	
	private JLabel lblDlmg, lblDItemName, lblDSeller, lblDSellerId, lblDsPrice, lblUserPrice, lblDDay;
	
	private JTextArea taDItemInfo;
	
	private JButton btnBid, btnFrontImg, btnBackImg, btnRightImg, btnLeftImg;
	
	public DetailOfAuctionsFrm(ListOfAuctionsFrm loaf) {
		super(loaf,"경매 상세 페이지",true);
		this.loaf=loaf;
	
	lblDlmg=new JLabel(new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/daum.png"));
	lblDItemName=new JLabel("상품명");
	lblDSeller=new JLabel("경매자ID");
	lblDSellerId=new JLabel("alsgml4860");
	lblDsPrice=new JLabel("경매 시작가");
	lblUserPrice=new JLabel("1,000,000원");
	lblDDay=new JLabel("n일 후 마감", JLabel.CENTER);
	
	taDItemInfo=new JTextArea("제품 상세 설명");
	
	btnBid=new JButton("입찰");
	btnFrontImg=new JButton("전면");
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
	lblDItemName.setFont(new Font("맑은고딕", Font.BOLD, 40)); 
	
	// 경매 시작가, 가격
	lblDsPrice.setBounds(10, 390, 300, 60);
	lblDsPrice.setFont(new Font("맑은고딕", Font.BOLD, 25));
	lblUserPrice.setBounds(180, 390, 300, 60);
	lblUserPrice.setFont(new Font("맑은고딕", Font.BOLD, 25));
	
	// 경매자, 경매자 ID
	lblDSeller.setBounds(10, 430, 100, 60);
	lblDSeller.setFont(new Font("맑은고딕", Font.BOLD, 25));
	lblDSellerId.setBounds(180, 430, 300, 60);
	lblDSellerId.setFont(new Font("맑은고딕", Font.BOLD, 25));
	
	// 경매 마감일
	lblDDay.setBounds(10, 490, 565, 60);
	lblDDay.setFont(new Font("맑은고딕", Font.BOLD, 40));
	
	//상세 정보
	taDItemInfo.setBounds(10, 560, 565, 200);
	taDItemInfo.setEditable(false);
	
	//입찰 버튼
	btnBid.setBounds(10, 770, 565, 50);
	
	add(lblDlmg);
	add(btnFrontImg);
	add(btnBackImg);
	add(btnRightImg);
	add(btnLeftImg);
	add(lblDItemName);
	add(lblDsPrice);
	add(lblUserPrice);
	add(lblDSeller);
	add(lblDSellerId);
	add(lblDDay);
	add(taDItemInfo);
	add(btnBid);
	
	DetailOfAuctionsEvt doae=new DetailOfAuctionsEvt(this);
	btnBid.addActionListener(doae);
//	btnFrontImg.addActionListener(doae);
//	btnBackImg.addActionListener(doae);
//	btnRightImg.addActionListener(doae);
//	btnLeftImg.addActionListener(doae);
	
	setBounds(100, 20, 600, 868);
	setVisible(true);
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
	

	
	/*public static void main(String[] args) {
		new DetailOfAuctionsFrm();
		
	}//main
*/}//class
