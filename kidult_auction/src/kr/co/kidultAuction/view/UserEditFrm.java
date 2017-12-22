package kr.co.kidultAuction.view;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.kidultAuction.controller.UserEditFrmEvt;

/**
 * 회원정보수정
 * 
 * @author user
 */
@SuppressWarnings("serial")
public class UserEditFrm extends JDialog {

	private JLabel lblId, lblPass, lblPassCon, lblName, lblBirth, lblAddr, lblEmail, lblPhone, lblKakao, lblBirthinfo,
			lblPhoneinfo;
	private JTextField tfName, tfBirth, tfAddr, tfEmail, tfPhone, tfId, tfKakao;
	private JPasswordField pfPass, pfPassCon;
	private JButton btnSubmit, btnCancel;
	private JPanel jp;

	public UserEditFrm(AuctionMainFrm amf) throws SQLException {
		super(amf, "회원정보수정");
		setLayout(null);

		lblId = new JLabel("ID");
		lblPass = new JLabel("Password");
		lblPassCon = new JLabel("Password  확인");
		lblName = new JLabel("이름");
		lblBirth = new JLabel("생년월일");
		lblAddr = new JLabel("주소");
		lblEmail = new JLabel("E-mail");
		lblPhone = new JLabel("연락처");
		lblKakao = new JLabel("카카오톡ID");
		lblBirthinfo = new JLabel("ex) 19951110");

		tfId = new JTextField();
		tfId.setEnabled(false);
		pfPass = new JPasswordField();
		pfPassCon = new JPasswordField();
		tfName = new JTextField();
		tfBirth = new JTextField();
		tfAddr = new JTextField();
		tfEmail = new JTextField();
		tfPhone = new JTextField();
		tfKakao = new JTextField();
		tfKakao.setEnabled(false);

		btnSubmit = new JButton("변경하기");
		btnCancel = new JButton("취소");
		
		jp=new JPanel();
		
		jp.setBackground(new Color(0xFFFBF6));
		
		btnSubmit.setBackground(new Color(0xD0E5FF));
		btnCancel.setBackground(new Color(0xD0E5FF));

		// 배치

		lblId.setBounds(83, 40, 80, 30);
		lblPass.setBounds(60, 80, 100, 30);
		lblPassCon.setBounds(50, 120, 100, 30);
		lblName.setBounds(75, 160, 80, 30);
		lblBirth.setBounds(65, 200, 80, 30);
		lblAddr.setBounds(75, 240, 80, 30);
		lblEmail.setBounds(70, 280, 80, 30);
		lblPhone.setBounds(70, 320, 80, 30);
		lblKakao.setBounds(58, 360, 80, 30);
		lblBirthinfo.setBounds(260, 200, 80, 30);

		tfId.setBounds(170, 40, 80, 25);
		pfPass.setBounds(170, 80, 100, 25);
		pfPassCon.setBounds(170, 120, 100, 25);
		tfName.setBounds(170, 160, 80, 25);
		tfBirth.setBounds(170, 200, 80, 25);
		tfAddr.setBounds(170, 240, 200, 25);
		tfEmail.setBounds(170, 280, 200, 25);
		tfPhone.setBounds(170, 320, 90, 25);
		tfKakao.setBounds(170, 360, 90, 25);

		btnSubmit.setBounds(100, 430, 90, 30);
		btnCancel.setBounds(230, 430, 90, 30);
		
		jp.setBounds(0,0,430,550);

		Font infofont = new Font("Dialog", Font.PLAIN | Font.BOLD, 10);
		lblBirthinfo.setFont(infofont);

		// 추가

		add(lblId);
		add(lblPass);
		add(lblPassCon);
		add(lblName);
		add(lblBirth);
		add(lblAddr);
		add(lblEmail);
		add(lblPhone);
		add(lblKakao);
		add(lblBirthinfo);

		add(tfId);
		add(pfPass);
		add(pfPassCon);
		add(tfName);
		add(tfBirth);
		add(tfAddr);
		add(tfEmail);
		add(tfPhone);
		add(tfKakao);

		add(btnSubmit);
		add(btnCancel);
		
		add(jp);

		// 이벤트처리
		UserEditFrmEvt uefe = new UserEditFrmEvt(this);
		btnSubmit.addActionListener(uefe);
		btnCancel.addActionListener(uefe);
		tfId.addActionListener(uefe);
		pfPass.addActionListener(uefe);
		pfPassCon.addActionListener(uefe);
		tfName.addActionListener(uefe);
		tfBirth.addActionListener(uefe);
		tfAddr.addActionListener(uefe);
		tfEmail.addActionListener(uefe);
		tfPhone.addActionListener(uefe);
		tfKakao.addActionListener(uefe);

		setBounds(700, 300, 430, 550);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

	}// AddUserFrm

	public JLabel getLblId() {
		return lblId;
	}

	public JLabel getLblPass() {
		return lblPass;
	}

	public JLabel getLblPassCon() {
		return lblPassCon;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JLabel getLblBirth() {
		return lblBirth;
	}

	public JLabel getLblAddr() {
		return lblAddr;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public JLabel getLblPhone() {
		return lblPhone;
	}

	public JLabel getLblKakao() {
		return lblKakao;
	}

	public JLabel getLblBirthinfo() {
		return lblBirthinfo;
	}

	public JLabel getLblPhoneinfo() {
		return lblPhoneinfo;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public JTextField getTfBirth() {
		return tfBirth;
	}

	public JTextField getTfAddr() {
		return tfAddr;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public JTextField getTfPhone() {
		return tfPhone;
	}

	public JTextField getTfId() {
		return tfId;
	}

	public JTextField getTfKakao() {
		return tfKakao;
	}

	public JPasswordField getPfPass() {
		return pfPass;
	}

	public JPasswordField getPfPassCon() {
		return pfPassCon;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

}// class
