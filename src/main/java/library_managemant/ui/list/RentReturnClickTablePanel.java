package library_managemant.ui.list;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;

import library_managemant.service.RentReturnService;

@SuppressWarnings("serial")
public class RentReturnClickTablePanel extends JPanel {
	private JTable table;
	private RentReturn rentRe;
	
	private RentReturnService service;
	
	private MemberSearchTablePanel mstp1;
	private List<RentReturn> list;
	
	
	public void selectRentInfobyMem(RentReturn rentReturn) {
		service = new RentReturnService();
		list=service.selectRentInfoByMem(rentReturn);
	}
	
	public void setMstp1(MemberSearchTablePanel mstp1) {
		this.mstp1 = mstp1;
	}
	
	public RentReturnClickTablePanel() {
		initialize();
	}
	
	public void loadData() {
		list = new ArrayList<RentReturn>();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(getModel());
		
		scrollPane.setViewportView(table);
	}
	
	class CustomTableModel extends DefaultTableModel{
		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}
	}
	
	private DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}
	// --- 위쪽 컬럼 내용 로우 받아오는곳
	private Object[][] getData() {
		
		return new Object[][] {null, null, null, null,null};
	}
	
	public String[] getColumnNames() {
		return new String[] {"회원번호","도서번호","도서제목","도서대여일","도서연체일"};
	}
	// ---- 이곳까지 ----
	
	
	public void setService(RentReturnService service) {
		this.service = service;
	}	
	
	public void setList() {
		Object[][] data = new Object[list.size()][];
		
		for(int i=0; i<data.length; i++) {
			data[i] = toArray(list.get(i));
		}
		
		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);
		
		//컬럼 클릭 정렬
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
		setAlignAndWidth();
	}

	private void setAlignAndWidth() {
		
		setTableAlign(SwingConstants.CENTER, 0,1,2);
				
		setTableCellWidth(100,250,100);
		
	}
	
	protected void setTableCellWidth(int...width) {
		TableColumnModel tcm = table.getColumnModel();
		
		for(int i=0; i<width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	protected void setTableAlign(int align, int...idx) {
		TableColumnModel tcm =table.getColumnModel();
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		for(int i=0; i<idx.length; i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

	
	private Object[] toArray(RentReturn r) {
		
		return new Object[] {r.getMemberNo1().getMemberNo()
				,r.getRentNo1().getBookNum()
				,r.getRentNo1().getBookName()
				,r.getBookRent(),r.getBookOver()};
	}
}
