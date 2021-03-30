package library_managemant.dao;

import java.util.List;

import library_managemant.dto.BookInfo;
import library_managemant.dto.RentReturn;

public interface BookInfoDao {
	List<BookInfo> selectBookInfoByAll(); // 상세정보
	List<BookInfo> selectBookInfoBy(); // 도서번호 제목 대출여부 
	List<BookInfo> selectBookByRent(); //  근데 member에서 클릭시 이게 나와야함 도서번호 제목 연체일 대여일 (join bookKind)
	
	//int insertBookInfo(BookInfo bookInfo);
	//int updateBookInfo(BookInfo bookInfo);
	//int deleteBookInfo(BookInfo bookInfo);
}
