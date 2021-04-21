package library_managemant.dto;

public class BookKind {
	private int bookKind;
	private String bookTitle;
	
	
	
	
	public BookKind(int bookKind) {
		
		this.bookKind = bookKind;
	}


	public BookKind(int bookKind, String bookTitle) {
		this.bookKind = bookKind;
		this.bookTitle = bookTitle;
	}


	public int getBookKind() {
		return bookKind;
	}


	public void setBookKind(int bookKind) {
		this.bookKind = bookKind;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	@Override
	public String toString() {
		return "BookKind [책종류 번호=" + bookKind + ", 책종류 =" + bookTitle +"]";
	}

}
