package library_managemant.dao;

import org.junit.Assert;
import org.junit.Test;

import library_managemant.daoimpl.MemberInfoDaoImpl;
import library_managemant.dto.MemberInfo;

public class MemberInfoDaoTest2 {
	private MemberInfoDaoImpl dao = new MemberInfoDaoImpl();
	@Test
	public void testSelectMemberDetailReturn() {
		int mem = 12001;
		
		MemberInfo res = dao.selectMemberDetailReturn(mem);
		System.out.println(res);
		Assert.assertNotNull(res);
	}

}
