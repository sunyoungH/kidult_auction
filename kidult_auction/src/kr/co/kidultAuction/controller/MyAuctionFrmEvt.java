package kr.co.kidultAuction.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.kidultAuction.dao.UserDAO_MH;
import kr.co.kidultAuction.view.AdminPageFrm;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.MyAuctionFrm;
import kr.co.kidultAuction.vo.LoginVO;
import kr.co.kidultAuction.vo.MyAuctionAddVO;
import kr.co.kidultAuction.vo.MyAuctionReceiveVO;
import kr.co.kidultAuction.vo.MyAuctionSendVO;
import kr.co.kidultAuction.vo.RejectVO;
import kr.co.kidultAuction.vo.SendStatusVO;

public class MyAuctionFrmEvt extends MouseAdapter {
	private AuctionMainFrm amf;
	private MyAuctionFrm maf;

	public static final int AddedList = 0;
	public static final int BidList = 1;
	public static final int SucBidList = 2;
	public static final int DOUBLE_CLICK = 3;
	List<MyAuctionSendVO> sendList;
	List<RejectVO> reject;

	public MyAuctionFrmEvt(MyAuctionFrm maf) throws SQLException {
		this.maf = maf;
		System.out.println("아이디" + AuctionMainFrm.User_id);
		setAddedList();
	}

	/**
	 * 등록한 경매
	 */
	public void setAddedList() throws SQLException {
		DefaultTableModel tempAddList = maf.getDtmAucItem();
		tempAddList.setRowCount(0);

		UserDAO_MH u_dao = UserDAO_MH.getInstance();
		List<MyAuctionAddVO> addList = u_dao.selectMyAuctionAdd();

		Object[] rowData = null;
		MyAuctionAddVO maav = null;
		LoginVO lv = new LoginVO();
		lv.setUser_id(AuctionMainFrm.User_id);

		for (int i = 0; i < addList.size(); i++) {
			maav = addList.get(i);
			rowData = new Object[7];
			rowData[0] = new Integer(i + 1);
			rowData[1] = maav.getItem_name();
			rowData[2] = maav.getCategory();
			rowData[3] = maav.getStart_price();
			rowData[4] = maav.getPeriod();
			rowData[5] = maav.getAdd_date();
			rowData[6] = maav.getPermit();

			tempAddList.addRow(rowData);
		} // end for
	}// setAddedList
	
	

	/**
	 * 보낼물건
	 */
	
	public void setBidList() throws SQLException {
		DefaultTableModel tempSendList = maf.getSendItem();
		

		UserDAO_MH u_dao = UserDAO_MH.getInstance();
		 sendList = u_dao.selectMyAuctionSend();
		 
		 tempSendList.setRowCount(0);	
		 
		Object[] rowData = null;
		MyAuctionSendVO maav = null;
		for (int i = 0; i < sendList.size(); i++) {
			
			maav = sendList.get(i);
			rowData = new Object[8];
			rowData[0] = new Integer(i + 1);
			rowData[1] = maav.getItem_name();
			rowData[2] = maav.getStart_price();
			rowData[3] = maav.getBid_price();
			rowData[4] = maav.getStart_date();
			rowData[5] = maav.getEnded_date();
			rowData[6] = maav.getKakao_id();
			rowData[7] = maav.getSend_status();

			tempSendList.addRow( rowData);
		} // end for
		
		/* JOptionPane.showConfirmDialog(maf, maav.getSend_status()); */
//		tempSendList.setRowCount( sendList.size());
	}// setBidList

	/**
	 * 받을 물건
	 */
	public void setSucBidList() throws SQLException {
		DefaultTableModel tempReceiveList = maf.getRecieveItem();
		tempReceiveList.setRowCount(0);

		UserDAO_MH u_dao = UserDAO_MH.getInstance();
		List<MyAuctionReceiveVO> ReceiveList = u_dao.selectMyAuctionReceive();

		Object[] rowData = null;
		MyAuctionReceiveVO marv = null;

		for (int i = 0; i < ReceiveList.size(); i++) {
			marv = ReceiveList.get(i);
			rowData = new Object[8];
			rowData[0] = new Integer(i + 1);
			rowData[1] = marv.getItem_name();
			rowData[2] = marv.getStart_price();
			rowData[3] = marv.getBid_price();
			rowData[4] = marv.getStart_date();
			rowData[5] = marv.getEnded_date();
			rowData[6] = marv.getKakao_id();
			rowData[7] = marv.getSend_status();

			tempReceiveList.addRow(rowData);
		} // end for
		/* JOptionPane.showConfirmDialog(maf, marv.getReceive_status()); */

	}
	public void panel(int taIndex) throws SQLException{
		switch (taIndex) {
		case 0:
			setAddedList();
			break;
		case 1:
				setBidList();
			break;
		case 2:
				setSucBidList();
			break;
		}// end switch
	}//panel()

	public void doubleClick( MouseEvent me)throws ClassCastException {
		JTable tempTable=(JTable)me.getSource();
		int rowNum=tempTable.getSelectedRow();
		
		if( me.getClickCount() == 2 ) {
			if(me.getSource()== maf.getJtAucItem()) {//등록한 경매
				System.out.println("등록 경매 클릭 행수 "+ rowNum);
				
				switch (me.getClickCount()) {
				case AddedList:

						UserDAO_MH u_dao = UserDAO_MH.getInstance();
						String auc_code=reject.get(maf.getJtAucItem().getSelectedRow()).getAuc_code();
						System.out.println(auc_code);
						try {
							u_dao.reject(auc_code);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						try {
							List<RejectVO> aucList = u_dao.reject(auc_code);
							RejectVO rv = null;
							String reject = "", reject_time = "";
							for (int i = 0; i < aucList.size(); i++) {
								rv = aucList.get(i);
								reject = rv.getReject_reason();
								reject_time = rv.getReject_date().substring(0, rv.getReject_date().indexOf(" ") + 1);
							} // end for

							StringBuilder rejectData = new StringBuilder();
							rejectData.append(reject_time + "일에 거부 되었습니다. \n 거부사유 : " + reject);

							JOptionPane.showMessageDialog(maf, rejectData.toString(), "거부사유", 0, null);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						System.out.println(AuctionMainFrm.User_id);
					}
				}// end switch
			
			if(me.getSource()== maf.getJtSendItem()) {//보낼 물건
				 
				switch (me.getClickCount()) {
				case SucBidList:
					UserDAO_MH u_dao = UserDAO_MH.getInstance();
					try {
					int ended_num=sendList.get(rowNum).getEnded_num();
						u_dao.sendStatus(ended_num);
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}// end switch
				
			}//end if
			
			
			if(me.getSource()== maf.getJtRecieveItem()) {//받을 물건
				System.out.println("받을 클릭 행수 "+ rowNum);
				
				
				
			}//end if
			
		}//end if
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		JTabbedPane tempTab = maf.getJtpTab();
		try {
			doubleClick(me);
		}catch(ClassCastException cnfe) {
		}
		//탭 클릭시 내용 조회 
		try {
			panel(tempTab.getSelectedIndex());
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}

}// class
