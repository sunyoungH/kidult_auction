package kr.co.kidultAuction.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.kidultAuction.view.AuctionMainFrm;

public class AddTestEvt implements ActionListener{
	
	private AddTest aiif;
	private File writeFile, writeThumbFile;
	private ImageIcon icon;
	private Socket client;
	
	public AddTestEvt(AddTest aiif) {
		this.aiif=aiif;
	}//AddItemImageFrmEvt
	
	/**
	 	����ڰ� ����� �̹����̸��� ��ü�Ͽ�, �̹����̸� �� �κп� front_  left_  right_ back_ �� �߰� 
		front_userid_20171219_145401 �� �������� ���
		��, �ִ���̰� userid�ִ���̿� ������. front_(6��) _20171219(8��) _145401(7��) => 21�� + userid�ִ� ����Ʈ�� (DB�� �̿� �˸°� ����)
	 * */
	private void imgSelect() throws IOException {
		FileDialog fdImg = new FileDialog(aiif, "���� �����ϱ� ", FileDialog.LOAD);
		fdImg.setVisible(true);

		String path = fdImg.getDirectory();
		String fileName = fdImg.getFile();

		if (fileName != null) {// ������ ������ ����
			
			String[] arrFile = fileName.split("[.]");
			String ext = arrFile[arrFile.length - 1];
			/////////////////////////////////////////////////// PNG ,JPG, GIF �� �������ּ��� /////////////////////////////////////////
			if (!"jpg,gif,png,PNG,JPG,GIF".contains(ext)) {
				JOptionPane.showMessageDialog(aiif, "jpg,gif,png���ϸ� �����մϴ�.");
				return;
		}// end if
			
		int dataSize=0;
		byte[] data=new byte[512];
		File file=new File(path+"/"+fileName);
		FileInputStream fis=new FileInputStream(file);
		int binaryLen=0;
		
		while((binaryLen=fis.read(data))>0) {
			dataSize++;
		}//end while
		
		fis.close();
		client=new Socket("211.63.89.157", 5500);
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF(fileName);
		dos.writeInt(dataSize);
		fis=new FileInputStream(file);
		
		while(dataSize>0) {
			binaryLen=fis.read(data);
			dos.write(data, 0, binaryLen);
			dataSize--;
		}//end while
		
		dos.flush();
		System.out.println(fileName+" => ���ۿϷ�");
		fis.close();
		client.close();
		
		icon=new ImageIcon(path+fileName);
		
		}//end if
	}//imgSelect
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==aiif.getBtnFront()) {
			try {
//				new KidultServer();
				imgSelect();
				System.out.println("������ �̹��� : "+ icon);
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
