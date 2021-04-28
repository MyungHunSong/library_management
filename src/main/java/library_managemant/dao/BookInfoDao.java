package library_managemant.dao;

import java.util.List;

import library_managemant.dto.BookInfo;
import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;

public interface BookInfoDao {
	List<BookInfo> selectBookInfoByAll(); // 상세정보
	
	List<BookInfo> selectBookThree();//3개만 출력하게 해주는것
	
	List<BookInfo> selectBookInfoBy(BookInfo bookInfo); // 도서번호 제목 대출여부 and 휴대전화 전화번호 까지. 
	
	// BookInfo selectBookDetail(int bookNum);
	BookInfo selectBookDetail(BookInfo bookInfo);
	List<BookInfo> selectBookDetailBookCan(String bookCan);
	
	BookInfo selectBookReturnDetail(int memNo); //디테일에서 맴버 번호로 책빌린사람만 책을 뛰어주는것 pRentTable에 넣어주어라.
	
	List<BookInfo> selectBookReturnDetailTable(BookInfo memNo); // 테이블에 나타내 주는것
	
	//int insertBookInfo(BookInfo bookInfo);
	//int updateBookInfo(BookInfo bookInfo);
	//int deleteBookInfo(BookInfo bookInfo);
}
