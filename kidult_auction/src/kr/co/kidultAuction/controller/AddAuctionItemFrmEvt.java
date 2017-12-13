package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.co.kidultAuction.view.AddAuctionItemFrm;
import kr.co.kidultAuction.view.AddItemImageFrm;


/////////////////////// ���� ?? //////////////////////////
public class AddAuctionItemFrmEvt implements ActionListener{
	
	private AddAuctionItemFrm aaif;
	public AddAuctionItemFrmEvt(AddAuctionItemFrm aaif) {
		this.aaif=aaif;
	}//AddAuctionItemFrmEvt
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==aaif.getBtnAddImg()) {
			new AddItemImageFrm();
		}
		if(ae.getSource()==aaif.getBtnPermit()) {
			System.out.println("���");
		}
		if(ae.getSource()==aaif.getBtnCancel()) {
			aaif.dispose();
		}
	}
	
	

}//class
