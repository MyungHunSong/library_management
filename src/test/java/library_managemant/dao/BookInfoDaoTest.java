package library_managemant.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import library_managemant.daoimpl.BookInfoDaoImpl;
import library_managemant.dto.BookInfo;


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
		BookInfo bookInfo = new BookInfo(40001);
		List<BookInfo> books = bao.selectBookInfoBy(bookInfo);
		Assert.assertNotNull(books);
		for(BookInfo b : books) {
			System.out.println(b.toString1());
		}
		
	}

	
//	@Test
//	public void testSelectBookRent() {
//		System.out.printf("%s()%n", "testSelectBookRent()");
//	
//		List<BookInfo> bookInfo = bao.selectBookByRent();
//		
//		
//		for(BookInfo b : bookInfo) {
//			b.toString2();
//			Assert.assertNotNull(b);
//			System.out.println(b.toString2());
//		}
//	
//				
//	}

	
	
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
