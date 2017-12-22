package kr.co.kidultAuction.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.kidultAuction.controller.LoginFrmEvt;

/**
 * �α���â
 * @author user
 */
@SuppressWarnings("serial")
public class LoginFrm extends JDialog{
	private JLabel lblId, lblPass;
	private JTextField tfId;
	private JPasswordField pfPass;
	private JButton btnAdmin, btnLogin, btnCancel;
	
	public LoginFrm(AuctionMainFrm amf) {
		super(amf,"�α���");
		setLayout(null);
		
		lblId=new JLabel("ID");
		lblPass=new JLabel("Password");
		
		tfId=new JTextField();
		pfPass=new JPasswordField();
		
		btnAdmin=new JButton("������ �α���");
		btnLogin=new JButton("�α���");
		btnCancel=new JButton("���");
		
		  java.net.URL url1 = 
         		 getClass().getClassLoader().getResource("kidultAuction_img/logback2.PNG"); // "��Ű����/������"
          ImageIcon icon1 = new ImageIcon(url1);
          
         JPanel jp1 = new JPanel() {
         	 public void paintComponent(Graphics g) {
         		 g.drawImage(icon1.getImage(), 0, 0, null);
         		 setOpaque(false);
         		 super.paintComponent(g);
         		 
         	 } 
          };
		
		Font btnfont = new Font("Dialog", Font.PLAIN | Font.BOLD, 12);
		btnAdmin.setFont(btnfont);
		btnLogin.setFont(btnfont);
		btnCancel.setFont(btnfont);
		
		//��ġ
		lblId.setBounds(135, 84, 70, 30);
		lblPass.setBounds(108, 114, 90, 30);

		tfId.setBounds(190, 84, 105, 30);
		pfPass.setBounds(190, 114, 105, 30);

		btnAdmin.setBounds(20, 160, 115, 30);
		btnLogin.setBounds(210, 160, 75, 30);
		btnCancel.setBounds(295, 160, 75, 30);
		
		jp1.setBounds(0,0,400,250);
		
		btnAdmin.setBackground(new Color(0xEAD0FF));
		btnLogin.setBackground(new Color(0xD0E5FF));
		btnCancel.setBackground(new Color(0xD0E5FF));
		
		//�߰�
		add(lblId);
		add(lblPass);
		add(tfId);
		add(pfPass);
		add(btnAdmin);
		add(btnLogin);
		add(btnCancel);
		add(jp1);
		
		LoginFrmEvt lfe=new LoginFrmEvt(this);
		btnAdmin.addActionListener(lfe);
		btnCancel.addActionListener(lfe);
		btnLogin.addActionListener(lfe);
		
		 setBounds(700, 300, 410, 250);
         setVisible(true);
         setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}//LoginFrm

	public JTextField getTfId() {
		return tfId;
	}

	public JPasswordField getPfPass() {
		return pfPass;
	}

	public JButton getBtnAdmin() {
		return btnAdmin;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	
}//class
