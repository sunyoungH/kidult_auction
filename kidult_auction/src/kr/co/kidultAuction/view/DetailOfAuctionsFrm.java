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
		super(loaf,"��� �� ������",true);
		this.loaf=loaf;
	
	lblDlmg=new JLabel(new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/daum.png"));
	lblDItemName=new JLabel("��ǰ��");
	lblDSeller=new JLabel("�����ID");
	lblDSellerId=new JLabel("alsgml4860");
	lblDsPrice=new JLabel("��� ���۰�");
	lblUserPrice=new JLabel("1,000,000��");
	lblDDay=new JLabel("n�� �� ����", JLabel.CENTER);
	
	taDItemInfo=new JTextArea("��ǰ �� ����");
	
	btnBid=new JButton("����");
	btnFrontImg=new JButton("����");
	btnBackImg=new JButton("�ĸ�");
	btnRightImg=new JButton("������");
	btnLeftImg=new JButton("������");
	
	setLayout(null);
	
	lblDlmg.setBounds(90, 10, 400, 300); //�̹���
	
	btnFrontImg.setBounds(95, 310, 75, 30); //���� �̹��� ��ư
	btnBackImg.setBounds(199, 310, 75, 30); //�ĸ� �̹��� ��ư
	btnRightImg.setBounds(304, 310, 75, 30); //������ �̹��� ��ư
	btnLeftImg.setBounds(409, 310, 75, 30); //������ �̹��� ��ư
	
	
	// ��� ��ǰ��
	lblDItemName.setBounds(10, 350, 300, 60); 
	lblDItemName.setFont(new Font("�������", Font.BOLD, 40)); 
	
	// ��� ���۰�, ����
	lblDsPrice.setBounds(10, 390, 300, 60);
	lblDsPrice.setFont(new Font("�������", Font.BOLD, 25));
	lblUserPrice.setBounds(180, 390, 300, 60);
	lblUserPrice.setFont(new Font("�������", Font.BOLD, 25));
	
	// �����, ����� ID
	lblDSeller.setBounds(10, 430, 100, 60);
	lblDSeller.setFont(new Font("�������", Font.BOLD, 25));
	lblDSellerId.setBounds(180, 430, 300, 60);
	lblDSellerId.setFont(new Font("�������", Font.BOLD, 25));
	
	// ��� ������
	lblDDay.setBounds(10, 490, 565, 60);
	lblDDay.setFont(new Font("�������", Font.BOLD, 40));
	
	//�� ����
	taDItemInfo.setBounds(10, 560, 565, 200);
	taDItemInfo.setEditable(false);
	
	//���� ��ư
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
