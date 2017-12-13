package kr.co.kidultAuction.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * �����
 * @author user
 */
@SuppressWarnings("serial")
public class MyAuctionFrm extends JDialog  {
	
	private JTabbedPane jtpTab;
	private DefaultTableModel dtmAucItem, SendItem, RecieveItem;
    private JTable jtAucItem,	 jtSendItem, jtRecieveItem;
	public MyAuctionFrm(AuctionMainFrm amf) {
		super(amf,"�� ���");
		setLayout(null);
		
		String[] arrAucItem= {"�̹���","��ǰ��","ī�װ�","��Ž��۰���","��űⰣ","�����","���ο���"};
//		String[][] arrAucItemData=new String[10][7];
		String[][] arrAucItemData= {{"","","","","","",""}};
		String[] arrSendItem= {"�̹���","��ǰ��","��� ���۰���","��������","�����","������","������ ī��ID","�߼ۿ���"};
//		String[][] arrSendItemData=new String[10][8];
		String[][] arrSendItemData= {{"","","","","","","",""}};
		String[] arrRecieveItem= {"�̹���","��ǰ��","��� ���۰���","��������","�����","������","����� ī��ID","�߼ۿ���"};
//		String[][] arrRecieveItemData=new String[10][8];
		String[][] arrRecieveItemData= {{"","","","","","","",""}};
		
		dtmAucItem=new DefaultTableModel(arrAucItemData, arrAucItem);
		SendItem=new DefaultTableModel(arrSendItemData, arrSendItem);
		RecieveItem=new DefaultTableModel(arrRecieveItemData, arrRecieveItem);
		
		jtAucItem=new JTable(dtmAucItem) {
			
			//�÷��� ���� ���� ����
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
			
			//�÷��� ���������� �Էµ� ������������ ���������� ����
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0,column).getClass();
			}//getColumnClass
		};
		
		jtSendItem=new JTable(SendItem) {
			
			//�÷��� ���� ���� ����
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
			
			//�÷��� ���������� �Էµ� ������������ ���������� ����
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0,column).getClass();
			}//getColumnClass
		};
		
		jtRecieveItem=new JTable(RecieveItem) {
			
			//�÷��� ���� ���� ����
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
			
			//�÷��� ���������� �Էµ� ������������ ���������� ����
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0,column).getClass();
			}//getColumnClass
		};
		
		//column �� ���� ����
		jtAucItem.getColumnModel().getColumn(0).setPreferredWidth(120);//�̹���
		jtAucItem.getColumnModel().getColumn(1).setPreferredWidth(100);//��ǰ��
		jtAucItem.getColumnModel().getColumn(2).setPreferredWidth(60);//ī�װ�
		jtAucItem.getColumnModel().getColumn(3).setPreferredWidth(60);//��Ž��۰���
		jtAucItem.getColumnModel().getColumn(4).setPreferredWidth(60);//��űⰣ
		jtAucItem.getColumnModel().getColumn(5).setPreferredWidth(60);//�����
		jtAucItem.getColumnModel().getColumn(6).setPreferredWidth(60);//���ο���
		//column�� ���� ����
		jtAucItem.setRowHeight(50);
		//�÷� �̵�����
		jtAucItem.getTableHeader().setReorderingAllowed(false);
		
		//column �� ���� ����
		jtSendItem.getColumnModel().getColumn(0).setPreferredWidth(120);//�̹���
		jtSendItem.getColumnModel().getColumn(1).setPreferredWidth(100);//��ǰ��
		jtSendItem.getColumnModel().getColumn(2).setPreferredWidth(40);//��� ���۰���
		jtSendItem.getColumnModel().getColumn(3).setPreferredWidth(40);//��������
		jtSendItem.getColumnModel().getColumn(4).setPreferredWidth(40);//�����
		jtSendItem.getColumnModel().getColumn(5).setPreferredWidth(40);//������
		jtSendItem.getColumnModel().getColumn(6).setPreferredWidth(40);//������ ī��
		jtSendItem.getColumnModel().getColumn(7).setPreferredWidth(40);//�߼ۿ���
		//column�� ���� ����
		jtSendItem.setRowHeight(50);
		//�÷� �̵�����
		jtSendItem.getTableHeader().setReorderingAllowed(false);
		
		//column �� ���� ����
		jtRecieveItem.getColumnModel().getColumn(0).setPreferredWidth(120);//�̹���
		jtRecieveItem.getColumnModel().getColumn(1).setPreferredWidth(100);//��ǰ��
		jtRecieveItem.getColumnModel().getColumn(2).setPreferredWidth(40);//��� ���۰���
		jtRecieveItem.getColumnModel().getColumn(3).setPreferredWidth(40);//��������
		jtRecieveItem.getColumnModel().getColumn(4).setPreferredWidth(40);//�����
		jtRecieveItem.getColumnModel().getColumn(5).setPreferredWidth(40);//������
		jtRecieveItem.getColumnModel().getColumn(6).setPreferredWidth(40);//����� ī��
		jtRecieveItem.getColumnModel().getColumn(7).setPreferredWidth(40);//�߼ۿ���
		//column�� ���� ����
		jtRecieveItem.setRowHeight(50);
		//�÷� �̵�����
		jtRecieveItem.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jspAuc=new JScrollPane(jtAucItem);
		JScrollPane jspSend=new JScrollPane(jtSendItem);
		JScrollPane jspRecieve=new JScrollPane(jtRecieveItem);
		
		jtpTab=new JTabbedPane();
		jtpTab.add("����� ���", jspAuc);
		jtpTab.addTab("��������", jspSend);
		jtpTab.addTab("��������", jspRecieve);
		
		jtpTab.setBounds(0,
				0,800,500);
		
		add(jtpTab);
		
		setBounds(100,100,800,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}//MyAuctionFrm


}//class
