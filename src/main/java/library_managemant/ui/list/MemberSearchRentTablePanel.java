package library_managemant.ui.list;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import library_managemant.dto.MemberInfo;
import library_managemant.service.MemberService;
import library_managemant.ui.Detail.MemberInfoDetail;
import library_managemant.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class MemberSearchRentTablePanel extends AbstractCustomTablePanel<MemberInfo> implements MouseListener{
	private MemberInfoDetail memDetail;
	private MemberService service;
	  
	public void setService(MemberService service) {
			this.service = service;
		}
	public MemberInfoDetail getMemDetail() {
		return memDetail;
	}

	public void setMemDetail(MemberInfoDetail memDetail) {
		this.memDetail = memDetail;
	}
	
	public MemberSearchRentTablePanel() {
		initialize();
	}
	private void initialize() {
		table.addMouseListener(this);
	}
	
	public void loadDataRent(MemberInfo memInfo) {
		service = new MemberService();
		list = service.selectLikeMeminfo(memInfo);
		setList();
	}

	class CustomTableModel extends DefaultTableModel {
		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}
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
	
	public void loadDetail(MemberInfo memInfo) {
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
		setTableCellAlign(SwingConstants.LEFT, 0, 2);

		setTableCellWidth(100, 250, 200);
	}
	@Override
	public Object[] toArray(MemberInfo m) {
		return new Object[]{m.getMemberNo(),m.getName(),m.getHomeNo(),m.getPhoneNo()};
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
		int memberNo = (int) table.getValueAt(idx, 0);
		if(idx == -1) {
			throw new NotSelectedException();
		}
		
		MemberInfo selectMemInfo = service.selectMemInfoDetail(memberNo);
		System.out.println("selectMemInfo>>"+selectMemInfo);
		memDetail.setItem(selectMemInfo);
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void thisTableMouseClicked(MouseEvent arg0) {
	}
}
	
