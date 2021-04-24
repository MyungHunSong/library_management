package library_managemant.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import library_managemant.daoimpl.RentReturnDaoImpl;
import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;


public class RentReturnDaoTest {
		
	private static RentReturnDaoImpl dao = RentReturnDaoImpl.getInstance();


	@Test
	public void testSelectRentReturnByMem() {
		
		System.out.println("testSelectRentReturnByMem()");
		
		RentReturn rR = new RentReturn(0);
		List<RentReturn> list = dao.selectRentReturnByMem(rR);
		Assert.assertNotNull(list);
			System.out.println(list);
	}

}
