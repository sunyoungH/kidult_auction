package kr.co.kidultAuction.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ReasonOfReject extends JDialog{
	
	JButton btnOk, btnCancel;
	JTextArea jtaReason;
	
	
	public ReasonOfReject() {
		
		JLabel lbReasonOfReject = new JLabel("거부 사유");
		Font lbfont = new Font("Dialog", Font.PLAIN | Font.BOLD, 20);
		lbReasonOfReject.setFont(lbfont);
		
		jtaReason = new JTextArea();
		JScrollPane jspReason = new JScrollPane(jtaReason);
		
		btnOk = new JButton("확인");
		btnCancel = new JButton("취소");
		
		//////////////////////////////////////////////////////
		
		setLayout(null);
		setBounds(700, 300, 300, 230);
		
		lbReasonOfReject.setBounds(100, 10, 100, 50);
		
		jspReason.setBounds(20, 60, 245, 80);
		
		btnOk.setBounds(120, 150, 70, 30);
		btnCancel.setBounds(200, 150, 70, 30);
		
		//////////////////////////////////////////////////////
		
		add(lbReasonOfReject);
		add(jspReason);
		add(btnOk);
		add(btnCancel);
		
		//////////////////////////////////////////////////////
		
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}//ReasonOfReject

	public static void main(String[] args) {
		new ReasonOfReject();
	}//main

}//class
