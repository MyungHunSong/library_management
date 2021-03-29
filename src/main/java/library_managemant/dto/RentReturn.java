package library_managemant.dto;

import java.util.Date;

public class RentReturn {
	private int memberNo1;
	private int rentNo1;
	private Date bookRent;
	private Date bookReturn;
	private int bookOver;
	
	
	
	
	
	public RentReturn(int rentNo1) {
		this.rentNo1 = rentNo1;
	}
	
	

	public RentReturn(Date bookRent, int bookOver) {
		
		this.bookRent = bookRent;
		this.bookOver = bookOver;
	}

	public RentReturn(int memberNo1, int rentNo1, Date bookRent, Date bookReturn, int bookOver) {
		super();
		this.memberNo1 = memberNo1;
		this.rentNo1 = rentNo1;
		this.bookRent = bookRent;
		this.bookReturn = bookReturn;
		this.bookOver = bookOver;
	}

	public int getMemberNo1() {
		return memberNo1;
	}

	public void setMemberNo1(int memberNo1) {
		this.memberNo1 = memberNo1;
	}

	public int getRentNo1() {
		return rentNo1;
	}

	public void setRentNo1(int rentNo1) {
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
		return "RentReturn [memberNo1=" + memberNo1 + ", rentNo1=" + rentNo1 + ", bookRent=" + bookRent
				+ ", bookReturn=" + bookReturn + ", bookOver=" + bookOver + "]";
	}

	
	
	
	
	
	
	
	
}
