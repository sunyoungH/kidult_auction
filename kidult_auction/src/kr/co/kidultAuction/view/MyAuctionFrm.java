package kr.co.kidultAuction.view;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.co.kidultAuction.controller.MyAuctionFrmEvt;

/**
 * �����
 * 
 * @author user
 */
@SuppressWarnings("serial")
public class MyAuctionFrm extends JDialog {

	private JTabbedPane jtpTab;
	private DefaultTableModel dtmAucItem, SendItem, RecieveItem;
	private JTable jtAucItem, jtSendItem, jtRecieveItem;

	public MyAuctionFrm(AuctionMainFrm amf) throws SQLException {
		super(amf, "�� ���");
		setLayout(null);

		String[] arrAucItem = { "��ȣ", "��ǰ��", "ī�װ�", "��Ž��۰���", "��űⰣ", "�����", "���ο���" };
		String[][] arrAucItemData = { { "", "", "", "", "", "", "" } };
		String[] arrSendItem = { "��ȣ", "��ǰ��", "��� ���۰���", "��������", "�����", "������", "������ ī��ID", "�߼ۿ���" };
		String[][] arrSendItemData = { { "", "", "", "", "", "", "", "" } };
		String[] arrRecieveItem = { "��ȣ", "��ǰ��", "��� ���۰���", "��������", "�����", "������", "����� ī��ID", "���뿩��" };
		String[][] arrRecieveItemData = { { "", "", "", "", "", "", "", "" } };

		dtmAucItem = new DefaultTableModel(arrAucItemData, arrAucItem);
		SendItem = new DefaultTableModel(arrSendItemData, arrSendItem);
		RecieveItem = new DefaultTableModel(arrRecieveItemData, arrRecieveItem);

		jtAucItem = new JTable(dtmAucItem) {

			// �÷��� ���� ���� ����
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// isCellEditable

			// �÷��� ���������� �Էµ� ������������ ���������� ����
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}// getColumnClass
		};

		jtSendItem = new JTable(SendItem) {

			// �÷��� ���� ���� ����
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// isCellEditable

			// �÷��� ���������� �Էµ� ������������ ���������� ����
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}// getColumnClass
		};

		jtRecieveItem = new JTable(RecieveItem) {

			// �÷��� ���� ���� ����
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// isCellEditable

			// �÷��� ���������� �Էµ� ������������ ���������� ����
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}// getColumnClass
		};

		// column �� ���� ����
		jtAucItem.getColumnModel().getColumn(0).setPreferredWidth(10);// ��ȣ
		jtAucItem.getColumnModel().getColumn(1).setPreferredWidth(100);// ��ǰ��
		jtAucItem.getColumnModel().getColumn(2).setPreferredWidth(60);// ī�װ�
		jtAucItem.getColumnModel().getColumn(3).setPreferredWidth(60);// ��Ž��۰���
		jtAucItem.getColumnModel().getColumn(4).setPreferredWidth(60);// ��űⰣ
		jtAucItem.getColumnModel().getColumn(5).setPreferredWidth(80);// �����
		jtAucItem.getColumnModel().getColumn(6).setPreferredWidth(40);// ���ο���
		// column�� ���� ����
		jtAucItem.setRowHeight(50);
		// �÷� �̵�����
		jtAucItem.getTableHeader().setReorderingAllowed(false);

		// column �� ���� ����
		jtSendItem.getColumnModel().getColumn(0).setPreferredWidth(10);// ��ȣ
		jtSendItem.getColumnModel().getColumn(1).setPreferredWidth(100);// ��ǰ��
		jtSendItem.getColumnModel().getColumn(2).setPreferredWidth(40);// ��� ���۰���
		jtSendItem.getColumnModel().getColumn(3).setPreferredWidth(40);// ��������
		jtSendItem.getColumnModel().getColumn(4).setPreferredWidth(50);// �����
		jtSendItem.getColumnModel().getColumn(5).setPreferredWidth(50);// ������
		jtSendItem.getColumnModel().getColumn(6).setPreferredWidth(40);// ������ ī��
		jtSendItem.getColumnModel().getColumn(7).setPreferredWidth(40);// �߼ۿ���
		// column�� ���� ����
		jtSendItem.setRowHeight(50);
		// �÷� �̵�����
		jtSendItem.getTableHeader().setReorderingAllowed(false);

		// column �� ���� ����
		jtRecieveItem.getColumnModel().getColumn(0).setPreferredWidth(10);// ��ȣ
		jtRecieveItem.getColumnModel().getColumn(1).setPreferredWidth(100);// ��ǰ��
		jtRecieveItem.getColumnModel().getColumn(2).setPreferredWidth(40);// ��� ���۰���
		jtRecieveItem.getColumnModel().getColumn(3).setPreferredWidth(40);// ��������
		jtRecieveItem.getColumnModel().getColumn(4).setPreferredWidth(50);// �����
		jtRecieveItem.getColumnModel().getColumn(5).setPreferredWidth(50);// ������
		jtRecieveItem.getColumnModel().getColumn(6).setPreferredWidth(40);// ����� ī��
		jtRecieveItem.getColumnModel().getColumn(7).setPreferredWidth(40);// ���뿩��
		// column�� ���� ����
		jtRecieveItem.setRowHeight(50);
		// �÷� �̵�����
		jtRecieveItem.getTableHeader().setReorderingAllowed(false);

		JScrollPane jspAuc = new JScrollPane(jtAucItem);
		JScrollPane jspSend = new JScrollPane(jtSendItem);
		JScrollPane jspRecieve = new JScrollPane(jtRecieveItem);

		jtpTab = new JTabbedPane();
		jtpTab.add("����� ���", jspAuc);
		jtpTab.addTab("��������", jspSend);
		jtpTab.addTab("��������", jspRecieve);

		jtpTab.setBackground(new Color(0xFFFFBF));

		jtpTab.setBounds(0, 0, 795, 500);

		JPanel jp = new JPanel();

		jp.setBackground(new Color(0xFFFBF6));

		jp.setBounds(0, 0, 800, 500);

		// ��� ����
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();

		center.setHorizontalAlignment(SwingConstants.CENTER);
		// ������ ���̺��� ColumnModel�� ������
		TableColumnModel tcmAuc = jtAucItem.getColumnModel();

		// �ݺ����� �̿��Ͽ� ���̺��� ��� ���ķ� ����
		for (int i = 0; i < tcmAuc.getColumnCount(); i++) {
			tcmAuc.getColumn(i).setCellRenderer(center);
		}
		/////////////////////////////////////////////////////////////////////
		TableColumnModel tcmSend = jtSendItem.getColumnModel();

		for (int i = 0; i < tcmSend.getColumnCount(); i++) {
			tcmSend.getColumn(i).setCellRenderer(center);
		}
		/////////////////////////////////////////////////////////////////////
		TableColumnModel tcmRecieve = jtRecieveItem.getColumnModel();

		for (int i = 0; i < tcmRecieve.getColumnCount(); i++) {
			tcmRecieve.getColumn(i).setCellRenderer(center);
		}

		add(jtpTab);
		add(jp);

		MyAuctionFrmEvt mafe = new MyAuctionFrmEvt(this);
		jtpTab.addMouseListener(mafe);
		jtAucItem.addMouseListener(mafe);
		jtSendItem.addMouseListener(mafe);
		jtRecieveItem.addMouseListener(mafe);

		setBounds(550, 200, 800, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	}// MyAuctionFrm

	public JTabbedPane getJtpTab() {
		return jtpTab;
	}

	public void setJtpTab(JTabbedPane jtpTab) {
		this.jtpTab = jtpTab;
	}

	public DefaultTableModel getDtmAucItem() {
		return dtmAucItem;
	}

	public void setDtmAucItem(DefaultTableModel dtmAucItem) {
		this.dtmAucItem = dtmAucItem;
	}

	public DefaultTableModel getSendItem() {
		return SendItem;
	}

	public void setSendItem(DefaultTableModel sendItem) {
		SendItem = sendItem;
	}

	public DefaultTableModel getRecieveItem() {
		return RecieveItem;
	}

	public void setRecieveItem(DefaultTableModel recieveItem) {
		RecieveItem = recieveItem;
	}

	public JTable getJtAucItem() {
		return jtAucItem;
	}

	public void setJtAucItem(JTable jtAucItem) {
		this.jtAucItem = jtAucItem;
	}

	public JTable getJtSendItem() {
		return jtSendItem;
	}

	public void setJtSendItem(JTable jtSendItem) {
		this.jtSendItem = jtSendItem;
	}

	public JTable getJtRecieveItem() {
		return jtRecieveItem;
	}

	public void setJtRecieveItem(JTable jtRecieveItem) {
		this.jtRecieveItem = jtRecieveItem;
	}

}// class
