package library_managemant.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


import library_managemant.daoimpl.MemberInfoDaoImpl;
import library_managemant.dto.MemberInfo;

public class MemberInfoDaoTest3 {
	private static MemberInfoDaoImpl dao = new MemberInfoDaoImpl();
	@Test
	public void testSlectAllReturnTable() {
		System.out.println("testSlectAllReturnTable()");
		
		List<MemberInfo> list = dao.selectAllReturnTable();
		System.out.println(list);
		Assert.assertNotNull(list);
	}

}
