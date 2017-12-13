package kr.co.kidultAuction.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class AllTimeBidFrm extends JFrame{
	
	private JTabbedPane jtpTab;
	private JTable jtAllBid;
	private DefaultTableModel dtmAllBid;
	
	
	public AllTimeBidFrm() {
		setLayout(null);
		
		String[] arrAllBid= {"����ڵ�","������ID","������","�����ð�"};
		String[][] arrAllBidData= {{"","","",""}};
		
		dtmAllBid=new DefaultTableModel(arrAllBidData, arrAllBid);
		
		jtAllBid=new JTable(dtmAllBid) {
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
				jtAllBid.getColumnModel().getColumn(0).setPreferredWidth(120);//����ڵ�
				jtAllBid.getColumnModel().getColumn(1).setPreferredWidth(100);//������ID
				jtAllBid.getColumnModel().getColumn(2).setPreferredWidth(60);//������
				jtAllBid.getColumnModel().getColumn(3).setPreferredWidth(60);//�����ð�
				//column�� ���� ����
				jtAllBid.setRowHeight(50);
				//�÷� �̵�����
				jtAllBid.getTableHeader().setReorderingAllowed(false);
				
				JScrollPane jspAllBid=new JScrollPane(jtAllBid);
				
				jtpTab=new JTabbedPane();
				jtpTab.add("����� ���", jspAllBid);
				
				jtpTab.setBounds(0,0,800,500);
				
				add(jtpTab);
				
				setBounds(100,100,810,500);
				setVisible(true);
				setResizable(false);
				
		
	}//AllTimeBidFrm

	public static void main(String[] args) {
		new AllTimeBidFrm();
	}//main

}//class
