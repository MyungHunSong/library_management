package library_managemant.dao;

import java.util.List;

import library_managemant.dto.BookInfo;
import library_managemant.dto.RentReturn;

public interface BookInfoDao {
	List<BookInfo> selectBookInfoByAll();
	List<BookInfo> selectBookInfoBy();
	List<BookInfo> selectBookByRent(RentReturn rentReturn);
	
	int insertBookInfo(BookInfo bookInfo);
	int updateBookInfo(BookInfo bookInfo);
	int deleteBookInfo(BookInfo bookInfo);
}
