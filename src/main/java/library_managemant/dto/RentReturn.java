package library_managemant.dto;

import java.util.Date;

public class RentReturn {
	private int rentNo;
	private int memberNum;
	
	private int bookNum1;
	private BookInfo bookName;
	
	private Date bookRent;
	private Date bookReturn;
	private int bookOver;
	
	
	
	public RentReturn(int memberNum) {
		
		this.memberNum = memberNum;
	}
	public RentReturn(int memberNum, int bookNum1, BookInfo bookName, Date bookRent, int bookOver) {
		this.memberNum = memberNum;
		this.bookNum1 = bookNum1;
		this.bookName = bookName;
		this.bookRent = bookRent;
		this.bookOver = bookOver;
	}
	public RentReturn(int rentNo, int memberNum, int bookNum1, BookInfo bookName, Date bookRent,
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
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getBookNum1() {
		return bookNum1;
	}
	public void setBookNum1(int bookNum1) {
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
	
	

//	@Override
//	public String toString() {
//		return String.format("RentReturn [회원번호 = %s 도서번호=%s, 도서제목=%s, 도서연체일=%s, 도서대여일=%s]",
//				memberNo1.getMemberNo(),rentNo1.getBookNum(), rentNo1.getBookName(),getBookOver(),getBookRent());
//	}
	
}
