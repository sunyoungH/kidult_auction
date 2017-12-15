package kr.co.kidultAuction.controller;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test extends JFrame {
	private JTextField jtf;
	
	
	public Test() {
		jtf=new JTextField("안녕");
		
		add(jtf);
		setVisible(true);
		setBounds(199, 199, 199, 199);
		
		TestJavaEvt tje=new TestJavaEvt(this);
		
		
	}
	
	
	public static void main(String[] args) {
		new Test();
//			System.out.println("제발 되어주세요");
//			System.out.println("12-13!!");
//			System.out.println("ddddddd  ");
//			System.out.println("ccccccc  ");
	}


	public JTextField getJtf() {
		return jtf;
	}


	public void setJtf(JTextField jtf) {
		this.jtf = jtf;
	}

}
