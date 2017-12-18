package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TestServer extends JFrame implements Runnable, ActionListener{
private JLabel jlbl;
private JButton btn;
private ServerSocket ssFile;
private Thread threadFile;
private File file;
private ImageIcon img;

public TestServer() {
	img=new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/addImg.png");
	JPanel jp=new JPanel();
	btn=new JButton("��������");
	jlbl=new JLabel(img);
	jp.add(btn);
	jp.add(jlbl);
	add(jp);
	
	btn.addActionListener(this);
	
	setBounds(400, 400, 400, 400);
	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
}
@Override
public void actionPerformed(ActionEvent e) {
	if(threadFile!=null) {
		JOptionPane.showMessageDialog(this, "������ �̹� �������Դϴ�");
		return;
	}//end if

	threadFile=new Thread(this);		//���� ��ü�� has a����� Thread�� �����Ѵ�.
	threadFile.start();	//run����
}//actionPerformed


public void run() {		//������ �д� �޼ҵ带 ����ȭ ó��... ������ �о���̴� ��
	try {
		ssFile=new ServerSocket(5050);	//������ �ǰ� �Ŀ� �������Դϴٶ�� �޼����� �ѷ��ִ� ���� �� ����
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd a HH:mm:ss");
		
		Socket someClient=null;
		DataInputStream dis=null;
		FileOutputStream fos=null;
		String fileName=null;
		int dataSize=0;	//���۵Ǵ� ������ ũ��
		int binaryLen=0; 	//�ѹ��� ���۵Ǵ� binary�� ũ��
		byte[] data=new byte[512];	//�о���� ������ binary������ �����ϴ� �迭.. 512�� 1024... ���
		String uploader="";
		File file=null;
		StringBuilder sbRename=null;
		
		while(true) {	//���� ����ڿ��� ������ �ް� �����ϱ�.. �� ���α׷��� ����Ǵ� ���ȱ����� ��� ������ �޴� �ܰ���
			someClient=ssFile.accept();		//�����ڰ� �������� ������ �Ǵ� block method��
			//���ϸ�, ����ũ��, binary data������ ���޵ǹǷ� �ش� ������ ó��
			dis=new DataInputStream(someClient.getInputStream());
			uploader=dis.readUTF();	//wirteUTF�� ���� ������ : ���δ���
			fileName=dis.readUTF();	//wirteUTF�� ���� ������ : ���ϸ�
			dataSize=dis.readInt();		//writeInt�� ���� ������ : ������ũ��
			
			//file�� binary data�� �޴´�.
			file=new File("d:/savefile/"+"123.png");
			fos=new FileOutputStream(file);
			while(dataSize>0) {	// 0�̸� binarydata�� ���ٴ� ����... ������ ������ ũ�����
				binaryLen=dis.read(data);  // ��Ʈ������ �о�鿩
				fos.write(data, 0, binaryLen);  //���Ͻ�Ʈ���� ���� -�ϳ��� data�� 0�������� �о���� binaryLenũ����� 
				dataSize--;
			}//end while
			fos.flush(); //��Ʈ���� ������ ����
			//���ε�� ���� ������ ���ϸ���� �����ִ� ����Ʈ �߰�
			fos.close(); //���� ����� ���� �� ���� ��Ʈ���� ���´�.
			someClient.close();  //������ ������ ���´�.
		}//end while
	} catch (IOException e) {
		e.printStackTrace();
	}//end catch
}//run
	public static void main(String args[]) {
		new TestServer(); 
	}//main

}
