package kr.co.kidultAuction.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import kr.co.kidultAuction.view.AddAuctionItemFrm;
import kr.co.kidultAuction.view.AddItemImageFrm;

public class AddItemImageFrmEvt implements ActionListener{
	
	private AddItemImageFrm aiif;
	
	private File writeFile, writeThumbFile;
	
	private ImageIcon icon;
	
	public AddItemImageFrmEvt(AddItemImageFrm aiif) {
		this.aiif=aiif;
	}//AddItemImageFrmEvt
	
	
	
	private void imgSelect() throws IOException {
		FileDialog fdImg = new FileDialog(aiif, "사진 선택하기 ", FileDialog.LOAD);
		fdImg.setVisible(true);

		String path = fdImg.getDirectory();
		String file = fdImg.getFile();

		if (file != null) {// 선택한 파일이 있음
			// 이미지 파일만 선택하도록 확장자(jpg,gif,png)비교
			String[] arrFile = file.split("[.]");
			String ext = arrFile[arrFile.length - 1];
			if (!"jpg,gif,png".contains(ext)) {
				JOptionPane.showMessageDialog(aiif, "도시락이미지는 jpg,gif,png만 가능합니다.");
				return;
			} // end if

			String runDir = System.getProperty("user.dir");
			File readFile = new File(path + file);
			writeFile = new File(runDir + "/src/kr/co/kidultAuction/img/" + file); // 같은이름으로 파일 못올리게
			
			if (writeFile.exists()) {// 파일이 복사되는 폴더에 같은 이름의 파일이 존재한다면 파일명을 변경하도록 설정한다.
				JOptionPane.showMessageDialog(aiif, "동일이름의 도시락 이미지가 존재합니다. \n다른이름으로 변경하여 이미지를 등록해주세요");
				return;
			} // end if
			
			FileInputStream fis = null;
			FileOutputStream fos = null;
			byte[] readData=new byte[512];
			int temp=0;
			
			//파일에서 읽어 들이는 스트림
			fis=new FileInputStream(readFile);
			//목적지에 파일을 생성하는 스트림
			fos=new FileOutputStream(writeFile);
			while ((temp=fis.read(readData))!=-1) {
				//파일에서 읽어들인 내용을 파일로 보낸다
				fos.write(readData, 0, temp);
			}//end while
			fos.flush();//분출 하지 않으면 파일이 제대로 생성되지 않는다
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
			JOptionPane.showMessageDialog(aiif, "이미지가 정상적으로 등록되었음");
			
			
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
				JOptionPane.showMessageDialog(aiif, "이미지가 정상적으로 등록되지 않음");
				e.printStackTrace();
			}
		}
		
		if(ae.getSource()==aiif.getBtnBack()) {
			try {
					imgSelect();
				aiif.getLbBackImg().setIcon(icon);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(aiif, "이미지가 정상적으로 등록되지 않음");
				e.printStackTrace();
			}
		}
		
		if(ae.getSource()==aiif.getBtnLeft()) {
			try {
				imgSelect();
				aiif.getLbLeftImg().setIcon(icon);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(aiif, "이미지가 정상적으로 등록되지 않음");
				e.printStackTrace();
			}
		}
		
		if(ae.getSource()==aiif.getBtnRight()) {
			try {
				imgSelect();
				aiif.getLbRightImg().setIcon(icon);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(aiif, "이미지가 정상적으로 등록되지 않음");
				e.printStackTrace();
			}
		}
		
		if(ae.getSource()==aiif.getBtnAdd()) {
			System.out.println("등록");
		}
		
		if(ae.getSource()==aiif.getBtnCancel()) {
			aiif.dispose();
		}
		
		
	}//actionPerformed

}
