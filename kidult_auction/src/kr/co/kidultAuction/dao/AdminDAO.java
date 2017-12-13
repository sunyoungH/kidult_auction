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

import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.vo.AdminPermitVO;
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
	 승인 대기 목록  (승인여부Commit - 'N' , 'Y'로 구분)
	 * */
	public List<AdminPermitVO> selectPermitListN() throws SQLException {
		List<AdminPermitVO> list=new ArrayList<AdminPermitVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		StringBuilder selectPermit=new StringBuilder();
		selectPermit
		.append(" select user_id, auction_code, category, status, item_name, period, start_price ")
		.append(" from auction_item where commit='N' ");
		
		con=getconn();
		pstmt=con.prepareStatement(selectPermit.toString());
		rs=pstmt.executeQuery();
		
		AdminPermitVO apv=null;
		while(rs.next()) {
			apv=new AdminPermitVO(rs.getString("user_id"), rs.getString("auction_code"), rs.getString("category"), 
					rs.getString("status"), rs.getString("item_name"), rs.getString("period"), rs.getInt("start_price"));
			list.add(apv);
		}//end while
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
		
		StringBuilder selectPermit=new StringBuilder();
		selectPermit
		.append(" select user_id, auction_code, category, status, item_name, period, start_price ")
		.append(" from auction_item where commit='Y' ");
		
		con=getconn();
		pstmt=con.prepareStatement(selectPermit.toString());
		rs=pstmt.executeQuery();
		
		AdminPermitVO apv=null;
		while(rs.next()) {
			apv=new AdminPermitVO(rs.getString("user_id"), rs.getString("auction_code"), rs.getString("category"), 
					rs.getString("status"), rs.getString("item_name"), rs.getString("period"), rs.getInt("start_price"));
			list.add(apv);
		}//end while
		return list;
	}//selectPermitList
	
	
}//class
