package library_managemant.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import library_managemant.daoimpl.BookInfoDaoImpl;
import library_managemant.dto.BookInfo;
import library_managemant.dto.RentReturn;

public class BookInfoDaoTest {
	private static BookInfoDao bao = new BookInfoDaoImpl();
	
	@Test
	public void testSelectBookInfoByAll() {
		System.out.printf("%s()%n","testSelectBookInfoByAll()");
		List<BookInfo> bookInfo = bao.selectBookInfoByAll();
		
		Assert.assertNotNull(bookInfo);
		System.out.println(bookInfo);
	}

	@Test
	public void testSelectBookInfoBy() {
		System.out.printf("%s()%n", "testSelectBookInfoBy()");
		List<BookInfo> bookInfos = bao.selectBookInfoBy();
		
		Assert.assertNotNull(bookInfos);
		System.out.println(bookInfos);
	}

	@Test
	public void testSelectBookRent() {
		System.out.printf("%s()%n", "testSelectBookInfoBy()");
		
		
	
		
	}

	//@Test
	public void testInsertBookInfo() {
		fail("Not yet implemented");
	}

	//@Test
	public void testUpdateBookInfo() {
		fail("Not yet implemented");
	}

	//@Test
	public void testDeleteBookInfo() {
		fail("Not yet implemented");
	}

}
