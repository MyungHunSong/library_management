package library_managemant.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import library_managemant.dto.BookInfo;
import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;
import library_managemant.libdb.JdbcCon;

public class TransAction {
	private static TransAction instance = new TransAction();
	
	public static TransAction getInstance() {
		return instance;
	}

	public TransAction() {
		
	}
	// 대출 반납
	public String transInsertUpdateBookInfo(BookInfo bookInfo, MemberInfo memberInfo) throws SQLException {
		String bookInfoSql = "update book_info set bookCan =? where bookNum = ?";
		String rentInfoSql = "insert into rent_return(memberNo, bookNum1, bookRent, bookReturn, bookOver) values(?, ?, now(), null,0)";
		
		String res = null;
		Connection con = null;
		PreparedStatement bPstmt = null;
		PreparedStatement rPstmt = null;
		
		try {
			con = JdbcCon.getConnection();
			con.setAutoCommit(false);
			
			bPstmt = con.prepareStatement(bookInfoSql);
			bPstmt.setString(1, bookInfo.getBookCan());
			bPstmt.setInt(2, bookInfo.getBookNum());
			
			if(bPstmt.executeUpdate()==0) {
				throw new SQLException();
			}
			
			rPstmt = con.prepareStatement(rentInfoSql);
			rPstmt.setInt(1, memberInfo.getMemberNo());
			rPstmt.setInt(2, bookInfo.getBookNum());
			rPstmt.executeUpdate();
			
			con.commit();
			res="commit";
		}catch (SQLException e) {
			res="rollback";
			rollbackCon(con);
		}finally {
			closeUtil(con, bPstmt, rPstmt);
		}
		if(res.equals("rollback")) {
			throw new SQLException();
		}
		return res;
		
	}
	
	// 대출 반납
	public String transUpdateRentReturnAndUpdateBookInfo(BookInfo bookInfo,RentReturn rentReturn) throws SQLException {
		String rentInfoSql = "update book_info set bookCan = ? where bookNum = ?";
		String rentReturnSql = "delete from rent_return where rentNo = ?";
		
		String res = null;
		Connection con = null;
		PreparedStatement bPstmt = null;
		PreparedStatement rPstmt = null;
		
		try {
			con = JdbcCon.getConnection();
			con.setAutoCommit(false);
			bPstmt = con.prepareStatement(rentInfoSql);
			bPstmt.setString(1, bookInfo.getBookCan());
			bPstmt.setInt(2, bookInfo.getBookNum());
			
			if(bPstmt.executeUpdate() == 0) {
				throw new SQLException();
			}
			rPstmt = con.prepareStatement(rentReturnSql);
			rPstmt.setInt(1, rentReturn.getRentNo());
			rPstmt.executeUpdate();
			
			con.commit();
			res = "commit";
		}catch(SQLException e) {
			res="rollback";
			rollbackCon(con);
		}finally {
			System.out.println(res);
			closeUtil(con, bPstmt, rPstmt);
		}
		if(res.equals("rollback")) {
			throw new SQLException();
		}
		return res;
		
	}

	private void closeUtil(Connection con, PreparedStatement bPstmt, PreparedStatement rPstmt) {
		try {
			con.setAutoCommit(true);
			if(bPstmt != null) {
				bPstmt.close();
			}
			if(rPstmt != null) {
				rPstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private void rollbackCon(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
