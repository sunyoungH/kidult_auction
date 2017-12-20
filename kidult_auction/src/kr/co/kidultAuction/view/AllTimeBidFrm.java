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
		super(apf,"실시간 입찰 정보",true);
		this.apf=apf;
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
				jtAllBid.getColumnModel().getColumn(0).setPreferredWidth(100);//경매코드
				jtAllBid.getColumnModel().getColumn(1).setPreferredWidth(100);//입찰자ID
				jtAllBid.getColumnModel().getColumn(2).setPreferredWidth(100);//입찰가
				jtAllBid.getColumnModel().getColumn(3).setPreferredWidth(100);//입찰시간
				//column의 높이 변경
				jtAllBid.setRowHeight(50);
				//컬럼 이동막기
				jtAllBid.getTableHeader().setReorderingAllowed(false);
	
				viewAllTimeBidding();
				
				JScrollPane jspAllBid=new JScrollPane(jtAllBid);
				
				jspAllBid.setBounds(0,0,400,500);
				
				add(jspAllBid);
				
				setBounds(0, 0, 400, 500);
				setVisible(true);
				setResizable(false);
				
	}//AllTimeBidFrm
	
	public void viewAllTimeBidding() throws SQLException {
		AdminDAO a_dao=AdminDAO.getInstance();
		List<AdminItemPriceVO> allTimelist=a_dao.selectATBidList();
		
		dtmAllBid.setRowCount(0);
		Object[] rowData=null;
		AdminItemPriceVO aipv=null;
		
		for(int i=0; i<allTimelist.size(); i++) {
			aipv=allTimelist.get(i);
			rowData=new Object[4];
			rowData[0]=AdminPageFrm.auc_code;
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
