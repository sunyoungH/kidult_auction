package kr.co.kidultAuction.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.kidultAuction.dao.AdminDAO;
import kr.co.kidultAuction.vo.AdminItemPriceVO;
import kr.co.kidultAuction.vo.AdminSucBidVO;

@SuppressWarnings("serial")
public class AllTimeBidFrm extends JDialog{
	
	private JTabbedPane jtpTab;
	private JTable jtAllBid;
	private DefaultTableModel dtmAllBid;
	private AdminPageFrm apf;
	
	
	public AllTimeBidFrm(AdminPageFrm apf) throws SQLException {
		super(apf,"�ǽð� ���� ����",true);
		this.apf=apf;
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
				
				viewAllTimeBidding();
	}//AllTimeBidFrm
	
	public void viewAllTimeBidding() throws SQLException {
		AdminDAO a_dao=AdminDAO.getInstance();
		List<AdminItemPriceVO> allTimelist=a_dao.selectATBidList();
			
		Object[] rowData=null;
		AdminItemPriceVO aipv=null;
		
		for(int i=0; i<allTimelist.size(); i++) {
			aipv=allTimelist.get(i);
			rowData=new Object[4];
			rowData[0]="��ư������ ����ڵ�޾ƿ���";
			rowData[1]=aipv.getUser_id();
			rowData[2]=aipv.getBid_price();
			rowData[3]=aipv.getBid_date();
			
			dtmAllBid.addRow(rowData);
		}//end for

		
	}//viewBidding
	

	public JTabbedPane getJtpTab() {
		return jtpTab;
	}

	public void setJtpTab(JTabbedPane jtpTab) {
		this.jtpTab = jtpTab;
	}

	public JTable getJtAllBid() {
		return jtAllBid;
	}

	public void setJtAllBid(JTable jtAllBid) {
		this.jtAllBid = jtAllBid;
	}

}//class
