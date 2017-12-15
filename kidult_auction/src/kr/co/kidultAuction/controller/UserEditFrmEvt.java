package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.kidultAuction.dao.UserDAO;
import kr.co.kidultAuction.view.UserEditFrm;
import kr.co.kidultAuction.vo.UserShowVO;

public class UserEditFrmEvt implements ActionListener {
	private UserEditFrm uef;

	public UserEditFrmEvt(UserEditFrm uef) throws SQLException {
		this.uef = uef;
		UserEditFrmEvt();
	}

	public void UserEditFrmEvt() throws SQLException {

		UserDAO u_dao = UserDAO.getInstance();
		List<UserShowVO> list = new ArrayList<UserShowVO>();
		list=u_dao.selectUserInfo();
		UserShowVO usv = null;

		for (int i = 0; i < list.size(); i++) {

			usv = list.get(i);

			uef.getTfId().setText(usv.getUser_id());
			uef.getTfName().setText(usv.getName());
			uef.getTfBirth().setText(usv.getBirth_date());
			uef.getTfAddr().setText(usv.getAddr());
			uef.getTfEmail().setText(usv.getEmail());
			uef.getTfPhone().setText(usv.getPhone());
			uef.getTfKakao().setText(usv.getKakao_id());

		}

	}// UserEditFrmEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == uef.getBtnSubmit()) {

			System.out.println("변경되었음");
		} // end if
		if (ae.getSource() == uef.getBtnCancel()) {
			uef.dispose();
			System.out.println("닫기");
		} // end if

	}// actonPerformed

}
