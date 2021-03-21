package library_managemant.dao;

import java.util.List;

import library_managemant.dto.BookInfo;

public interface BookInfoDao {
	List<BookInfo> selectBookInfoByAll();
	BookInfo selectBookInfoByNo(BookInfo bookInfo);
	
	int insertBookInfo(BookInfo bookInfo);
	int updateBookInfo(BookInfo bookInfo);
	int deleteBookInfo(BookInfo bookInfo);
}
