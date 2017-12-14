package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.kidultAuction.view.DetailOfAuctionsFrm;

public class DetailOfAuctionsEvt extends WindowAdapter implements ActionListener {
	
	private DetailOfAuctionsFrm doa;
	
	public DetailOfAuctionsEvt(DetailOfAuctionsFrm doa) {
		this.doa=doa;
	}//DetailOfAuctionsEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		ImageIcon icon=new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/cancel.JPG");
		String msg=doa.getLblDItemName().getText().trim()+
				"\n"+doa.getLblDsPrice().getText().trim()+
				"\t"+doa.getLblUserPrice().getText().trim();
		if(ae.getSource() == doa.getBtnBid()) {
			JOptionPane.showInputDialog(null,msg,"¿‘¬˚«œ±‚",0,icon,null,null);
		}//end if
	}//actionPerformed
}//class
