package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.kidultAuction.dao.UserDAO_EJ;
import kr.co.kidultAuction.view.AddAuctionItemFrm;
import kr.co.kidultAuction.view.AddItemImageFrm;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.vo.AddAuctionItemVO;
import sun.management.snmp.util.SnmpNamedListTableCache;


/////////////////////// ���� ?? ////////////////////////// 
public class AddAuctionItemFrmEvt implements ActionListener{
	
		
	private AddAuctionItemFrm aaif;
	private AddItemImageFrmEvt aiife;
	
	JTextField tfItemName;
	JTextField tfStartPrice;
	JTextArea taItemInfo;
	JComboBox<String> jcbCategory;
	JComboBox<String> jcbStatus;
	JComboBox<String> jcbPeriod;
	int startPrice;
	int period;
	String category;
	String status;
	
	public AddAuctionItemFrmEvt(AddAuctionItemFrm aaif) {
		this.aaif=aaif;
		this.aiife=aiife;
	}//AddAuctionItemFrmEvt
	
	
	private boolean checkNull() {
		
		 tfItemName=aaif.getTfItemName();
		 tfStartPrice=aaif.getTfStartPrice();
		 taItemInfo=aaif.getTaItemInfo();
		 jcbCategory=aaif.getJcbCategory();
		 jcbStatus=aaif.getJcbStatus();
		 jcbPeriod=aaif.getJcbPeriod(); 
		 startPrice=0;
		boolean flag = false;
		
		
		
		if(jcbCategory.getSelectedItem()=="ī�װ� ����") {
			JOptionPane.showMessageDialog(null, "ī�װ��� ������ �ּ���");
			flag = true;
			return flag;
		}//end if
		if(tfItemName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "��ǰ���� �Է����ּ���");
			flag = true;
			return flag;
		}//end if
		
		if(tfStartPrice.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
		}else {
			try {
				startPrice=Integer.parseInt(tfStartPrice.getText().trim());
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "������ ���ڸ� �Է����ּ���");
				flag = true;
				return flag;
			}//end catch
		}//end else
		
		if(taItemInfo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "������ �Է��� �ּ���");
			flag = true;
			return flag;
		}//end if
		
		period=jcbPeriod.getSelectedIndex()+1;
		if(jcbCategory.getSelectedItem().toString().equals("����")){
			category="L";
		}else if(jcbCategory.getSelectedItem().toString().equals("�����")) {
			category="F";
		}else if(jcbCategory.getSelectedItem().toString().equals("�ǱԾ�")){
			category="P";
		}else {
			JOptionPane.showMessageDialog(null, "���� ������ �߿��� ������ �ּ���");
		}
		
		status=jcbStatus.getSelectedItem().toString();
		
		System.out.println("��ϿϷ�");
		return flag;
	}//checkNull
	
	
	
	
	
	private Socket client;
	static String sendFileName;
	String front_sendFileName;
	String back_sendFileName;
	String left_sendFileName;
	String right_sendFileName;
	
	
	public void uploadFile() throws IOException {
		
		for(int i=0; i<4; i++) {
		
			int dataSize=0;
			byte[] data=new byte[512];
			File file = null;
			if(i==0) {
				 file=new File(aiife.frontIcon.toString());
			}else if(i==1) {
				 file=new File(aiife.backIcon.toString());
			}else if(i==2) {
				 file=new File(aiife.leftIcon.toString());
			}else if(i==3) {
				 file=new File(aiife.rightIcon.toString());
			}//end if
			FileInputStream fis=new FileInputStream(file);
			
			int binaryLen=0;
			while((binaryLen=fis.read(data))>0) {
				dataSize++;
			}//end while
			
			fis.close();
			client=new Socket("211.63.89.135", 5500);
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			
			StringBuilder newFileName=null;
			SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd_HH_m_s");
			String date= sdf.format(new Date());
			
			if(i==0) {
				newFileName=new StringBuilder(AddItemImageFrmEvt.frontFileName);
			}else if(i==1) {
				newFileName=new StringBuilder(AddItemImageFrmEvt.backFileName);
			}else if(i==2) {
				 newFileName=new StringBuilder(AddItemImageFrmEvt.leftFileName);
			}else if(i==3) {
				newFileName=new StringBuilder(AddItemImageFrmEvt.rightFileName);
			}//end if
			
			sendFileName=AuctionMainFrm.User_id+"_"+newFileName.insert(newFileName.indexOf("."), "_"+date);
			
			
//			dos.writeUTF(sendFileName);  /////////////////���� �̸� �ٲܼ� �մµ�////////////////////
			if(i==0) {
				front_sendFileName=sendFileName;
				 dos.writeUTF(front_sendFileName);  /////////////////���� �̸� �ٲܼ� �մµ�////////////////////
			}else if(i==1) {
				back_sendFileName=sendFileName;
				 dos.writeUTF(back_sendFileName);  
			}else if(i==2) {
				left_sendFileName=sendFileName;
				 dos.writeUTF(left_sendFileName);  
			}else if(i==3) {
				right_sendFileName=sendFileName;
				 dos.writeUTF(right_sendFileName);  
			}//end if
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
			

		
		}//end for
		
		//���� ����� �ԷµǾ��ٸ� �߻��� ���� ���� ó���ϱ� ���� VO�߰�
		AddAuctionItemVO aaiv=new AddAuctionItemVO(front_sendFileName,
				back_sendFileName,left_sendFileName,
				right_sendFileName,category,tfItemName.getText().trim(),
				status,taItemInfo.getText().trim().toString(), startPrice, period,AuctionMainFrm.User_id);
		
		UserDAO_EJ ej_dao=UserDAO_EJ.getInstance();
		try {
			//�޴��߰� �� 
			ej_dao.insertAddItem(aaiv);
		} catch (SQLException e) {
			System.out.println("����");
			e.printStackTrace();
		}//end catch
		
		if(sendFileName.equals("")) {
			JOptionPane.showMessageDialog(null, "�̹����� �־��ּ���");
		}
		
	}//uploadFile
	
	
	
	
//	public void deleteFile() {
//		 File file = new File(aiife.path+"s_"+aiife.fileName);
//         
//	        if( file.exists() ){
//	            if(file.delete()){
//	                System.out.println("���ϻ��� ����");
//	            }else{
//	                System.out.println("���ϻ��� ����");
//	            }
//	        }else{
//	            System.out.println("������ �������� �ʽ��ϴ�.");
//	        }
//	             
//
//	}//deleteFile
	
	
	
		
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==aaif.getBtnAddImg()) {
			new AddItemImageFrm(aaif);
			
		}
		if(ae.getSource()==aaif.getBtnPermit()) {
			try {
				if(!checkNull()) {
					uploadFile();
					aaif.dispose();
				}//end if
			} catch (IOException e) {
				System.out.println("�ö������");
				e.printStackTrace();
			}
			
		}
		if(ae.getSource()==aaif.getBtnCancel()) {
			aaif.dispose(); 
		}
	}
	
	
	

}//class
