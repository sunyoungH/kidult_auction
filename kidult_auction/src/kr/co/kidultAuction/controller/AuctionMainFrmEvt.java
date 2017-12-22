package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import kr.co.kidultAuction.dao.AdminDAO;
import kr.co.kidultAuction.view.AddAuctionItemFrm;
import kr.co.kidultAuction.view.AddUserFrm;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.ListOfAuctionsFrm;
import kr.co.kidultAuction.view.LoginFrm;
import kr.co.kidultAuction.view.MyAuctionFrm;
import kr.co.kidultAuction.view.MyPageFrm;

public class AuctionMainFrmEvt implements ActionListener, Runnable{
	private AuctionMainFrm amf;
	private Thread insertEndBid;
	
	public AuctionMainFrmEvt(AuctionMainFrm amf) {
		this.amf=amf;
		if(insertEndBid!=null) {
			System.out.println("경매종료 thread 가동중");
			return;
		}//end if
			insertEndBid=new Thread(this);
			insertEndBid.start();
	}//auctionmainFrmEvt
	
	public String insertEndBid() {
		boolean endflag=false;
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
		String nowDate=sdf.format(new Date());
		if(nowDate.equals("17-12-21")) {
			endflag=true;
		}//end if
		return nowDate;
	}//insertEndBid
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==amf.getBtnAddUser()) {
			new AddUserFrm(amf);
		}//end if
		
		if(ae.getSource()==amf.getBtnAddItem()) {
			new AddAuctionItemFrm(amf);
		}//end if
		
		if(ae.getSource()==amf.getBtnAuctionList()) {
			try {
				new ListOfAuctionsFrm(amf);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//end if
		
		if(ae.getSource()==amf.getBtnLogin()) {
			new LoginFrm(amf);
		}//end if
		
		if(ae.getSource()==amf.getBtnMyPage()) {
			new MyPageFrm(amf);
		}//end if
		
		
	}//actionPerformed

	@Override
	public void run() {
//		SimpleDateFormat sdf=new SimpleDateFormat("HH");
//		String time=sdf.format(new Date());
//		AdminDAO a_dao=AdminDAO.getInstance();
//		try {
//			boolean insertFlag=a_dao.insertEndBid();
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		while(true) {
//			try {
//			insertEndBid.sleep(1000*20);
//			a_dao.insertBidUserData();
//			System.out.println(time);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		}
	}//run
	
}//class
