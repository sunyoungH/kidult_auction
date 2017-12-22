package kr.co.kidultAuction.view;

import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.co.kidultAuction.controller.AdminPageFrmEvt;


/**
 * 관리자 페이지
 * @author user
 */
@SuppressWarnings("serial")
public class AdminPageFrm extends JDialog{
	private AuctionMainFrm amf;
	public static String auc_code="";
	public static String user_id="";
	public static int start_price=0;

	private JTabbedPane jtpTab;
	private DefaultTableModel userList,watingList,completeList,bidList,sucBidList;
	private JTable jtuserList, jtwatingList, jtcompleteList, jtbidList, jtsucBidList;
	 
	public AdminPageFrm(AuctionMainFrm amf) throws SQLException {
		super(amf,"관리자 페이지");
		
		String[] arrUserList= {"번호","회원ID","이름","연락처","카톡ID","생년월일","이메일","주소","가입일"};
		String[][] arrUserListData= {{"","","","","","","","",""}};
		String[] arrWatingList= {"번호","판매자ID","경매코드","카테고리","상태","물건명","시작가격","경매기간"};
		String[][] arrWatingListData= {{"","","","","","","",""}};
		String[] arrCompleteList= {"번호","판매자ID","경매코드","카테고리","상태","물건명","시작가격","경매기간"};
		String[][] arrCompleteListData= {{"","","","","","","",""}};
		String[] arrBidList= {"번호","등록자ID","물건명","경매코드","현재 최고 입찰가","시작가격","시작일","종료일"};
		String[][] arrBidListData= {{"","","","","","","",""}};
		String[] arrSucBidList= {"번호","등록자ID","물건명","경매코드","낙찰가","시작가격","시작일","종료일"};
		String[][] arrSucBidListData= {{"","","","","","","",""}};
		
		userList=new DefaultTableModel(arrUserListData, arrUserList);
		watingList=new DefaultTableModel(arrWatingListData, arrWatingList);
		completeList=new DefaultTableModel(arrCompleteListData, arrCompleteList);
		bidList=new DefaultTableModel(arrBidListData, arrBidList);
		sucBidList=new DefaultTableModel(arrSucBidListData, arrSucBidList);
		
		jtuserList=new JTable(userList) {
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
		
		jtwatingList=new JTable(watingList) {
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
		
		jtcompleteList=new JTable(completeList) {
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
		
		jtbidList=new JTable(bidList) {
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
		
		jtsucBidList=new JTable(sucBidList) {
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
		jtuserList.getColumnModel().getColumn(0).setPreferredWidth(10);//번호
		jtuserList.getColumnModel().getColumn(1).setPreferredWidth(60);//회원ID
		jtuserList.getColumnModel().getColumn(2).setPreferredWidth(40);//이름
		jtuserList.getColumnModel().getColumn(3).setPreferredWidth(60);//연락처
		jtuserList.getColumnModel().getColumn(4).setPreferredWidth(60);//카톡ID
		jtuserList.getColumnModel().getColumn(5).setPreferredWidth(40);//생년월일
		jtuserList.getColumnModel().getColumn(6).setPreferredWidth(70);//이메일
		jtuserList.getColumnModel().getColumn(7).setPreferredWidth(110);//주소
		jtuserList.getColumnModel().getColumn(8).setPreferredWidth(40);//가입일
		//column의 높이 변경
		jtuserList.setRowHeight(50);
		//컬럼 이동막기
		jtuserList.getTableHeader().setReorderingAllowed(false);
		
		//column 의 넓이 변경
		jtwatingList.getColumnModel().getColumn(0).setPreferredWidth(10);//번호
		jtwatingList.getColumnModel().getColumn(1).setPreferredWidth(60);//판매자ID
		jtwatingList.getColumnModel().getColumn(2).setPreferredWidth(90);//경매코드
		jtwatingList.getColumnModel().getColumn(3).setPreferredWidth(60);//카테고리
		jtwatingList.getColumnModel().getColumn(4).setPreferredWidth(40);//상태
		jtwatingList.getColumnModel().getColumn(5).setPreferredWidth(90);//물건명
		jtwatingList.getColumnModel().getColumn(6).setPreferredWidth(40);//시작가격
		jtwatingList.getColumnModel().getColumn(7).setPreferredWidth(40);//경매기간
		//column의 높이 변경
		jtwatingList.setRowHeight(50);
		//컬럼 이동막기
		jtwatingList.getTableHeader().setReorderingAllowed(false);
		
		//column 의 넓이 변경
		jtcompleteList.getColumnModel().getColumn(0).setPreferredWidth(10);//번호
		jtcompleteList.getColumnModel().getColumn(1).setPreferredWidth(60);//판매자ID
		jtcompleteList.getColumnModel().getColumn(2).setPreferredWidth(90);//이미지
		jtcompleteList.getColumnModel().getColumn(3).setPreferredWidth(60);//카테고리
		jtcompleteList.getColumnModel().getColumn(4).setPreferredWidth(40);//상태
		jtcompleteList.getColumnModel().getColumn(5).setPreferredWidth(90);//물건명
		jtcompleteList.getColumnModel().getColumn(6).setPreferredWidth(40);//시작가격
		jtcompleteList.getColumnModel().getColumn(7).setPreferredWidth(40);//경매기간
		//column의 높이 변경
		jtcompleteList.setRowHeight(50);
		//컬럼 이동막기
		jtcompleteList.getTableHeader().setReorderingAllowed(false);
		
		//column 의 넓이 변경
		jtbidList.getColumnModel().getColumn(0).setPreferredWidth(10);//번호
		jtbidList.getColumnModel().getColumn(1).setPreferredWidth(60);//등록자ID
		jtbidList.getColumnModel().getColumn(2).setPreferredWidth(90);//물건명
		jtbidList.getColumnModel().getColumn(3).setPreferredWidth(60);//경매코드
		jtbidList.getColumnModel().getColumn(4).setPreferredWidth(40);//현재 입찰가
		jtbidList.getColumnModel().getColumn(5).setPreferredWidth(40);//시작가격
		jtbidList.getColumnModel().getColumn(6).setPreferredWidth(40);//시작일
		jtbidList.getColumnModel().getColumn(7).setPreferredWidth(40);//종료일
		//column의 높이 변경
		jtbidList.setRowHeight(50);
		//컬럼 이동막기
		jtbidList.getTableHeader().setReorderingAllowed(false);
		
		//column 의 넓이 변경
		jtsucBidList.getColumnModel().getColumn(0).setPreferredWidth(10);//번호
		jtsucBidList.getColumnModel().getColumn(1).setPreferredWidth(60);//등록자ID
		jtsucBidList.getColumnModel().getColumn(2).setPreferredWidth(90);//물건명
		jtsucBidList.getColumnModel().getColumn(3).setPreferredWidth(60);//경매코드
		jtsucBidList.getColumnModel().getColumn(4).setPreferredWidth(40);//낙찰가
		jtsucBidList.getColumnModel().getColumn(5).setPreferredWidth(40);//시작가격
		jtsucBidList.getColumnModel().getColumn(6).setPreferredWidth(40);//시작일
		jtsucBidList.getColumnModel().getColumn(7).setPreferredWidth(40);//종료일
		//column의 높이 변경
		jtsucBidList.setRowHeight(50);
		//컬럼 이동막기
		jtsucBidList.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jspUser=new JScrollPane(jtuserList);
		JScrollPane jspWating=new JScrollPane(jtwatingList);
		JScrollPane jspComplete=new JScrollPane(jtcompleteList);
		JScrollPane jspBid=new JScrollPane(jtbidList);
		JScrollPane jspSucBid=new JScrollPane(jtsucBidList);
		
		//////////// DefaultTableCellRender
		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel userListColumnModel= jtuserList.getColumnModel();
		TableColumnModel jtwatingListColumnModel= jtwatingList.getColumnModel();
		TableColumnModel jtcompleteListColumnModel= jtcompleteList.getColumnModel();
		TableColumnModel jtbidListColumnModel= jtbidList.getColumnModel();
		TableColumnModel jtsucBidListColumnModel= jtsucBidList.getColumnModel();
		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < userListColumnModel.getColumnCount(); i++) {
			userListColumnModel.getColumn(i).setCellRenderer(cellRenderer);
		}//end for
		for (int i = 0; i < jtwatingListColumnModel.getColumnCount(); i++) {
			jtwatingListColumnModel.getColumn(i).setCellRenderer(cellRenderer);
		}//end for
		for (int i = 0; i < jtcompleteListColumnModel.getColumnCount(); i++) {
			jtcompleteListColumnModel.getColumn(i).setCellRenderer(cellRenderer);
		}//end for
		for (int i = 0; i < jtbidListColumnModel.getColumnCount(); i++) {
			jtbidListColumnModel.getColumn(i).setCellRenderer(cellRenderer);
		}//end for
		for (int i = 0; i < jtsucBidListColumnModel.getColumnCount(); i++) {
			jtsucBidListColumnModel.getColumn(i).setCellRenderer(cellRenderer);
		}//end for
		
		jtpTab=new JTabbedPane();
		jtpTab.add("회원목록", jspUser);
		jtpTab.addTab("승인대기목록", jspWating);
		jtpTab.addTab("승인완료목록", jspComplete);
		jtpTab.addTab("입찰목록", jspBid);
		jtpTab.addTab("낙찰목록", jspSucBid);
		
		jtpTab.setBounds(0,0,800,500);
		
        add(jtpTab);
        
    	//이벤트 등록
//		AdminPageEvt ape=new AdminPageEvt(this);
//		jtuserList.addMouseListener(ape);//JTable 이벤트
//		jtwatingList.addMouseListener(ape);//JTable 이벤트
//		jtcompleteList.addMouseListener(ape);//JTap의 이벤트
//		jtbidList.addMouseListener(ape);//JTap의 이벤트
//		jtsucBidList.addMouseListener(ape);//JTap의 이벤트
//		jtpTab.addMouseListener(ape);//JTap의 이벤트
		
		setBounds(100,100,810,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		AdminPageFrmEvt apfe=new AdminPageFrmEvt(this);
		jtpTab.addMouseListener(apfe);
		jtwatingList.addMouseListener(apfe);
		jtbidList.addMouseListener(apfe);
		
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
