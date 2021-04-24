package library_managemant.ui.list;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;
import library_managemant.service.RentReturnService;
import library_managemant.ui.exception.NotSelectedException;
import library_managemant.ui.main.BookRent;

@SuppressWarnings("serial")
public class RentReturnClickTablePanel extends AbstractCustomTablePanel<RentReturn>{
	
	private RentReturnService service = new RentReturnService();
	private RentReturn rentReturn;
	private MemberSearchTablePanel memTable = new MemberSearchTablePanel();
	
	public RentReturn getRentReturn() {
		return rentReturn;
	}
	
	public RentReturnClickTablePanel() {
		initialize();
	}
	
	private void initialize() {
		table.setVisible(false);
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
		if(list == null) {
			JOptionPane.showMessageDialog(null, "대여 중인 도서 목록이 없습니다.");
			BookRent frame = new BookRent();
			frame.setVisible(true);
		}
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
}
