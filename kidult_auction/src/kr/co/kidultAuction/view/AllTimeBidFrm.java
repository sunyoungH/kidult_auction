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
		
		String[] arrAllBid= {"경매코드","입찰자ID","입찰가","입찰시간"};
		String[][] arrAllBidData= {{"","","",""}};
		
		dtmAllBid=new DefaultTableModel(arrAllBidData, arrAllBid);
		
		jtAllBid=new JTable(dtmAllBid) {
			//컬럼의 내용 편집 막기
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
			
			//컬럼의 데이터형이 입력된 데이터형으로 보여지도록 설정
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0,column).getClass();
			}//getColumnClass
		};
		
		//column 의 넓이 변경
				jtAllBid.getColumnModel().getColumn(0).setPreferredWidth(120);//경매코드
				jtAllBid.getColumnModel().getColumn(1).setPreferredWidth(100);//입찰자ID
				jtAllBid.getColumnModel().getColumn(2).setPreferredWidth(60);//입찰가
				jtAllBid.getColumnModel().getColumn(3).setPreferredWidth(60);//입찰시간
				//column의 높이 변경
				jtAllBid.setRowHeight(50);
				//컬럼 이동막기
				jtAllBid.getTableHeader().setReorderingAllowed(false);
				
				JScrollPane jspAllBid=new JScrollPane(jtAllBid);
				
				jtpTab=new JTabbedPane();
				jtpTab.add("등록한 경매", jspAllBid);
				
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
