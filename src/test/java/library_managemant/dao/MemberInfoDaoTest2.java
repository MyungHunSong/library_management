package library_managemant.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import library_managemant.daoimpl.MemberInfoDaoImpl;
import library_managemant.dto.MemberInfo;

public class MemberInfoDaoTest2 {
	private static MemberInfoDaoImpl dao = MemberInfoDaoImpl.getInstance();
	private static Connection con;
	@Test
	public void testSelectMemberDetailByNo() {
		System.out.println("testSelectMemberDetailByNo()");
		
		int memInfo = 12002;
		
		MemberInfo memberInfo = dao.selectMemberDetailByNo(memInfo);
		
		Assert.assertNotNull(memberInfo);
		
		System.out.println(memberInfo);
	}

}
