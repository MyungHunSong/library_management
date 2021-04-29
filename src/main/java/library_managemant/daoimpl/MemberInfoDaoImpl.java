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
import library_managemant.dto.RentReturn;
import library_managemant.libdb.JdbcCon;

public class MemberInfoDaoImpl implements MemberInfoDao {

	private static final MemberInfoDaoImpl instance = new MemberInfoDaoImpl();

	public static MemberInfoDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<MemberInfo> selectMemberInfoByAll() {
		String sql = "select memberNo, name, births, homeNo, phoneNo, adress from member_info";

		try (Connection con = JdbcCon.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			{
				if (rs.next()) {
					List<MemberInfo> list = new ArrayList<>();

					do {
						list.add(getMemberInfo(rs));
					} while (rs.next());
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
		String homeNo = rs.getString("homeNo");
		String phoneNo = rs.getString("phoneNo");
		String adress = rs.getString("adress");

		return new MemberInfo(memberNo, name, births, homeNo, phoneNo, adress);
	}

	// 2번에 모든정보를 출력(회원번호, 이름, 전화번호, 휴대전화)
	@Override
	public List<MemberInfo> selectMemeberInfoList() {
		String sql = "select memberNo, name, homeNo, phoneNo from member_info";

		try (Connection con = JdbcCon.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			{
				if (rs.next()) {
					List<MemberInfo> list = new ArrayList<>();

					do {
						list.add(getMemSearch(rs));
					} while (rs.next());
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
	public List<MemberInfo> selectMemberInfoByNo(MemberInfo memInfo) {
		String sql = "select memberNo, name, homeNo, phoneNo from member_info where memberNo like ? or name like ?";

		try (Connection con = JdbcCon.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, memInfo.getMemberNo());
			pstmt.setString(2, memInfo.getName());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<MemberInfo> list = new ArrayList<>();

					do {
						list.add(getMemSearch(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MemberInfo selectMemberDetailByNo(int memInfo) {
		String sql = "select memberNo\r\n" + "	   ,name\r\n" + "	   ,births \r\n" + "	   ,homeNo\r\n"
				+ "	   ,phoneNo\r\n" + "	 ,adress\r\n" + "from member_info\r\n" + "where memberNo = ?";
		try (Connection con = JdbcCon.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, memInfo);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getMemDetail(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private MemberInfo getMemDetail(ResultSet rs) throws NumberFormatException, SQLException {
		int memberNo = Integer.parseInt(rs.getString("memberNo"));
		String name = rs.getString("name");
		Date births = rs.getDate("births");
		String homeNo = rs.getString("homeNo");
		String phoneNo = rs.getString("phoneNo");
		String adress = rs.getString("adress");
		return new MemberInfo(memberNo, name, births, homeNo, phoneNo, adress);
	}
	// 리스트로 회원 검색법
	@Override
	public List<MemberInfo> selectMemberInfoByReturnD(MemberInfo memInfo) {
		String sql = "select memberNo\r\n" + "	   ,name\r\n" + "	   ,births \r\n" + "	   ,homeNo\r\n"
				+ "	   ,phoneNo\r\n" + "	   ,adress\r\n" + "from member_info\r\n" + "where memberNo = ?";
		try (Connection con = JdbcCon.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, memInfo.getMemberNo());
			
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<MemberInfo> list = new ArrayList<>();

					do {
						list.add(getMemSearch(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	private MemberInfo getRentDetail(ResultSet rs) throws NumberFormatException, SQLException {
		int memberNo = Integer.parseInt(rs.getString("memberNo"));
		String name = rs.getString("name");
		Date births = rs.getDate("births");
		String homeNo = rs.getString("homeNo");
		String phoneNo = rs.getString("phoneNo");
		String adress = rs.getString("adress");
		return new MemberInfo(memberNo, name, births, homeNo, phoneNo, adress);
	}

	@Override
	public MemberInfo selectMemberDetailReturn(int memInfo) {
		String sql = "select memberNo " + 
				"	   ,name " + 
				"	   ,births " + 
				"	   ,homeNo " + 
				"	   ,phoneNo " + 
				"	   ,adress " + 
				" from member_info " + 
				" where memberNo=?";
		try (Connection con = JdbcCon.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, memInfo);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getRentDetail(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MemberInfo> selectAllReturnTable() {
		String sql="select m.memberNo, m.name, m.homeNo, m.phoneNo from\r\n" + 
				"				member_info m join rent_return r on m.memberNo = r.memberNo \r\n" + 
				"				join book_info b on b.bookNum = r.bookNum1\r\n" + 
				"				where bookCan = '대출불가'";
		
		try (Connection con = JdbcCon.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			{
				if (rs.next()) {
					List<MemberInfo> list = new ArrayList<>();

					do {
						list.add(getMemberInfoReturn(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	private MemberInfo getMemberInfoReturn(ResultSet rs) throws SQLException {
		int memberNo = Integer.parseInt(rs.getString("m.memberNo"));
		String name = rs.getString("m.name");
		String homeNo = rs.getString("m.homeNo");
		String phoneNo = rs.getString("m.phoneNo");
		return new MemberInfo(memberNo, name, homeNo, phoneNo);
	}

	@Override
	public MemberInfo selectClickReturnTable(int memberNo) {
		String sql = "select m.memberNo, name, births, phoneNo, adress \r\n" + 
				"from member_info m join rent_return r on m.memberNo = r.memberNo \r\n" + 
				"where m.memberNo = ?";
		
		try (Connection con = JdbcCon.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			ResultSet rs = pstmt.executeQuery();
			{
				if (rs.next()) {
					return getClickDetail(rs);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	private MemberInfo getClickDetail(ResultSet rs) throws NumberFormatException, SQLException {
		int memberNo = Integer.parseInt(rs.getString("m.memberNo"));
		String name = rs.getString("name");
		Date births = rs.getDate("births");
		String phoneNo = rs.getString("phoneNo");
		String adress = rs.getString("adress");
		return new MemberInfo(memberNo, name, births, phoneNo, adress);
	}

}
