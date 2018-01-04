package kr.co.kidultAuction.controller;

import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	
	static ImageIcon icon, finalIcon, downsizeImg;
	
	private Socket client;
	
	boolean frontFlag=false;
	boolean leftFlag=false;
	boolean rightFlag=false;
	boolean backFlag=false;
	
	 static ImageIcon frontIcon;
	 static ImageIcon backIcon;
	 static ImageIcon leftIcon;
	 static ImageIcon rightIcon;
	
	static String path, fileName;
	
	 static String frontFileName;
	 static String backFileName;
	 static String leftFileName;
	 static String rightFileName;
	 
	 static int cnt=0;
	

	
	
	
	public AddItemImageFrmEvt(AddItemImageFrm aiif, AddAuctionItemFrm aaif) {
		this.aiif=aiif;
		this.aaif=aaif;
	}//AddItemImageFrmEvt
	
	
	
	private void imgSelect() throws IOException {
		
		
		
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
//			 ImageIO.write(finishImg, "jpg", "C:/Users/Public/Pictures/Sample Pictures/ddd.jpg");
			 finalIcon = new ImageIcon(finishImg); //Image로 ImageIcon 생성
			 
			 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		     BufferedImage newImage = new BufferedImage(225, 225, finishImg.SCALE_SMOOTH);
		        Graphics g = newImage.getGraphics();
		        g.drawImage(finishImg, 0, 0, null);
		        g.dispose();
		        ImageIO.write(newImage, "jpg", new File(path+"s_"+fileName));
		        
		        downsizeImg=new ImageIcon(path+"s_"+fileName);

			 /*===================================================================================*/
//			 BufferedImage originalImage = ImageIO.read(new File("C:/Users/Public/Pictures/Sample Pictures/ej_test5.jpg"));
//				int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
//			 
//			 BufferedImage resizedImage = new BufferedImage(225, 225, type);
//			 Graphics2D g2 = resizedImage.createGraphics();
//			 g2.drawImage(originalImage, 0, 0, 225, 225, null);
//			 ImageIO.write(resizedImage, "jpg", new File("C:/Users/Public/Pictures/Sample Pictures/ej_test5.png"));
//			 System.out.println(resizedImage);
//			 g2.dispose();
			 /*===================================================================================*/
			 
			 
			 JOptionPane.showMessageDialog(aiif, "이미지가 정상적으로 등록되었음");
			 
			 if(frontFlag==true) {
				 frontFileName="front_"+fileName;
				 return;
			 }//end if
			 
			 if(backFlag==true) {
				 backFileName="back_"+fileName;
				 return;
			 }//end if
			 
			 if(leftFlag==true) {
				 leftFileName="left_"+fileName;
				 return;
			 }//end if
			 
			 if(rightFlag==true) {
				 rightFileName="right_"+fileName;
				 return;
			 }//end if

			 
		}//end if
		
	}//imgSelect
	

	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==aiif.getBtnFront()) {
			try {
				frontFlag=true;
				imgSelect();
				frontFlag=false;
				frontIcon=downsizeImg; //frontIcon=icon   icon을 이미지 사이즈를 경로로 바꾸면은 됨
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
				backFlag=false;
				 backIcon=downsizeImg;
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
				leftFlag=false;
				leftIcon=downsizeImg;
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
				rightFlag=false;
				rightIcon=downsizeImg;
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
