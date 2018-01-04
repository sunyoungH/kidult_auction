package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import kr.co.kidultAuction.dao.UserDAO_YW;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.DetailOfAuctionsFrm;
import kr.co.kidultAuction.view.ListOfAuctionsFrm;
import kr.co.kidultAuction.vo.DetailOfAuctionVO;
import kr.co.kidultAuction.vo.ListOfAuctionVO;

public class ListOfAuctionsEvt extends WindowAdapter implements ActionListener {
	
	private ListOfAuctionsFrm loaf; 
	private AuctionMainFrm amf;
	
	UserDAO_YW u_dao=UserDAO_YW.getInstance();
	
	public ListOfAuctionsEvt(ListOfAuctionsFrm loaf,AuctionMainFrm amf) {
		this.loaf=loaf;
		this.amf=amf;
	}
	
	// ������ ��ư method
	private void openDetail(String auc_code) {
		
		List<DetailOfAuctionVO> doavlist;
		
			try {
				doavlist=u_dao.detail(auc_code);
				new DetailOfAuctionsFrm(loaf);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(loaf, "��ǰ �������� �ҷ����µ� �����߾��");
				e.printStackTrace();
			}//try
			
	}//setDetail
	
	
	//
	private List<ListOfAuctionVO> setlist(String category) {
		
		List<ListOfAuctionVO> loavlist=null;
		
		try {
			loavlist=u_dao.selectCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return loavlist;
	}//setlist
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		ArrayList<JButton> auclist=loaf.getArrbtn();
		ArrayList<JLabel> auc_Code=loaf.getArrjl();
		
		
		//������ ��ư ����
		for(int i=0 ; i < auclist.size();i++) {
			if(ae.getSource()== auclist.get(i)) {
				//Ư�� ��°�� ��ư�� ���ȴ�.
				loaf.AUC_CODE=auc_Code.get(i).getText(); //static ������ ����
				String auccode=auc_Code.get(i).getText(); //dao�� �Էµ� ��
				
				openDetail(auccode);
			}//end if
		}//end for
		
		
		//ī�װ��� ����Ʈ ����
		String selectcategory=(String)loaf.getCbCategory().getSelectedItem();
		if(ae.getSource() == loaf.getBtnSearch()) {
			
			loaf.dispose();
			try {
				new ListOfAuctionsFrm(amf,selectcategory);
			} catch (SQLException e) {
				e.printStackTrace();
			}//catch
		
		}//end if	
	}//actionPerformed

}//class


