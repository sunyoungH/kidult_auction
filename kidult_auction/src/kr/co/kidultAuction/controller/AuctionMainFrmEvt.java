package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import kr.co.kidultAuction.view.AddAuctionItemFrm;
import kr.co.kidultAuction.view.AddUserFrm;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.ListOfAuctionsFrm;
import kr.co.kidultAuction.view.LoginFrm;
import kr.co.kidultAuction.view.MyAuctionFrm;
import kr.co.kidultAuction.view.MyPageFrm;

public class AuctionMainFrmEvt implements ActionListener{
	private AuctionMainFrm amf;
	public AuctionMainFrmEvt(AuctionMainFrm amf) {
		this.amf=amf;
	}
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
	
}//class
