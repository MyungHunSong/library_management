package library_managemant.ui.list;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;

import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;
import library_managemant.service.MemberService;
import library_managemant.service.RentReturnService;
import library_managemant.ui.exception.NotSelectedException;
import library_managemant.ui.list.returns.detail.MemberInfoReturnDetail;
import library_managemant.ui.returnclick.ClickDirectReturn;

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
		return list.get(list.indexOf(new RentReturn(new MemberInfo(memberNo))));
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
		return new Object[] {
				String.format("%s", r.getMemberNum().getMemberNo())
				,String.format("%s", r.getBookNum1().getBookNum())
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

		ClickDirectReturn frame = new ClickDirectReturn();	
//		MemberInfo memberInfo = memService.selectClickReturnTable(memberNo);
//		System.out.println("memberInfo click >>" + memberInfo);
//		frame.getgetClickMemDetail().setItem(memberInfo);
		frame.setVisible(true);
				
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
