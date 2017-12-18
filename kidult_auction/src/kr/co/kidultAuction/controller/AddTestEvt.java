package kr.co.kidultAuction.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import kr.co.kidultAuction.view.AuctionMainFrm;

public class AddTestEvt implements ActionListener{
	
	private AddTest aiif;
	
	private File writeFile, writeThumbFile;
	
	private ImageIcon icon;
	
	public AddTestEvt(AddTest aiif) {
		this.aiif=aiif;
	}//AddItemImageFrmEvt
	
	
	private void imgSelect() throws IOException {
		FileDialog fdImg = new FileDialog(aiif, "���� �����ϱ� ", FileDialog.LOAD);
		fdImg.setVisible(true);

		String path = fdImg.getDirectory();
		String file = fdImg.getFile();

		if (file != null) {// ������ ������ ����
			// �̹��� ���ϸ� �����ϵ��� Ȯ����(jpg,gif,png)��
			String[] arrFile = file.split("[.]");
			String ext = arrFile[arrFile.length - 1];
			/////////////////////////////////////////////////// PNG ,JPG, GIF �� �������ּ��� /////////////////////////////////////////
			if (!"jpg,gif,png,PNG".contains(ext)) {
				JOptionPane.showMessageDialog(aiif, "���ö��̹����� jpg,gif,png�� �����մϴ�.");
				return;
			} // end if

			///////////////////////////// SimpleDateFormat////////////////
			SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd_h_m_s");
			String date= sdf.format(new Date());
			/////////////////////////////////////////////////////////////////////
			
			String runDir = System.getProperty("user.dir");
			File readFile = new File(path + file);
			/////////////////////////////////////////////////////////////////////
			writeFile = new File(runDir + "/src/kr/co/kidultAuction/img/" + AuctionMainFrm.User_id+date); // �����̸����� ���� ���ø���
			/////////////////////////////////////////////////////////////////////
			
			FileInputStream fis = null;
			FileOutputStream fos = null;
			byte[] readData=new byte[512];
			int temp=0;
			
			//���Ͽ��� �о� ���̴� ��Ʈ��
			fis=new FileInputStream(readFile);
			//�������� ������ �����ϴ� ��Ʈ��
			fos=new FileOutputStream(writeFile);
			while ((temp=fis.read(readData))!=-1) {
				//���Ͽ��� �о���� ������ ���Ϸ� ������
				fos.write(readData, 0, temp);
			}//end while
			fos.flush();//���� ���� ������ ������ ����� �������� �ʴ´�
			if(fis !=null) {
				fis.close();
			}//end if
			if(fos !=null) {
				fos.close();
			}//end if
			readData=null;
			
			fis=new FileInputStream(readFile);
			fos=new FileOutputStream(writeFile);
			readData=new byte[512];
			while((temp=fis.read(readData))!=-1) {
				fos.write(readData, 0, temp);
			}//end while
			fos.flush();
			
			JLabel lblTemp = null;
			 icon=new ImageIcon(writeFile.getAbsolutePath());
			//lblTemp.setIcon(icon);
			System.out.println( icon);
			JOptionPane.showMessageDialog(aiif, "�̹����� ���������� ��ϵǾ���");
			
			System.out.println(writeFile.getAbsolutePath());
			
		}//end if
	}//imgSelect

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==aiif.getBtnFront()) {
			try {
				imgSelect();
				System.out.println( icon);
				aiif.getLbFrontImg().setIcon(icon);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(aiif, "�̹����� ���������� ��ϵ��� ����");
				e.printStackTrace();
			}
		}
		
		if(ae.getSource()==aiif.getBtnBack()) {
			try {
					imgSelect();
				aiif.getLbBackImg().setIcon(icon);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(aiif, "�̹����� ���������� ��ϵ��� ����");
				e.printStackTrace();
			}
		}
		
		if(ae.getSource()==aiif.getBtnLeft()) {
			try {
				imgSelect();
				aiif.getLbLeftImg().setIcon(icon);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(aiif, "�̹����� ���������� ��ϵ��� ����");
				e.printStackTrace();
			} 
		}
		
		if(ae.getSource()==aiif.getBtnRight()) {
			try {
				imgSelect();
				aiif.getLbRightImg().setIcon(icon);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(aiif, "�̹����� ���������� ��ϵ��� ����");
				e.printStackTrace();
			}
		}
		
		if(ae.getSource()==aiif.getBtnAdd()) {
			System.out.println("���");
		}
		
		if(ae.getSource()==aiif.getBtnCancel()) {
			aiif.dispose();
		}
		
		
	}//actionPerformed

}
