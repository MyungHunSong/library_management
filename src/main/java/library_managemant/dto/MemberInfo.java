package library_managemant.dto;

import java.util.Date;

public class MemberInfo {
	private int memberNo;
	private String name;
	
	private Date births;
	
	private String homeNo;
	private String phoneNo;
	private String adress;
	
	//요것은 요것이다. 가즈아~!
	
	public MemberInfo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	


	public MemberInfo(int memberNo, String name) {
		this.memberNo = memberNo;
		this.name = name;
	}




	public MemberInfo(int memberNo, String name, String homeNo, String phoneNo) {
		super();
		this.memberNo = memberNo;
		this.name = name;
		this.homeNo = homeNo;
		this.phoneNo = phoneNo;
	}
	
	


	public MemberInfo(String name, Date births, String homeNo, String phoneNo, String adress) {
		this.name = name;
		this.births = births;
		this.homeNo = homeNo;
		this.phoneNo = phoneNo;
		this.adress = adress;
	}




	public MemberInfo(int memberNo, String name, Date births, String homeNo, String phoneNo, String adress) {
		super();
		this.memberNo = memberNo;
		this.name = name;
		this.births = births;
		this.homeNo = homeNo;
		this.phoneNo = phoneNo;
		this.adress = adress;
	}

	
	

	public Date getBirths() {
		return births;
	}




	public void setBirths(Date births) {
		this.births = births;
	}




	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getYear() {
		return births;
	}


	public void setYear(Date year) {
		this.births = year;
	}


	public String getHomeNo() {
		return homeNo;
	}


	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	@Override
	public String toString() {
		return String.format("MemberInfo [회원 번호=%s, 이름 =%s, 생년월일=%tF, 전화번호=%s, 휴대전화=%s, 주소=%s]", memberNo,
				name, births, homeNo, phoneNo, adress);
	}
	
	
	
}
