package library_managemant.dao;

import org.junit.Assert;
import org.junit.Test;


import library_managemant.daoimpl.RentReturnDaoImpl;
import library_managemant.dto.BookInfo;
import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;

public class rentAndReturn {
	private static RentReturnDao dao = RentReturnDaoImpl.getInstance();
	
	// rent
	//@Test
	public void testInsertBookTable() {
		System.out.println("testInsertBookTable()");
		
		MemberInfo memNum = new MemberInfo(12004);
		BookInfo bookNum = new BookInfo(40004);
	
		int res = dao.insertBookTable(memNum, bookNum);
		System.out.println(res);
		
		Assert.assertEquals(2, res);
	}

	//return
	@Test
	public void testUpdateReturn() {
		System.out.println("testUpdateReturn()");
		
		BookInfo bookNum = new BookInfo(40004);
		RentReturn rentNo = new RentReturn(7);
		
		int res = dao.updateReturn(bookNum, rentNo);
		
		System.out.println(res);
		
		Assert.assertEquals(2, res);
	}

}
