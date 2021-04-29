package library_managemant.dto;

public class BookInfo {
	private int rentNo;
	private int bookNum;
	private String bookName;
	private String bookCan;
	private BookKind bookKind;

	private RentReturn bookRent;
	
	private MemberInfo memInfo;
	
	

		

	public BookInfo(int bookNum, RentReturn bookRent) {
		this.bookNum = bookNum;
		this.bookRent = bookRent;
	}



	public BookInfo(RentReturn bookRent) {
		this.bookRent = bookRent;
	}
	
	

	public BookInfo(String bookCan) {
		this.bookCan = bookCan;
	}
	
	public BookInfo(int bookNum, String bookName, String bookCan, BookKind bookKind, RentReturn bookRent) {
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookCan = bookCan;
		this.bookKind = bookKind;
		this.bookRent = bookRent;
	}



	public BookInfo(int bookNum, String bookName, RentReturn bookRent) {
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookRent = bookRent;
	}

	public BookInfo(int rentNo, int bookNum, String bookName, String bookCan, BookKind bookKind) {
		this.rentNo = rentNo;
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookCan = bookCan;
		this.bookKind = bookKind;
	}

	public BookInfo(MemberInfo memInfo) {	
		this.memInfo = memInfo;
	}
	
	public MemberInfo getMemInfo() {
		return memInfo;
	}



	public void setMemInfo(MemberInfo memInfo) {
		this.memInfo = memInfo;
	}



	public BookInfo(int bookNum) {
		this.bookNum = bookNum;
	}
	
//	public BookInfo(String bookName) {
//		this.bookName = bookName;
//	}
	

	public BookInfo(int bookNum, String bookName) {
		this.bookNum = bookNum;
		this.bookName = bookName;
	}
	

	// 1.도서번호 2.도서제목 3.대출여부
	public BookInfo(int bookNum, String bookName, String bookCan) {
		super();
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookCan = bookCan;
	}

	
	// 1.도서번호 2.도서제목 3.도서구분
	public BookInfo(int bookNum, String bookName, BookKind bookKind, String bookCan) {
		
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookKind = bookKind;
		this.bookCan = bookCan;
	}


	// 1. 도서 상세정보
	
	


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
	
	public RentReturn getBookRent() {
		return bookRent;
	}

	public void setBookRent(RentReturn bookRent) {
		this.bookRent = bookRent;
	}

	@Override
	public String toString() {
		return "BookInfo 대여 번호=" + rentNo + ", 도서 번호 =" + bookNum + ", 도서 제목=" + bookName + ", 대출 여부 =" + bookCan
				+ ", 도서 구분 =" + bookKind +  "대여일 =";
	}
	
	public String toString1() {
		return "도서번호: "+ bookNum +" 도서제목"+ bookName +" 대출여부:" + bookCan;
	}
	
	
	
	
}
