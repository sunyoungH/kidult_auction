package kr.co.kidultAuction.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
			lblPhoneinfo, lblMushroom, lblMario, lblUnder;
	private JTextField tfId, tfName, tfBirth, tfAddr, tfEmail, tfPhone, tfKakao;
	private JPasswordField pfPass, pfPassCon;
	private JButton btnIdCheck, btnKakaoCheck, btnSubmit, btnCancel;
	private AuctionMainFrm amf;

	public AddUserFrm(AuctionMainFrm amf) {
		super(amf, "회원가입", false);
		setLayout(null);
		this.amf = amf;
		
		String path = System.getProperty("user.dir");
		System.out.println(path);
		ImageIcon Lava = new ImageIcon(path+"\\src\\kr\\co\\kidultAuction\\img\\mushroomMario.png");
		ImageIcon Mario = new ImageIcon(path+"\\src\\kr\\co\\kidultAuction\\img\\marioJoin.png");
		ImageIcon underBar = new ImageIcon(path+"\\src\\kr\\co\\kidultAuction\\img\\underJoin.png");

		lblId = new JLabel("ID");
		lblPass = new JLabel("Password");
		lblPassCon = new JLabel("Password  확인");
		lblMushroom = new JLabel(Lava);
		lblName = new JLabel("이름");
		lblBirth = new JLabel("생년월일");
		lblAddr = new JLabel("주소");
		lblEmail = new JLabel("E-mail");
		lblPhone = new JLabel("연락처");
		lblKakao = new JLabel("카카오톡ID");
		lblBirthinfo = new JLabel("ex) 19951110");
		lblPhoneinfo = new JLabel("'-'을 제외하고 쓰시오");
		lblMario = new JLabel(Mario);
		lblUnder = new JLabel(underBar);

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
		btnKakaoCheck = new JButton("중복확인");
		btnSubmit = new JButton("회원가입");
		btnCancel = new JButton("취소");
		
        JPanel jp=new JPanel();
		
		jp.setBackground(new Color(0xFFFBF6));
		
		btnIdCheck.setBackground(new Color(0xD0E5FF));
		btnKakaoCheck.setBackground(new Color(0xD0E5FF));
		btnSubmit.setBackground(new Color(0xD0E5FF));
		btnCancel.setBackground(new Color(0xD0E5FF));

		// 배치

		lblId.setBounds(83, 40, 80, 30);
		lblPass.setBounds(60, 80, 100, 30);
		lblPassCon.setBounds(50, 120, 100, 30);
		lblMushroom.setBounds(290, 95, 88, 90);
		lblName.setBounds(75, 160, 80, 30);
		lblBirth.setBounds(65, 200, 80, 30);
		lblAddr.setBounds(75, 240, 80, 30);
		lblEmail.setBounds(70, 280, 80, 30);
		lblPhone.setBounds(70, 320, 80, 30);
		lblKakao.setBounds(58, 360, 80, 30);
		lblMario.setBounds(10, 390, 80, 75);
		lblUnder.setBounds(0, 450, 430, 80);
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
		btnKakaoCheck.setBounds(270, 360, 88, 25);
		btnSubmit.setBounds(100, 430, 90, 30);
		btnCancel.setBounds(230, 430, 90, 30);
		
		jp.setBounds(0,0,430,550);

		Font infofont = new Font("Dialog", Font.PLAIN | Font.BOLD, 10);
		lblBirthinfo.setFont(infofont);
		lblPhoneinfo.setFont(infofont);

		// 추가

		add(lblId);
		add(lblPass);
		add(lblPassCon);
		add(lblMushroom);
		add(lblName);
		add(lblBirth);
		add(lblAddr);
		add(lblEmail);
		add(lblPhone);
		add(lblKakao);
		add(lblMario);
		add(lblUnder);
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
		add(btnKakaoCheck);
		add(btnSubmit);
		add(btnCancel);
		
		add(jp);
		
		AddUserFrmEvt aufe= new AddUserFrmEvt(this);
		btnIdCheck.addActionListener(aufe);
		btnKakaoCheck.addActionListener(aufe);
		btnSubmit.addActionListener(aufe);
		btnCancel.addActionListener(aufe);

		setBounds(700, 300, 430, 550);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	}// AddUserFrm

	public JButton getBtnIdCheck() {
		return btnIdCheck;
	}

	public JButton getBtnKakaoCheck() {
		return btnKakaoCheck;
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

	public AuctionMainFrm getAmf() {
		return amf;
	}

}// class
