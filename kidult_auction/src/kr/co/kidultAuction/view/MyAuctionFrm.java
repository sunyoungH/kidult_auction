package kr.co.kidultAuction.view;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.kidultAuction.controller.MyAuctionFrmEvt;

/**
 * 내경매
 * 
 * @author user
 */
@SuppressWarnings("serial")
public class MyAuctionFrm extends JDialog {

	private JTabbedPane jtpTab;
	private DefaultTableModel dtmAucItem, SendItem, RecieveItem;
	private JTable jtAucItem, jtSendItem, jtRecieveItem;

	public MyAuctionFrm(AuctionMainFrm amf) throws SQLException {
		super(amf, "내 경매");
		setLayout(null);

		String[] arrAucItem = { "번호", "물품명", "카테고리", "경매시작가격", "경매기간", "등록일", "승인여부" };
		String[][] arrAucItemData = { { "", "", "", "", "", "", "" } };
		String[] arrSendItem = { "번호", "물품명", "경매 시작가격", "낙찰가격", "등록일", "종료일", "낙찰자 카톡ID", "발송여부" };
		String[][] arrSendItemData = { { "", "", "", "", "", "", "", "" } };
		String[] arrRecieveItem = { "번호", "물품명", "경매 시작가격", "낙찰가격", "등록일", "낙찰일", "경매자 카톡ID", "수취여부" };
		String[][] arrRecieveItemData = { { "", "", "", "", "", "", "", "" } };

		dtmAucItem = new DefaultTableModel(arrAucItemData, arrAucItem);
		SendItem = new DefaultTableModel(arrSendItemData, arrSendItem);
		RecieveItem = new DefaultTableModel(arrRecieveItemData, arrRecieveItem);

		jtAucItem = new JTable(dtmAucItem) {

			// 컬럼의 내용 편집 막기
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// isCellEditable

			// 컬럼의 데이터형이 입력된 데이터형으로 보여지도록 설정
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}// getColumnClass
		};

		jtSendItem = new JTable(SendItem) {

			// 컬럼의 내용 편집 막기
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// isCellEditable

			// 컬럼의 데이터형이 입력된 데이터형으로 보여지도록 설정
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}// getColumnClass
		};

		jtRecieveItem = new JTable(RecieveItem) {

			// 컬럼의 내용 편집 막기
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// isCellEditable

			// 컬럼의 데이터형이 입력된 데이터형으로 보여지도록 설정
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}// getColumnClass
		};

		// column 의 넓이 변경
		jtAucItem.getColumnModel().getColumn(0).setPreferredWidth(10);// 번호
		jtAucItem.getColumnModel().getColumn(1).setPreferredWidth(100);// 물품명
		jtAucItem.getColumnModel().getColumn(2).setPreferredWidth(60);// 카테고리
		jtAucItem.getColumnModel().getColumn(3).setPreferredWidth(60);// 경매시작가격
		jtAucItem.getColumnModel().getColumn(4).setPreferredWidth(60);// 경매기간
		jtAucItem.getColumnModel().getColumn(5).setPreferredWidth(50);// 등록일
		jtAucItem.getColumnModel().getColumn(6).setPreferredWidth(60);// 승인여부
		// column의 높이 변경
		jtAucItem.setRowHeight(50);
		// 컬럼 이동막기
		jtAucItem.getTableHeader().setReorderingAllowed(false);

		// column 의 넓이 변경
		jtSendItem.getColumnModel().getColumn(0).setPreferredWidth(10);// 번호
		jtSendItem.getColumnModel().getColumn(1).setPreferredWidth(100);// 물품명
		jtSendItem.getColumnModel().getColumn(2).setPreferredWidth(40);// 경매 시작가격
		jtSendItem.getColumnModel().getColumn(3).setPreferredWidth(40);// 낙찰가격
		jtSendItem.getColumnModel().getColumn(4).setPreferredWidth(50);// 등록일
		jtSendItem.getColumnModel().getColumn(5).setPreferredWidth(50);// 종료일
		jtSendItem.getColumnModel().getColumn(6).setPreferredWidth(40);// 낙찰자 카톡
		jtSendItem.getColumnModel().getColumn(7).setPreferredWidth(40);// 발송여부
		// column의 높이 변경
		jtSendItem.setRowHeight(50);
		// 컬럼 이동막기
		jtSendItem.getTableHeader().setReorderingAllowed(false);

		// column 의 넓이 변경
		jtRecieveItem.getColumnModel().getColumn(0).setPreferredWidth(10);// 번호
		jtRecieveItem.getColumnModel().getColumn(1).setPreferredWidth(100);// 물품명
		jtRecieveItem.getColumnModel().getColumn(2).setPreferredWidth(40);// 경매 시작가격
		jtRecieveItem.getColumnModel().getColumn(3).setPreferredWidth(40);// 낙찰가격
		jtRecieveItem.getColumnModel().getColumn(4).setPreferredWidth(50);// 등록일
		jtRecieveItem.getColumnModel().getColumn(5).setPreferredWidth(50);// 낙찰일
		jtRecieveItem.getColumnModel().getColumn(6).setPreferredWidth(40);// 경매자 카톡
		jtRecieveItem.getColumnModel().getColumn(7).setPreferredWidth(40);// 수취여부
		// column의 높이 변경
		jtRecieveItem.setRowHeight(50);
		// 컬럼 이동막기
		jtRecieveItem.getTableHeader().setReorderingAllowed(false);

		JScrollPane jspAuc = new JScrollPane(jtAucItem);
		JScrollPane jspSend = new JScrollPane(jtSendItem);
		JScrollPane jspRecieve = new JScrollPane(jtRecieveItem);

		jtpTab = new JTabbedPane();
		jtpTab.add("등록한 경매", jspAuc);
		jtpTab.addTab("보낼물건", jspSend);
		jtpTab.addTab("받을물건", jspRecieve);

		jtpTab.setBounds(0, 0, 795, 500);

		add(jtpTab);

		setBounds(550, 200, 800, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		MyAuctionFrmEvt mafe = new MyAuctionFrmEvt(this);
		jtAucItem.addMouseListener(mafe);
		jtSendItem.addMouseListener(mafe);
		jtRecieveItem.addMouseListener(mafe);
		jtpTab.addMouseListener(mafe);

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
