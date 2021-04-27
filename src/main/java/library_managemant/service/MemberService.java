package library_managemant.service;

import java.util.List;

import library_managemant.dao.MemberInfoDao;
import library_managemant.daoimpl.MemberInfoDaoImpl;
import library_managemant.dto.MemberInfo;

public class MemberService {
	private MemberInfoDao memDao = MemberInfoDaoImpl.getInstance();
	
	
	public MemberService() {	
	}
	//상세 정보
	public List<MemberInfo> showMemberInfoByAll(){
		
		return memDao.selectMemberInfoByAll();
	}
	// 회원 번호, 이름, 전화번호, 휴대전화 출력
	public List<MemberInfo> showMemberInfoList(){
		return memDao.selectMemeberInfoList();
	}
	
	// 원하는 조건으로 이름 검색하는법
	public List<MemberInfo> selectLikeMeminfo(MemberInfo memberInfo) {
		return memDao.selectMemberInfoByNo(memberInfo);
	}
	
	public MemberInfo selectMemInfoDetail(int memInfo){
		return memDao.selectMemberDetailByNo(memInfo);
	}
	
	// returntable 대여한사람 검색법 (리스트로)
	public List<MemberInfo> SelectRentNeedReturn(MemberInfo memInfo) {
		return memDao.selectMemberInfoByReturnD(memInfo);
	}
 
	public MemberInfo SelectReturnDetail(int memInfo) {
		return memDao.selectMemberDetailReturn(memInfo);
		
	}
	
	// 새로운 리턴 스트링 기능
}
