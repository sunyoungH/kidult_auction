package kr.co.kidultAuction.view;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RunAction {

	public static void main(String[] args) throws IOException {
		new AuctionMainFrm();
		String dir=System.getProperty("user.dir");
		System.out.println(dir);
		//C:\dev\git\kidult_auction\kidult_auction
		
		SimpleDateFormat sdf_date=new SimpleDateFormat("yyMMdd_HH_m_s");
		String s= sdf_date.format(new Date());
		System.out.println(s);
		
//		ServerSocket ss=new ServerSocket(5050);
//		Socket so=new Socket("211.63.89.157",5050);
//		so=ss.accept();
//		System.out.println("내 아이피 : "+so.getInetAddress().toString());
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd_h_m_s");
		String date= sdf.format(new Date());
		StringBuilder newFileName=new StringBuilder("c:/dev/hello.txt");
		System.out.println(AuctionMainFrm.User_id);
		newFileName.insert(newFileName.indexOf("."), "_"+AuctionMainFrm.User_id+"_"+date);
		System.out.println(newFileName.toString());
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("1");
		System.out.println(list.get(0));
		System.out.println(list.size());
		
	}//main

}//class
