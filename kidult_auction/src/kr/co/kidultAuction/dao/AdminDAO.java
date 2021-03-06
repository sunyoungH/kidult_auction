package kr.co.kidultAuction.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import kr.co.kidultAuction.view.AdminPageFrm;
import kr.co.kidultAuction.vo.AddBidVO;
import kr.co.kidultAuction.vo.AdminApproveVO;
import kr.co.kidultAuction.vo.AdminBidVO;
import kr.co.kidultAuction.vo.AdminOncomingBidVO;
import kr.co.kidultAuction.vo.AdminItemPriceVO;
import kr.co.kidultAuction.vo.AdminPermitVO;
import kr.co.kidultAuction.vo.AdminRejectVO;
import kr.co.kidultAuction.vo.AdminSucBidVO;
import kr.co.kidultAuction.vo.AdminUserVO;
import kr.co.kidultAuction.vo.LoginVO;

public class AdminDAO {
	private static AdminDAO a_dao;
	
	private AdminDAO() {
		
	}//AdminDAO
	
	public static AdminDAO getInstance() {
		if(a_dao==null) {
			a_dao=new AdminDAO();
		}//end if
		return a_dao;
	}//getInstance
	
	private Connection getconn() throws SQLException{
		Connection con=null;
		Properties prop=new Properties();
		try {
			prop.load(new FileReader("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/dao/database.properties"));
			
			try {
				Class.forName(prop.getProperty("driverClass"));
				con=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("id"),prop.getProperty("pass"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}//end catch
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		return con;
	}//getconn
	
	private void dbClose(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException{
		if(con!=null) {con.close();}
		if(pstmt!=null) {pstmt.close();}
		if(rs!=null) {rs.close();}
	}//dbClose

	/**
	 관리자 로그인 
	 * */
	public boolean selectAdminLogin(LoginVO lv) throws SQLException{
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			StringBuilder selectAdmin=new StringBuilder();
			selectAdmin
			.append(" select admin_id, admin_pass")
			.append(" from admin where admin_id=? and admin_pass=? ");
			
			con=getconn();
			pstmt=con.prepareStatement(selectAdmin.toString());
			
			pstmt.setString(1, lv.getAdmin_id());
			pstmt.setString(2, lv.getAdmin_pass());
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				flag=true;
			}//end while
		}finally {
			dbClose(con, pstmt, rs);
		}//end finally
		return flag;
	}//selectAdminLogin
	
	/**
	 사용자 로그인 (user_dao에 들어가있어야하는 메소드) 
	 * */
	public boolean selectUserLogin(LoginVO lv) throws SQLException{
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			StringBuilder selectUser=new StringBuilder();
			selectUser
			.append(" select user_id, user_pass ")
			.append(" from auc_user where user_id=? and user_pass=? ");
			
			con=getconn();
			pstmt=con.prepareStatement(selectUser.toString());
			
			pstmt.setString(1, lv.getUser_id());
			pstmt.setString(2, lv.getUser_pass());
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				flag=true;
			}//end while
		}finally {
			dbClose(con, pstmt, rs);
		}//end finally
		return flag;
	}//selectAdminLogin
	
	/**
	 관리자 페이지 - 회원 목록 확인
	 * */
	public List<AdminUserVO> selectUserList() throws SQLException{
		List<AdminUserVO> list=new ArrayList<AdminUserVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			StringBuilder selectUser=new StringBuilder();
			selectUser
			.append(" select user_id, name, phone, kakao_id, birth_date, email, addr, user_joindate ")
			.append(" from auc_user ");
			
			con=getconn();
			pstmt=con.prepareStatement(selectUser.toString());
			rs=pstmt.executeQuery();

			AdminUserVO auv=null;
			while(rs.next()) {
				auv=new AdminUserVO(rs.getString("user_id"), rs.getString("name"), rs.getString("phone"),
						rs.getString("kakao_id"), rs.getString("birth_date"), rs.getString("email"), rs.getString("addr"), rs.getString("user_joindate"));
				list.add(auv);
			}//end while
		}finally {
			dbClose(con, pstmt, rs);
		}//end finally
		
		return list;
	}//selectUserList
	
	/**
	 승인 대기 목록  (승인여부Permit - 'N' , 'Y'로 구분)
	 * */
	public List<AdminPermitVO> selectPermitListN() throws SQLException {
		List<AdminPermitVO> list=new ArrayList<AdminPermitVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		StringBuilder selectPermit=new StringBuilder();
		selectPermit
		.append(" select user_id, auc_code, category, status, item_name, period, start_price ")
		.append(" from auc_item where permit='N' ");
		
		con=getconn();
		pstmt=con.prepareStatement(selectPermit.toString());
		rs=pstmt.executeQuery();
		
		AdminPermitVO apv=null;
		while(rs.next()) {
			apv=new AdminPermitVO(rs.getString("user_id"), rs.getString("auc_code"), rs.getString("category"), 
					rs.getString("status"), rs.getString("item_name"), rs.getString("period"), rs.getInt("start_price"));
			list.add(apv);
		}//end while
		}finally {
			dbClose(con, pstmt, rs);
		}
		return list;
	}//selectPermitList
	
	
	/**
	 * 승인, 승인거부창 (Approve)
	 * */
	public List<AdminApproveVO> selectApprove() throws SQLException {
		List<AdminApproveVO> list=new ArrayList<AdminApproveVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			StringBuilder selectItem=new StringBuilder();
			selectItem
			.append(" select user_id, category, status, item_name, period, detail_info, front_img, left_img, right_img, back_img, start_price ")
			.append(" from auc_item where auc_code=?  ");
			
			con=getconn();
			pstmt=con.prepareStatement(selectItem.toString());
			pstmt.setString(1, AdminPageFrm.auc_code);
			
			rs=pstmt.executeQuery();
			
			AdminApproveVO aav=null;
			while(rs.next()) {
				aav=new AdminApproveVO(rs.getString("user_id"), rs.getString("category"), rs.getString("status"), rs.getString("item_name"), 
						rs.getString("period"), rs.getString("detail_info"), rs.getString("front_img"), rs.getString("left_img"), 
						rs.getString("right_img"), rs.getString("back_img"), rs.getInt("start_price"));
				list.add(aav);
			}//end while
		}finally {
			dbClose(con, pstmt, rs);
		}
		return list;
	}//selectApprove
	
	/**
	 * 승인 (ApproveFrmEvt)
	 * @throws SQLException 
	 * */
	public boolean updateApproveItem() throws SQLException {
		boolean flag=false;
		int rsFlag=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			StringBuilder updateApprove=new StringBuilder();
			updateApprove
			.append(" update auc_item")
			.append(" set permit_date=sysdate, permit='Y', start_date=to_date(sysdate+1,'yy-mm-dd') ")
			.append(" where auc_code=?");
			
			con=getconn();
			pstmt=con.prepareStatement(updateApprove.toString());
			pstmt.setString(1, AdminPageFrm.auc_code);
			rsFlag=pstmt.executeUpdate();
			
			if(rsFlag!=0) {
				flag=true;
			}//end if
		}finally {
			dbClose(con, pstmt, null);
		}
		return flag;
	}//updateApproveItem
	
	/**
	 * 승인되면서 , 입찰 가데이터 추가됨!!!!!
	 * @throws SQLException 
	 * */
	public boolean insertBidUserData() throws SQLException {
		boolean flag=false;
		int rsFlag=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			StringBuilder insertBidData=new StringBuilder();
			insertBidData
			.append(" insert into bid_item(bid_num, bid_price, bid_date, auc_code, user_id)")
			.append(" values(seq_bid.nextval,?,sysdate, ? , ?) ");
			
			con=getconn();
			pstmt=con.prepareStatement(insertBidData.toString());
			pstmt.setInt(1, AdminPageFrm.start_price);
			pstmt.setString(2, AdminPageFrm.auc_code);
			pstmt.setString(3, AdminPageFrm.user_id);
			rsFlag=pstmt.executeUpdate();
			
			if(rsFlag!=0) {
				flag=true;
			}//end if
		}finally {
			dbClose(con, pstmt, null);
		}
		return flag;
	}//updateApproveItem
	
	/**
	 * 거부 
	 * @throws SQLException 
	 */
	public boolean rejectItem(AdminRejectVO rv) throws SQLException {
		boolean rejectFlag=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		StringBuilder addReject=new StringBuilder();
		addReject
		.append(" insert into reject_item(reject_reason, auc_code, admin_id) values(?,?,?) ");
		
		con=getconn();
		pstmt=con.prepareStatement(addReject.toString());
		pstmt.setString(1, rv.getReject_reason());
		pstmt.setString(2, rv.getAuc_code());
		pstmt.setString(3, rv.getAdmin_id());
		
		if(pstmt.executeUpdate()!=0) {
			rejectFlag=true;
		}//end if
		}finally {
			dbClose(con, pstmt, null);
		}
		
		return rejectFlag;
	}//rejectItem

	
	/**
	 승인 완료 목록 ('Y')
	 */
	public List<AdminPermitVO> selectPermitListY() throws SQLException {
		List<AdminPermitVO> list=new ArrayList<AdminPermitVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		StringBuilder selectPermit=new StringBuilder();
		selectPermit
		.append(" select user_id, auc_code, category, status, item_name, period, start_price ")
		.append(" from auc_item where permit='Y' ");
		
		con=getconn();
		pstmt=con.prepareStatement(selectPermit.toString());
		rs=pstmt.executeQuery();
		
		AdminPermitVO apv=null;
		while(rs.next()) {
			apv=new AdminPermitVO(rs.getString("user_id"), rs.getString("auc_code"), rs.getString("category"), 
					rs.getString("status"), rs.getString("item_name"), rs.getString("period"), rs.getInt("start_price"));
			list.add(apv);
		}//end while
		}finally {
			dbClose(con, pstmt, rs);
		}
		return list;
	}//selectPermitList
	
	/**
	 입찰중인 페이지
	 */
	public List<AdminBidVO> selectBidList() throws SQLException {
		List<AdminBidVO> list=new ArrayList<AdminBidVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		StringBuilder selectBid=new StringBuilder();
		selectBid
		.append(" select au.user_id user_id, ai.item_name item_name, ai.auc_code auc_code, (select max(bid_price) from bid_item where auc_code=ai.auc_code ) top_price")
		.append("  , ai.start_price start_price, ai.start_date start_date, to_date(start_date+period, 'yy-mm-dd') bid_end_date   ")
		.append(" from auc_user au, auc_item ai, bid_item bi ")
		.append(" where au.user_id=ai.user_id and bi.auc_code=ai.auc_code and ai.start_date is not null ")
		.append(" group by ai.user_id, ai.item_name, ai.auc_code, ai.start_price, ai.start_date, to_date(start_date+period, 'yy-mm-dd') ");
		
		con=getconn();
		pstmt=con.prepareStatement(selectBid.toString());
		rs=pstmt.executeQuery();
		
		AdminBidVO abv=null;
		while(rs.next()) {
			abv=new AdminBidVO(rs.getString("user_id"),  rs.getString("auc_code"), rs.getString("item_name"),rs.getString("start_date"), 
						 rs.getString("bid_end_date"), rs.getInt("top_price"), rs.getInt("start_price"));
			list.add(abv);
		}//end while
		}finally {
			dbClose(con, pstmt, rs);
		}
		return list;
	}//selectBidList
	
	/**
	 낙찰 목록
	 */

	public List<AdminSucBidVO> selectSucBid() throws SQLException{
		List<AdminSucBidVO> list=new ArrayList<AdminSucBidVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		StringBuilder selectBid=new StringBuilder();
		selectBid
		.append(" select au.user_id, ai.item_name, ai.auc_code, ei.ended_price, ai.start_price, to_date(ai.start_date,'yy-mm-dd') start_date, to_date(ei.ended_date, 'yy-mm-dd') ended_date")
		.append(" from auc_user au, auc_item ai, bid_item bi, ended_item ei ")
		.append(" where au.user_id=ai.user_id and bi.auc_code=ai.auc_code  and ei.bid_num=bi.bid_num ");
		
		con=getconn();
		pstmt=con.prepareStatement(selectBid.toString());
		rs=pstmt.executeQuery();
		
		AdminSucBidVO asbv=null;
		while(rs.next()) {
			System.out.println("bidding........");
			asbv=new AdminSucBidVO(rs.getString("user_id"), rs.getString("item_name"), rs.getString("auc_code"), rs.getString("start_date"), 
					rs.getString("ended_date"), rs.getInt("ended_price"), rs.getInt("start_price"));
			list.add(asbv);
		}//end while
		}finally {
			dbClose(con, pstmt, rs);
		}
		return list;
	}//selectSucBid
	
	/**
	 * 실시간 입찰 데이터
	 * @throws SQLException 
	 * */
	public List<AdminItemPriceVO> selectATBidList() throws SQLException {
		List<AdminItemPriceVO> list=new ArrayList<AdminItemPriceVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		StringBuilder selectBid=new StringBuilder();
		selectBid
		.append("select ai.auc_code, bi.user_id, bi.bid_price, bi.bid_date")
		.append(" from auc_user au, auc_item ai, bid_item bi ")
		.append(" where au.user_id=ai.user_id and bi.auc_code=ai.auc_code and bi.user_id!=? and ai.auc_code=? ")
		.append(" order by bid_price desc ");
		
		con=getconn();
		pstmt=con.prepareStatement(selectBid.toString());
		pstmt.setString(1, AdminPageFrm.user_id);
		pstmt.setString(2, AdminPageFrm.auc_code);
		rs=pstmt.executeQuery();
		
		AdminItemPriceVO aipv=null;
		while(rs.next()) {
			aipv=new AdminItemPriceVO(rs.getString("user_id"), rs.getString("bid_date"), rs.getInt("bid_price"));
			list.add(aipv);
		}//end while
		}finally { 
			dbClose(con, pstmt, null);
		}//end finally
		
		return list;
	}//selectATBidList
	
	
	/**
	 *  경매가 종료되면 ended_date로 insert되는 정보들
	 *  경매완료된 물품을 완료 테이블로 넣기 위해서 쓰는 method
	 * 모든 parameter가 auc_code이므로 auc_code를 받으면 된다
	 */
	public boolean insertEndBid(String auc_code) throws SQLException{
		boolean insertFlag=false;
		int cnt=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		StringBuilder selectSuc=new StringBuilder();
		selectSuc
		.append(" insert into ended_item(ended_num, send_status, ended_date, bid_num,ended_price) ")
		.append(" values(seq_end_bid.nextval, '준비중', ")
		.append(" (select start_date from auc_item where auc_code=?)+(select period from auc_item where auc_code=?), ")
		.append(" (select num from ")
		.append(" (select rownum r, bid_price, num  from ")
		.append(" (select rownum, bid_price, bid_num num ")
		.append(" from bid_item where auc_code=? order by bid_price desc)) ")
		.append(" where r=1), ")
		.append(" (select bid_price ")
		.append(" from(select rownum ,bid_price, user_id ")
		.append(" from (select rownum , bid_price, user_id from bid_item where auc_code=? order by bid_price desc) where rownum=1))) ");
		
		con=getconn();
		con.setAutoCommit(false);
		pstmt=con.prepareStatement(selectSuc.toString());
		pstmt.setString(1, auc_code);
		pstmt.setString(2, auc_code);
		pstmt.setString(3, auc_code);
		pstmt.setString(4, auc_code);
		cnt=pstmt.executeUpdate();
		
		
		if(cnt>0) {
			insertFlag=true;
		}
//		con.commit();
//		con.setAutoCommit(true);
			
		}finally {
			dbClose(con, pstmt, rs);
		}//end finally
		return insertFlag;
		
	}//selectSucBid
	
	/**
	 * 경매 종료 처리를 위해 필요한 경매코드와 예상종료일 리스트 얻기
	 * @throws SQLException 
	 */
	public List<AdminOncomingBidVO> selectOncomingData() throws SQLException {
		List<AdminOncomingBidVO> list=new ArrayList<AdminOncomingBidVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		String selectData="select auc_code, start_date+period expected_end_date from auc_item where permit='Y'";
		con=getconn();
		pstmt=con.prepareStatement(selectData);
		rs=pstmt.executeQuery();
		
		AdminOncomingBidVO aobv=null;
		while(rs.next()) {
			aobv=new AdminOncomingBidVO(rs.getString("auc_code"), rs.getString("expected_end_date"));
			list.add(aobv);
		}//end while
		}finally {
			dbClose(con, pstmt, rs);
		}
		return list;
	}//selectOncomingData
	

	
}//class
