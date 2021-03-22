package library_managemant.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


import library_managemant.daoimpl.BookKindDaoImpl;
import library_managemant.dto.BookKind;

public class BookKindDaoTest {
	
	private static BookKindDao dao = BookKindDaoImpl.getInstance();

	@Test
	public void testSelectBookKindByAll() {
		System.out.println("BookKindByAll()");
		
		List<BookKind> bookKindList = dao.selectBookKindByAll();
		Assert.assertNotNull(bookKindList);
		
		
	}

	//@Test
	public void testSelectBookKindByNo() {
		
	}

	//@Test
	public void testInsertBookKind() {
		fail("Not yet implemented");
	}

	//@Test
	public void testUpdateBookKind() {
		fail("Not yet implemented");
	}

	//@Test
	public void testDeleteBookKind() {
		fail("Not yet implemented");
	}

}
