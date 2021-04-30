package library_managemant.dao;

import java.util.List;

import library_managemant.dto.BookInfo;
import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;

public interface RentReturnDao {
	

	List<RentReturn> selectRentReturnByMem(RentReturn rentReturn);
	
	List<RentReturn> selectReturnInfoByRentNo(MemberInfo memNo);

	// 대출
	int insertBookTable(MemberInfo memNo, BookInfo bookNo);
	RentReturn ReturnByNo(int rentNo);
	
	// 반납
	int updateReturn(RentReturn rentNo);
	
	
		
}