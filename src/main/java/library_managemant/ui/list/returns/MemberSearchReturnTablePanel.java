package library_managemant.ui.list.returns;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import library_managemant.dto.BookInfo;
import library_managemant.dto.MemberInfo;
import library_managemant.service.MemberService;
import library_managemant.ui.exception.NotSelectedException;
import library_managemant.ui.list.AbstractCustomTablePanel;
import library_managemant.ui.list.returns.detail.MemberInfoReturnDetail;
import library_managemant.ui.returnclick.ClickMemDetail;

@SuppressWarnings("serial")
public class MemberSearchReturnTablePanel extends AbstractCustomTablePanel<MemberInfo> implements MouseListener{
	private MemberInfoReturnDetail memDetail;
	
	private ClickMemDetail clickMemDetail;
	private MemberService service = new MemberService();
	
	private BookSearchReturnTablePanel bsrt = new BookSearchReturnTablePanel();
	
	
	
	public ClickMemDetail getClickMemDetail() {
		return clickMemDetail;
	}

	public void setClickMemDetail(ClickMemDetail clickMemDetail) {
		this.clickMemDetail = clickMemDetail;
	}

	public void setBsrt(BookSearchReturnTablePanel bsrt) {
		this.bsrt = bsrt;
	}
	
	public MemberService getService() {
		return service;
	}


	public void setService(MemberService service) {
			this.service = service;
		}
	
	public MemberInfoReturnDetail getMemDetail() {
		return memDetail;
	}

	public void setMemReturnDetail(MemberInfoReturnDetail memDetail) {
		this.memDetail = memDetail;
	}
	
	public MemberSearchReturnTablePanel() {
		initialize();
	}
	private void initialize() {
		table.addMouseListener(this);	
	}
	
	//리턴클릭테이블에서 클릭시 멤버로 받아와서 그사람만 뛰어주는 방법(다음 기회에 쓰도록)
	public void loadReturnMemberNo(int memNo) {
//		list = service.selectClickReturnTable(memNo);
//		setList();
	}
	
	// 클릭테이블에서 반납화면 회원정보에 넣어줄 값들
	
	
// 멤버번호 & 이름 검색법
	public void loadDataReturn(MemberInfo memInfo) {
		list = service.selectLikeMeminfo(memInfo);
		setList();
	}
	
	public void loadReturnTable() {
		list = service.SelectReturnByAll();
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
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		int idx=table.getSelectedRow();
		int memberNo = (int) table.getValueAt(idx, 0);
		if(idx == -1) {
			throw new NotSelectedException();
		}
		
		bsrt.loadReturnTable(new BookInfo(new MemberInfo(memberNo)));
		bsrt.setList();
	
		MemberInfo selectMemInfo = service.selectMemInfoDetail(memberNo);
		memDetail.setItem(selectMemInfo);
		
		bsrt.setVisible(true);		
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void thisTableMouseClicked(MouseEvent arg0) {
	}
}
