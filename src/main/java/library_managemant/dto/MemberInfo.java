package library_managemant.dto;

import java.util.Date;

public class MemberInfo {
	private int memberNo;
	private String name;
	private Date year;
	private String homeNo;
	private String phoneNo;
	private String adress;
	
	
	public MemberInfo(int memberNo, String name, String homeNo, String phoneNo) {
		super();
		this.memberNo = memberNo;
		this.name = name;
		this.homeNo = homeNo;
		this.phoneNo = phoneNo;
	}


	public MemberInfo(int memberNo, String name, Date year, String homeNo, String phoneNo, String adress) {
		super();
		this.memberNo = memberNo;
		this.name = name;
		this.year = year;
		this.homeNo = homeNo;
		this.phoneNo = phoneNo;
		this.adress = adress;
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
		return year;
	}


	public void setYear(Date year) {
		this.year = year;
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
		return "MemberInfo [memberNo=" + memberNo + ", name=" + name + ", year=" + year + ", homeNo=" + homeNo
				+ ", phoneNo=" + phoneNo + ", adress=" + adress + "]";
	}
	
	
	
	
	
	
}
