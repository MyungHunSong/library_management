package library_managemant.ui.list;

import java.util.List;

import javax.swing.JPanel;
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
import library_managemant.service.MemberService;
import library_managemant.ui.exception.NotSelectedException;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class MemberSearchTablePanel extends JPanel {

	private MemberService service;
	private List<MemberInfo> list;
	private JTable table;

	public MemberSearchTablePanel() {
		initialize();
	}

	// --- 묶어 ----
	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(getModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
	}

	// 내부 클래스 선언해서 열을 작성시켜주는 방법.
	class CustomTableModel extends DefaultTableModel {
		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
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

	// 서비스를 받아 오는 방법
	public void initList() {
		// 서비스 생성한게 없으니까 못받아 왔떤거다 한번 생성 해줘보면 나온다.
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
}
