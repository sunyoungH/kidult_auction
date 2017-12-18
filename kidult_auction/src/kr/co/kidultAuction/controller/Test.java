package kr.co.kidultAuction.controller;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Test extends JFrame implements ActionListener{
	private JTextField jtf;
	private JLabel lbl, lbltest;
	private JScrollPane jsp;
	private 	JPanel panel1;
	private JButton btn;
	private Socket client;
	
	public Test() {
		jtf=new JTextField("�ȳ�");
		lbltest=new JLabel("���̷�");
		btn=new JButton("�ø���");
		
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
		add(btn);
//		add(jp);
//		for(int i=0; i<5; i++) {
//			jp.add(lbltest);
//		}//end for

//		add(jp);
//		add(jtf);
		setVisible(true);
		setBounds(300, 300, 300, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		btn.addActionListener(this);
		
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


	public JButton getBtn() {
		return btn;
	}


	public void setBtn(JButton btn) {
		this.btn = btn;
	}
	

	
	private void uploadFile() throws UnknownHostException, IOException {
		//���ε��� ���� �ּ� �Է�
		String ip=JOptionPane.showInputDialog("ip�� �� ������ �Է����ּ���\n ex)211.63.89.xx");
		if(ip!=null) {	//��Ҵ��� ���� �ƴҶ� Ÿ�ּ���
			FileDialog fdOpen=new FileDialog(this, "���ε� ���� ����", FileDialog.LOAD);
			fdOpen.setVisible(true);
			
			String path=fdOpen.getDirectory();
			String fileName=fdOpen.getFile();
			if(path!=null) {	//������ ��������
				int dataSize=0;
				byte[] data=new byte[512];
				//������ ������ ũ�⸦ ���մϴ�. (FileStream�� ����Ͽ�!!!)
				File file=new File(path+"/"+fileName);
				FileInputStream fis=new FileInputStream(file);
				int binaryLen=0;
				while((binaryLen=fis.read(data)) >0) {
					dataSize++;
				}//end while
				fis.close(); //������ ������ �о���� ��Ʈ���� ���´�.
			client=new Socket("211.63.89."+ip, 5050);
			//���Ͽ��� �о�鿩, ��½�Ʈ���� ���ϳ����� ���
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			//������ ���δ�,���ϸ�, ũ��, binary data������ �����ؾ���.
			dos.writeUTF(fileName);
			dos.writeInt(dataSize);	
			//������ �о���̱� ���� ��Ʈ���� �����
			fis=new FileInputStream(file);
			
			while(dataSize>0) {
				binaryLen=fis.read(data);  //������ �о�鿩, byte�� �迭 �� 512���߿� binaryLen�� 30�� �����־��~ 
				dos.write(data, 0, binaryLen); //�о���� ��ŭ ��Ʈ���� ���
				dataSize--;
				
				
			}//end while
			dos.flush();	//��Ʈ�� ������ �������� ����
			System.out.println(fileName+"����!");
			//����� ��� ��Ʈ���� �ݱ�
			fis.close();
			client.close();
			}//end if
		}//end if
	}//uploadFile

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			uploadFile();
		} catch (UnknownHostException e1) {
			System.out.println("������ �������� �ʽ��ϴ�. \n �����ּҸ� Ȯ���ϼ���!");
			e1.printStackTrace();	
		} catch (IOException e1) {
			System.out.println("���� ���� �� ���� �߻�");
			e1.printStackTrace();
		}//end catch
	}//actionPerformed

}
