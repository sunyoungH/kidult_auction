package kr.co.kidultAuction.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RunAction {

	public static void main(String[] args) {
		new AuctionMainFrm();
		String dir=System.getProperty("user.dir");
		System.out.println(dir);
		//C:\dev\git\kidult_auction\kidult_auction
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd_h_m_s");
		String s= sdf.format(new Date());
		System.out.println(s);
		
	}//main

}//class
