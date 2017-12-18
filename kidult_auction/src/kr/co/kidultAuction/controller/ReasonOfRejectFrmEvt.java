package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.kidultAuction.dao.AdminDAO;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.ReasonOfRejectFrm;
import kr.co.kidultAuction.vo.RejectVO;

public class ReasonOfRejectFrmEvt implements ActionListener {
private ReasonOfRejectFrm rorf;
private RejectVO rv;

	public ReasonOfRejectFrmEvt(ReasonOfRejectFrm rorf) {
		this.rorf=rorf;
	}//reasonOfReject

	public void addReject() throws SQLException {
		RejectVO rv=new RejectVO();
		System.out.println(AuctionMainFrm.User_id+"/"+AuctionMainFrm.Admin_id+"/"+AdminPageFrmEvt.auc_code);
		rv.setAdmin_id(AuctionMainFrm.Admin_id);
		rv.setAuc_code(AdminPageFrmEvt.auc_code);
		rv.setReject_reason(rorf.getJtaReason().getText());
		
		AdminDAO a_dao=AdminDAO.getInstance();
		if(a_dao.rejectItem(rv)) {
			JOptionPane.showMessageDialog(rorf, "사용자의 아이템을 거절하셨습니다");
			rorf.dispose();
		}//end if
		
	}//addReject
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==rorf.getBtnOk()) {
			try {
				addReject();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//end if
		
		if(ae.getSource()==rorf.getBtnCancel()) {
			JOptionPane.showMessageDialog(rorf, "거부를 중지합니다");
			rorf.dispose();
		}//end if
		
	}//actionPerformed
}//class
