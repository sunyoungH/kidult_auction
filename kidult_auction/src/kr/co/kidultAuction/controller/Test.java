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
		jtf=new JTextField("안녕");
		lbltest=new JLabel("하이루");
		btn=new JButton("올리기");
		
		JPanel jp=new JPanel();
		ArrayList<JLabel> arrlist=new ArrayList<JLabel>();
			for(int i=0; i<11; i++) {
				lbl=new JLabel("안뇽!");
				arrlist.add(lbl);
				jp.add(arrlist.get(i));
			}//end for
			
			JPanel innerjp=new JPanel();
			JPanel outerjp=new JPanel();
			JPanel panel1=new JPanel();
	
			ArrayList<JPanel> innerList=new ArrayList<JPanel>();
			for(int i=0; i<11; i++) {
				jtf=new JTextField("안녕");
				lbl=new JLabel("반가워!!");
				panel1.add(jtf);
				panel1.add(lbl);
				innerjp.add(panel1);
				innerjp.setBorder(new TitledBorder("하이"));
				
				innerList.add(innerjp);
				
				outerjp.add(innerList.get(i));
			}//end for
			outerjp.setBorder(new TitledBorder("하이"));
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


	public JButton getBtn() {
		return btn;
	}


	public void setBtn(JButton btn) {
		this.btn = btn;
	}
	

	
	private void uploadFile() throws UnknownHostException, IOException {
		//업로드할 서버 주소 입력
		String ip=JOptionPane.showInputDialog("ip의 끝 구간만 입력해주세요\n ex)211.63.89.xx");
		if(ip!=null) {	//취소누른 것이 아닐때 타주세요
			FileDialog fdOpen=new FileDialog(this, "업로드 파일 선택", FileDialog.LOAD);
			fdOpen.setVisible(true);
			
			String path=fdOpen.getDirectory();
			String fileName=fdOpen.getFile();
			if(path!=null) {	//파일을 선택했음
				int dataSize=0;
				byte[] data=new byte[512];
				//전송할 파일의 크기를 구합니다. (FileStream을 사용하여!!!)
				File file=new File(path+"/"+fileName);
				FileInputStream fis=new FileInputStream(file);
				int binaryLen=0;
				while((binaryLen=fis.read(data)) >0) {
					dataSize++;
				}//end while
				fis.close(); //파일의 정보를 읽어들인 스트림을 끊는다.
			client=new Socket("211.63.89."+ip, 5050);
			//파일에서 읽어들여, 출력스트림에 파일내용을 기술
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			//서버로 업로더,파일명, 크기, binary data순서로 전송해야함.
			dos.writeUTF(fileName);
			dos.writeInt(dataSize);	
			//파일을 읽어들이기 위해 스트림을 재생성
			fis=new FileInputStream(file);
			
			while(dataSize>0) {
				binaryLen=fis.read(data);  //파일을 읽어들여, byte의 배열 방 512개중에 binaryLen은 30방 쓰고있어요~ 
				dos.write(data, 0, binaryLen); //읽어들인 만큼 스트림에 기록
				dataSize--;
				
				
			}//end while
			dos.flush();	//스트림 내용을 목적지로 분출
			System.out.println(fileName+"전송!");
			//사용한 모든 스트림을 닫기
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
			System.out.println("서버가 존재하지 않습니다. \n 서버주소를 확인하세요!");
			e1.printStackTrace();	
		} catch (IOException e1) {
			System.out.println("파일 전송 중 문제 발생");
			e1.printStackTrace();
		}//end catch
	}//actionPerformed

}
