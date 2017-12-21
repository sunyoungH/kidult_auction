package kr.co.kidultAuction.controller; 

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import kr.co.kidultAuction.dao.AdminDAO;
import kr.co.kidultAuction.view.AdminPageFrm;
import kr.co.kidultAuction.view.AllTimeBidFrm;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.ApproveFrm;
import kr.co.kidultAuction.vo.AdminApproveVO;
import kr.co.kidultAuction.vo.AdminBidVO;
import kr.co.kidultAuction.vo.AdminPermitVO;
import kr.co.kidultAuction.vo.AdminSucBidVO;
import kr.co.kidultAuction.vo.AdminUserVO;

public class AdminPageFrmEvt extends MouseAdapter{
private AdminPageFrm apf;
private ApproveFrm af;

public static final int WAITING_LIST=1;
public static final int BIDDING_LIST=3;


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
			rowData[5]=auv.getBirth_date().substring(0, auv.getBirth_date().indexOf(" ")+1);
			rowData[6]=auv.getEmail();
			rowData[7]=auv.getAddr();
			rowData[8]=auv.getUser_joindate().substring(0, auv.getUser_joindate().indexOf(" ")+1);
			
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
			switch(apv.getCategory().toString()) {
			case("F") : rowData[3]="피규어";
			case("P") : rowData[3]="프라모델";
			case("L") : rowData[3]="레고";
			}//end switch
			rowData[4]=apv.getStatus();
			rowData[5]=apv.getItem_name();
			rowData[6]=apv.getStart_price();
			rowData[7]=apv.getPeriod();
			
			watingList.addRow(rowData);
		}//end for
		
	}//viewWaitingList
	
	
	/**
	 승인 완료 목록
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
			switch(apv.getCategory().toString()) {
			case("F") : rowData[3]="피규어";
			case("P") : rowData[3]="프라모델";
			case("L") : rowData[3]="레고";
			}//end switch
			rowData[4]=apv.getStatus();
			rowData[5]=apv.getItem_name();
			rowData[6]=apv.getStart_price();
			rowData[7]=apv.getPeriod();
			
			completeList.addRow(rowData);
		}//end for
		
	}//viewPermitList
	
	/**
	 입찰 목록   
	 * */
	public void viewBidList() throws SQLException {
		DefaultTableModel bidList=apf.getBidList();
		bidList.setRowCount(0);
		
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
			rowData[6]=abv.getStart_date().substring(0, abv.getStart_date().indexOf(" ")+1);
			rowData[7]=abv.getBid_end_date().substring(0, abv.getBid_end_date().indexOf(" ")+1);
			
			bidList.addRow(rowData);
		}//end for
		
	}//viewBidList
	
	/**
	 낙찰 목록   (0부터 시작할때 nullpointer 떨어짐)
	 * @throws SQLException 
	 */
	
	public void viewSucBidList() throws SQLException {
		DefaultTableModel sucList= apf.getSucBidList();
		sucList.setRowCount(0);
		
		AdminDAO a_dao=AdminDAO.getInstance();
		List<AdminSucBidVO> sucBidList=a_dao.selectSucBid();
		System.out.println(sucBidList.get(0));
		
		Object[] rowData=null;
		AdminSucBidVO asbv=null;
		
		for(int i=0; i<sucBidList.size(); i++) {
			asbv=sucBidList.get(i);
			rowData=new Object[8];
			rowData[0]=new Integer(i+1);
			rowData[1]=asbv.getUser_id();
			rowData[2]=asbv.getItem_name();
			rowData[3]=asbv.getAuc_code();
			rowData[4]=asbv.getEnded_price();
			rowData[5]=asbv.getStart_price();
			rowData[6]=asbv.getStart_date().substring(0, asbv.getStart_date().indexOf(" ")+1);
			rowData[7]=asbv.getEnded_date().substring(0, asbv.getEnded_date().indexOf(" ")+1);
			
			sucList.addRow(rowData);
		}//end for
		
	}//viewSucBid
	/**
	 *  승인목록 보기
	 * */
	public void viewApprove() throws SQLException {
		List<AdminApproveVO> approveList=new ArrayList<AdminApproveVO>();
		AdminDAO a_dao=AdminDAO.getInstance();
		approveList=a_dao.selectApprove();
		
		AdminApproveVO aav=null;
		
		for(int i=0; i<approveList.size(); i++) {
			aav=approveList.get(i);
			af.getTfUserId().setText("하이");
			af.getTfUserId().setText(aav.getUser_id());
		}//end for
	}//viewApprove
	
	
	
	
	/**
	 * getImgIcon  승인, 승인거부 창에 있는 이미지 네장 불러오는 method
	 * */
	public void getImgIcon() {
		
	}
	
	
	
		
	@Override
		public void mouseClicked(MouseEvent me) {
		JTabbedPane jtpTab=apf.getJtpTab();
		JTable waitingList=apf.getJtwatingList();
		JTable bidList=apf.getJtbidList();
		
		switch(jtpTab.getSelectedIndex()) {
		case WAITING_LIST :
			if(me.getClickCount()==2) {
			 AdminPageFrm.auc_code=(String)waitingList.getValueAt(waitingList.getSelectedRow(), 2);
			 AdminPageFrm.user_id=(String)waitingList.getValueAt(waitingList.getSelectedRow(), 1);
			 System.out.println(AdminPageFrm.auc_code+" : adminPageFrmEvt에서 찍히는 auction code");
			 try {
				 new ApproveFrm(apf);
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }//end catch
			 }//end if
			break;
			
		case BIDDING_LIST :
			if(me.getClickCount()==2) {
				System.out.println("넌 왜안타");
				AdminPageFrm.auc_code=(String)bidList.getValueAt(bidList.getSelectedRow(), 3);
				AdminPageFrm.user_id=(String)bidList.getValueAt(bidList.getSelectedRow(), 1);
				System.out.println(AdminPageFrm.auc_code);
				try {
					new AllTimeBidFrm(apf);
				} catch (SQLException e) {
					e.printStackTrace();
				}//end catch
			}//end if
			
		}//switch~case
	}//mouseClicked
		

}//class

