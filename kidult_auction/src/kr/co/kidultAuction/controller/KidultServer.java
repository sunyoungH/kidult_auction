package kr.co.kidultAuction.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import kr.co.kidultAuction.view.AuctionMainFrm;


public class KidultServer implements Runnable{
private Thread thread;
private ServerSocket server;
	
	public KidultServer() {
		if(thread!=null) {
			JOptionPane.showMessageDialog(null, "이미 서버 가동중");
			System.out.println("이미 서버 가동중");
			return;
		}//end if
		thread=new Thread(this);
		thread.start();
		System.out.println("가동중");
	}//kidultServer
	
	public void run() {		//파일이 읽는 메소드를 동기화 처리... 파일을 읽어들이는 일
		
		try {
			Socket userSocket=null;
			DataInputStream dis=null;
			FileOutputStream fos=null;
			String fileFullName=null;
			int fileDataSize=0;
			int binaryLen=0;
			byte[] data=new byte[512];
			StringBuilder newFileName=null;
			File file=null;
			server=new ServerSocket(5500);
		while(true) {
			userSocket=server.accept();
			dis=new DataInputStream(userSocket.getInputStream());
			fileFullName=dis.readUTF();
			fileDataSize=dis.readInt();
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd_HHms");
			String date= sdf.format(new Date());
			newFileName=new StringBuilder(fileFullName);
			newFileName.insert(newFileName.indexOf("."), "_"+AuctionMainFrm.User_id+"_"+date);
			
			file=new File("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/"+newFileName);
			fos=new FileOutputStream(file);
				while(fileDataSize>0) {
					binaryLen=dis.read(data);
					fos.write(data, 0, binaryLen);
					fileDataSize--;
				}//end while
			fos.flush();
			System.out.println(userSocket.getInetAddress()+" => 아이피가 "+newFileName+" => 상기 파일명으로 등록함" );
			fos.close();
			userSocket.close();
		}//end while
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
	}//run	
	
	public static void main (String args[]) {
		new KidultServer();
	}
	
}//class
