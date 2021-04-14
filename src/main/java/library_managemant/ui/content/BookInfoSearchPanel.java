package library_managemant.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import library_managemant.dto.BookInfo;

import javax.swing.JButton;

public class BookInfoSearchPanel extends JPanel {
	private JTextField tfSearch;
	private JButton btnSearch;
	
	private JComboBox cmb1Search;
	private String[] bookInfo = {"도서제목"};

	
	public BookInfoSearchPanel() {
		initialize();
		addBookCmb1Search();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 4, 5, 5));
		
		JLabel lblSearch = new JLabel("빠른회원검색:");
		add(lblSearch);
		
		cmb1Search = new JComboBox();
		cmb1Search.setSelectedIndex(-1);
		add(cmb1Search);
		
		tfSearch = new JTextField();
		add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSearch = new JButton("검색");
		add(btnSearch);
	}
	
	private void addBookCmb1Search() {
		for(String f : bookInfo) {
			cmb1Search.addItem(f);
		}
	}
	
	public BookInfo getBookInfo() {
		int bookNum = Integer.parseInt(tfSearch.getText().trim());
		
		return new BookInfo(bookNum);
	}
	
	public void setBookInfo(BookInfo bookInfo) {
		tfSearch.setText(bookInfo.getBookNum()+"");
	}
	
	public void clearTf() {
		tfSearch.setText("");
	}
}
