package library_managemant.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import library_managemant.daoimpl.BookInfoDaoImpl;
import library_managemant.dto.BookInfo;

public class BookInfoDaoTest2 {
	private static BookInfoDao bao = new BookInfoDaoImpl();
	@Test
	public void testSelectBookDetailBookCan() {
		
		System.out.println("testSelectBookDetailBookCan()");
		String res = "대출가능";
		List<BookInfo> newBook = bao.selectBookDetailBookCan(res);
		
		Assert.assertNotNull(newBook);
		System.out.println(newBook);
	}

}
