package library_managemant.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import library_managemant.dao.BookInfoDao;
import library_managemant.dto.BookInfo;
import library_managemant.dto.BookKind;
import library_managemant.libdb.JdbcCon;

public class BookInfoDaoImpl implements BookInfoDao {

	// ---- selectBookInfoByAll ----
	@Override
	public List<BookInfo> selectBookInfoByAll() {
		String sql = "select rentNo, bookNum, bookName, bookCan, bookKind from book_info";

		try (Connection con = JdbcCon.getConnection();) {
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			{
				if (rs.next()) {
					List<BookInfo> list = new ArrayList<>();

					do {
						list.add(getBookInfo(rs));
					} while (rs.next());
					return list;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	private BookInfo getBookInfo(ResultSet rs) throws SQLException {
		int rentNo = rs.getInt("rentNo");
		int bookNum = rs.getInt("bookNum");
		String bookName = rs.getString("bookName");
		String bookCan = rs.getString("bookCan");
		int bookKind = rs.getInt("bookKind");
		return new BookInfo(rentNo, bookNum, bookName, bookCan, new BookKind(bookKind));
	}

	// ---- selectBookInfoBy ----
	@Override
	public List<BookInfo> selectBookInfoBy() {
		String sql = "select bookNum, bookName, bookCan from book_info";
		try (Connection con = JdbcCon.getConnection();) {
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				List<BookInfo> list = new ArrayList<>();

				do {
					list.add(getBookBy(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BookInfo getBookBy(ResultSet rs) throws SQLException {
		int bookNum = rs.getInt("bookNum");
		String bookName = rs.getString("bookName");
		String bookCan = rs.getString("bookCan");
		return new BookInfo(bookNum, bookName, bookCan);
	}
	
	
	

	// ---- BookInfo ----
	@Override
	public List<BookInfo> selectBookRent() {

		return null;
	}

	@Override
	public int insertBookInfo(BookInfo bookInfo) {

		return 0;
	}

	@Override
	public int updateBookInfo(BookInfo bookInfo) {

		return 0;
	}

	@Override
	public int deleteBookInfo(BookInfo bookInfo) {

		return 0;
	}

}
