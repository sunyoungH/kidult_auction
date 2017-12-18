package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.kidultAuction.dao.AdminDAO;
import kr.co.kidultAuction.view.ApproveFrm;
import kr.co.kidultAuction.view.ReasonOfRejectFrm;
import kr.co.kidultAuction.vo.AdminApproveVO;

public class ApproveFrmEvt implements ActionListener{
	public static final int DOUBLE_CLICK=2;
	public static final int WAITING_LIST=1;
	private ApproveFrm af;

	public ApproveFrmEvt(ApproveFrm af) throws SQLException {
		this.af=af;
		addApprove();

	}//PermitFrmEvt

	public void addApprove() throws SQLException {
		String str=AdminPageFrmEvt.auc_code;
		System.out.println(str+"ApproveFrmEvt");

		List<AdminApproveVO> approveList=new ArrayList<AdminApproveVO>();
		AdminDAO a_dao=AdminDAO.getInstance();
		approveList=a_dao.selectApprove();

		AdminApproveVO aav=null;

		for(int i=0; i<approveList.size(); i++) {
			aav=approveList.get(i);
		}//end for
		
		af.getTfUserId().setText(aav.getUser_id());
		if("L".equals(aav.getCategory())){
			af.getTfCategory().setText("레고");
		}else if("P".equals(aav.getCategory())) {
			af.getTfCategory().setText("프라모델");
		}else if("F".equals(aav.getCategory())) {
			af.getTfCategory().setText("피규어");
		}//end else if
		af.getTfStatus().setText(aav.getStatus());
		af.getTfItemName().setText(aav.getItem_name());
		af.getTfSPrice().setText(String.valueOf(aav.getStart_price()));
		af.getTfPeriod().setText(aav.getPeriod()+"일");
		af.getTaItemInfo().setText(aav.getDetail_info());
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==af.getBtnCommit()) {
			AdminDAO a_dao=AdminDAO.getInstance();
			try {
				boolean approveFlag=a_dao.updateApproveItem();
				if(approveFlag) {
					JOptionPane.showMessageDialog(af, "승인 완료!");
					af.dispose();
				}else {
					JOptionPane.showMessageDialog(af, "승인과정중 오류");
				}//end else
			} catch (SQLException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(ae.getSource()==af.getBtnReject()) {
			new ReasonOfRejectFrm(af);
			System.out.println("관리자께서 승인거부하셨습니다.");
			af.dispose();
		}//end if
	}//actionPerformed
}//class
