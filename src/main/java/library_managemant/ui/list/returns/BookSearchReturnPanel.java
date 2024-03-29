package library_managemant.ui.list.returns;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import library_managemant.dto.BookInfo;

@SuppressWarnings("serial")
public class BookSearchReturnPanel extends JPanel implements ActionListener{
	private BookSearchReturnTablePanel bistp;
	
	

	public void setBistp(BookSearchReturnTablePanel bistp) {
		this.bistp = bistp;
	}
	private JTextField tfSearch;
	private JComboBox cmb1;
	private JButton btnSearch;
	

	private String[] bookInfo = {"도서번호"};
	

	public BookSearchReturnPanel() {
		initialize();
		bistp = new BookSearchReturnTablePanel();
		addBookCmb1Search();
		cmb1.setSelectedIndex(-1);
	}
	private void initialize() {
		setLayout(new GridLayout(0, 4, 5, 5));
		
		JLabel lblSearch = new JLabel("빠른회원검색:");
		add(lblSearch);
		
		cmb1 = new JComboBox();
		add(cmb1);

		tfSearch = new JTextField();
		
		add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		add(btnSearch);	
	}
	
	private void addBookCmb1Search() {
		for(String f : bookInfo) {
			cmb1.addItem(f);
		}
	}
	
	public BookInfo getBookInfo() {
		int bookNum = Integer.parseInt(tfSearch.getText().trim());
		
		return new BookInfo(bookNum);
	}
	// 북인포 에 북넘만 넣기
	public void setBookInfo(BookInfo bookInfo) {
		tfSearch.setText(bookInfo.getBookNum()+"");
	}
	
	// 텍스트 필드 초기화 기능
	public void clearTf() {
		tfSearch.setText("");
	}
	
	
	//검색 기능
	public void actionPerformed(ActionEvent e) {
		try {
		if (e.getSource() == btnSearch) {
			btnNewButtonActionPerformed(e);
		}
		}catch (NullPointerException n) {
			bistp.loadData();
		}
	
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		if(cmb1.getSelectedItem().equals("도서번호")) {
			int bookInt = Integer.parseInt(tfSearch.getText());
			BookInfo bookInfo = new BookInfo(bookInt);
			System.out.println(bistp);
			bistp.loadBookInfo(bookInfo);
			System.out.println("BookInfo>>"+bookInfo);
			
			clearTf();
			cmb1.setSelectedIndex(-1); //검색창이 -1 일때 안보이게 하는거.
		}
		
	}

}
