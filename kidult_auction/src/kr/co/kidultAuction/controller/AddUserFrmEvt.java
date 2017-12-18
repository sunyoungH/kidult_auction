package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import kr.co.kidultAuction.view.AddUserFrm;

public class AddUserFrmEvt implements ActionListener {
	
	private AddUserFrm auf;
	
	public AddUserFrmEvt(AddUserFrm auf) {
		this.auf=auf;
	}//AddUserFrmEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == auf.getBtnIdCheck()) {
			
		}
		
		if(ae.getSource() == auf.getBtnSubmit()) {
			if(new String(auf.getTfId().getText()).equals("")) {
				JOptionPane.showMessageDialog(auf, "���̵� �Է��ϼ���.");
				auf.getTfId().requestFocus();
				return;
			}
			if(new String(auf.getPfPass().getPassword()).equals("")) {
				JOptionPane.showMessageDialog(auf, "��ȣ�� �Է��ϼ���.");
				auf.getPfPass().requestFocus();
				return;
			}
			if(new String(auf.getPfPassCon().getPassword()).equals("")) {
				JOptionPane.showMessageDialog(auf, "Ȯ���� ��ȣ�� �Է��ϼ���.");
				auf.getPfPassCon().requestFocus();
				return;
			}
			if(auf.getPfPass().getPassword()!=auf.getPfPassCon().getPassword()) {
				JOptionPane.showMessageDialog(auf, "��ȣ�� ��ġ���� �ʽ��ϴ�.");
				auf.getPfPass().requestFocus();
				return;
			}
			if(new String(auf.getTfName().getText()).equals("")) {
				JOptionPane.showMessageDialog(auf, "�̸��� �Է��ϼ���.");
				auf.getTfName().requestFocus();
				return;
			}
			if(new String(auf.getTfBirth().getText()).equals("")) {
				JOptionPane.showMessageDialog(auf, "��������� �Է��ϼ���.");
				auf.getTfBirth().requestFocus();
				return;
			}
			if(new String(auf.getTfAddr().getText()).equals("")) {
				JOptionPane.showMessageDialog(auf, "�ּҸ� �Է��ϼ���.");
				auf.getTfAddr().requestFocus();
				return;
			}
			if(new String(auf.getTfEmail().getText()).equals("")) {
				JOptionPane.showMessageDialog(auf, "�̸����� �Է��ϼ���.");
				auf.getTfEmail().requestFocus();
				return;
			}
			if(new String(auf.getTfPhone().getText()).equals("")) {
				JOptionPane.showMessageDialog(auf, "�ڵ�����ȣ�� �Է��ϼ���.");
				auf.getTfPhone().requestFocus();
				return;
			}
			if(new String(auf.getTfKakao().getText()).equals("")) {
				JOptionPane.showMessageDialog(auf, "īī�����̵� �Է��ϼ���.");
				auf.getTfKakao().requestFocus();
				return;
			}
			System.out.println("��ϿϷ�");
		}
		
		if(ae.getSource() == auf.getBtnCancel()) {
			auf.dispose();
		}
	}//actionPerformed
	
	

}//class
