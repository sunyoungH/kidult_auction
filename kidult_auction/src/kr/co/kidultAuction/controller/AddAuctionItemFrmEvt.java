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


/////////////////////// ���� ?? ////////////////////////// 
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
		
		
		if(jcbCategory.getSelectedItem()=="ī�װ� ����") {
			JOptionPane.showMessageDialog(null, "ī�װ��� ������ �ּ���");
			return;
		}//end if
		if(tfItemName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "��ǰ���� �Է����ּ���");
			return;
		}//end if
		
		if(tfStartPrice.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
		}else {
			try {
				startPrice=Integer.parseInt(tfStartPrice.getText().trim());
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "������ ���ڸ� �Է����ּ���");
				return;
			}//end catch
		}//end else
		
		if(taItemInfo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "������ �Է��� �ּ���");
			return;
		}//end if
		
//		AddAuctionItemVO aaivo=new AddAuctionItemVO(tfItemName.getText().trim(),
//				startPrice,taItemInfo.getText().trim(),jcbCategory.getSelectedItem(),
//				jcbPeriod.getSelectedItem(),jcbStatus.getSelectedItem());
		System.out.println("��ϿϷ�");
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
		System.out.println(aiife.icon+" => ���ۿϷ�");
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
				System.out.println("�ö������");
				e.printStackTrace();
			}
			System.out.println(aiife.frontIcon);//->�� ����
			System.out.println(aiife.backIcon);//->�� ����
			System.out.println(aiife.leftIcon);//->�� ����
			System.out.println(aiife.rightIcon);//->�� ����
//			itemAdd();
			
		}
		if(ae.getSource()==aaif.getBtnCancel()) {
			aaif.dispose(); 
		}
	}
	
	

}//class
