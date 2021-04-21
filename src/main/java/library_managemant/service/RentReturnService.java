package library_managemant.service;

import java.util.List;

import library_managemant.dao.RentReturnDao;
import library_managemant.daoimpl.RentReturnDaoImpl;
import library_managemant.dto.RentReturn;

public class RentReturnService {
	private RentReturnDao dao = RentReturnDaoImpl.getInstance();
	
	
	public RentReturnService() {
	}
	
	// 회원 번호, 도서번호, 도서이름,연체여부,연체일
	public List<RentReturn> selectRentInfoByMem(RentReturn rentReturn) {
		return dao.selectRentReturnByMem(rentReturn);
	}
}
