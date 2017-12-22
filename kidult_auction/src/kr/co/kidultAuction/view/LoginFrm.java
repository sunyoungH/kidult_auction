
package kr.co.kidultAuction.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		super(amf,"�α���",true);
		setLayout(null);
		
		lblId=new JLabel("ID");
		lblPass=new JLabel("Password");
		
		tfId=new JTextField();
		pfPass=new JPasswordField();
		
		btnAdmin=new JButton("������ �α���");
		btnLogin=new JButton("�α���");
		btnCancel=new JButton("���");
		
		Font btnfont = new Font("Dialog", Font.PLAIN | Font.BOLD, 12);
		btnAdmin.setFont(btnfont);
		btnLogin.setFont(btnfont);
		btnCancel.setFont(btnfont);
		
		//��ġ
		lblId.setBounds(120, 60, 70, 30);
		lblPass.setBounds(93, 90, 90, 30);

		tfId.setBounds(190, 60, 105, 30);
		pfPass.setBounds(190, 90, 105, 30);

		btnAdmin.setBounds(20, 160, 115, 30);
		btnLogin.setBounds(205, 160, 75, 30);
		btnCancel.setBounds(285, 160, 75, 30);
		
		//�߰�
		add(lblId);
		add(lblPass);
		add(tfId);
		add(pfPass);
		add(btnAdmin);
		add(btnLogin);
		add(btnCancel);
		
		LoginFrmEvt lfe=new LoginFrmEvt(this);
		btnAdmin.addActionListener(lfe);
		btnCancel.addActionListener(lfe);
		btnLogin.addActionListener(lfe);
		
		 setBounds(700, 300, 400, 250);
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
