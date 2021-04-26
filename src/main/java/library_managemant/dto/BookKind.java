package library_managemant.dto;

public class BookKind {
	private int bookKind;
	private String kindTitle;
	
	
	
	
	public BookKind(String kindTitle) {
		this.kindTitle = kindTitle;
	}

	public BookKind(int bookKind) {	
		this.bookKind = bookKind;
	}
	
	public BookKind(int bookKind, String kindTitle) {
		this.bookKind = bookKind;
		this.kindTitle = kindTitle;
	}

	public int getBookKind() {
		return bookKind;
	}


	public void setBookKind(int bookKind) {
		this.bookKind = bookKind;
	}


	public String getKindTitle() {
		return kindTitle;
	}


	public void setKindTitle(String kindTitle) {
		this.kindTitle = kindTitle;
	}


	@Override
	public String toString() {
		return "BookKind [책종류 번호=" + bookKind + ", 책종류 =" + kindTitle +"]";
	}

}
