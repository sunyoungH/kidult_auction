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
import kr.co.kidultAuction.vo.AddUserVO;
import kr.co.kidultAuction.vo.LoginVO;
import kr.co.kidultAuction.vo.UserEditVO;
import kr.co.kidultAuction.vo.UserShowVO;

public class UserDAO {
	private static UserDAO u_dao; 
	
	//기본 생성자
	private UserDAO() {
		
	}//userDAO
	
	//getInstance
	public static UserDAO getInstance() {
		if(u_dao==null) {
			u_dao=new UserDAO();
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
	
	public boolean confirmPass(LoginVO pv) throws SQLException {
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
	
	public void insertUser(AddUserVO auv) throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	}//insertUser
	
	public List<UserShowVO> selectUserInfo() throws SQLException{
		List<UserShowVO> list=new ArrayList<UserShowVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserShowVO usv = null;
		
		try {
		StringBuilder UserInfo=new StringBuilder();
		UserInfo.append(" select user_id, name, to_char(birth_date,'yyyymmdd') birth_date, addr, email, phone,kakao_id")
			        .append(" from auc_user where user_id=?");
		
		con=getconn();
		pstmt=con.prepareStatement(UserInfo.toString());
		pstmt.setString(1, AuctionMainFrm.User_id );
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
	
	}//class
