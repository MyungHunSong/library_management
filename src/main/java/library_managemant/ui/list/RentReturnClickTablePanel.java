package library_managemant.ui.list;

import javax.swing.SwingConstants;

import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;
import library_managemant.service.MemberService;
import library_managemant.service.RentReturnService;
import library_managemant.ui.exception.NotSelectedException;
import library_managemant.ui.list.returns.detail.MemberInfoReturnDetail;
import library_managemant.ui.main.BookReturn;

import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class RentReturnClickTablePanel extends AbstractCustomTablePanel<RentReturn> implements MouseListener{
	
	private RentReturnService service = new RentReturnService();
	private RentReturn rentReturn;
	
	private MemberInfoReturnDetail memDetail;	
	private MemberService memService = new MemberService();
	
	
	
	public MemberInfoReturnDetail getMemDetail() {
		return memDetail;
	}

	public void setMemDetail(MemberInfoReturnDetail memDetail) {
		this.memDetail = memDetail;
	}

	public RentReturn getRentReturn() {
		return rentReturn;
	}
	
	public RentReturnClickTablePanel() {
		initialize();
	}
	
	private void initialize() {
		table.setVisible(false);
		table.addMouseListener(this);
	}
	public void rentVisible() {
		table.setVisible(true);
	}
	
	
	public void setService(RentReturnService service) {
		this.service = service;
	}

	@Override
	public RentReturn getItem() {
		int row = table.getSelectedRow();
		int memberNo = (int) table.getValueAt(row, 0);
		
		if(row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new RentReturn(memberNo)));
	}

	@Override
	public void initList() { 
	}
	
	public void loadRentInfo(RentReturn rentReturn) {
		service = new RentReturnService();
		list = service.selectRentInfoByMem(rentReturn);
	}
	
	@Override
	public String[] getColumnNames() {
		
		return new String[]{"회원번호", "도서번호", "도서제목", "도서연체일", "도서대여일"};
	}
	

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 1);
		setTableCellAlign(SwingConstants.RIGHT, 0, 2);

		setTableCellWidth(100, 130, 150,270,270);
		
	}

	@Override
	public Object[] toArray(RentReturn r) {
		return new Object[] {r.getMemberNum()
				,r.getBookNum1()
				,r.getBookName().getBookName()
				,r.getBookOver
				(),r.getBookRent()};
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
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void thisTableMouseClicked(MouseEvent e) {
		int memberNo = getSelectIdx();
		BookReturn frame = new BookReturn();
		
		
		
		MemberInfo memberInfo = memService.SelectReturnDetail(memberNo);
		frame.getReturnMemInfo().getMemDetail().setItem(memberInfo);
		
		
		
		frame.setVisible(true);

		System.out.println("" + memberNo);
		
		
	
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
