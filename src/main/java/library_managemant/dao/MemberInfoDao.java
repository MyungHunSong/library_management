package library_managemant.dao;

import java.util.List;

import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;

public interface MemberInfoDao {
	
	List<MemberInfo> selectMemberInfoByAll(); // 상세정보
	List<MemberInfo> selectMemeberInfoList();//회원 번호, 이름, 전화번호, 휴대전화
	List<MemberInfo> selectMemberInfoByNo(MemberInfo memInfo);
	
	MemberInfo selectMemberDetailByNo(int memInfo);// 회원 번호로 검색 
	
	
	List<MemberInfo> selectMemberDetailClick(int memNo, RentReturn rentReturn);
	// 반납을 위한것.
}