package library_managemant.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import library_managemant.dao.BookKindDao;
import library_managemant.dto.BookKind;
import library_managemant.libdb.JdbcCon;

public class BookKindDaoImpl implements BookKindDao {
	
	private static final BookKindDaoImpl instance = new BookKindDaoImpl();
	
	public static BookKindDaoImpl getInstance() {
		
		return instance;
	}
	// ----- selectBookKindByAll -----
	@Override
	public List<BookKind> selectBookKindByAll() {
		String sql = "select bookKind,kindTitle from book_kind";
		try(Connection con = JdbcCon.getConnection();){
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();{
				if(rs.next()) {
					List<BookKind> list = new ArrayList<>();
					
					do {
							list.add(getBookKind(rs));
					}while(rs.next());
						return list;
					
				}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
		

	private BookKind getBookKind(ResultSet rs) throws SQLException {
		int bookKind = rs.getInt("bookKind");
		String bookTitle = rs.getString("kindTitle");
		return new BookKind(bookKind, bookTitle);
	}
	
	
	
	// ----- selectBookKindByNo -----
	@Override
	public BookKind selectBookKindByNo(BookKind bookkind) {
		String  sql = "select bookKind,kindTitle from book_kind where bookKind = ?";
		
		try(Connection con = JdbcCon.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setInt(1, bookkind.getBookKind());
				
				try(ResultSet rs = pstmt.executeQuery()){
					if(rs.next()) {
						return getBookKind(rs);
					}
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
