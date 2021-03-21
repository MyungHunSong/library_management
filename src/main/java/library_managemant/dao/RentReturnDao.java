package library_managemant.dao;

import java.util.List;

import library_managemant.dto.RentReturn;

public interface RentReturnDao {
	List<RentReturn> selectRentReturnByAll();
	RentReturn selectRentReturnByNo(RentReturn rentReturn);
	
	int insertRentReturn (RentReturn rentReturn);
	int updateRentReturn (RentReturn rentReturn);
	int deleteRentReturn (RentReturn rentReturn);
}
