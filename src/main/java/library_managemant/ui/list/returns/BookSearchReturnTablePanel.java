package library_managemant.ui.list.returns;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import library_managemant.dto.BookInfo;
import library_managemant.service.BookInfoService;
import library_managemant.ui.Detail.BookInfoDetail;
import library_managemant.ui.exception.NotSelectedException;
import library_managemant.ui.list.AbstractCustomTablePanel;
import library_managemant.ui.list.returns.detail.BookInfoReturnDetail;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class BookSearchReturnTablePanel extends AbstractCustomTablePanel<BookInfo> implements MouseListener{
	private BookInfoService service;
	private BookInfoReturnDetail bookDetail;
	
	
		public void loadReturnTable(BookInfo bookInfo) {
			service = new BookInfoService(); 
			list = service.selectBookRentTable(bookInfo);
			setList();
		}
	
	public void setBookDetail(BookInfoReturnDetail bookDetail) {
		this.bookDetail = bookDetail;
	}

	public BookSearchReturnTablePanel() {
		initialize();
	}
	private void initialize() {
		setVisible(false);
		table.addMouseListener(this);
	}
	public void returnVisible() {
		table.setVisible(true);
	}

	// byNo 기능
		public void loadBookInfo(BookInfo bookInfo) {
			service = new BookInfoService();
			list = service.selectBookInfoBy(bookInfo);
			setList(); // 테이블 을 만드는기능 셀렉No할때 써줘야한다.
		}
		
		public void loadBookReturnTable(int memNum) {
			service = new BookInfoService();
			 
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
			String bookCan = "대출불가";
			list = service.selectBookCan(bookCan);
		}

		@Override
		public String[] getColumnNames() {
			return new String[] { "도서번호", "도서제목", "도서연체일","도서대여일" };
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
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			thisTableMouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
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
		bookDetail.setItem(selectBookInfo);
		
		
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void thisTableMouseClicked(MouseEvent e) {
	}
}
