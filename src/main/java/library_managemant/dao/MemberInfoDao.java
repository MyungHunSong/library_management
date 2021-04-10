package library_managemant.dao;

import java.util.List;

import library_managemant.dto.MemberInfo;

public interface MemberInfoDao {
	
	List<MemberInfo> selectMemberInfoByAll(); // 상세정보
	List<MemberInfo> selectMemeberInfoList(); //회원 번호, 이름, 전화번호, 휴대전화
	MemberInfo selectMemberInfoByNo(MemberInfo memberInfo); // 조건 검색 where empno = ?
	
	//int insertMemberInfo(MemberInfo  memberInfo);
	//int updateMemberInfo(MemberInfo  memberInfo);
	//int deleteMemberInfo(MemberInfo memberInfo);
}