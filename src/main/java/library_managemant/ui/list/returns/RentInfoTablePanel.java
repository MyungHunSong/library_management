package library_managemant.ui.list.returns;

import javax.swing.SwingConstants;

import library_managemant.dto.BookInfo;
import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;
import library_managemant.service.RentReturnService;
import library_managemant.ui.exception.NotSelectedException;
import library_managemant.ui.list.AbstractCustomTablePanel;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class RentInfoTablePanel extends AbstractCustomTablePanel<RentReturn> implements MouseListener {
	private RentReturnService rentService;
	
	public void setRentService(RentReturnService rentService) {
		this.rentService = rentService;
	}
	
	public RentInfoTablePanel() {
		initialize();
	}
	
	private void initialize() {
		table.addMouseListener(this);
	}
	
	public void selectReturnByMemNo(MemberInfo memNo) {
		list = rentService.showRentReturnListMemNo(memNo);
	}
	
	// 렌트 번호랑 , 책 번호 받아오기
	public RentReturn getRentNo() {
		int row = table.getSelectedRow();
		int rentNo = (int) table.getValueAt(row, 0);
		int bookNo = (int) table.getValueAt(row, 1);

		return new RentReturn(rentNo, new BookInfo(bookNo));
	}
	
	@Override
	public RentReturn getItem() {
		int row = table.getSelectedRow();
		int rentNo = (int) table.getValueAt(row, 0);

		if (row == -1) {
			throw new NotSelectedException();
		}

		return list.get(list.indexOf(new RentReturn(rentNo)));	
	}

	@Override
	public void initList() {
		list = new ArrayList<RentReturn>();
	}

	@Override
	public String[] getColumnNames() {
		
		return new String[] {"도서번호","도서제목","도서연체일","도서대여일"};
	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 1);
		setTableCellAlign(SwingConstants.RIGHT, 0, 2);
		setTableCellWidth(100,100,500,130,150);		
	}

	@Override
	public Object[] toArray(RentReturn t) {
		
		return new Object[] {t.getRentNo(), t.getBookNum1().getBookNum(),t.getBookName() ,t.getBookRent(), t.getBookRent()};
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == table) {
			thisTableMouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void thisTableMouseClicked(MouseEvent arg0) {
		int row = table.getSelectedRow();
		int rentNo = (int)table.getValueAt(row, 0);
		
	}
}
