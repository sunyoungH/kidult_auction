package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.co.kidultAuction.dao.UserDAO_YW;
import kr.co.kidultAuction.view.DetailOfAuctionsFrm;
import kr.co.kidultAuction.view.ListOfAuctionsFrm;
import kr.co.kidultAuction.vo.ListOfAuctionVO;

public class ListOfAuctionsEvt extends WindowAdapter implements ActionListener {
	
	private ListOfAuctionsFrm loaf; 
	
	
	public ListOfAuctionsEvt(ListOfAuctionsFrm loaf) {
		this.loaf=loaf;
	}
	
	public void viewDetailOfAuction() {

		
	}//viewDetailOfAuction


	@Override
	public void actionPerformed(ActionEvent ae) {
//		if(ae.getSource() == loaf.getBtnShowDetail()) {
//			new DetailOfAuctionsFrm(loaf);
//		}//end if
		
		String selectcategory="";
		if(ae.getSource() == loaf.getCbCategory()) {
			selectcategory=(String)loaf.getCbCategory().getSelectedItem();
		
		if(ae.getSource() == loaf.getBtnSearch()) {
			System.out.println(selectcategory+"Å¬¸¯");
		}
		}//end if
	}//actionPerformed

	
	
	
}
