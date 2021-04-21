package library_managemant.dao;

import java.util.List;

import library_managemant.dto.BookInfo;
import library_managemant.dto.RentReturn;

public interface BookInfoDao {
	List<BookInfo> selectBookInfoByAll(); // 상세정보
	
	List<BookInfo> selectBookThree();//3개만 출력하게 해주는것
	
	List<BookInfo> selectBookInfoBy(BookInfo bookInfo); // 도서번호 제목 대출여부 
	
	
	
	//int insertBookInfo(BookInfo bookInfo);
	//int updateBookInfo(BookInfo bookInfo);
	//int deleteBookInfo(BookInfo bookInfo);
}
