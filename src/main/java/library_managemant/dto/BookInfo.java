package library_managemant.dto;

public class BookInfo {
	private int rentNo;
	private int bookNum;
	private String bookName;
	private String bookCan;
	private BookKind bookKind;
	
	private RentReturn rentReturn;
	
	// bookInfoReturn 테이블에 넣을것
	
	
	
	
	private MemberInfo memInfo;
	
	
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
	
	public BookInfo(String bookName) {
		this.bookName = bookName;
	}
	

	public BookInfo(int bookNum, String bookName) {
		this.bookNum = bookNum;
		this.bookName = bookName;
	}
	

	public BookInfo(int bookNum, String bookName, RentReturn rentReturn) {
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
	public BookInfo(int bookNum, String bookName, BookKind bookKind, String bookCan) {
		
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookKind = bookKind;
		this.bookCan = bookCan;
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
	
	


	public RentReturn getRentReturn() {
		return rentReturn;
	}


	public void setRentReturn(RentReturn rentReturn) {
		this.rentReturn = rentReturn;
	}


	@Override
	public String toString() {
		return "BookInfo [대여 번호=" + rentNo + ", 도서 번호 =" + bookNum + ", 도서 제목=" + bookName + ", 대출 여부 =" + bookCan
				+ ", 도서 구분 =" + bookKind +  "대여일 =" +rentReturn  + "]";
	}
	
	public String toString1() {
		return "도서번호: "+ bookNum +" 도서제목"+ bookName +" 대출여부:" + bookCan;
	}
	
	public String toString2() {
		return "도서번호 : "+bookNum+" 도서제목: "+bookName+" 도서연체일: "+rentReturn.getBookOver()+" 도서대여일: "+rentReturn.getBookRent();
				
	} 
	
	
	
	
}
