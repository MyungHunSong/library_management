package library_managemant.service;

import java.util.List;

import library_managemant.daoimpl.BookInfoDaoImpl;
import library_managemant.dto.BookInfo;

public class BookInfoService {
	private BookInfoDaoImpl bookDao = BookInfoDaoImpl.getInstance();

	public BookInfoService() {
	}
	// 상세 정보.
	public List<BookInfo> showBookInfoByAll(){
		return bookDao.selectBookInfoByAll();
	}
	
	//도서번호, 도서제목, 대출여부 만 출력
	public List<BookInfo> showBookInfoList(){
		return bookDao.selectBookThree();
	}
	
	public List<BookInfo> selectBookInfoBy(BookInfo bookInfo){
		return bookDao.selectBookInfoBy(bookInfo);
	}
	
	public BookInfo selectBookDetailByNo(int bookNum) {
		return bookDao.selectBookDetail(bookNum);
	}
	
	// 대출 가능한것들
	public List<BookInfo> selectBookCan(String bookCan){
		return bookDao.selectBookDetailBookCan(bookCan);
	}
	
}
