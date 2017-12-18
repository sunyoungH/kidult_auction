package kr.co.kidultAuction.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import kr.co.kidultAuction.controller.ReasonOfRejectFrmEvt;

@SuppressWarnings("serial")
public class ReasonOfRejectFrm extends JDialog{
	//�źλ���
	private JButton btnOk, btnCancel;
	private JTextArea jtaReason;

	public ReasonOfRejectFrm(ApproveFrm af) {
		super(af,"�ź� ���� �Է�",true);
		JLabel lbReasonOfReject = new JLabel("�ź� ����");
		Font lbfont = new Font("Dialog", Font.PLAIN | Font.BOLD, 20);
		lbReasonOfReject.setFont(lbfont);
		jtaReason = new JTextArea();
		JScrollPane jspReason = new JScrollPane(jtaReason);
		
		btnOk = new JButton("Ȯ��");
		btnCancel = new JButton("���");
		
		setLayout(null);
		setBounds(700, 300, 300, 230);
		lbReasonOfReject.setBounds(100, 10, 100, 50);
		jspReason.setBounds(20, 60, 245, 80);
		btnOk.setBounds(120, 150, 70, 30);
		btnCancel.setBounds(200, 150, 70, 30);
		
		add(lbReasonOfReject);
		add(jspReason);
		add(btnOk);
		add(btnCancel);
		
		ReasonOfRejectFrmEvt rore=new ReasonOfRejectFrmEvt(this);
		btnOk.addActionListener(rore);
		btnCancel.addActionListener(rore);
		
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}//ReasonOfReject

	public JButton getBtnOk() {
		return btnOk;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JTextArea getJtaReason() {
		return jtaReason;
	}

}//class
