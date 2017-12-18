package kr.co.kidultAuction.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import kr.co.kidultAuction.controller.AuctionMainFrmEvt;

/**
 * ����â
 * 
 * @author user
 */
@SuppressWarnings("serial")
public class AuctionMainFrm extends JFrame {

	private JButton btnAuctionList, btnMyPage, btnAddItem, btnAddUser, btnLogin;
	private JLabel lblMainName;
	public static String User_id="user_test";
	public static String Admin_id;

	public AuctionMainFrm() {
		super("Ű��Ʈ ����");
		setLayout(null);

		btnAuctionList = new JButton("��Ÿ��");
		btnAddItem = new JButton("��ŵ��");
		btnMyPage = new JButton("��������");
		btnAddUser = new JButton("ȸ������");
		btnLogin = new JButton("�α���");

		lblMainName = new JLabel("Ű��Ʈ ����");
		
		//��Ʈ
		Font lafont = new Font("Dialog", Font.PLAIN | Font.BOLD, 45);
		lblMainName.setFont(lafont);
		
		// ��ġ

		lblMainName.setBounds(227, 80, 600, 50);
		btnAuctionList.setBounds(50, 180, 190, 200);
		btnAddItem.setBounds(250, 180, 190, 200);
		btnMyPage.setBounds(450, 180, 190, 200);
		btnAddUser.setBounds(480, 15, 90, 25);
		btnLogin.setBounds(580, 15, 90, 25);

		// �߰�
		add(lblMainName);
		add(btnAuctionList);
		add(btnAddItem);
		add(btnMyPage);
		add(btnAddUser);
		add(btnLogin);

		setBounds(0, 0, 700, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		AuctionMainFrmEvt amfe=new AuctionMainFrmEvt(this);
		btnAuctionList.addActionListener(amfe);
		btnAddItem.addActionListener(amfe);
		btnMyPage.addActionListener(amfe);
		btnAddUser.addActionListener(amfe);
		btnLogin.addActionListener(amfe);
	}// AuctionMainFrm

	public JButton getBtnAuctionList() {
		return btnAuctionList;
	}

	public JButton getBtnMyPage() {
		return btnMyPage;
	}

	public JButton getBtnAddItem() {
		return btnAddItem;
	}

	public JButton getBtnAddUser() {
		return btnAddUser;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JLabel getLblMainName() {
		return lblMainName;
	}

	public static String getUser_id() {
		return User_id;
	}


}// class
