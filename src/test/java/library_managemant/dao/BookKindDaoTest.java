package library_managemant.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import library_managemant.daoimpl.BookKindDaoImpl;
import library_managemant.dto.BookKind;

@SuppressWarnings("unused")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookKindDaoTest {
	
	private static BookKindDao dao = BookKindDaoImpl.getInstance();

	@Test
	public void test05SelectBookKindByAll() {
		System.out.printf("%s() %n","BookKindByAll()");
		
		List<BookKind> bookKindList = dao.selectBookKindByAll();
		Assert.assertNotNull(bookKindList);
		
		System.out.println(bookKindList);
	}

	@Test
	public void test01SelectBookKindByNo() {
		System.out.printf("%s() %n","testSelectBookKindByNo()");
		
		BookKind bookkind = new BookKind(1);
		BookKind searchBook = dao.selectBookKindByNo(bookkind);
		
		Assert.assertNotNull(searchBook);
		System.out.println(searchBook);
		
		
	}

	@Test
	public void test2InsertBookKind() {
		System.out.printf("%s() %n","test1InsertBookKind()");
		
		BookKind bookkind = new BookKind(5, "과학");
		int res = dao.insertBookKind(bookkind);
		Assert.assertEquals(1, res);
		System.out.println(res);
	}

	@Test
	public void test3UpdateBookKind() {
		System.out.printf("%s() %n","testUpdateBookKind()");
		
		BookKind newBook= new BookKind(5,"수학");
		int res = dao.updateBookKind(newBook);
		Assert.assertEquals(1, res);
		
		System.out.println(res);
	}	

	@Test
	public void test4DeleteBookKind() {
		System.out.printf("%s() %n","testDeleteBookKind()");
		
		BookKind newBook =new BookKind(5);
		int res = dao.deleteBookKind(newBook);
		
		Assert.assertEquals(1, res);
		System.out.println(res);
		
	}

}
