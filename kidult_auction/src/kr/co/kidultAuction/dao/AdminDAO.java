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

import kr.co.kidultAuction.controller.AdminPageFrmEvt;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.vo.AdminApproveVO;
import kr.co.kidultAuction.vo.AdminBidVO;
import kr.co.kidultAuction.vo.AdminPermitVO;
import kr.co.kidultAuction.vo.AdminSucBidVO;
import kr.co.kidultAuction.vo.AdminUserVO;
import kr.co.kidultAuction.vo.LoginVO;

public class AdminDAO {
	private AdminPageFrmEvt apfe;
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
	 없어도 되는 메소드. 관리자 유효성 검증하기 위해 만듦
	 * */
	public List<String> listAdminLogin(LoginVO lv) throws SQLException{
		List<String> list=new ArrayList<String>();
		
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
				list.add(rs.getString("admin_id"));
			}//end while
		}finally {
			dbClose(con, pstmt, rs);
		}//end finally
		return list;
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
		.append(" select au.user_id, ai.auc_code, ai.item_name, ai.permit_date, ei.ended_date, bi.bid_price, ai.start_price ")
		.append(" from auc_user au, auc_item ai, ended_item ei, bid_item bi ")
		.append(" where au.user_id=ai.user_id and bi.user_id=ai.user_id and bi.bid_num=ei.bid_num and ei.ended_date is null and permit='Y' ");
		
		con=getconn();
		pstmt=con.prepareStatement(selectBid.toString());
		rs=pstmt.executeQuery();
		
		AdminBidVO abv=null;
		while(rs.next()) {
			abv=new AdminBidVO(rs.getString("user_id"), rs.getString("auc_code"), rs.getString("item_name"),  
					rs.getString("permit_date"), rs.getString("ended_date"), rs.getInt("bid_price"), rs.getInt("start_price"));
			
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
		StringBuilder selectSuc=new StringBuilder();
		selectSuc
		.append(" select au.user_id, ai.auc_code, ai.item_name, ai.permit_date, ei.ended_date, bi.bid_price, ai.start_price ")
		.append(" from auc_user au, auc_item ai, ended_item ei, bid_item bi ")
		.append(" where au.user_id=ai.user_id and bi.user_id=ai.user_id and bi.bid_num=ei.bid_num and ei.ended_date is not null ");
		
		con=getconn();
		pstmt=con.prepareStatement(selectSuc.toString());
		rs=pstmt.executeQuery();
		
		AdminSucBidVO asbv=null;
		while(rs.next()) {
			asbv=new AdminSucBidVO(rs.getString("user_id"), rs.getString("item_name"), rs.getString("auc_code"), 
						rs.getString("permit_date"), rs.getString("ended_date"), rs.getInt("bid_price"), rs.getInt("start_price"));
			list.add(asbv);
		}//end while
		}finally {
			dbClose(con, pstmt, rs);
		}
		return list;
		
	}//selectSucBid

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
		pstmt.setString(1, AdminPageFrmEvt.auc_code);
		
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
		.append(" set permit_date=sysdate, permit='Y' ")
		.append(" where auc_code=?");
		
		con=getconn();
		pstmt=con.prepareStatement(updateApprove.toString());
		pstmt.setString(1, AdminPageFrmEvt.auc_code);
		rsFlag=pstmt.executeUpdate();
		
		if(rsFlag!=0) {
			flag=true;
		}//end if
		}finally {
			dbClose(con, pstmt, null);
		}
		return flag;
	}//updateApproveItem
	
}//class
