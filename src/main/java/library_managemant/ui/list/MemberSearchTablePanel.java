package library_managemant.ui.list;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import library_managemant.ui.Detail.MemberInfoDetail;
import library_managemant.ui.exception.NotSelectedException;
import library_managemant.ui.main.BookRent;


@SuppressWarnings("serial")
public class MemberSearchTablePanel extends JPanel implements MouseListener {

	private List<MemberInfo> list;
	private JTable table;
	private JScrollPane scrollPane;
	
	private MemberInfoDetail memDetail;
	private RentReturnClickTablePanel rentTable;

	private MemberService service;
	
	public MemberInfoDetail getMemDetail() {
		return memDetail;
	}

	public void setMemDetail(MemberInfoDetail memDetail) {
		this.memDetail = memDetail;
	}

	public RentReturnClickTablePanel getRentT() {
		return rentTable;
	}
	
	// 리턴 클릭 테이블 패널을 받아옴
	public void setRentTable(RentReturnClickTablePanel rentTable) {
		this.rentTable = rentTable;
	}



	//RentReturnClickTablePanel 생성후, table에 마우스 리스너를 달아주는것
	public MemberSearchTablePanel() {
		initialize();
		table.addMouseListener(this);
	}

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
		int memberNo = getSelectIdx();
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



	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getClickCount() == 3) {
			mouseDoubleClickBookRent();
		}
		
	}

	private void mouseDoubleClickBookRent() {

		try {
			
		int memberNo = getSelectIdx();
		rentTable.loadRentInfo(new RentReturn(new MemberInfo(memberNo)));
		rentTable.setList();
		
		} catch (NullPointerException n) {
			
			int memberNo = getSelectIdx();	
			BookRent frame = new BookRent();
			MemberInfo selectMemInfo = service.selectMemInfoDetail(memberNo);
			frame.getRentMemTable().getMemDetail().setItem(selectMemInfo);
			frame.setVisible(true);
		}

	}
	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		
		
		
	}
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == table) {
			mousePressedThisTable(e);
		}
		
	}
	protected void tableMouseClicked(MouseEvent arg0) {
		
	}
	
	private void mousePressedThisTable(MouseEvent e) {
		int memberNo = getSelectIdx();

		rentTable.loadRentInfo(new RentReturn(new MemberInfo(memberNo)));
		System.out.println("MemberSearchTablePanel MEMBERNO >> " +  memberNo);
		rentTable.setList();
		rentTable.rentVisible();
		
		try {
			rentTable.setList();
		}catch (NullPointerException n) {
			System.out.println(1);
		
		}finally {
			rentTable.rentVisible();
		}

	}

	private int getSelectIdx() {
		int idx = table.getSelectedRow();
		int memberNo = (int) table.getValueAt(idx, 0);
		if (idx == -1) {
			throw new NotSelectedException();
		}
		return memberNo;
	}
}
