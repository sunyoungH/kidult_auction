package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import kr.co.kidultAuction.view.DetailOfAuctionsFrm;
import kr.co.kidultAuction.view.ListOfAuctionsFrm;

public class ListOfAuctionsEvt extends WindowAdapter implements ActionListener {
	
	private ListOfAuctionsFrm loaf; 
	
	
	public ListOfAuctionsEvt(ListOfAuctionsFrm loaf) {
		this.loaf=loaf;
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == loaf.getBtnShowDetail()) {
			new DetailOfAuctionsFrm(loaf);
		}//end if
		
		String category=(String) loaf.getCbCategory().getSelectedItem();
		if(ae.getSource() == loaf.getCbCategory()) {
			switch(category) {
			case "레고":
				///////카테고리 생성중
			}
		}
	}//actionPerformed

	
	
	
}
