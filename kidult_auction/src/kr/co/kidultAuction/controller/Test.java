package kr.co.kidultAuction.controller;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Test extends JFrame {
	private JTextField jtf;
	private JLabel lbl, lbltest;
	private JScrollPane jsp;
	private 		JPanel panel1;
	
	public Test() {
		jtf=new JTextField("�ȳ�");
		lbltest=new JLabel("���̷�");
		
		JPanel jp=new JPanel();
		ArrayList<JLabel> arrlist=new ArrayList<JLabel>();
			for(int i=0; i<11; i++) {
				lbl=new JLabel("�ȴ�!");
				arrlist.add(lbl);
				jp.add(arrlist.get(i));
			}//end for
			
			JPanel innerjp=new JPanel();
			JPanel outerjp=new JPanel();
			JPanel panel1=new JPanel();
	
			ArrayList<JPanel> innerList=new ArrayList<JPanel>();
			for(int i=0; i<11; i++) {
				jtf=new JTextField("�ȳ�");
				lbl=new JLabel("�ݰ���!!");
				panel1.add(jtf);
				panel1.add(lbl);
				innerjp.add(panel1);
				innerjp.setBorder(new TitledBorder("����"));
				
				innerList.add(innerjp);
				
				outerjp.add(innerList.get(i));
			}//end for
			outerjp.setBorder(new TitledBorder("����"));
			outerjp.setPreferredSize(new Dimension(1000, 1000));
			jsp=new JScrollPane(outerjp);
		
		add(jsp);
//		add(jp);
//		for(int i=0; i<5; i++) {
//			jp.add(lbltest);
//		}//end for

//		add(jp);
//		add(jtf);
		setVisible(true);
		setBounds(300, 300, 300, 300);
		
		TestJavaEvt tje=new TestJavaEvt(this);
		
		
	}
	
	
	public static void main(String[] args) {
		new Test();
//			System.out.println("���� �Ǿ��ּ���");
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
