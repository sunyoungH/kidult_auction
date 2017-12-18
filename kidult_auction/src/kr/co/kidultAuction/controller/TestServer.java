package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TestServer extends JFrame implements Runnable, ActionListener{
private JLabel jlbl;
private JButton btn;
private ServerSocket ssFile;
private Thread threadFile;
private File file;
private ImageIcon img;

public TestServer() {
	img=new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/addImg.png");
	JPanel jp=new JPanel();
	btn=new JButton("서버가동");
	jlbl=new JLabel(img);
	jp.add(btn);
	jp.add(jlbl);
	add(jp);
	
	btn.addActionListener(this);
	
	setBounds(400, 400, 400, 400);
	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
}
@Override
public void actionPerformed(ActionEvent e) {
	if(threadFile!=null) {
		JOptionPane.showMessageDialog(this, "서버가 이미 가동중입니다");
		return;
	}//end if

	threadFile=new Thread(this);		//현재 객체와 has a관계로 Thread를 생성한다.
	threadFile.start();	//run가동
}//actionPerformed


public void run() {		//파일이 읽는 메소드를 동기화 처리... 파일을 읽어들이는 일
	try {
		ssFile=new ServerSocket(5050);	//생성이 되고난 후에 가동중입니다라는 메세지를 뿌려주는 것이 더 나음
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd a HH:mm:ss");
		
		Socket someClient=null;
		DataInputStream dis=null;
		FileOutputStream fos=null;
		String fileName=null;
		int dataSize=0;	//전송되는 파일의 크기
		int binaryLen=0; 	//한번에 전송되는 binary의 크기
		byte[] data=new byte[512];	//읽어들인 파일의 binary정보를 저장하는 배열.. 512나 1024... 등등
		String uploader="";
		File file=null;
		StringBuilder sbRename=null;
		
		while(true) {	//여러 사용자에게 파일을 받고 싶으니까.. 이 프로그램이 실행되는 동안까지는 계속 파일을 받는 단계임
			someClient=ssFile.accept();		//접속자가 왔을때만 실행이 되는 block method임
			//파일명, 파일크기, binary data순서로 전달되므로 해당 순서로 처리
			dis=new DataInputStream(someClient.getInputStream());
			uploader=dis.readUTF();	//wirteUTF로 보낸 데이터 : 업로더명
			fileName=dis.readUTF();	//wirteUTF로 보낸 데이터 : 파일명
			dataSize=dis.readInt();		//writeInt로 보낸 데이터 : 데이터크기
			
			//file의 binary data를 받는다.
			file=new File("d:/savefile/"+"123.png");
			fos=new FileOutputStream(file);
			while(dataSize>0) {	// 0이면 binarydata가 없다는 말임... 보내온 파일의 크기까지
				binaryLen=dis.read(data);  // 스트림에서 읽어들여
				fos.write(data, 0, binaryLen);  //파일스트림에 쓴다 -하나의 data를 0에서부터 읽어들인 binaryLen크기까지 
				dataSize--;
			}//end while
			fos.flush(); //스트림의 내용을 분출
			//업로드된 파일 정보를 파일목록을 보여주는 리스트 추가
			fos.close(); //파일 기록이 끝난 후 파일 스트림을 끊는다.
			someClient.close();  //접속자 소켓을 끊는다.
		}//end while
	} catch (IOException e) {
		e.printStackTrace();
	}//end catch
}//run
	public static void main(String args[]) {
		new TestServer(); 
	}//main

}
