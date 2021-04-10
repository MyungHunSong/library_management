package library_managemant.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	public void testSelectMemeberInfoList() {
		System.out.printf("%s()%n","testSelectMemeberInfoList()");
		
		List<MemberInfo> list = dao.selectMemeberInfoList();
		List<String> lists = list
				.stream()
				.map(e->e.getMemberNo()+","+e.getName()+","+e.getHomeNo()+","+e.getPhoneNo())
				.collect(Collectors.toCollection(ArrayList::new));
		
		
		
		
		
		
		Assert.assertNotNull(lists + ",");
		
		System.out.println(lists);
	}

	@Test
	public void testSelectMemberInfoByNo() {
		System.out.printf("%s()%n","testSelectMemberInfoByNo()");
		
		MemberInfo memInfo = new MemberInfo(12002,"김연수");
		MemberInfo searchMem = dao.selectMemberInfoByNo(memInfo);
		String mem = searchMem.toStr();
		Assert.assertNotNull(mem);
		System.out.println(mem);
		
	}

}
