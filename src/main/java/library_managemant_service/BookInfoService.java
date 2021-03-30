package library_managemant_service;

import java.util.List;

import library_managemant.dao.BookInfoDao;
import library_managemant.daoimpl.BookInfoDaoImpl;
import library_managemant.dto.BookInfo;

public class BookInfoService {
	private BookInfoDao dao = BookInfoDaoImpl.getInstance();
	
	public List<BookInfo> showBookInfo(){
		
		return dao.selectBookInfoByAll();
	}
	
	public List<BookInfo> BookInfoSee(){
		return dao.selectBookInfoBy();
	}
}
