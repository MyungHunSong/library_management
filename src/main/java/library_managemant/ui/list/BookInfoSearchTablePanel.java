package library_managemant.ui.list;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import library_managemant.dto.BookInfo;
import library_managemant.service.BookInfoService;
import library_managemant.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class BookInfoSearchTablePanel extends AbstractCustomTablePanel<BookInfo> {
	private BookInfoService service;
	
	
	public BookInfoSearchTablePanel() {
		initialize();
	}
	// 이거 로드나오게 할려면 필수다
		public void setService(BookInfoService service) {
			this.service = service;
		}
		
		public void loadData() {
			initList();
			setList();
		}
	
	public BookInfo getItem() {
		int row = table.getSelectedRow();
		int bookNum = (int) table.getValueAt(row, 0);
				
		if(row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new BookInfo(bookNum)));
	}
	
	@Override
	public void initList() {
		service = new BookInfoService();
		list = service.showBookInfoList();
	}
	@Override
	public String[] getColumnNames() {
		
		return new String[] {"도서번호","도서제목","대출여부"};
	}
	@Override
	public Object[] toArray(BookInfo b) {
		return new Object[] {b.getBookNum(), b.getBookName(), b.getBookCan()};
	}
	
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
	}
	
	class CustomBookTableModel extends DefaultTableModel{
		public CustomBookTableModel(Object[][] data, Object[] columnNames) {
			super(data,columnNames);
		}
	}
	
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 1);
		setTableCellAlign(SwingConstants.RIGHT,0,2);
		
		setTableCellWidth(100,250,200);
	}
	
	public void loadBookInfo(BookInfo bookInfo) {
		service = new BookInfoService();
		list = service.selectBookInfoBy(bookInfo);
		
	}
	
	
	
//	private Object[] getColumnNaems() {
//		return new String[] {"도서번호","도서제목","대출여부"};
//	}


}
