package library_managemant.ui.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import library_managemant.service.BookInfoService;
import library_managemant.service.MemberService;
import library_managemant.ui.list.returns.BookSearchReturnPanel;
import library_managemant.ui.list.returns.BookSearchReturnTablePanel;
import library_managemant.ui.list.returns.MemberSearchReturnPanel;
import library_managemant.ui.list.returns.MemberSearchReturnTablePanel;
import library_managemant.ui.list.returns.detail.BookInfoReturnDetail;
import library_managemant.ui.list.returns.detail.MemberInfoReturnDetail;

@SuppressWarnings("serial")
public class BookReturn extends JFrame {

	private JPanel contentPane;
	
	private MemberSearchReturnPanel pMemSearch;
	private MemberSearchReturnTablePanel returnMemInfo;
	
	private BookSearchReturnPanel returnBookSearch;
	private BookSearchReturnTablePanel  returnBookInfo;
	
	private MemberService memService = new MemberService();
	private BookInfoService bookService;
	private MemberInfoReturnDetail pMemDetail;
	private BookInfoReturnDetail pBookDetail;
	
	
	
	
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
		
		// 회원반납목록
		returnMemInfo = new MemberSearchReturnTablePanel();
		returnMemInfo.setService(memService);
		returnMemInfo.loadData();
		panel.add(returnMemInfo, BorderLayout.CENTER);
		
		pMemSearch.setMstrpReturn(returnMemInfo);
		
		pMemDetail = new MemberInfoReturnDetail();
		returnMemInfo.setMemReturnDetail(pMemDetail);
		contentPane.add(pMemDetail);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		returnBookSearch = new BookSearchReturnPanel();
		panel_2.add(returnBookSearch, BorderLayout.NORTH);
		
		
		// pBookReturnTable
		returnBookInfo = new BookSearchReturnTablePanel();
		returnBookInfo.setService(bookService);
		returnBookInfo.loadData();
		panel_2.add(returnBookInfo, BorderLayout.CENTER);
		
		returnBookSearch.setBistp(returnBookInfo);
		
		pBookDetail = new BookInfoReturnDetail();
		returnBookInfo.setBookDetail(pBookDetail);
		contentPane.add(pBookDetail);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_4);
		
		JButton btnReturn = new JButton("반납하기");
		panel_4.add(btnReturn);
		
		JButton btnCansle = new JButton("취소");
		panel_4.add(btnCansle);
	}

}
