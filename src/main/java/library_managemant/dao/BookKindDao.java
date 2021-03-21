package library_managemant.dao;

import java.util.List;

import library_managemant.dto.BookKind;

public interface BookKindDao {
	List<BookKind> selectBookKindByAll();
	BookKind selectBookKindByNo(BookKind bkkind);
	
	int insertBookKind(BookKind bkkind);
	int updateBookKind(BookKind bkkind);
	int deleteBookKind(BookKind bkkind);
}
