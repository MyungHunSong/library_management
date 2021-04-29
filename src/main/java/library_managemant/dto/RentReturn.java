package library_managemant.dto;

import java.util.Date;

public class RentReturn {
	private int rentNo;
	
	private MemberInfo memberNum;
	private BookInfo bookNum1;
	
	private BookInfo bookName;
	
	private Date bookRent;
	private Date bookReturn;
	private int bookOver;
	
	public RentReturn(int rentNo) {
		this.rentNo = rentNo;
	}
	
	public RentReturn(int rentNo, BookInfo bookNum1) {
		
		this.rentNo = rentNo;
		this.bookNum1 = bookNum1;
	}
	

	public RentReturn(int rentNo, MemberInfo memberNum, BookInfo bookNum1) {
		this.rentNo = rentNo;
		this.memberNum = memberNum;
		this.bookNum1 = bookNum1;
	}

	public RentReturn(BookInfo bookNum1) {
		super();
		this.bookNum1 = bookNum1;
	}

	public RentReturn(int rentNo, MemberInfo memberNum, BookInfo bookNum1, int bookOver) {
		super();
		this.rentNo = rentNo;
		this.memberNum = memberNum;
		this.bookNum1 = bookNum1;
		this.bookOver = bookOver;
	}

	public RentReturn(Date bookRent) {
		this.bookRent = bookRent;
	}
	
	public RentReturn(Date bookRent, int bookOver) {
		this.bookRent = bookRent;
		this.bookOver = bookOver;
	}
	public RentReturn(BookInfo bookNum1, BookInfo bookName, Date bookRent, int bookOver) {
	
	this.bookNum1 = bookNum1;
	this.bookName = bookName;
	this.bookRent = bookRent;
	this.bookOver = bookOver;
	}
	
	public RentReturn(MemberInfo memberNum) {	
		this.memberNum = memberNum;
	}

	
	public RentReturn(MemberInfo memberNum, BookInfo bookNum1) {
		this.memberNum = memberNum;
		this.bookNum1 = bookNum1;
	}


	public RentReturn(MemberInfo memberNum, BookInfo bookNum1, BookInfo bookName, Date bookRent, int bookOver) {
		this.memberNum = memberNum;
		this.bookNum1 = bookNum1;
		this.bookName = bookName;
		this.bookRent = bookRent;
		this.bookOver = bookOver;
	}
	public RentReturn(int rentNo, MemberInfo memberNum, BookInfo bookNum1, BookInfo bookName, Date bookRent,
			Date bookReturn, int bookOver) {
		this.rentNo = rentNo;
		this.memberNum = memberNum;
		this.bookNum1 = bookNum1;
		this.bookName = bookName;
		this.bookRent = bookRent;
		this.bookReturn = bookReturn;
		this.bookOver = bookOver;
	}
	
	public int getRentNo() {
		return rentNo;
	}
	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}
	public MemberInfo getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(MemberInfo memberNum) {
		this.memberNum = memberNum;
	}
	public BookInfo getBookNum1() {
		return bookNum1;
	}
	public void setBookNum1(BookInfo bookNum1) {
		this.bookNum1 = bookNum1;
	}
	
	public BookInfo getBookName() {
		return bookName;
	}
	public void setBookName(BookInfo bookName) {
		this.bookName = bookName;
	}
	public Date getBookRent() {
		return bookRent;
	}
	public void setBookRent(Date bookRent) {
		this.bookRent = bookRent;
	}
	public Date getBookReturn() {
		return bookReturn;
	}
	public void setBookReturn(Date bookReturn) {
		this.bookReturn = bookReturn;
	}
	public int getBookOver() {
		return bookOver;
	}
	public void setBookOver(int bookOver) {
		this.bookOver = bookOver;
	}
	
	
	
	@Override
	public String toString() {
		return String.format(
				"RentReturn [대여번호=%s, 회원번호=%s, 책번호=%s, 책이름=%s, 대여일자=%s, 반납일자=%s, 연체일자=%s]",
				rentNo, memberNum, bookNum1, bookName, bookRent, bookReturn, bookOver);
	}	
}
