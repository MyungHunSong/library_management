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
		String sql = "select m.memberNo, b.bookNum, b.bookName, r.bookRent, r.bookOver"
				+ " from rent_return r join member_info m on r.memberNo1 = m.memberNo"
				+ " join book_info b on b.rentNo =r.rentNo1 where m.memberNo = ?";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, rentReturn.getMemberNo1().getMemberNo());
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
		int memberNo1 = 0;
		BookInfo rentNo1 = null;
		Date bookRent = null;
		int bookOver = 0;
		memberNo1 = rs.getInt("memberNo");
		rentNo1 = new BookInfo(rs.getInt("b.bookNum"));
		rentNo1.setBookName(rs.getString("b.bookName"));
//		try {
//			memberNo1 = rs.getInt("memberNo");
//			System.out.println(memberNo1);
//		} catch (SQLException e) {}
//
//		try {
//			rentNo1 = new BookInfo(rs.getInt("b.bookNum"));
//
//			rentNo1.setBookName(rs.getString("b.bookName"));
//		} catch (SQLException e) {}

		bookRent = rs.getDate("r.bookRent");
		bookOver = rs.getInt("r.bookOver");
		return new RentReturn(
				new MemberInfo(memberNo1),
				new BookInfo(rentNo1.getBookNum(),rentNo1.getBookName()),
				bookRent, bookOver);
	}

	@Override
	public List<RentReturn> selectRentReturnByAll() {
		String sql = "";
		return null;
	}

}
