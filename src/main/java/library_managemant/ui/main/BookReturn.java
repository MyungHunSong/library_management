package library_managemant.ui.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import library_managemant.dto.BookInfo;
import library_managemant.dto.RentReturn;
import library_managemant.service.BookInfoService;
import library_managemant.service.MemberService;
import library_managemant.service.RentReturnService;
import library_managemant.ui.list.returns.BookSearchReturnPanel;
import library_managemant.ui.list.returns.BookSearchReturnTablePanel;
import library_managemant.ui.list.returns.MemberSearchReturnPanel;
import library_managemant.ui.list.returns.MemberSearchReturnTablePanel;
import library_managemant.ui.list.returns.detail.BookInfoReturnDetail;
import library_managemant.ui.list.returns.detail.MemberInfoReturnDetail;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BookReturn extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private MemberSearchReturnPanel pMemSearch;
	private MemberSearchReturnTablePanel returnMemInfo;
	
	private BookSearchReturnPanel returnBookSearch;
	private BookSearchReturnTablePanel  returnBookInfo;
	
	private MemberService memService = new MemberService();
	private BookInfoService bookService;
	private MemberInfoReturnDetail pMemDetail;
	private BookInfoReturnDetail pBookDetail;
	
	private RentReturnService rentService;
	private JPanel panel_1;
	private JButton btnReturn;
	private JButton btnCansle;
	
	public MemberSearchReturnTablePanel getReturnMemInfo() {
		return returnMemInfo;
	}
	
	public void setReturnMemInfo(MemberSearchReturnTablePanel returnMemInfo) {
		this.returnMemInfo = returnMemInfo;
	}
	
	public BookSearchReturnTablePanel getReturnBookInfo() {
		return returnBookInfo;
	}
	public void setReturnBookInfo(BookSearchReturnTablePanel returnBookInfo) {
		this.returnBookInfo = returnBookInfo;
	}
	
	public BookReturn() {
		initialize();
	}
	private void initialize() {
		setTitle("반납하기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 813, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		pMemSearch = new MemberSearchReturnPanel();
		
		panel.add(pMemSearch, BorderLayout.NORTH);
		
		// 회원 반납 목록이 이거말고 딴게 떠야한다.
		returnMemInfo = new MemberSearchReturnTablePanel();
		returnMemInfo.setService(memService);
		returnMemInfo.loadReturnTable();
		panel.add(returnMemInfo, BorderLayout.CENTER);
		
		pMemSearch.setMstrpReturn(returnMemInfo);
		
		pMemDetail = new MemberInfoReturnDetail();
		returnMemInfo.setMemReturnDetail(pMemDetail);
		contentPane.add(pMemDetail);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		// pBookReturnTable
		returnBookInfo = new BookSearchReturnTablePanel();
		returnMemInfo.setBsrt(returnBookInfo);
		returnBookInfo .setService(bookService);
		panel_1.add(returnBookInfo, BorderLayout.CENTER);
		
		
		
		pBookDetail = new BookInfoReturnDetail();
		returnBookInfo.setBookDetail(pBookDetail);
		contentPane.add(pBookDetail);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_4);
		
		btnReturn = new JButton("반납하기");
		btnReturn.addActionListener(this);
		panel_4.add(btnReturn);
		
		btnCansle = new JButton("취소");
		btnCansle.addActionListener(this);
		panel_4.add(btnCansle);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCansle) {
			btnCansleActionPerformed(arg0);
		}
		if (arg0.getSource() == btnReturn) {
			btnReturnActionPerformed(arg0);
		}
	}
	protected void btnReturnActionPerformed(ActionEvent arg0) {
		int rentNo = pBookDetail.getItemRentNo().getBookRent().getRentNo();
		
		try {		
			rentService.updateReturnService(new RentReturn(rentNo));
			returnMemInfo.loadData();
			returnBookInfo.loadData();
			pMemDetail.clearTf();
			pBookDetail.clearTf();
			JOptionPane.showInternalMessageDialog(null, "도서 반납완료.");
			
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "도서정보를 선택하세요.", "메세지", JOptionPane.WARNING_MESSAGE);
		}
	}
	protected void btnCansleActionPerformed(ActionEvent arg0) {
		pMemDetail.clearTf();
		pBookDetail.clearTf();
	}
}
