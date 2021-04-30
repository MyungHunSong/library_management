package library_managemant.ui.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import library_managemant.dto.BookInfo;
import library_managemant.dto.MemberInfo;
import library_managemant.service.BookInfoService;
import library_managemant.service.MemberService;
import library_managemant.service.RentReturnService;
import library_managemant.ui.Detail.BookInfoDetail;
import library_managemant.ui.Detail.MemberInfoDetail;
import library_managemant.ui.content.BookSearchRentPanel;
import library_managemant.ui.content.MemSearchRentPanel;
import library_managemant.ui.list.BookInfoSearchRentTablePanel;
import library_managemant.ui.list.BookInfoSearchTablePanel;
import library_managemant.ui.list.MemberSearchRentTablePanel;

@SuppressWarnings("serial")
public class BookRent extends JFrame implements ActionListener {

	private JPanel contentPane;
	private MemberService memService = new MemberService();
	
    private RentReturnService rentService = new RentReturnService(); // 트랜잭션 쓰자.
    
	private MemberSearchRentTablePanel rentMemTable; //= new MemberSearchRentTablePanel();
	
	
	private MemSearchRentPanel rentMemSearch;
	
	private BookInfoService bookService = new BookInfoService();
	
	private BookSearchRentPanel rentBookSearch;
	private BookInfoSearchRentTablePanel rentBookTable = new BookInfoSearchRentTablePanel();
	
	private MemberInfoDetail pMemDetail;
	
	
	private BookInfoDetail pBookDetail;
	private JButton btnRent;
	private JButton btnCansle;
	
	private BookInfoSearchTablePanel pistp = new BookInfoSearchTablePanel();
	
	public BookRent() {
		initialize();
	}
	
	public void setBookService(BookInfoService bookService) {
		this.bookService = bookService;
	}

	public MemberSearchRentTablePanel getRentMemTable() {
		return rentMemTable;
	}

	public void setRentMemTable(MemberSearchRentTablePanel rentMemTable) {
		this.rentMemTable = rentMemTable;
	}



	private void initialize() {
		setTitle("대여하기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		rentMemSearch = new MemSearchRentPanel();
		panel.add(rentMemSearch, BorderLayout.NORTH);
		
		rentMemTable = new MemberSearchRentTablePanel();
		rentMemTable.setService(memService);
		rentMemTable.loadData();
		panel.add(rentMemTable, BorderLayout.CENTER);
		
		rentMemSearch.setMsrtp(rentMemTable);
		
		// 디테일 패널에 글귀 들어오게 하기.
		pMemDetail = new MemberInfoDetail();//rentMemTable.getMemDetail(); // 멤버 디테일 테이블
		rentMemTable.setMemDetail(pMemDetail);// rentReturn테이블에다가
		contentPane.add(pMemDetail);
		

		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		
		
		rentBookSearch = new BookSearchRentPanel();
		panel_2.add(rentBookSearch, BorderLayout.NORTH);
		
		
		
		rentBookTable = new BookInfoSearchRentTablePanel();
		rentBookTable.setService(bookService);
		rentBookTable.loadData();
		panel_2.add(rentBookTable, BorderLayout.CENTER);
		
		
		
		rentBookSearch.setBisrtp(rentBookTable);
		
		
		
		pBookDetail = new BookInfoDetail();
		rentBookTable.setBookDetail(pBookDetail);
		contentPane.add(pBookDetail);
		
		
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_4);
		
		
		
		btnRent = new JButton("대여하기");
		btnRent.addActionListener(this);
		panel_4.add(btnRent);
		
		
		
		btnCansle = new JButton("취소");
		btnCansle.addActionListener(this);
		btnCansle.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(btnCansle);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCansle) {
			btnCansleActionPerformed(arg0);
		}
		if (arg0.getSource() == btnRent) {
			btnRentActionPerformed(arg0);
		}
	}
	protected void btnRentActionPerformed(ActionEvent arg0) {
		MemberInfo memNo = pMemDetail.getItemMemNo();
		BookInfo bookNo = pBookDetail.getItemBookNo();
		
		BookInfo bookCan = pBookDetail.getItemBookCan();
		
		String bookY = "대출가능";
		String bookN = "대출불가";
	try {
		if(bookCan.getBookCan().equals(bookY)) {
			rentService.insertRentService(memNo, bookNo);
			rentMemTable.loadData();
			rentBookTable.loadData();
			pMemDetail.clearTf();
			pBookDetail.clearTf();
			pistp.loadData();
			pistp.setList();
			JOptionPane.showMessageDialog(null, "도서 대여완료.");
			
		}else if(bookCan.getBookCan().equals(bookN)){
			JOptionPane.showMessageDialog(null, "대여중인 도서입니다.", "메세지",JOptionPane.ERROR_MESSAGE);
			rentMemTable.loadData();
			rentBookTable.loadData();
			pMemDetail.clearTf();
			pBookDetail.clearTf();
		}
	}catch (NullPointerException e) {
		JOptionPane.showMessageDialog(null, "대여 하실려면 도서를 선택해 주세요.","경고",JOptionPane.WARNING_MESSAGE);
	}
	}
	protected void btnCansleActionPerformed(ActionEvent arg0) {
		pMemDetail.clearTf();
		pBookDetail.clearTf();
	}
}
