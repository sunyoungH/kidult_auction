package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.kidultAuction.dao.AdminDAO;
import kr.co.kidultAuction.view.AdminPageFrm;
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

	/***
	 * db���� ��ϵ� ������ �ҷ����� method
	 * @throws SQLException
	 */
	public void addApprove() throws SQLException {
		String str=AdminPageFrm.auc_code;
		System.out.println(str+"ApproveFrmEvt");

		List<AdminApproveVO> approveList=new ArrayList<AdminApproveVO>();
		AdminDAO a_dao=AdminDAO.getInstance();
		approveList=a_dao.selectApprove();

		AdminApproveVO aav=null;

		for(int i=0; i<approveList.size(); i++) {
			aav=approveList.get(i);
		}//end for
		
		af.getTfUserId().setText(aav.getUser_id());
		switch(aav.getCategory().toString()) {
		case("F") : af.getTfCategory().setText("�ǱԾ�");
		case("P") : af.getTfCategory().setText("�����");
		case("L") : af.getTfCategory().setText("����");
		}//end switch
		af.getTfStatus().setText(aav.getStatus());
		af.getTfItemName().setText(aav.getItem_name());
		af.getTfSPrice().setText(String.valueOf(aav.getStart_price()));
		af.getTfPeriod().setText(aav.getPeriod()+"��");
		af.getTaItemInfo().setText(aav.getDetail_info());
		
		String path="C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/";
		af.getLblImgFront().setIcon(new ImageIcon(path+aav.getFront_img()));
		af.getLblImgRight().setIcon(new ImageIcon(path+aav.getRight_img()));
		af.getLblImgLeft().setIcon(new ImageIcon(path+aav.getLeft_img()));
		af.getLblImgBack().setIcon(new ImageIcon(path+"back_img__171221_14501.PNG"));
		
		AdminPageFrm.start_price=aav.getStart_price();
	}//addApprove
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==af.getBtnCommit()) {
			AdminDAO a_dao=AdminDAO.getInstance();
			try {
				boolean approveFlag=a_dao.updateApproveItem();
				if(approveFlag) {
					JOptionPane.showMessageDialog(af, "���� �Ϸ�!");
					if(a_dao.insertBidUserData()) {
						System.out.println("������� bid ������ �߰��Ϸ�");
					}//end if
					af.dispose();
				}else {
					JOptionPane.showMessageDialog(af, "���ΰ����� ����");
				}//end else
			} catch (SQLException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(ae.getSource()==af.getBtnReject()) {
			new ReasonOfRejectFrm(af);
			System.out.println("�����ڲ��� ���ΰź��ϼ̽��ϴ�.");
			af.dispose();
		}//end if
	}//actionPerformed

	
}//class
