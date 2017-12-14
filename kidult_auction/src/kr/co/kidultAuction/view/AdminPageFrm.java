package kr.co.kidultAuction.view;

import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.kidultAuction.controller.AdminPageFrmEvt;


/**
 * ������ ������
 * @author user
 */
@SuppressWarnings("serial")
public class AdminPageFrm extends JDialog{
	private AuctionMainFrm amf;

	private JTabbedPane jtpTab;
	private DefaultTableModel userList,watingList,completeList,bidList,sucBidList;
	private JTable jtuserList, jtwatingList, jtcompleteList, jtbidList, jtsucBidList;
	 
	public AdminPageFrm(AuctionMainFrm amf) throws SQLException {
		super(amf,"������ ������");
		/*this.amf=amf;*/
		
		String[] arrUserList= {"��ȣ","ȸ��ID","�̸�","����ó","ī��ID","�������","�̸���","�ּ�","������"};
		String[][] arrUserListData= {{"","","","","","","","",""}};
		String[] arrWatingList= {"��ȣ","�Ǹ���ID","����ڵ�","ī�װ�","����","���Ǹ�","���۰���","��űⰣ"};
		String[][] arrWatingListData= {{"","","","","","","",""}};
		String[] arrCompleteList= {"��ȣ","�Ǹ���ID","����ڵ�","ī�װ�","����","���Ǹ�","���۰���","��űⰣ"};
		String[][] arrCompleteListData= {{"","","","","","","",""}};
		String[] arrBidList= {"��ȣ","�����ID","���Ǹ�","����ڵ�","���� ������","���۰���","������","������"};
		String[][] arrBidListData= {{"","","","","","","",""}};
		String[] arrSucBidList= {"��ȣ","�����ID","���Ǹ�","����ڵ�","������","���۰���","������","������"};
		String[][] arrSucBidListData= {{"","","","","","","",""}};
		
		userList=new DefaultTableModel(arrUserListData, arrUserList);
		watingList=new DefaultTableModel(arrWatingListData, arrWatingList);
		completeList=new DefaultTableModel(arrCompleteListData, arrCompleteList);
		bidList=new DefaultTableModel(arrBidListData, arrBidList);
		sucBidList=new DefaultTableModel(arrSucBidListData, arrSucBidList);
		
		jtuserList=new JTable(userList) {
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
		
		jtwatingList=new JTable(watingList) {
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
		
		jtcompleteList=new JTable(completeList) {
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
		
		jtbidList=new JTable(bidList) {
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
		
		jtsucBidList=new JTable(sucBidList) {
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
		jtuserList.getColumnModel().getColumn(0).setPreferredWidth(20);//��ȣ
		jtuserList.getColumnModel().getColumn(1).setPreferredWidth(60);//ȸ��ID
		jtuserList.getColumnModel().getColumn(2).setPreferredWidth(40);//�̸�
		jtuserList.getColumnModel().getColumn(3).setPreferredWidth(60);//����ó
		jtuserList.getColumnModel().getColumn(4).setPreferredWidth(60);//ī��ID
		jtuserList.getColumnModel().getColumn(5).setPreferredWidth(40);//�������
		jtuserList.getColumnModel().getColumn(6).setPreferredWidth(70);//�̸���
		jtuserList.getColumnModel().getColumn(7).setPreferredWidth(100);//�ּ�
		jtuserList.getColumnModel().getColumn(8).setPreferredWidth(40);//������
		//column�� ���� ����
		jtuserList.setRowHeight(50);
		//�÷� �̵�����
		jtuserList.getTableHeader().setReorderingAllowed(false);
		
		//column �� ���� ����
		jtwatingList.getColumnModel().getColumn(0).setPreferredWidth(20);//��ȣ
		jtwatingList.getColumnModel().getColumn(1).setPreferredWidth(60);//�Ǹ���ID
		jtwatingList.getColumnModel().getColumn(2).setPreferredWidth(90);//�̹���
		jtwatingList.getColumnModel().getColumn(3).setPreferredWidth(60);//ī�װ�
		jtwatingList.getColumnModel().getColumn(4).setPreferredWidth(40);//����
		jtwatingList.getColumnModel().getColumn(5).setPreferredWidth(80);//���Ǹ�
		jtwatingList.getColumnModel().getColumn(6).setPreferredWidth(40);//���۰���
		jtwatingList.getColumnModel().getColumn(7).setPreferredWidth(40);//��űⰣ
		//column�� ���� ����
		jtwatingList.setRowHeight(50);
		//�÷� �̵�����
		jtwatingList.getTableHeader().setReorderingAllowed(false);
		
		//column �� ���� ����
		jtcompleteList.getColumnModel().getColumn(0).setPreferredWidth(20);//��ȣ
		jtcompleteList.getColumnModel().getColumn(1).setPreferredWidth(60);//�Ǹ���ID
		jtcompleteList.getColumnModel().getColumn(2).setPreferredWidth(90);//�̹���
		jtcompleteList.getColumnModel().getColumn(3).setPreferredWidth(60);//ī�װ�
		jtcompleteList.getColumnModel().getColumn(4).setPreferredWidth(40);//����
		jtcompleteList.getColumnModel().getColumn(5).setPreferredWidth(80);//���Ǹ�
		jtcompleteList.getColumnModel().getColumn(6).setPreferredWidth(40);//���۰���
		jtcompleteList.getColumnModel().getColumn(7).setPreferredWidth(40);//��űⰣ
		//column�� ���� ����
		jtcompleteList.setRowHeight(50);
		//�÷� �̵�����
		jtcompleteList.getTableHeader().setReorderingAllowed(false);
		
		//column �� ���� ����
		jtbidList.getColumnModel().getColumn(0).setPreferredWidth(20);//��ȣ
		jtbidList.getColumnModel().getColumn(1).setPreferredWidth(60);//�����ID
		jtbidList.getColumnModel().getColumn(2).setPreferredWidth(80);//���Ǹ�
		jtbidList.getColumnModel().getColumn(3).setPreferredWidth(60);//����ڵ�
		jtbidList.getColumnModel().getColumn(4).setPreferredWidth(40);//���� ������
		jtbidList.getColumnModel().getColumn(5).setPreferredWidth(40);//���۰���
		jtbidList.getColumnModel().getColumn(6).setPreferredWidth(40);//������
		jtbidList.getColumnModel().getColumn(7).setPreferredWidth(40);//������
		//column�� ���� ����
		jtbidList.setRowHeight(50);
		//�÷� �̵�����
		jtbidList.getTableHeader().setReorderingAllowed(false);
		
		//column �� ���� ����
		jtsucBidList.getColumnModel().getColumn(0).setPreferredWidth(20);//��ȣ
		jtsucBidList.getColumnModel().getColumn(1).setPreferredWidth(60);//�����ID
		jtsucBidList.getColumnModel().getColumn(2).setPreferredWidth(80);//���Ǹ�
		jtsucBidList.getColumnModel().getColumn(3).setPreferredWidth(60);//����ڵ�
		jtsucBidList.getColumnModel().getColumn(4).setPreferredWidth(40);//������
		jtsucBidList.getColumnModel().getColumn(5).setPreferredWidth(40);//���۰���
		jtsucBidList.getColumnModel().getColumn(6).setPreferredWidth(40);//������
		jtsucBidList.getColumnModel().getColumn(7).setPreferredWidth(40);//������
		//column�� ���� ����
		jtsucBidList.setRowHeight(50);
		//�÷� �̵�����
		jtsucBidList.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jspUser=new JScrollPane(jtuserList);
		JScrollPane jspWating=new JScrollPane(jtwatingList);
		JScrollPane jspComplete=new JScrollPane(jtcompleteList);
		JScrollPane jspBid=new JScrollPane(jtbidList);
		JScrollPane jspSucBid=new JScrollPane(jtsucBidList);
		
		jtpTab=new JTabbedPane();
		jtpTab.add("ȸ�����", jspUser);
		jtpTab.addTab("���δ����", jspWating);
		jtpTab.addTab("���οϷ���", jspComplete);
		jtpTab.addTab("�������", jspBid);
		jtpTab.addTab("�������", jspSucBid);
		
		jtpTab.setBounds(0,0,800,500);
		
        add(jtpTab);
        
    	//�̺�Ʈ ���
//		AdminPageEvt ape=new AdminPageEvt(this);
//		jtuserList.addMouseListener(ape);//JTable �̺�Ʈ
//		jtwatingList.addMouseListener(ape);//JTable �̺�Ʈ
//		jtcompleteList.addMouseListener(ape);//JTap�� �̺�Ʈ
//		jtbidList.addMouseListener(ape);//JTap�� �̺�Ʈ
//		jtsucBidList.addMouseListener(ape);//JTap�� �̺�Ʈ
//		jtpTab.addMouseListener(ape);//JTap�� �̺�Ʈ
		
		setBounds(100,100,810,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		AdminPageFrmEvt apfe=new AdminPageFrmEvt(this);
		jtpTab.addMouseListener(apfe);
		jtwatingList.addMouseListener(apfe);
		
	}//AdminPageFrm

	public AuctionMainFrm getAmf() {
		return amf;
	}

	public JTabbedPane getJtpTab() {
		return jtpTab;
	}

	public DefaultTableModel getUserList() {
		return userList;
	}

	public DefaultTableModel getWatingList() {
		return watingList;
	}

	public DefaultTableModel getCompleteList() {
		return completeList;
	}

	public DefaultTableModel getBidList() {
		return bidList;
	}

	public DefaultTableModel getSucBidList() {
		return sucBidList;
	}

	public JTable getJtuserList() {
		return jtuserList;
	}

	public JTable getJtwatingList() {
		return jtwatingList;
	}

	public JTable getJtcompleteList() {
		return jtcompleteList;
	}

	public JTable getJtbidList() {
		return jtbidList;
	}

	public JTable getJtsucBidList() {
		return jtsucBidList;
	}
	

}//class
