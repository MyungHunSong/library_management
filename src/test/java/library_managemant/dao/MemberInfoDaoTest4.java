package library_managemant.dao;

import org.junit.Test;

import library_managemant.daoimpl.MemberInfoDaoImpl;
import library_managemant.dto.MemberInfo;

public class MemberInfoDaoTest4 {
	private static MemberInfoDao dao = MemberInfoDaoImpl.getInstance();
	@Test
	public void testSelectClickReturnTable() {
		System.out.println("testSelectClickReturnTable()");
		MemberInfo memNo = new MemberInfo(12001);
		
	}

}
