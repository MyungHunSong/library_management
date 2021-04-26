package library_managemant.ui.content;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import library_managemant.dto.BookInfo;
import library_managemant.service.BookInfoService;
import library_managemant.ui.list.BookInfoSearchRentTablePanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BookSearchRentPanel extends JPanel implements ActionListener {
	private JTextField tfSearch;
	private JComboBox cmb1;
	private JButton btnSearch;
	
	private BookInfoSearchRentTablePanel bisrtp;
	private BookInfoService service = new BookInfoService();
	
	private String[] bookInfo = {"도서번호"};

	public void setBisrtp(BookInfoSearchRentTablePanel bisrtp) {
		this.bisrtp = bisrtp;
	}
	
	public BookSearchRentPanel() {
		initialize();
		bisrtp = new BookInfoSearchRentTablePanel();
		addBookCmb1Search();
		cmb1.setSelectedIndex(-1);
	}
	private void addBookCmb1Search() {
		for(String f : bookInfo) {
			cmb1.addItem(f);
		}
	}

	private void initialize() {
		setLayout(new GridLayout(0, 4, 3, 3));
		
		JLabel lblNewLabel = new JLabel("빠른회원검색:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel);
		
		cmb1 = new JComboBox();
		cmb1.addActionListener(this);
		add(cmb1);
		
		tfSearch = new JTextField();
		add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		add(btnSearch);
	}
	
	public void clearTf() {
		tfSearch.setText("");
	}

	public void actionPerformed(ActionEvent arg0) {
		try {
		if (arg0.getSource() == btnSearch) {
			btnSearchActionPerformed(arg0);
		}
		}catch (NullPointerException e) {
			bisrtp.loadData();
		}
	}

	protected void btnSearchActionPerformed(ActionEvent arg0) {
		if(cmb1.getSelectedItem().equals("도서번호")) {
			int bookInt = Integer.parseInt(tfSearch.getText());
			BookInfo bookInfo = new BookInfo(bookInt);
			System.out.println(bisrtp);
			bisrtp.loadBookInfo(bookInfo);
			System.out.println("BookInfo>>"+bookInfo);
			
			clearTf();
			cmb1.setSelectedIndex(-1); //검색창이 -1 일때 안보이게 하는거.
		}
	}
}
