package kr.co.kidultAuction.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.co.kidultAuction.controller.AuctionMainFrmEvt;

/**
 * 메인창
 * 
 * @author user
 */
@SuppressWarnings("serial")
public class AuctionMainFrm extends JFrame {

	private JButton btnAuctionList, btnMyPage, btnAddItem, btnAddUser, btnLogin, btnExit;
	private JLabel lblMainName;
	public static String User_id = "";
	public static String Admin_id = "";
	public static String ended_num="";
	private boolean flag = false;

	public AuctionMainFrm() {
		super("키덜트 옥션");
		setLayout(null);
		String path = System.getProperty("user.dir");
		System.out.println(path);
		ImageIcon back = new ImageIcon(path + "\\src\\kr\\co\\kidultAuction\\img\\backgroundMain.png");
		ImageIcon listBtn = new ImageIcon(path + "\\src\\kr\\co\\kidultAuction\\img\\auctionListBtn.png");
		ImageIcon addBtn = new ImageIcon(path + "\\src\\kr\\co\\kidultAuction\\img\\auctionItemAddBtn.png");
		ImageIcon myPage = new ImageIcon(path + "\\src\\kr\\co\\kidultAuction\\img\\myPage.png");
		ImageIcon exit = new ImageIcon(path + "\\src\\kr\\co\\kidultAuction\\img\\exit.png");
		ImageIcon login = new ImageIcon(path + "\\src\\kr\\co\\kidultAuction\\img\\mainLogin.png");
		ImageIcon join = new ImageIcon(path + "\\src\\kr\\co\\kidultAuction\\img\\mainJoin.png");

		// JPanel background = new JPanel();

		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(back.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				// Dimension d = getSize();
				// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};

		btnAuctionList = new JButton(listBtn);
		btnAddItem = new JButton(addBtn);
		btnMyPage = new JButton(myPage);
		btnAddUser = new JButton(join);
		btnLogin = new JButton(login);
		btnExit = new JButton(exit);

		lblMainName = new JLabel("Auction");

		// 폰트
		Font lafont = new Font("Dialog", Font.PLAIN | Font.BOLD, 30);
		lblMainName.setFont(lafont);

		background.setLayout(null);

		// 배치
		lblMainName.setBounds(290, 23, 600, 50);
		btnAuctionList.setBounds(95, 265, 150, 142);
		btnAddItem.setBounds(265, 265, 150, 142);
		btnMyPage.setBounds(435, 265, 150, 142);
		btnAddUser.setBounds(120, 215, 90, 30);
		btnLogin.setBounds(20, 215, 90, 30);
		btnExit.setBounds(625, 395, 50, 50);
		/*
		 * btnAddUser.setBounds(480, 15, 90, 25); btnLogin.setBounds(580, 15, 90, 25);
		 */
		background.setBounds(0, 0, 700, 500);

		// 추가
		add(background);
		background.add(lblMainName);
		background.add(btnAuctionList);
		background.add(btnAddItem);
		background.add(btnMyPage);
		background.add(btnAddUser);
		background.add(btnLogin);
		background.add(btnExit);

		setBounds(550, 200, 710, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AuctionMainFrmEvt amfe = new AuctionMainFrmEvt(this);
		btnAuctionList.addActionListener(amfe);
		btnAddItem.addActionListener(amfe);
		btnMyPage.addActionListener(amfe);
		btnAddUser.addActionListener(amfe);
		btnLogin.addActionListener(amfe);
		btnExit.addActionListener(amfe);
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

	public JButton getBtnExit() {
		return btnExit;
	}

	public static String getUser_id() {
		return User_id;
	}

	public static String getEnded_num() {
		return ended_num;
	}

	public static void setEnded_num(String ended_num) {
		AuctionMainFrm.ended_num = ended_num;
	}
	

}// class
