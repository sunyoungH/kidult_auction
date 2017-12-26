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
		FileDialog fdImg = new FileDialog(aiif, "사진 선택하기 ", FileDialog.LOAD);
		fdImg.setVisible(true);

		path = fdImg.getDirectory();
		fileName = fdImg.getFile();

		if (fileName != null) {// 선택한 파일이 있음
			// 이미지 파일만 선택하도록 확장자(jpg,gif,png)비교
			String[] arrFile = fileName.split("[.]");
			String ext = arrFile[arrFile.length - 1];
			if (!"jpg,gif,png,JPG,GIF,PNG".contains(ext)) {
				JOptionPane.showMessageDialog(aiif, "이미지는 jpg,gif,png만 가능합니다.");
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
//			System.out.println(fileName+" => 전송완료");
//			fis.close();
//			client.close();
			
			icon=new ImageIcon(path+fileName);
			
			/*----------------------------------------------------------------------------------------------------*/
			//여기서는 주소 값만 받아온다음에 AddAuctionItemFrm 에서 확인을 눌렀을 때 img package 안으로 값이 전달 되도록 하게 하고 
			

			
						
//			 icon=new ImageIcon(writeFile.getAbsolutePath());
			 Image resizeImg = icon.getImage();  //ImageIcon을 Image로 변환.
			 Image finishImg = resizeImg.getScaledInstance(225, 225, java.awt.Image.SCALE_SMOOTH);
			 finalIcon = new ImageIcon(finishImg); //Image로 ImageIcon 생성

			 JOptionPane.showMessageDialog(aiif, "이미지가 정상적으로 등록되었음");
			 
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
				JOptionPane.showMessageDialog(aiif, "이미지가 정상적으로 등록되지 않음");
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
				JOptionPane.showMessageDialog(aiif, "이미지가 정상적으로 등록되지 않음");
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
				JOptionPane.showMessageDialog(aiif, "이미지가 정상적으로 등록되지 않음");
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
				JOptionPane.showMessageDialog(aiif, "이미지가 정상적으로 등록되지 않음");
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
