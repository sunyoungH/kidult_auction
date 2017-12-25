package kr.co.kidultAuction.view;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunAction {

	public static void main(String[] args) throws IOException {
		new AuctionMainFrm();
//		String dir=System.getProperty("user.dir");
//		System.out.println(dir);
		//C:\dev\git\kidult_auction\kidult_auction
		
		SimpleDateFormat sdf_date=new SimpleDateFormat("yyMMdd_HH_m_s");
		String s= sdf_date.format(new Date());
		System.out.println(s);
		
//		ServerSocket ss=new ServerSocket(5050);
//		Socket so=new Socket("211.63.89.157",5050);
//		so=ss.accept();
//		System.out.println("내 아이피 : "+so.getInetAddress().toString());
		
		sdf_date=new SimpleDateFormat("HH:mm:ss");
		String nowSec=sdf_date.format(new Date());
		System.out.println(nowSec);
		int leftHour=24-Integer.parseInt(nowSec.substring(0, 2));
		int leftMinute=60-Integer.parseInt(nowSec.substring(3,5));
		int leftSec=60-Integer.parseInt(nowSec.substring(6));
		
		System.out.println(leftHour+"/"+leftMinute+"/"+leftSec);
		
		int leftTotal=0;
		leftTotal=leftHour*1000*60*60 + leftMinute*1000*60 + leftSec*1000;
		System.out.println(leftTotal);
		
		
		
	}//main

}//class
