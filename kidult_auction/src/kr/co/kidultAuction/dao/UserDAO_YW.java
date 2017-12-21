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
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import kr.co.kidultAuction.view.ListOfAuctionsFrm;
import kr.co.kidultAuction.vo.ListOfAuctionVO;
import kr.co.kidultAuction.vo.LoginVO;
import kr.co.kidultAuction.vo.PasswordVO;
import kr.co.kidultAuction.vo.UserEditVO;
import kr.co.kidultAuction.vo.UserShowVO;

public class UserDAO_YW {
	private static UserDAO_YW u_dao; 
	
	//기본 생성자
	private UserDAO_YW() {
		
	}//userDAO
	
	//getInstance
	public static UserDAO_YW getInstance() {
		if(u_dao==null) {
			u_dao=new UserDAO_YW();
		}//end if
			return u_dao;
	}//getInstance
	
	//getConn
	public Connection getconn() throws SQLException{
		Connection con=null;
		Properties prop=new Properties();
		
		try {
			prop.load(new FileReader("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/dao/database.properties"));
			try {
				Class.forName(prop.getProperty("driverClass"));
				con=DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("id"), prop.getProperty("pass"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}//end catch
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		return con;
	}//getConn
	
	//dbClose
	public void dbClose(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		if(con!=null) {con.close();}
		if(pstmt!=null) {pstmt.close();}
		if(rs!=null) {rs.close();}
		}//dbClose
	
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
	
	public boolean confirmPass(PasswordVO pv) throws SQLException {
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			StringBuilder confirmP=new StringBuilder();
			confirmP.append(" select user_id, user_pass from auc_user where user_id=? and user_pass=? ");
			
			con=getconn();
			pstmt=con.prepareStatement(confirmP.toString());
			
			pstmt.setString(1, pv.getUser_id());
			pstmt.setString(2, pv.getUser_pass());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				flag=true;
			}//end while
			
		}finally {
			dbClose(con, pstmt, rs);
		}//end finally
		return flag;
	}//confirmPass
	
	public List<UserShowVO> selectUserInfo() throws SQLException{
		List<UserShowVO> list=new ArrayList<UserShowVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserShowVO usv = null;
		
		try {
		StringBuilder UserInfo=new StringBuilder();
		UserInfo.append(" select user_id, name, birth_date, addr, email, phone,kakao_id")
			        .append(" from auc_user where user_id=? user_pass=?");
		
		con=getconn();
		pstmt=con.prepareStatement(UserInfo.toString());
		rs=pstmt.executeQuery();
		
		 while (rs.next()) {
             usv = new UserShowVO(rs.getString("user_id"), rs.getString("name"), rs.getString("birth_date"), rs.getString("addr"),
                             rs.getString("email"), rs.getString("phone"), rs.getString("kakao_id"));
             list.add(usv);  //에버노트 11월 3일꺼 참조하자!!!!!
     } // end while

		}finally {
			dbClose(con, pstmt, rs);
		}//end finally
		return list;
	}//selectUserInfo
	
//////////////////////////////////////////////////////////////////////////////////////
	
	public List<String> selectCategory() throws SQLException {
		List<String> list=new ArrayList<>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getconn();
			String selectCategory="select category from auc_item";
			pstmt=con.prepareStatement(selectCategory);
			
			rs=pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("category"));
				System.out.println(rs.getString("category"));
			}//end while
		} finally {
			dbClose(con, pstmt, rs);
		}//end finally
		return list;
	}//selectCategory
	
	public List<ListOfAuctionVO> selectItem() throws SQLException{

		List<ListOfAuctionVO> list=new ArrayList<ListOfAuctionVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getconn();
			
			StringBuilder selectCategory=new StringBuilder();
			selectCategory.append("select front_img, status, item_name, end_date, user_id, auc_code, start_price")
						  .append(" from auc_item ")
						  /*.append(" where auc_code=? ")*/;
			pstmt=con.prepareStatement(selectCategory.toString());
			
//			pstmt.setString(1, ListOfAuctionsFrm.);
			
			rs=pstmt.executeQuery();
			
			ListOfAuctionVO loav=null;
			while (rs.next()) {
				loav=new ListOfAuctionVO(rs.getString("front_img"),rs.getString("status"),rs.getString("item_name")
										,rs.getString("end_date"),rs.getString("user_id"),rs.getString("auc_code")
										,rs.getInt("start_price"));
				list.add(loav);
			}//end while
		} finally {
			dbClose(con, pstmt, rs);
		}//end finally
		
		return list;
	}//selectItem
	
//////////////////////////////////////////////////////////////////////////////////////
	
	}//class
