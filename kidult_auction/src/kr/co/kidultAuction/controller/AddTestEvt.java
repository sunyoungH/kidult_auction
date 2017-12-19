package kr.co.kidultAuction.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	 	사용자가 등록한 이미지이름을 대체하여, 이미지이름 앞 부분에 front_  left_  right_ back_ 을 추가 
		front_userid_20171219_145401 의 형식으로 기록
		즉, 최대길이가 userid최대길이에 한정됨. front_(6자) _20171219(8자) _145401(7자) => 21자 + userid최대 바이트수 (DB는 이에 알맞게 수정)
	 * */
	private void imgSelect()  {
		FileDialog fdImg = new FileDialog(aiif, "사진 선택하기 ", FileDialog.LOAD);
		fdImg.setVisible(true);

		String path = fdImg.getDirectory();
		String fileName = fdImg.getFile();

		if (fileName != null) {// 선택한 파일이 있음
			String[] arrFile = fileName.split("[.]");
			String ext = arrFile[arrFile.length - 1];
			/////////////////////////////////////////////////// PNG ,JPG, GIF 도 포함해주세요 /////////////////////////////////////////
			if (!"jpg,gif,png,PNG,JPG,GIF".contains(ext)) {
				JOptionPane.showMessageDialog(aiif, "jpg,gif,png파일만 가능합니다.");
				return;
		}// end if
			
		try {
			int dataSize=0;
			byte[] data=new byte[512];
			File file=new File(path+"/"+fileName);
			FileInputStream fis;
			fis = new FileInputStream(file);
			int binaryLen=0;
			while((binaryLen=fis.read(data))>0) {
				dataSize++;
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
				System.out.println(fileName+" => 전송완료");
				fis.close();
				client.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("서버 전송 과정중 파일 존재하지 않음 에러(fileinputStream)");
		}catch (IOException e) {
			e.printStackTrace();
			System.err.println("서버 전송 과정중 io excetpion");
		}//end while
		}//end if
	}//imgSelect
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==aiif.getBtnFront()) {
				new KidultServer();
				imgSelect();
				System.out.println( icon);
				aiif.getLbFrontImg().setIcon(icon);
		}
		
		if(ae.getSource()==aiif.getBtnBack()) {
					imgSelect();
				aiif.getLbBackImg().setIcon(icon);
		}
		
		if(ae.getSource()==aiif.getBtnLeft()) {
				imgSelect();
				aiif.getLbLeftImg().setIcon(icon);
		}
		
		if(ae.getSource()==aiif.getBtnRight()) {
				imgSelect();
		}
		
		if(ae.getSource()==aiif.getBtnAdd()) {
			System.out.println("등록");
		}
		
		if(ae.getSource()==aiif.getBtnCancel()) {
			aiif.dispose();
		}
		
		
	}//actionPerformed

}
