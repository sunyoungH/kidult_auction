package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.kidultAuction.dao.AdminDAO;
import kr.co.kidultAuction.view.AdminPageFrm;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.ReasonOfRejectFrm;
import kr.co.kidultAuction.vo.AdminRejectVO;

public class ReasonOfRejectFrmEvt implements ActionListener {
private ReasonOfRejectFrm rorf;
private AdminRejectVO rv;

	public ReasonOfRejectFrmEvt(ReasonOfRejectFrm rorf) {
		this.rorf=rorf;
	}//reasonOfReject

	public void addReject() throws SQLException {
		AdminRejectVO rv=new AdminRejectVO();
		System.out.println(AuctionMainFrm.User_id+"/"+AuctionMainFrm.Admin_id+"/"+AdminPageFrm.auc_code);
		rv.setAdmin_id(AuctionMainFrm.Admin_id);
		rv.setAuc_code(AdminPageFrm.auc_code);
		rv.setReject_reason(rorf.getJtaReason().getText());
		
		AdminDAO a_dao=AdminDAO.getInstance();
		if(a_dao.rejectItem(rv)) {
			JOptionPane.showMessageDialog(rorf, "������� �������� �����ϼ̽��ϴ�");
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
			JOptionPane.showMessageDialog(rorf, "�źθ� �����մϴ�");
			rorf.dispose();
		}//end if
		
	}//actionPerformed
}//class
