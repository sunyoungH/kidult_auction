package kr.co.kidultAuction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.kidultAuction.vo.AddBidVO;

public class ADDBID {

	/**
	 * 입찰 method (입찰 데이터등록시 숫자=1)
	 * @throws SQLException 
	 */
	public int insertBidPrice(AddBidVO abv) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		int cnt=0;
		
		try {
		StringBuilder insertBid=new StringBuilder();
		insertBid
		.append(" insert into bid_item(bid_num, bid_price, auc_code, user_id) ")
		.append(" values(seq_auc.nextval,?, ?, ?)");
		
		
		con=getconn();
		pstmt=con.prepareStatement(insertBid.toString());
		pstmt.setInt(1, abv.getBid_price());
		pstmt.setString(2, abv.getAuction_code());
		pstmt.setString(3, abv.getUser_id());
		
		cnt=pstmt.executeUpdate();
		}finally {
			dbClose(con, pstmt, null);
		}//end finally
		
		return cnt; 
	}//insertBidPrice
	
	
	
}
