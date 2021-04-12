package library_managemant.ui.exception;

public class NotSelectedException extends RuntimeException{
	
	public NotSelectedException() {
		super("땡 입벤입니다.");
	}
	
	public NotSelectedException(Throwable cause) {
		super("목록을 넣어 주세요"+cause);
	}
}
