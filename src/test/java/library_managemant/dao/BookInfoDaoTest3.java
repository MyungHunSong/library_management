package library_managemant.dao;

import org.junit.Assert;
import org.junit.Test;

import library_managemant.daoimpl.BookInfoDaoImpl;
import library_managemant.dto.BookInfo;

public class BookInfoDaoTest3 {
	private static BookInfoDaoImpl dao = BookInfoDaoImpl.getInstance();
	@Test
	public void testSelectBookReturnDetail() {
		System.out.println("testSelectBookReturnDetail()");
		int mem = 12001;
		
		BookInfo memNum = dao.selectBookReturnDetail(mem);
		Assert.assertNotNull(memNum);
		System.out.println(memNum);
	}

}
