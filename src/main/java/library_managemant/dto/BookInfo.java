package library_managemant.dto;

public class BookInfo {
	private int rentNo;
	private int bookNum;
	private String bookName;
	private String bookCan;
	private BookKind bookKind;
	private RentReturn rentReturn;
	
	
	
	
	

	public BookInfo(int bookNum, String bookName, library_managemant.dto.RentReturn rentReturn) {
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.rentReturn = rentReturn;
	}


	// 1.도서번호 2.도서제목 3.대출여부
	public BookInfo(int bookNum, String bookName, String bookCan) {
		super();
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookCan = bookCan;
	}

	
	// 1.도서번호 2.도서제목 3.도서구분
	public BookInfo(int bookNum, String bookName, BookKind bookKind) {
		
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookKind = bookKind;
	}


	// 1. 도서 상세정보
	public BookInfo(int rentNo, int bookNum, String bookName, String bookCan, BookKind bookKind) {
		
		this.rentNo = rentNo;
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookCan = bookCan;
		this.bookKind = bookKind;
	}
	
	


	public int getRentNo() {
		return rentNo;
	}


	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}


	public int getBookNum() {
		return bookNum;
	}


	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookCan() {
		return bookCan;
	}


	public void setBookCan(String bookCan) {
		this.bookCan = bookCan;
	}


	public BookKind getBookKind() {
		return bookKind;
	}


	public void setBookKind(BookKind bookKind) {
		this.bookKind = bookKind;
	}


	@Override
	public String toString() {
		return "BookInfo [rentNo=" + rentNo + ", bookNum=" + bookNum + ", bookName=" + bookName + ", bookCan=" + bookCan
				+ ", bookKind=" + bookKind + "]";
	}
	
	
	
	
}
