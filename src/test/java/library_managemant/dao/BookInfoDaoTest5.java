package library_managemant.dao;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


import library_managemant.daoimpl.BookInfoDaoImpl;
import library_managemant.dto.BookInfo;

public class BookInfoDaoTest5 {

	private static BookInfoDao dao = BookInfoDaoImpl.getInstance();
	@Test
	public void testSelectBookDetail(BookInfo bookNum) {
		
		BookInfo res = new BookInfo(40001);
		
		BookInfo i = dao.selectBookDetail(res);
		
		Assert.assertNotNull(i);
		System.out.println(i);
	}

}
