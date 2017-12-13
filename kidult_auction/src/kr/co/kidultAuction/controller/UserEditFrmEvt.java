package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.co.kidultAuction.view.UserEditFrm;

public class UserEditFrmEvt implements ActionListener{
	private UserEditFrm uef;
	public UserEditFrmEvt(UserEditFrm uef) {
		this.uef=uef;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==uef.getBtnSubmit()) {
			System.out.println("변경되었음");
		}//end if
		if(ae.getSource()==uef.getBtnCancel()) {
			System.out.println("취소되었음");
		}//end if
		
	}//actonPerformed

}
