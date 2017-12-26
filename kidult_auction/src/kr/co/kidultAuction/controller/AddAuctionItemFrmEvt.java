package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.kidultAuction.view.AddAuctionItemFrm;
import kr.co.kidultAuction.view.AddItemImageFrm;


/////////////////////// 성공 ?? ////////////////////////// 
public class AddAuctionItemFrmEvt implements ActionListener{
	
		
	private AddAuctionItemFrm aaif;
	private AddItemImageFrmEvt aiife;
	public AddAuctionItemFrmEvt(AddAuctionItemFrm aaif) {
		this.aaif=aaif;
		this.aiife=aiife;
	}//AddAuctionItemFrmEvt
	
	private void itemAdd() {
		
		JTextField tfItemName=aaif.getTfItemName();
		JTextField tfStartPrice=aaif.getTfStartPrice();
		JTextArea taItemInfo=aaif.getTaItemInfo();
		JComboBox<String> jcbCategory=aaif.getJcbCategory();
		JComboBox<String> jcbStatus=aaif.getJcbStatus();
		JComboBox<String> jcbPeriod=aaif.getJcbPeriod(); 
		int startPrice=0;
		
		
		if(jcbCategory.getSelectedItem()=="카테고리 선택") {
			JOptionPane.showMessageDialog(null, "카테고리를 선택해 주세요");
			return;
		}//end if
		if(tfItemName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "물품명을 입력해주세요");
			return;
		}//end if
		
		if(tfStartPrice.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "가격을 입력해주세요");
		}else {
			try {
				startPrice=Integer.parseInt(tfStartPrice.getText().trim());
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "가격은 숫자만 입력해주세요");
				return;
			}//end catch
		}//end else
		
		if(taItemInfo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "설명을 입력해 주세요");
			return;
		}//end if
		
//		AddAuctionItemVO aaivo=new AddAuctionItemVO(tfItemName.getText().trim(),
//				startPrice,taItemInfo.getText().trim(),jcbCategory.getSelectedItem(),
//				jcbPeriod.getSelectedItem(),jcbStatus.getSelectedItem());
		System.out.println("등록완료");
	}//itemAdd
	
	private Socket client;
	
	public void test() throws IOException {
		int dataSize=0;
		byte[] data=new byte[512];
		File file=new File(aiife.icon.toString());
		FileInputStream fis=new FileInputStream(file);
		int binaryLen=0;
		
		while((binaryLen=fis.read(data))>0) {
			dataSize++;
		}//end while
		
		fis.close();
		client=new Socket("211.63.89.135", 5500);
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF(aiife.fileName);
		dos.writeInt(dataSize);
		fis=new FileInputStream(file);
		
		while(dataSize>0) {
			binaryLen=fis.read(data);
			dos.write(data, 0, binaryLen);
			dataSize--;
		}//end while
		
		dos.flush();
		System.out.println(aiife.icon+" => 전송완료");
		fis.close();
		client.close();
	}//test
	
	
	
	
		
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==aaif.getBtnAddImg()) {
			new AddItemImageFrm(aaif);
			
		}
		if(ae.getSource()==aaif.getBtnPermit()) {
			try {
//				new KidultServer();
				test();
			} catch (IOException e) {
				System.out.println("시라라라라라라");
				e.printStackTrace();
			}
			System.out.println(aiife.frontIcon);//->값 나옴
			System.out.println(aiife.backIcon);//->값 나옴
			System.out.println(aiife.leftIcon);//->값 나옴
			System.out.println(aiife.rightIcon);//->값 나옴
//			itemAdd();
			
		}
		if(ae.getSource()==aaif.getBtnCancel()) {
			aaif.dispose(); 
		}
	}
	
	

}//class
