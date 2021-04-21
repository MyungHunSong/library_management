package library_managemant.dto;

import java.util.Date;

public class RentReturn {
	private MemberInfo memberNo1;
	private BookInfo rentNo1;
	private Date bookRent;
	private Date bookReturn;
	private int bookOver;
	

	public RentReturn() {
	}

	public RentReturn(MemberInfo memberNo1, BookInfo rentNo1, Date bookRent, int bookOver) {
		this.memberNo1 = memberNo1;
		this.rentNo1 = rentNo1;
		this.bookRent = bookRent;
		this.bookOver = bookOver;
	}
	
	public RentReturn(BookInfo rentNo1, Date bookRent, int bookOver) {
		this.rentNo1 = rentNo1;
		this.bookRent = bookRent;
		this.bookOver = bookOver;
	}

	public  RentReturn(MemberInfo memberNo1) {
		this.memberNo1 = memberNo1;
	}

	public RentReturn(MemberInfo memberNo1, BookInfo rentNo1, Date bookRent, Date bookReturn, int bookOver) {
		this.memberNo1 = memberNo1;
		this.rentNo1 = rentNo1;
		this.bookRent = bookRent;
		this.bookReturn = bookReturn;
		this.bookOver = bookOver;
	}

	public MemberInfo getMemberNo1() {
		return memberNo1;
	}

	public void setMemberNo1(MemberInfo memberNo1) {
		this.memberNo1 = memberNo1;
	}

	public BookInfo getRentNo1() {
		return rentNo1;
	}

	public void setRentNo1(BookInfo rentNo1) {
		this.rentNo1 = rentNo1;
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
		return String.format("RentReturn [회원번호 = %s 도서번호=%s, 도서제목=%s, 도서연체일=%s, 도서대여일=%s]",
				memberNo1.getMemberNo(),rentNo1.getBookNum(), rentNo1.getBookName(),getBookOver(),getBookRent());
	}
	
}
