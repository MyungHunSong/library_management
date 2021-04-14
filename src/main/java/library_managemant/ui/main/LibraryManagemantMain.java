package library_managemant.ui.main;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import library_managemant.service.BookInfoService;
import library_managemant.service.MemberService;
import library_managemant.ui.content.MemberSearchPanel;
import library_managemant.ui.list.MemberSearchTablePanel;
import library_managemant.ui.list.BookInfoSearchTablePanel;
import library_managemant.ui.content.BookInfoSearchPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



@SuppressWarnings("serial")
public class LibraryManagemantMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnRent;
	private JButton btnReturn;
	private JPanel pMem;
	private JPanel pBook;
	private MemberSearchPanel pMemSearch;
	private BookInfoSearchPanel pBookSearch;
	private MemberSearchTablePanel pMemInfo;
	private BookInfoSearchTablePanel pBookInfo;
	private JPanel panel_1;
	
	private MemberService memService;
	private BookInfoService bookService;
	
	private MemberSearchTablePanel mList;
	
	
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
		
		pMemInfo = new MemberSearchTablePanel();
		pMemInfo.loadData();
		pMem.add(pMemInfo, BorderLayout.CENTER);
		
		pBook = new JPanel();
		pInfo.add(pBook);
		pBook.setLayout(new BorderLayout(0, 0));
		
		pBookSearch = new BookInfoSearchPanel();
		
		
		pBook.add(pBookSearch, BorderLayout.NORTH);
		
		pBookInfo = new BookInfoSearchTablePanel();
		pBookInfo.loadData();
		pBook.add(pBookInfo, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uD604\uC7AC \uB300\uC5EC\uC911\uC778 \uB3C4\uC11C\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_2.add(panel_1, BorderLayout.CENTER);
	}
	
	// 목록 받아오기.
	protected void setService() {
		//memService = new MemberService();
	}
	
	//데이터 로드하는 기능
//	protected void tableLoadData() {
//		mList.setService(service);
//		mList.loadData();
//	}
	
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
