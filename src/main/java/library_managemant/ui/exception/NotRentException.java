package library_managemant.ui.exception;

@SuppressWarnings("serial")
public class NotRentException extends RuntimeException{
	
	public NotRentException() {
		super("대여중인 도서 목록이 없습니다.");
	}
	
	public NotRentException(Throwable cause) {
		super("대여를 원하시면 대여하기에 들어 가십쇼."+cause);
	}
	
}
