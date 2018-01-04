package kr.co.kidultAuction.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import kr.co.kidultAuction.vo.AddAuctionItemVO;

public class UserDAO_EJ {
	
private static UserDAO_EJ u_dao; 
	
	//기본 생성자
	private UserDAO_EJ() {
		
	}//userDAO
	
	//getInstance
	public static UserDAO_EJ getInstance() {
		if(u_dao==null) {
			u_dao=new UserDAO_EJ();
		}//end if
			return u_dao;
	}//getInstance
	
	//getConn
	public Connection getConn() throws SQLException{
		Connection con=null;
		Properties prop=new Properties();
		
		try {
			String path=System.getProperty("user.dir");
			prop.load(new FileReader(path+"/src/kr/co/kidultAuction/dao/database.properties"));
//			C:\dev\git\kidult_auction_sub\kidult_auction\src\kr\co\kidultAuction\dao\database.properties
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
	
	
	
	public void insertAddItem(AddAuctionItemVO aaiv)throws SQLException {
	
		Connection con=null;
		PreparedStatement pstmt=null;
		
		SimpleDateFormat sdf_date=new SimpleDateFormat("yyMMdd_HH_m_s");
		
		try {
			con=getConn();
			StringBuilder insertAddItem=new StringBuilder();
			insertAddItem
			.append("insert into auc_item(auc_code,item_name,front_img,left_img,right_img,back_img,category,")
			.append("status,start_price,period,detail_info,add_date,permit,permit_date,start_date,user_id,category_num)")
			.append("values(concat(?||'_', lpad(auc_code_seq.nextval,4,0)),?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,sysdate,?,?)");
			
			
			pstmt=con.prepareStatement(insertAddItem.toString());
			pstmt.setString(1, aaiv.getCategory());
			pstmt.setString(2, aaiv.getItem_name());
			pstmt.setString(3, aaiv.getFront_img());
			pstmt.setString(4, aaiv.getLeft_img());
			pstmt.setString(5, aaiv.getRight_img());
			pstmt.setString(6, aaiv.getBack_img());
			pstmt.setString(7, aaiv.getCategory()); //카테고리 이름을 넣어야함sdf_date
			pstmt.setString(8, aaiv.getStatus());
			pstmt.setInt(9, aaiv.getStart_price());
			pstmt.setInt(10, aaiv.getPeriod());
			pstmt.setString(11, aaiv.getDetail_info());
//			pstmt.setString(12,"1111111");//add_date
			pstmt.setString(12,"N");
//			pstmt.setDate(14, sdf_date);//permit_date
//			pstmt.setDate //start_date
			pstmt.setString(13,aaiv.getUser_id()); //user_id넣어야함
			pstmt.setString(14, aaiv.getCategory());
			
			
			pstmt.executeUpdate();
			
		}finally {
			dbClose(con,pstmt,null);
		}//end finally
		
	}//insertAddItem
	
	
	public void auc_code() {
		
	}//auc_code

}//class
