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
import kr.co.kidultAuction.vo.MyAuctionAddVO;
import kr.co.kidultAuction.vo.MyAuctionReceiveVO;
import kr.co.kidultAuction.vo.MyAuctionSendVO;
import kr.co.kidultAuction.vo.UserEditVO;
import kr.co.kidultAuction.vo.UserShowVO;

public class UserDAO_MH {
	private static UserDAO_MH u_dao; 
	
	//기본 생성자
	private UserDAO_MH() {
		
	}//userDAO
	
	//getInstance
	public static UserDAO_MH getInstance() {
		if(u_dao==null) {
			u_dao=new UserDAO_MH();
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
             list.add(usv); 
     } // end while

		}finally {
			dbClose(con, pstmt, rs);
		}//end finally
		return list;
	}//selectUserInfo
	
	/**
	 * 회원정보 수정
	 */
/*	public void updateUser(UserEditVO uev) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=getconn();
			String edit=
					"insert into dosot_ordering(ORDER_NUM,NAME,QUANTITY,ORDER_IP,item_num)values(seq_order.nextval,?,?,?,?)";
			pstmt=con.prepareStatement(edit);
			//바인드 변수에 값 넣기
			pstmt.setString(1, uev.getName());
			
			
			pstmt.executeUpdate();
			
		}finally {
			dbClose(con, pstmt, null);
		}//end finally
		
	}//insertOrder
*/	
	
	  public boolean updateUser( UserEditVO uev) throws SQLException{
		    boolean returnValue = false;
		    Connection con=null;
	        PreparedStatement pstmt = null;
	        
	      try {
	        con=getconn();
	        
	        StringBuffer sql = new StringBuffer();
	        sql.append(" update auc_user ");
	        sql.append(" set user_pass=?,name=?,birth_date=to_date(? ,'yyyy-mm-dd'),addr=?,email=?,phone=?");
	        sql.append(" where user_id=?");
	                   
	        pstmt = con.prepareStatement(sql.toString());
	        
	        pstmt.setString(1,uev.getUser_pass());
	        pstmt.setString(2,uev.getName());
	        pstmt.setString(3,uev.getBirth_date());
	        pstmt.setString(4,uev.getAddr());
	        pstmt.setString(5,uev.getEmail());
	        pstmt.setString(6,uev.getPhone());
	        pstmt.setString(7,AuctionMainFrm.User_id );
	        
	        
	        //정상적으로 insert를 하면 1을 리턴
	        int count = pstmt.executeUpdate(); 
	        if(count >0){
	            returnValue = true;
	        }
	    
	      }finally {
	        dbClose(con, pstmt, null);
	      }//end finally
	      // 정상적인 레코드 수정이면 true를 출력
	        return returnValue; 
	      
	    }   
	  
	  /**
	   * 등록한 경매
	 */
	public List<MyAuctionAddVO> selectMyAuctionAdd() throws SQLException{
			List<MyAuctionAddVO> list=new ArrayList<MyAuctionAddVO>();
			
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			
			try {
			StringBuilder AuctionAdd=new StringBuilder();
			AuctionAdd.append(" select a.item_name, a.category, a.period, a.add_date, a.permit, a.start_price, r.reject_reason, r.reject_date ")
			.append(" from auc_item a, reject_item r  where a.auc_code=r.auc_code and user_id=? ");
			
			con=getconn();
			pstmt=con.prepareStatement(AuctionAdd.toString());
			pstmt.setString(1, AuctionMainFrm.User_id );
			rs=pstmt.executeQuery();
			
			MyAuctionAddVO maav = null;
			 while (rs.next()) {
				 maav = new MyAuctionAddVO(rs.getString("item_name"), rs.getString("category"), rs.getString("period"),
	                             rs.getString("add_date"), rs.getString("permit"),rs.getString("reject_reason"),rs.getString("reject_date"),rs.getInt("start_price")) ;
				 
	             list.add(maav); 
	     } // end while

			}finally {
				dbClose(con, pstmt, rs);
			}//end finally
			return list;
		}//selectMyAuctionAdd
	  
	  /**
	   * 보낼물건
	 */
	public List<MyAuctionSendVO> selectMyAuctionSend() throws SQLException{
			List<MyAuctionSendVO> list=new ArrayList<MyAuctionSendVO>();
			
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			MyAuctionSendVO masv = null;
			
			try {
			StringBuilder AuctionSend=new StringBuilder();
			AuctionSend.append(" select a.item_name, a.category, a.period, a.add_date, a.permit, a.start_price, r.reject_reason");
			AuctionSend.append(" from auc_item a, reject_item r  where a.auc_code=r.auc_code and user_id=?");
			
			con=getconn();
			pstmt=con.prepareStatement(AuctionSend.toString());
			pstmt.setString(1, AuctionMainFrm.User_id );
			rs=pstmt.executeQuery();
			
			 while (rs.next()) {
				 masv = new MyAuctionSendVO(rs.getString("item_name"), rs.getString("add_date"), rs.getString("ended_date"),
	                             rs.getString("kakao_id"), rs.getString("send_status"), rs.getInt("start_price") ,rs.getInt("bid_price"));
				 
	             list.add(masv); 
	     } // end while

			}finally {
				dbClose(con, pstmt, rs);
			}//end finally
			return list;
		}//AuctionSend
	  
	/**
	 * 받을 물건
	 */
	public List<MyAuctionReceiveVO> selectMyAuctionReceive() throws SQLException{
		List<MyAuctionReceiveVO> list=new ArrayList<MyAuctionReceiveVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MyAuctionReceiveVO masv = null;
		
		try {
		StringBuilder AuctionReceive=new StringBuilder();
		AuctionReceive.append(" select a.item_name, a.category, a.period, a.add_date, a.permit, a.start_price, r.reject_reason");
		AuctionReceive.append(" from auc_item a, reject_item r  where a.auc_code=r.auc_code and user_id=?");
		
		con=getconn();
		pstmt=con.prepareStatement(AuctionReceive.toString());
		pstmt.setString(1, AuctionMainFrm.User_id );
		rs=pstmt.executeQuery();
		
		 while (rs.next()) {
			 masv = new MyAuctionReceiveVO(rs.getString("item_name"), rs.getString("add_date"), rs.getString("ended_date"),
                             rs.getString("kakao_id"), rs.getString("send_status"), rs.getInt("start_price") ,rs.getInt("bid_price"));
			 
             list.add(masv); 
     } // end while

		}finally {
			dbClose(con, pstmt, rs);
		}//end finally
		return list;
	}//AuctionSend
	  
	  
	}//class
