package library_managemant.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import library_managemant.dao.MemberInfoDao;
import library_managemant.dto.MemberInfo;
import library_managemant.libdb.JdbcCon;

public class MemberInfoDaoImpl implements MemberInfoDao {
	
	private static final MemberInfoDaoImpl instance = new MemberInfoDaoImpl();
	
	public static MemberInfoDaoImpl getInstance() {
		return instance;
	}
	
	
	
	@Override
	public List<MemberInfo> selectMemberInfoByAll() {
		String sql = "select memberNo, name, births, homeNo, phoneNo, adress from member_info";
		
		try(Connection con = JdbcCon.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();{
				if(rs.next()) {
					List<MemberInfo> list = new ArrayList<>();
					
					do{
						list.add(getMemberInfo(rs));
					}while(rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	private MemberInfo getMemberInfo(ResultSet rs) throws SQLException {
		int memberNo = rs.getInt("memberNo");
		String name = rs.getString("name");
		Date births = rs.getDate("births");
		String homeNo =rs.getString("homeNo");
		String phoneNo = rs.getString("phoneNo");
		String adress = rs.getString("adress");
		
		return new MemberInfo(memberNo, name, births, homeNo, phoneNo, adress);
	}
	
	// 2번에 모든정보를 출력(회원번호, 이름, 전화번호, 휴대전화)
	@Override
	public List<MemberInfo> selectMemeberInfoList() {
		String sql = "select memberNo, name, homeNo, phoneNo from member_info";
		
		try(Connection con = JdbcCon.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery();{
					if(rs.next()) {
						List<MemberInfo> list = new ArrayList<>();
						
						do {
							list.add(getMemSearch(rs));
						}while(rs.next());
						return list;
					}
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	private MemberInfo getMemSearch(ResultSet rs) throws SQLException {
		int memberNo = rs.getInt("memberNo");
		String name = rs.getString("name");
		String homeNo = rs.getString("homeNo");
		String phoneNo = rs.getString("phoneNo");
		return new MemberInfo(memberNo, name, homeNo, phoneNo);
	}

	// 회원 번호 검색 하는것
	@Override
	public MemberInfo selectMemberInfoByNo(MemberInfo memberInfo) {
		String sql ="select memberNo, name, homeNo, phoneNo from member_info where memberNo like ? or name like ?";
		
		try(Connection con = JdbcCon.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, memberInfo.getMemberNo());
			pstmt.setString(2, memberInfo.getName());
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getMemSearch(rs);
				}
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return null;
	}
}
