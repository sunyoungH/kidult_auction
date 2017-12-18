package kr.co.kidultAuction.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.kidultAuction.controller.AddUserFrmEvt;

/**
 * 회원가입
 * 
 * @author user
 */
@SuppressWarnings("serial")
public class AddUserFrm extends JDialog {

	private JLabel lblId, lblPass, lblPassCon, lblName, lblBirth, lblAddr, lblEmail, lblPhone, lblKakao, lblBirthinfo,
			lblPhoneinfo;
	private JTextField tfId, tfName, tfBirth, tfAddr, tfEmail, tfPhone, tfKakao;
	private JPasswordField pfPass, pfPassCon;
	private JButton btnIdCheck, btnSubmit, btnCancel;

	public AddUserFrm(AuctionMainFrm amf) {
		super(amf, "로그인", false);
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
		lblPhoneinfo = new JLabel("'-'을 제외하고 쓰시오");

		tfId = new JTextField();
		pfPass = new JPasswordField();
		pfPassCon = new JPasswordField();
		tfName = new JTextField();
		tfBirth = new JTextField();
		tfAddr = new JTextField();
		tfEmail = new JTextField();
		tfPhone = new JTextField();
		tfKakao = new JTextField();

		btnIdCheck = new JButton("중복확인");
		btnSubmit = new JButton("회원가입");
		btnCancel = new JButton("취소");

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
		lblPhoneinfo.setBounds(265, 320, 120, 30);

		tfId.setBounds(170, 40, 80, 25);
		pfPass.setBounds(170, 80, 100, 25);
		pfPassCon.setBounds(170, 120, 100, 25);
		tfName.setBounds(170, 160, 80, 25);
		tfBirth.setBounds(170, 200, 80, 25);
		tfAddr.setBounds(170, 240, 200, 25);
		tfEmail.setBounds(170, 280, 200, 25);
		tfPhone.setBounds(170, 320, 90, 25);
		tfKakao.setBounds(170, 360, 90, 25);

		btnIdCheck.setBounds(270, 40, 88, 25);
		btnSubmit.setBounds(100, 430, 90, 30);
		btnCancel.setBounds(230, 430, 90, 30);

		Font infofont = new Font("Dialog", Font.PLAIN | Font.BOLD, 10);
		lblBirthinfo.setFont(infofont);
		lblPhoneinfo.setFont(infofont);

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
		add(lblPhoneinfo);

		add(tfId);
		add(pfPass);
		add(pfPassCon);
		add(tfName);
		add(tfBirth);
		add(tfAddr);
		add(tfEmail);
		add(tfPhone);
		add(tfKakao);

		add(btnIdCheck);
		add(btnSubmit);
		add(btnCancel);
		
		AddUserFrmEvt aufe= new AddUserFrmEvt(this);
		btnIdCheck.addActionListener(aufe);
		btnSubmit.addActionListener(aufe);
		btnCancel.addActionListener(aufe);

		setBounds(700, 300, 430, 550);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	}// AddUserFrm

	public JButton getBtnIdCheck() {
		return btnIdCheck;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JTextField getTfId() {
		return tfId;
	}

	public JPasswordField getPfPass() {
		return pfPass;
	}
	
	public JPasswordField getPfPassCon() {
		return pfPassCon;
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

	public JTextField getTfKakao() {
		return tfKakao;
	}

	
	

}// class
