package library_managemant.ui.list;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import library_managemant.dto.BookInfo;
import library_managemant.service.BookInfoService;
import library_managemant.ui.Detail.BookInfoDetail;
import library_managemant.ui.exception.NotSelectedException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class BookInfoSearchRentTablePanel extends AbstractCustomTablePanel<BookInfo> implements MouseListener{
	private BookInfoService service;
	private BookInfoDetail bookDetail;
	
	
	public void setBookDetail(BookInfoDetail bookDetail) {
		this.bookDetail = bookDetail;
	}

	public BookInfoSearchRentTablePanel() {
		initialize();
	}
	private void initialize() {
		table.addMouseListener(this);
	}

		// byNo 기능
		public void loadBookInfo(BookInfo bookInfo) {
			service = new BookInfoService();
			list = service.selectBookInfoBy(bookInfo);
			setList(); // 테이블 을 만드는기능 셀렉No할때 써줘야한다.
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

			if (row == -1) {
				throw new NotSelectedException();
			}
			return list.get(list.indexOf(new BookInfo(bookNum)));
		}

		@Override
		public void initList() {
			service = new BookInfoService();
			String bookCan = "대출가능";
			list = service.selectBookCan(bookCan);
		}

		@Override
		public String[] getColumnNames() {
			return new String[] { "도서번호", "도서제목", "대출여부" };
		}

		@Override
		public Object[] toArray(BookInfo b) {
			return new Object[] { b.getBookNum(), b.getBookName(), b.getBookCan() };
		}

		

		class CustomBookTableModel extends DefaultTableModel {
			public CustomBookTableModel(Object[][] data, Object[] columnNames) {
				super(data, columnNames);
			}
		}

		protected void setAlignAndWidth() {
			setTableCellAlign(SwingConstants.CENTER, 1);
			setTableCellAlign(SwingConstants.RIGHT, 0, 2);
			setTableCellWidth(100, 250, 200);
		}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == table) {
			thisTableMouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		int idx=table.getSelectedRow();
		int bookNum = (int) table.getValueAt(idx, 0);
		if(idx == -1) {
			throw new NotSelectedException();
		}
		
		BookInfo selectBookInfo = service.selectBookDetailByNo(bookNum);
		System.out.println("selectBookInfo>>" + selectBookInfo);
		bookDetail.setItem(selectBookInfo);
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void thisTableMouseClicked(MouseEvent arg0) {
	}
}
