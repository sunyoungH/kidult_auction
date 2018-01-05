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
	
	public static String AUC_CODE;//����ڵ�
	
	private ImageIcon defultImg;

	public DetailOfAuctionsFrm(ListOfAuctionsFrm loaf) throws SQLException {
		super(loaf,"��� �� ������",true);
		this.loaf=loaf;
		
		AUC_CODE=loaf.AUC_CODE;
		UserDAO_YW u_dao=UserDAO_YW.getInstance();
		List<DetailOfAuctionVO> doav=u_dao.detail(AUC_CODE);
		defultImg=new ImageIcon(doav.get(0).getFront_img());
		
	lblDlmg=new JLabel(defultImg);
	lblDItemName=new JLabel(doav.get(0).getItem_name());
	lblStatus=new JLabel(doav.get(0).getStatus());
	lblDSeller=new JLabel("�Ǹ���");
	lblDSellerId=new JLabel(doav.get(0).getUser_id());
	lblDsPrice=new JLabel("���۰���");
	lblUserPrice=new JLabel(new DecimalFormat("#,###��").format(doav.get(0).getStart_price()));
	lblDDay=new JLabel(doav.get(0).getPeriod()+"��");
	
	taDItemInfo=new JTextArea(doav.get(0).getDetail_info());
	
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
	lblDItemName.setFont(new Font("Serif", Font.BOLD, 40)); 
	
	// ��ǰ ����
	lblStatus.setBorder(new TitledBorder(""));
	lblStatus.setBounds(515, 350, 60, 40);
	lblStatus.setFont(new Font("Serif", Font.BOLD, 15)); 
	
	// ��� ���۰�, ����
	lblDsPrice.setBounds(10, 390, 300, 60);
	lblDsPrice.setFont(new Font("Serif", Font.BOLD, 25));
	lblUserPrice.setBounds(180, 390, 300, 60);
	lblUserPrice.setFont(new Font("Serif", Font.BOLD, 25));
	
	// �����, ����� ID
	lblDSeller.setBounds(10, 430, 100, 60);
	lblDSeller.setFont(new Font("Serif", Font.BOLD, 25));
	lblDSellerId.setBounds(180, 430, 300, 60);
	lblDSellerId.setFont(new Font("Serif", Font.BOLD, 25));
	
	// ��� ������
	lblDDay.setBounds(10, 490, 565, 60);
	lblDDay.setFont(new Font("Serif", Font.BOLD, 40));
	
	//�� ����
	taDItemInfo.setBounds(10, 560, 565, 200);
	taDItemInfo.setEditable(false);
	
	//���� ��ư
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
