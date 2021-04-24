package library_managemant.ui.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import library_managemant.service.BookInfoService;
import library_managemant.service.MemberService;
import library_managemant.ui.Detail.BookInfoDetail;
import library_managemant.ui.Detail.MemberInfoDetail;
import library_managemant.ui.content.BookInfoSearchPanel;
import library_managemant.ui.content.MemSearchRentPanel;
import library_managemant.ui.list.BookInfoSearchTablePanel;
import library_managemant.ui.list.MemberSearchRentTablePanel;

@SuppressWarnings("serial")
public class BookRent extends JFrame {

	private JPanel contentPane;
	
	private BookInfoSearchPanel pBookSearch;
	
	
	private MemberService memService = new MemberService();
	
	private MemberSearchRentTablePanel rentMemTable = new MemberSearchRentTablePanel();
	private MemSearchRentPanel rentMemSearch;
	private MemberInfoDetail memInfoDetail; // 이친구 받아오는 테이블
	
	
	private BookInfoService bookService = new BookInfoService();
	
	private BookInfoSearchPanel rentBookSearch;
	private BookInfoSearchTablePanel rentBookTable;
	private MemberInfoDetail pMemDetail;
	
	public BookRent() {
		initialize();
	}
	
	
	
//	public void setMemSevice(MemberService memSevice) {
//		this.memService = memSevice;
//	}
//
//	public void setpBookInfo(BookInfoSearchTablePanel pBookInfo) {
//		this.pBookInfo = pBookInfo;
//	}


	public MemberSearchRentTablePanel getRentMemTable() {
		return rentMemTable;
	}



	public void setRentMemTable(MemberSearchRentTablePanel rentMemTable) {
		this.rentMemTable = rentMemTable;
	}



	private void initialize() {
		setTitle("대여하기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		pMemDetail = new MemberInfoDetail(); // 멤버 디테일 테이블
//		pMemDetail.getMsrtp();
//		rentMemTable.setMemDetail(memInfoDetail);// rentReturn테이블에다가
//		pMemDetail.setMemService(memService);
		contentPane.add(pMemDetail);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		rentBookSearch = new BookInfoSearchPanel();
		panel_2.add(rentBookSearch, BorderLayout.NORTH);
		
		rentBookTable = new BookInfoSearchTablePanel();
		rentBookTable.setService(bookService);
		rentBookTable.loadData();
		panel_2.add(rentBookTable, BorderLayout.CENTER);
		
		rentBookSearch.setBistp(rentBookTable);
		
		BookInfoDetail panel_3 = new BookInfoDetail();
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_4);
		
		JButton btnRent = new JButton("대여하기");
		panel_4.add(btnRent);
		
		JButton btnCansle = new JButton("취소");
		btnCansle.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(btnCansle);
	}
}
