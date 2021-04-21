package library_managemant.ui.list;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
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

import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;
import library_managemant.service.MemberService;
import library_managemant.service.RentReturnService;
import library_managemant.ui.exception.NotSelectedException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class MemberSearchTablePanel extends JPanel implements MouseListener{

	
	private List<MemberInfo> list;
	private JTable table;
	private JScrollPane scrollPane;
	
	private List<RentReturn> lists = new ArrayList<RentReturn>();
	private RentReturnService rService;
	
	private RentReturnClickTablePanel rentTable;
	private MemberService service;
	
	
	public void selectRentInfoByMemNo(RentReturn rentReturn) {
		lists = rService.selectRentInfoByMem(rentReturn);
	}
	
	// 서비스를 놓아주고 요서비스를 쓰기위한것.
	public void setrService(RentReturnService rService) {
		this.rService = rService;
	}

	//RentReturnClickTablePanel 생성후, table에 마우스 리스너를 달아주는것
	public MemberSearchTablePanel() {
		initialize();
		rentTable = new RentReturnClickTablePanel();
		table.addMouseListener(this);
	}
	
	//

	// --- 묶어 ----
	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.addMouseListener(this);
		table.setModel(getModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
	}
	
	

	// 내부 클래스 선언해서 열을 작성시켜주는 방법.
	class CustomTableModel extends DefaultTableModel {
		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}
		
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

	// 테이블에 들어갈 표를 짜주는것
	private DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}

	// 겟데이터 초기화식
	private Object[][] getData() {
		return new Object[][] { null, null, null, null };
	}

	// 열의 칸에 들어갈 제목을 짜준다.
	public String[] getColumnNames() {
		return new String[] { "회원번호", "이름", "전화번호", "휴대전화" };
	}

	// ---- 여기까지 ----
	public void loadData() {
		initList();
		setList();
	}
	
	public void loadData2(MemberInfo memInfo) {
		service = new MemberService();
		list = service.selectLikeMeminfo(memInfo);
		setList();
	}
	
	// 수정 불가 
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	public void initList() {
		service = new MemberService();
		list = service.showMemberInfoList();
	}

	// --- setList (겟을 위해서라면) ---
	public void setList() {
		Object[][] data = new Object[list.size()][];

		for (int i = 0; i < data.length; i++) {
			data[i] = toArray(list.get(i));
		}
		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);

		setAlignAndWidth();
	}
	// MemberService 를 쓰기위해서 MemberService를 설정 해주는것.
	public void setService(MemberService service) {
		this.service = service;
	}

	private Object[] toArray(MemberInfo m) {

		return new Object[] { m.getMemberNo(), m.getName(), m.getHomeNo(), m.getPhoneNo() };
	}

	// --- 위에 셋 리스트에 들어갈 목록들을 찝어주는것 ----
	public MemberInfo getItem() {
		int row = table.getSelectedRow();
		int memberNo = (int) table.getValueAt(row, 0);
		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new MemberInfo(memberNo)));
	}

	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 1);
		setTableCellAlign(SwingConstants.RIGHT, 0, 2);

		setTableCellWidth(100, 250, 200);
	}

	// 컬럼 내용 정렬
	private void setTableCellAlign(int align, int... idx) {
		TableColumnModel tcm = table.getColumnModel();

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();

		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}

	}

	// 컬럼 너비 조정.
	private void setTableCellWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();
		
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}

	}
	
	// 마우스 클릭시 뜨게하는기능
	
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == table) {
			tableMouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		//눌럿다 땟을떄
		if(e.getSource()==table) {
			mousePressedThisTable(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void tableMouseClicked(MouseEvent arg0) {
	}
	
	//마우스를 눌럿다 땟을때 나오게하는법
	private void mousePressedThisTable(MouseEvent e) {
		int idx = table.getSelectedRow();
		// 리스트 위치가 아닌 0번째 값으로찾기
		int memberNo = (int) table.getValueAt(idx, 0);
		if(idx==-1) {
			throw new NotSelectedException();
		}
			rService = new RentReturnService();
			rentTable.selectRentInfobyMem(new RentReturn(new MemberInfo(memberNo)));
			if(rService != null) {
				setVisible(true);
				
			}
			rentTable.setList();
	}
}
