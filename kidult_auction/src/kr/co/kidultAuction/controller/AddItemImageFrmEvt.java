package kr.co.kidultAuction.controller;

import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import kr.co.kidultAuction.view.AddAuctionItemFrm;
import kr.co.kidultAuction.view.AddItemImageFrm;

public class AddItemImageFrmEvt implements ActionListener{
	
	private AddItemImageFrm aiif;
	private AddAuctionItemFrm aaif;
	private File writeFile, writeThumbFile;
	
	static ImageIcon icon, finalIcon;
	
	private Socket client;
	
	boolean frontFlag;
	boolean leftFlag;
	boolean rightFlag;
	boolean backFlag;
	
	 static ImageIcon frontIcon;
	 static ImageIcon backIcon;
	 static ImageIcon leftIcon;
	 static ImageIcon rightIcon;
	
	static String path, fileName;
	
	
	
	public AddItemImageFrmEvt(AddItemImageFrm aiif, AddAuctionItemFrm aaif) {
		this.aiif=aiif;
		this.aaif=aaif;
	}//AddItemImageFrmEvt
	
	
	
	private void imgSelect() throws IOException {
		
		frontFlag=false;
		leftFlag=false;
		rightFlag=false;
		backFlag=false;
		FileDialog fdImg = new FileDialog(aiif, "���� �����ϱ� ", FileDialog.LOAD);
		fdImg.setVisible(true);

		path = fdImg.getDirectory();
		fileName = fdImg.getFile();

		if (fileName != null) {// ������ ������ ����
			// �̹��� ���ϸ� �����ϵ��� Ȯ����(jpg,gif,png)��
			String[] arrFile = fileName.split("[.]");
			String ext = arrFile[arrFile.length - 1];
			if (!"jpg,gif,png,JPG,GIF,PNG".contains(ext)) {
				JOptionPane.showMessageDialog(aiif, "�̹����� jpg,gif,png�� �����մϴ�.");
				return;
			} // end if
			
			
			
			/*----------------------------------------------------------------------------------------------------*/

//			int dataSize=0;
//			byte[] data=new byte[512];
//			File file=new File(path+"/"+fileName);
//			FileInputStream fis=new FileInputStream(file);
//			int binaryLen=0;
//			
//			while((binaryLen=fis.read(data))>0) {
//				dataSize++;
//			}//end while
//			
//			fis.close();
//			client=new Socket("211.63.89.135", 5500);
//			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
//			dos.writeUTF(fileName);
//			dos.writeInt(dataSize);
//			fis=new FileInputStream(file);
//			
//			while(dataSize>0) {
//				binaryLen=fis.read(data);
//				dos.write(data, 0, binaryLen);
//				dataSize--;
//			}//end while
//			
//			dos.flush();
//			System.out.println(fileName+" => ���ۿϷ�");
//			fis.close();
//			client.close();
			
			icon=new ImageIcon(path+fileName);
			
			/*----------------------------------------------------------------------------------------------------*/
			//���⼭�� �ּ� ���� �޾ƿ´����� AddAuctionItemFrm ���� Ȯ���� ������ �� img package ������ ���� ���� �ǵ��� �ϰ� �ϰ� 
			

			
						
//			 icon=new ImageIcon(writeFile.getAbsolutePath());
			 Image resizeImg = icon.getImage();  //ImageIcon�� Image�� ��ȯ.
			 Image finishImg = resizeImg.getScaledInstance(225, 225, java.awt.Image.SCALE_SMOOTH);
			 finalIcon = new ImageIcon(finishImg); //Image�� ImageIcon ����

			 JOptionPane.showMessageDialog(aiif, "�̹����� ���������� ��ϵǾ���");
			 
		}//end if
		
	}//imgSelect
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==aiif.getBtnFront()) {
			try {
				frontFlag=true;
				imgSelect();
				frontIcon=icon;
				aiif.getLbFrontImg().setIcon(finalIcon);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(aiif, "�̹����� ���������� ��ϵ��� ����");
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(ae.getSource()==aiif.getBtnBack()) {
			try {
				backFlag=true;
				imgSelect();
				 backIcon=icon;
				aiif.getLbBackImg().setIcon(finalIcon);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(aiif, "�̹����� ���������� ��ϵ��� ����");
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(ae.getSource()==aiif.getBtnLeft()) {
			try {
				leftFlag=true;
				imgSelect();
				leftIcon=icon;
				aiif.getLbLeftImg().setIcon(finalIcon);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(aiif, "�̹����� ���������� ��ϵ��� ����");
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(ae.getSource()==aiif.getBtnRight()) {
			try {
				rightFlag=true;
				imgSelect();
				rightIcon=icon;
				aiif.getLbRightImg().setIcon(finalIcon);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(aiif, "�̹����� ���������� ��ϵ��� ����");
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(ae.getSource()==aiif.getBtnAdd()) {
			ImageIcon  deliveryIcon= (ImageIcon)aiif.getLbFrontImg().getIcon();
			aaif.getLbItemImg().setIcon(deliveryIcon);
			aiif.dispose(); 
			
		}//end if
		
		if(ae.getSource()==aiif.getBtnCancel()) {
			aiif.dispose();
		}//end if
		
		
	}//actionPerformed


	
	
}//class
