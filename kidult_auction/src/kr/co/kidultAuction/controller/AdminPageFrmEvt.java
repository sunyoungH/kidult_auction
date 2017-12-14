package kr.co.kidultAuction.controller; 

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import kr.co.kidultAuction.dao.AdminDAO;
import kr.co.kidultAuction.view.AdminPageFrm;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.PermitFrm;
import kr.co.kidultAuction.vo.AdminBidVO;
import kr.co.kidultAuction.vo.AdminPermitVO;
import kr.co.kidultAuction.vo.AdminSucBidVO;
import kr.co.kidultAuction.vo.AdminUserVO;

public class AdminPageFrmEvt extends MouseAdapter{
private AdminPageFrm apf;
private AuctionMainFrm amf;
public static final int DOUBLE_CLICK=2;
public static final int WAITING_LIST=2;

	public AdminPageFrmEvt(AdminPageFrm apf) throws SQLException {
		this.apf=apf;
		System.out.println("adminPage에서 보이는 관리자 아이디"+AuctionMainFrm.User_id);
		viewUserList();	
		viewWatingList();
		viewPermitList();
		viewBidList();
		viewSucBidList(); 
	}//adminPageFrmEvt

	
	/**
	 회원 목록
	 * */
	public void viewUserList() throws SQLException {
		DefaultTableModel tempUserList=apf.getUserList();
		tempUserList.setRowCount(0);
		
		AdminDAO a_dao=AdminDAO.getInstance();
		List<AdminUserVO> userList=a_dao.selectUserList();
		
		Object[] rowData=null;
		AdminUserVO auv=null;
		
		for(int i=0; i<userList.size(); i++) {
			auv=userList.get(i);
			rowData=new Object[9];
			rowData[0]=new Integer(i+1);
			rowData[1]=auv.getUser_id();
			rowData[2]=auv.getName();
			rowData[3]=auv.getPhone();
			rowData[4]=auv.getKakao_id();
			rowData[5]=auv.getBirth_date();
			rowData[6]=auv.getEmail();
			rowData[7]=auv.getAddr();
			rowData[8]=auv.getUser_joindate();
			
			tempUserList.addRow(rowData);
		}//end for
		
	}//viewUserList
	
	/**
	 승인 대기 목록
	 * */
	public void viewWatingList() throws SQLException {
		DefaultTableModel watingList=apf.getWatingList();
		watingList.setRowCount(0);
		
		AdminDAO a_dao=AdminDAO.getInstance();
		List<AdminPermitVO> permitList=a_dao.selectPermitListN();
		
		Object[] rowData=null;
		AdminPermitVO apv=null;
		
		for(int i=0; i<permitList.size(); i++) {
			apv=permitList.get(i);
			rowData=new Object[8];
			rowData[0]=new Integer(i+1);
			rowData[1]=apv.getUser_id();
			rowData[2]=apv.getAuc_code();
			rowData[3]=apv.getCategory();
			rowData[4]=apv.getStatus();
			rowData[5]=apv.getItem_name();
			rowData[6]=apv.getStart_price();
			rowData[7]=apv.getPeriod();
			
			watingList.addRow(rowData);
		}//end for
		
	}//viewWaitingList
	
	
	/**
	 승인 대기 목록
	 * */
	public void viewPermitList() throws SQLException {
		DefaultTableModel completeList=apf.getCompleteList();
		completeList.setRowCount(0);
		
		
		AdminDAO a_dao=AdminDAO.getInstance();
		List<AdminPermitVO> permitList=a_dao.selectPermitListY();
		
		Object[] rowData=null;
		AdminPermitVO apv=null;
		
		for(int i=0; i<permitList.size(); i++) {
			apv=permitList.get(i);
			rowData=new Object[8];
			rowData[0]=new Integer(i+1);
			rowData[1]=apv.getUser_id();
			rowData[2]=apv.getAuc_code();
			rowData[3]=apv.getCategory();
			rowData[4]=apv.getStatus();
			rowData[5]=apv.getItem_name();
			rowData[6]=apv.getStart_price();
			rowData[7]=apv.getPeriod();
			
			completeList.addRow(rowData);
		}//end for
		
		System.out.println(permitList.size());
	}//viewPermitList
	
	/**
	 입찰 목록   왜 rowCount 1부터 시작해야하는지....
	 * */
	public void viewBidList() throws SQLException {
		DefaultTableModel bidList=apf.getBidList();
		bidList.setRowCount(1);
		
		AdminDAO a_dao=AdminDAO.getInstance();
		List<AdminBidVO> biddingList=a_dao.selectBidList();
		
		Object[] rowData=null;
		AdminBidVO abv=null;
		
		for(int i=0; i<biddingList.size(); i++) {
			abv=biddingList.get(i);
			rowData=new Object[8];
			rowData[0]=new Integer(i+1);
			rowData[1]=abv.getUser_id();
			rowData[2]=abv.getItem_name();
			rowData[3]=abv.getAuc_code();
			rowData[4]=abv.getBid_price();
			rowData[5]=abv.getStart_price();
			rowData[6]=abv.getPermit_date();
			rowData[7]=abv.getEnded_date();
			
			bidList.addRow(rowData);
		}//end for
		System.out.println(biddingList.size());
		
	}//viewBidList
	
	/**
	 낙찰 목록    !!!!!왜 setRowCount 1을 해야 보이는지 확인!!!!!
	 * @throws SQLException 
	 */
	
	public void viewSucBidList() throws SQLException {
		DefaultTableModel sucList= apf.getSucBidList();
		sucList.setRowCount(1);
		
		AdminDAO a_dao=AdminDAO.getInstance();
		List<AdminSucBidVO> sucBidList=a_dao.selectSucBid();
		
		Object[] rowData=null;
		AdminSucBidVO asbv=null;
		
		for(int i=0; i<sucBidList.size(); i++) {
			asbv=sucBidList.get(i);
			rowData=new Object[8];
			rowData[0]=new Integer(i+1);
			rowData[1]=asbv.getUser_id();
			rowData[2]=asbv.getItem_name();
			rowData[3]=asbv.getAuc_code();
			rowData[4]=asbv.getBid_price();
			rowData[5]=asbv.getStart_price();
			rowData[6]=asbv.getPermit_date();
			rowData[7]=asbv.getEnded_date();
			
			sucList.addRow(rowData);
		}//end for
		
		
	}
	
	@Override
		public void mouseClicked(MouseEvent me) {
		JTabbedPane jtpTab=apf.getJtpTab();
		JTable waitingList=apf.getJtwatingList();
		
		switch(jtpTab.getSelectedIndex()) {
		
		case 1 :
			switch(me.getClickCount()) {
			case DOUBLE_CLICK :
				new PermitFrm(amf);
				JOptionPane.showMessageDialog(apf, waitingList.getSelectedRow());
		}//end switch
		
		
		}//switch~case
		
	}//mouseClicked

}//class

