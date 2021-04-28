package library_managemant.dao;

import java.util.List;

import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;

public interface RentReturnDao {
	
	List<RentReturn> selectRentReturnByAll();
	List<RentReturn> selectRentReturnByMem(RentReturn rentReturn);
	
	List<MemberInfo> selectMemberDetailClick(int memberNo, RentReturn returnRent);
	
	RentReturn selectRentInfoByRentNum(RentReturn rentReturn);
	
	// 반납 테이블의 책을 표기해주는값
	List<RentReturn> selectReturnTableByAll(RentReturn rentReturn);
}