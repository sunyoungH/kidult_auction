package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.kidultAuction.dao.AdminDAO;
import kr.co.kidultAuction.view.AddAuctionItemFrm;
import kr.co.kidultAuction.view.AddUserFrm;
import kr.co.kidultAuction.view.AdminPageFrm;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.ListOfAuctionsFrm;
import kr.co.kidultAuction.view.LoginFrm;
import kr.co.kidultAuction.view.MyAuctionFrm;
import kr.co.kidultAuction.view.MyPageFrm;
import kr.co.kidultAuction.vo.AdminOncomingBidVO;

public class AuctionMainFrmEvt implements ActionListener {
	private AuctionMainFrm amf;
	private boolean flag = false;

	public AuctionMainFrmEvt(AuctionMainFrm amf) {
		this.amf=amf;
		try {
			endBid();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// auctionmainFrmEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == amf.getBtnAddUser()) {
			new AddUserFrm(amf);
		} // end if

		if (ae.getSource() == amf.getBtnAddItem()) {
			new AddAuctionItemFrm(amf);
		} // end if

		if (ae.getSource() == amf.getBtnAuctionList()) {
			try {
				new ListOfAuctionsFrm(amf);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end if
        
		if (ae.getSource() == amf.getBtnLogin()) {
			LoginFrm lf = new LoginFrm(amf);
			if (lf.isFlag()) {
				amf.getBtnLogin().setIcon(new ImageIcon(getClass().getClassLoader().getResource("kidultAuction_img/mainLogin.png")));
				// amf.getBtnLogin().setText("로그인");
				flag=true;
			}
		} // end if

		if (ae.getSource() == amf.getBtnMyPage()) {
			new MyPageFrm(amf);
		} // end if

		if (ae.getSource() == amf.getBtnExit()) {
			switch (JOptionPane.showConfirmDialog(amf, "종료하시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				amf.dispose();
				break;
			}
		} // end if

	}// actionPerformed


	/**
	 * 경매 자동 종료 메소드
	 * @throws SQLException
	 */

	public void endBid() throws SQLException {
		boolean flag = false;
		AdminDAO a_dao = AdminDAO.getInstance();
		List<AdminOncomingBidVO> dataList = a_dao.selectOncomingData();
		AdminOncomingBidVO aobv = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		String nowDate = sdf.format(new Date());
		String[] expected_end_date = new String[dataList.size()], auc_code = new String[dataList.size()];
		Map<Integer, String> code_date = new HashMap<>();

		if (dataList.size() != 0) {
			for (int i = 0; i < dataList.size(); i++) {
				aobv = dataList.get(i);
				expected_end_date[i] = aobv.getExpected_end_date();
				expected_end_date[i] = expected_end_date[i].substring(2, expected_end_date[i].indexOf(" "));
				auc_code[i] = aobv.getAuc_code();

				if (nowDate.equals(expected_end_date[i])) {
					code_date.put(i, auc_code[i]);
				} // end if
			} // end for
		} // end if
		System.out.println("====" + code_date.size());
		for (int j = 1; j < code_date.size() + 1; j++) {
			System.out.println(j);
			if (code_date.containsKey(j)) {
				AdminPageFrm.auc_code = code_date.get(j);
				System.out.println("키있음" + j + " / " + AdminPageFrm.auc_code);
				a_dao.insertEndBid(AdminPageFrm.auc_code);
			} else {
				System.out.println("키없음");
			} // end else
		} // end for
	}// endBid

}// class
