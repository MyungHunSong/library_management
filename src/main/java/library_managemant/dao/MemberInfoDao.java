package library_managemant.dao;

import java.util.List;

import library_managemant.dto.MemberInfo;

public interface MemberInfoDao {
	
	List<MemberInfo> selectMemberInfoByAll();
	MemberInfo selectMemberInfoByNo(MemberInfo memberInfo);
	
	int insertMemberInfo(MemberInfo  memberInfo);
	int updateMemberInfo(MemberInfo  memberInfo);
	int deleteMemberInfo(MemberInfo memberInfo);
}