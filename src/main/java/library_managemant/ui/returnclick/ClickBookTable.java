package library_managemant.ui.returnclick;

import javax.swing.SwingConstants;

import library_managemant.dto.BookInfo;
import library_managemant.ui.exception.NotSelectedException;
import library_managemant.ui.list.AbstractCustomTablePanel;

@SuppressWarnings("serial")
public class ClickBookTable extends AbstractCustomTablePanel<BookInfo>{

	
	public ClickBookTable() {
	}

	@Override
	public BookInfo getItem() {
		int row = table.getSelectedRow();
		int bookNum = (int) table.getValueAt(row, 0);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new BookInfo(bookNum)));
	}

	@Override
	public void initList() {
	}

	@Override
	public String[] getColumnNames() {
		
		return new String[] { "도서번호", "도서제목", "도서연체일","도서대여일" };
	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 1);
		setTableCellAlign(SwingConstants.RIGHT, 0, 2);
		setTableCellWidth(100, 250, 200);
	}

	@Override
	public Object[] toArray(BookInfo b) {
		
		return new Object[] { b.getBookNum(), b.getBookName(), b.getBookRent().getBookOver(), b.getBookRent().getBookRent()};
	}

}
