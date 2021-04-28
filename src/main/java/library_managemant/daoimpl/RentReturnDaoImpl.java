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

			pstmt.setInt(1, rentReturn.getMemberNum());
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
		return new RentReturn(memberNum, bookNum1, bookName, bookRent, bookOver);
	}
	// 반납테이블에 뜨게 해주는법
	@Override
	public List<RentReturn> selectReturnTableByAll(RentReturn rentReturn) {
		String sql ="select r.bookNum1, b.bookName, r.bookRent,r.bookOver " + 
				"from rent_return r join book_info b on r.bookNum1 = b.bookNum " + 
				"join member_info m on r.memberNo = m.memberNo " + 
				"where r.memberNo = ?";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, rentReturn.getMemberNum());
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					List<RentReturn> list = new ArrayList<>();
					do {
						list.add(getReturnTable(rs));
					}while(rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private RentReturn getReturnTable(ResultSet rs) throws SQLException {
		int bookNum1 = Integer.parseInt(rs.getString("r.bookNum1"));
		BookInfo bookName = new BookInfo(rs.getString("b.bookName"));
		Date bookRent = rs.getDate("r.bookRent");
		int bookOver = Integer.parseInt(rs.getString("r.bookOver"));
		return new RentReturn(bookNum1, bookName, bookRent, bookOver);
	}

	@Override
	public List<RentReturn> selectRentReturnByAll() {
		return null;
	}

	@Override
	public List<MemberInfo> selectMemberDetailClick(int memberNo, RentReturn returnRent) {
		return null;
	}

	@Override
	public RentReturn selectRentInfoByRentNum(RentReturn rentReturn) {
		
		return null;
	}

	

}
