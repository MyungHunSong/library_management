package library_managemant.ui.list;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import library_managemant.dto.BookInfo;
import library_managemant.service.BookInfoService;
import library_managemant.ui.exception.NotSelectedException;




@SuppressWarnings("serial")
public class BookInfoSearchTablePanel extends JPanel {
	private BookInfoService service;
	private List<BookInfo> list;
	private JTable table;
	
	public void setService(BookInfoService service) {
		this.service = service;
	}
	
	public BookInfoSearchTablePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(getModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
	}
	
	// 내부 클래스
	class CustomBookTableModel extends DefaultTableModel{
		public CustomBookTableModel(Object[][] data, Object[] columnNames) {
			super(data,columnNames);
		}
	}
	//----- -----
	private DefaultTableModel getModel() {
		CustomBookTableModel model = new CustomBookTableModel(getData(), getColumnNaems());
		return model;
	}
	
	private Object[][] getData() {
		
		return new Object[][] {
			null,null,null
		};
	}
	
	private Object[] getColumnNaems() {
		return new String[] {"도서번호","도서제목","대출여부"};
	}
	//----- -----
	public void loadData() {
		initList();
		setList();
	}
	
	
	private void initList() {
		service = new BookInfoService();
		list = service.showBookInfoList();
	}
	
	private void setList() {
		Object[][] data = new Object[list.size()][];
		
		for(int i =0; i<data.length; i++) {
			data[i]=toArray(list.get(i));
		}
		CustomBookTableModel model = new CustomBookTableModel(data, getColumnNaems());
		table.setModel(model);
		
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
		setAlignAndWidth();
	}
	
	
	
	private Object[] toArray(BookInfo b) {
		
		return new Object[] {b.getBookNum(), b.getBookName(), b.getBookCan()};
	}
	
	//----- -----
	public BookInfo getItem() {
		int row = table.getSelectedRow();
		int bookNum = (int) table.getValueAt(row, 0);
				
		if(row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new BookInfo(bookNum)));
	}
	
	
	//----- -----
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 1);
		setTableCellAlign(SwingConstants.RIGHT,0,2);
		
		setTableCellWidth(100,250,200);
	}
	
	private void setTableCellAlign(int align, int...idx) {
		TableColumnModel tcm = table.getColumnModel();
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		
		for(int i =0; i<idx.length;i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
	private void setTableCellWidth(int...width) {
		TableColumnModel tcm = table.getColumnModel();
		
		for(int i =0; i<width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
}
