package library_managemant.daoimpl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import library_managemant.dto.MemberInfo;

public class MemberInfoDaoImplTest2 {
	private static MemberInfoDaoImpl dao = MemberInfoDaoImpl.getInstance();
	@Test
	public void testSelectMemberInfoByReturnD() {
		int memInfo = 12001;
		
		List<MemberInfo> list = dao.selectMemberInfoByReturnD(new MemberInfo(memInfo));
		
		Assert.assertNotNull(list);
		System.out.println(list);
	}

}
