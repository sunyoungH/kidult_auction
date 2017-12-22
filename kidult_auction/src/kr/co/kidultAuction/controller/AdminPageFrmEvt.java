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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import kr.co.kidultAuction.vo.AdminOncomingBidVO;
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
		endBid();
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
			rowData[6]=apv.getStart_price()+"원";
			rowData[7]=apv.getPeriod()+"일";

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

		SimpleDateFormat sdf=new SimpleDateFormat("yy-mm-dd");
		String nowDate=sdf.format(new Date());
		String expected_end_date="";


		for(int i=0; i<biddingList.size(); i++) {
			abv=biddingList.get(i);
			rowData=new Object[8];
			rowData[0]=new Integer(i+1);
			rowData[1]=abv.getUser_id();
			rowData[2]=abv.getItem_name();
			rowData[3]=abv.getAuc_code();
			rowData[4]=abv.getTop_price();
			rowData[5]=abv.getStart_price();
			rowData[6]=abv.getStart_date().substring(0, abv.getStart_date().indexOf(" ")+1);
			expected_end_date=abv.getBid_end_date().substring(0, abv.getBid_end_date().indexOf(" ")+1);
			rowData[7]=expected_end_date;

			if(true) {
				//		if(nowDate.equals(expected_end_date)) {
				bidList.addRow(rowData);
			}
		}//end for
		/// 경매시작시간(승인날짜 +1일 자정 =expected_date)이 됐을 때, 입찰 목록을 조회 가능하게 하겠습니다.
	}//viewBidList

	/**
	 낙찰 목록   
	 * @throws SQLException 
	 */

	public void viewSucBidList() throws SQLException {
		DefaultTableModel sucList= apf.getSucBidList();
		sucList.setRowCount(0);

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
			rowData[4]=asbv.getEnded_price();
			rowData[5]=asbv.getStart_price();
			rowData[6]=asbv.getStart_date().substring(0, asbv.getStart_date().indexOf(" ")+1);
			rowData[7]=asbv.getEnded_date().substring(0, asbv.getEnded_date().indexOf(" ")+1);

			sucList.addRow(rowData);
		}//end for

	}//viewSucBid

	/**
	 * getImgIcon  승인, 승인거부 창에 있는 이미지 네장 불러오는 method
	 * */
	public void getImgIcon() {

	}


	/**
	 * 경매 자동 종료 메소드
	 * @throws SQLException 
	 * */

	public boolean endBid() throws SQLException {
		boolean flag=false;
		AdminDAO a_dao=AdminDAO.getInstance();
		List<AdminOncomingBidVO> dataList=a_dao.selectOncomingData();
		AdminOncomingBidVO aobv=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
		String nowDate=sdf.format(new Date());
		String[] expected_end_date=new String[dataList.size()], auc_code=new String[dataList.size()];
		Map<Integer, String> code_date=new HashMap<>();

		if(dataList.size()!=0) {
			for(int i=0; i<dataList.size(); i++) {
				aobv=dataList.get(i);
				expected_end_date[i]=aobv.getExpected_end_date();
				expected_end_date[i]=expected_end_date[i].substring(2, expected_end_date[i].indexOf(" "));
				auc_code[i]=aobv.getAuc_code();

				if("17-12-24".equals(expected_end_date[i])) {
				code_date.put(i,auc_code[i]);
				}//end if
				
				System.out.println(expected_end_date[i]);
				System.out.println(auc_code[i]);
			}//end for
			

//			if(nowDate.equals(expected_end_date)) {
		}//end if
		for(int j=0; j<code_date.size(); j++) {
			AdminPageFrm.auc_code=code_date.get(j);
			System.out.println(AdminPageFrm.auc_code);
//			a_dao.insertEndBid();
		}//end for
		return flag;
	}//endBid



	@Override
	public void mouseClicked(MouseEvent me) {
		JTabbedPane jtpTab=apf.getJtpTab();
		JTable waitingList=apf.getJtwatingList();
		JTable bidList=apf.getJtbidList();

		switch(jtpTab.getSelectedIndex()) {
		/**
		 * 승인 또는 승인거부 
		 * */
		case WAITING_LIST :
			if(me.getClickCount()==2) {
				AdminPageFrm.auc_code=(String)waitingList.getValueAt(waitingList.getSelectedRow(), 2);
				AdminPageFrm.user_id=(String)waitingList.getValueAt(waitingList.getSelectedRow(), 1);
				try {
					new ApproveFrm(apf);
				} catch (SQLException e) {
					e.printStackTrace();
				}//end catch
			}//end if
			break;

			/**
			 * 경매 진행중인 목록 실시간 경매가격 조회 
			 */
		case BIDDING_LIST :
			if(me.getClickCount()==2) {
				AdminPageFrm.auc_code=(String)bidList.getValueAt(bidList.getSelectedRow(), 3);
				AdminPageFrm.user_id=(String)bidList.getValueAt(bidList.getSelectedRow(), 1);
				System.out.println(AdminPageFrm.auc_code+"/"+AdminPageFrm.user_id);
				try {
					new AllTimeBidFrm(apf);
				} catch (SQLException e) {
					e.printStackTrace();
				}//end catch
			}//end if

		}//switch~case
	}//mouseClicked


}//class

