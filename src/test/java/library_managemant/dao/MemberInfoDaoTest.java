package library_managemant.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


import library_managemant.daoimpl.MemberInfoDaoImpl;
import library_managemant.dto.MemberInfo;

public class MemberInfoDaoTest {
	private static MemberInfoDao dao = MemberInfoDaoImpl.getInstance();
	
	@Test
	public void testSelectMemberInfoByAll() {
		System.out.printf("%s()%n","testSelectMemberInfoByAll()");
		
		List<MemberInfo> list = dao.selectMemberInfoByAll();
		Assert.assertNotNull(list);
		
		System.out.println(list);
	}

	@Test
	public void testSelectMemeberInfo() {
		System.out.printf("%s()%n","testSelectMemeberInfo()");
		
		List<MemberInfo> list = dao.selectMemeberInfo();
		Assert.assertNotNull(list);
		
		System.out.println(list);
	}

	@Test
	public void testSelectMemberInfoByNo() {
		System.out.printf("%s()%n","testSelectMemberInfoByNo()");
		
		MemberInfo memInfo = new MemberInfo(12001);
		MemberInfo searchMem = dao.selectMemberInfoByNo(memInfo);
		
		Assert.assertNotNull(searchMem);
		System.out.println(searchMem);
		
	}

}
