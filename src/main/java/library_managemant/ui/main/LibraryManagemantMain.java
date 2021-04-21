package library_managemant.ui.main;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import library_managemant.dto.RentReturn;
import library_managemant.service.BookInfoService;
import library_managemant.service.MemberService;
import library_managemant.service.RentReturnService;
import library_managemant.ui.content.BookInfoSearchPanel;
import library_managemant.ui.content.MemberSearchPanel;
import library_managemant.ui.list.BookInfoSearchTablePanel;
import library_managemant.ui.list.MemberSearchTablePanel;
import library_managemant.ui.list.RentReturnClickTablePanel;



@SuppressWarnings("serial")
public class LibraryManagemantMain extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnRent;
	private JButton btnReturn;
	private JPanel pMem;
	private BookInfoSearchTablePanel pBook;
	
	private MemberSearchPanel pMemSearch;
	private BookInfoSearchPanel pBookSearch;
	private MemberSearchTablePanel pMemTable;
	
	private MemberService memService = new MemberService();
	private BookInfoService bookService = new BookInfoService();
	
	private RentReturn rentReturn;
	private RentReturnService rentService = new RentReturnService();;
	
	private BookInfoSearchTablePanel pbookTable;
	
	private RentReturnClickTablePanel pRentTable;

	public void setBookService(BookInfoService bookService) {
		this.bookService = bookService;
	}


	public LibraryManagemantMain() { 
		initialize();
		
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		btnRent = new JButton("대출하기");
		btnRent.addActionListener(this);
		panel.add(btnRent);
		
		btnReturn = new JButton("반납하기");
		btnReturn.addActionListener(this);
		panel.add(btnReturn);
		
		JPanel pInfo = new JPanel();
		contentPane.add(pInfo, BorderLayout.CENTER);
		pInfo.setLayout(new GridLayout(0, 2, 10, 10));
		
		pMem = new JPanel();
		pInfo.add(pMem);
		pMem.setLayout(new BorderLayout(0, 0));
		
		pMemSearch = new MemberSearchPanel();
		pMem.add(pMemSearch, BorderLayout.NORTH);
		pMemSearch.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		//멤버 테이블
		pMemTable = new MemberSearchTablePanel();
		pMemTable.setService(memService);
		pMemTable.loadData();
		pMem.add(pMemTable, BorderLayout.CENTER);

		// 셋 으로 넣어주는 방법.
		pMemSearch.setMstp(pMemTable);
		
		pBook = new BookInfoSearchTablePanel();
		pInfo.add(pBook);
		pBook.setLayout(new BorderLayout(0, 0));
		
		pBookSearch = new BookInfoSearchPanel();
		pBook.add(pBookSearch, BorderLayout.NORTH);
		
		
		
		pbookTable = new BookInfoSearchTablePanel();
		pbookTable.setService(bookService);
		pbookTable.loadData();
		pBook.add(pbookTable, BorderLayout.CENTER);
		
		pBookSearch.setBistp(pbookTable);
		
		
//		pRentTable = pMemTable.getRentT();
//		pRentTable.setService(rentService);
//		contentPane.add(pRentTable, BorderLayout.SOUTH);
		
		pRentTable = new RentReturnClickTablePanel();
		pMemTable.setRentTable(pRentTable);
		pRentTable.setService(rentService);
		
		contentPane.add(pRentTable, BorderLayout.SOUTH);
	}
	

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReturn) {
			btnReturnActionPerformed(arg0);
		}
		if (arg0.getSource() == btnRent) {
			btnRentActionPerformed(arg0);
		}
	}
	//대여하기.
	protected void btnRentActionPerformed(ActionEvent arg0) {
		BookRent frame = new BookRent();
		frame.setVisible(true);
	}
	//반납하기.
	protected void btnReturnActionPerformed(ActionEvent arg0) {
		BookReturn frame = new BookReturn();
		frame.setVisible(true);
	}	
}
