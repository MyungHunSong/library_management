package library_managemant.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import library_managemant.daoimpl.BookInfoDaoImpl;
import library_managemant.dto.BookInfo;
import library_managemant.dto.MemberInfo;

public class BookInfoDaoTest4 {
	private static BookInfoDaoImpl dao = BookInfoDaoImpl.getInstance();

	@Test
	public void testSelectBookReturnDetailTable() {
		System.out.println("testSelectBookReturnDetailTable()");
		
		BookInfo memNo = new BookInfo(12001);
		List<BookInfo> list = dao.selectBookReturnDetailTable(memNo);
		
		Assert.assertNotNull(list);
		System.out.println(list);
	}

}
