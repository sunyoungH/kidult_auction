package kr.co.kidultAuction.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import kr.co.kidultAuction.controller.MyPageFrmEvt;


@SuppressWarnings("serial")
public class MyPageFrm extends JDialog {
	private JButton btnMyAuction, btnEdit;
	private JPanel jp;
	
	
	public MyPageFrm(AuctionMainFrm amf) {
		super(amf,"내 페이지");

		
		 // 배경

        java.net.URL url = 
        		getClass().getClassLoader().getResource("kidultAuction_img/back.png"); // "패키지명/사진명"
        		ImageIcon icon = new ImageIcon(url);

        		 jp = new JPanel() {
                     public void paintComponent(Graphics g) {
                         g.drawImage(icon.getImage(), 0, 0, null);
                         setOpaque(false);
                         super.paintComponent(g);
                         
                         jp.setLayout(null);
                        } 
                     };
                     java.net.URL url1 = 
                    		 getClass().getClassLoader().getResource("kidultAuction_img/myauction.png"); // "패키지명/사진명"
                     ImageIcon icon1 = new ImageIcon(url1);
                     
                    JPanel jp1 = new JPanel() {
                    	 public void paintComponent(Graphics g) {
                    		 g.drawImage(icon1.getImage(), 0, 0, null);
                    		 setOpaque(false);
                    		 super.paintComponent(g);
                    		 
                    	 } 
                     };
                     java.net.URL url2 = 
                    		 getClass().getClassLoader().getResource("kidultAuction_img/edit.png"); // "패키지명/사진명"
                     ImageIcon icon2 = new ImageIcon(url2);
                     
                   JPanel  jp2 = new JPanel() {
                    	 public void paintComponent(Graphics g) {
                    		 g.drawImage(icon2.getImage(), 0, 0, null);
                    		 setOpaque(false);
                    		 super.paintComponent(g);
                    		 
                    	 } 
                     };
                     
             		btnMyAuction=new JButton(icon1);
            		btnEdit=new JButton(icon2);
		
		setLayout(null);
		btnMyAuction.setBounds(50,70,130,100);
		btnEdit.setBounds(200,70,130,100);
		 jp.setBounds(0, 0, 500, 300);
		 jp1.setBounds(0, 0, 130, 100);
		 jp2.setBounds(270, 70, 130, 100);
		
		add(btnMyAuction);
		add(btnEdit);
		add(jp);
		add(jp1);
		add(jp2);
	
		setBounds(650,330,500,310);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		MyPageFrmEvt mpfe=new MyPageFrmEvt(this);
		btnMyAuction.addActionListener(mpfe);
		btnEdit.addActionListener(mpfe);
		
	}//MyPageFrm


	public JButton getBtnMyAuction() {
		return btnMyAuction;
	}

	public void setBtnMyAuction(JButton btnMyAuction) {
		this.btnMyAuction = btnMyAuction;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}
	
}
