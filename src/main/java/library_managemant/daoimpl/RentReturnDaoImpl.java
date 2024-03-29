package library_managemant.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import library_managemant.dao.RentReturnDao;
import library_managemant.dto.BookInfo;
import library_managemant.dto.BookKind;
import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;
import library_managemant.libdb.JdbcCon;

public class RentReturnDaoImpl implements RentReturnDao {

	private static final RentReturnDaoImpl instance = new RentReturnDaoImpl();
	private Connection con = JdbcCon.getConnection();

	public static RentReturnDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<RentReturn> selectRentReturnByMem(RentReturn rentReturn) {
		String sql = "select r.memberNo,r.bookNum1,b.bookName, r.bookRent, r.bookOver \r\n" + 
				"from rent_return r join member_info m on r.memberNo = m.memberNo\r\n" + 
				"join book_info b on r.bookNum1 =b.bookNum\r\n" + 
				"where m.memberNo = ?";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, rentReturn.getMemberNum().getMemberNo());
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					List<RentReturn> list = new ArrayList<>();
					do {
						list.add(getRentReturn(rs));
					}while(rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private RentReturn getRentReturn(ResultSet rs) throws SQLException{
		int memberNum = 0;
		int bookNum1 = 0;
		BookInfo bookName = new BookInfo(rs.getString("b.bookName"));
		Date bookRent = null;
		int bookOver = 0;
		
		memberNum = rs.getInt("r.memberNo");
		bookNum1 = rs.getInt("r.bookNum1");
		bookName.setBookName(rs.getString("b.bookName"));
		bookRent = rs.getDate("r.bookRent");
		bookOver = rs.getInt("r.bookOver");
		return new RentReturn(new MemberInfo(memberNum), new BookInfo(bookNum1), bookName, bookRent, bookOver);
	}
	
	
	// 대출
	@Override
	public int insertBookTable(MemberInfo memNo, BookInfo bookNo) {
		String sql1 = "insert into rent_return(memberNo, bookNum1, bookRent, bookReturn, bookOver) values(?,?, now(), null,0)";
		String sql2 = "update book_info set bookCan = '대출불가' where bookNum = ?";
		
		try(Connection con = JdbcCon.getConnection();
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);){
			
			pstmt1.setInt(1, memNo.getMemberNo());
			pstmt1.setInt(2, bookNo.getBookNum());
			pstmt1.executeUpdate();
			
			pstmt2.setInt(1, bookNo.getBookNum());
			pstmt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//반납
	@Override
	public int updateReturn(RentReturn rentNo) {
		String sql1 = "update book_info set bookCan = '대출가능' where bookNum = ?";
		
		String sql2 = "update rent_return set bookReturn = now() where rentNo = ? and bookReturn is null";
		
		try(Connection con = JdbcCon.getConnection();
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
					PreparedStatement pstmt2 = con.prepareStatement(sql2);){
		pstmt1.setInt(1, rentNo.getBookNum1().getBookNum());
		pstmt1.executeUpdate();
		
		pstmt2.setInt(1, rentNo.getRentNo());
		pstmt2.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return 0;
	}

	@Override
	public List<RentReturn> selectReturnInfoByRentNo(MemberInfo memInfo) {
		String sql = "select r.rentNo, r.memberNo,b.bookNum , b.bookNum,r.bookOver, r.bookRent, r.bookReturn\r\n" + 
				"from book_info b join rent_return r on b.bookNum = r.bookNum1\r\n" + 
				"join member_info m on r.memberNo =m.memberNo\r\n" + 
				"where r.memberNo = ?";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, memInfo.getMemberNo());
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					List<RentReturn> list = new ArrayList<>();
					do {
						list.add(getRentReturn(rs));
					}while(rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 검색해주는 기능
	@Override
	public RentReturn ReturnByNo(int rentNo) {
		String sql = "select r.rentNo, r.memberNo, r.bookNum1, b.bookName, bk.kindTitle\r\n" + 
				"from rent_return r join book_info b on r.bookNum1  =b.bookNum \r\n" + 
				"join member_info m on m.memberNo  = r.memberNo \r\n" + 
				"join book_kind bk on b.bookKind = bk.bookKind \r\n" + 
				"where rentNo = ?  order by rentNo";
		
		try (Connection con = JdbcCon.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, rentNo);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {

					return getRent2(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private RentReturn getRent2(ResultSet rs) throws NumberFormatException, SQLException {
		int rentNo = Integer.parseInt(rs.getString("r.rentNo"));
		MemberInfo memNo = new MemberInfo(rs.getInt("r.memberNo"));
		BookInfo bookNo = new BookInfo(rs.getInt("r.bookNum1"));
		bookNo.setBookName(rs.getString("b.bookName"));
		bookNo.setBookKind(new BookKind(rs.getString("bk.kindTitle")));
		return new RentReturn(rentNo, memNo,bookNo);
	}
}
