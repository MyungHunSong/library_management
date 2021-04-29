package library_managemant.ui.Detail;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import library_managemant.dto.BookInfo;

@SuppressWarnings("serial")
public class BookInfoDetail extends JPanel {
	private JTextField tfBookName;
	private JTextField tfBookNo;
	private JTextField tfBookKind;
	private JLabel label_2;
	private JTextField tfBookCan;
	
	private BookInfo bookInfo;
	

	public BookInfo getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	
	public JTextField getTfBookName() {
		return tfBookName;
	}
	public void setTfBookName(JTextField tfBookName) {
		this.tfBookName = tfBookName;
	}
	public JTextField getTfBookNo() {
		return tfBookNo;
	}
	public void setTfBookNo(JTextField tfBookNo) {
		this.tfBookNo = tfBookNo;
	}
	public JTextField getTfBookKind() {
		return tfBookKind;
	}
	public void setTfBookKind(JTextField tfBookKind) {
		this.tfBookKind = tfBookKind;
	}
	public BookInfoDetail() {
		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "\uB300\uC5EC\uB3C4\uC11C\uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblNewLabel = new JLabel("		도서제목:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		tfBookName = new JTextField();
		tfBookName.setEditable(false);
		tfBookName.setHorizontalAlignment(SwingConstants.CENTER);
		add(tfBookName);
		tfBookName.setColumns(15);
		
		JLabel label = new JLabel("		도서번호:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
		
		tfBookNo = new JTextField();
		tfBookNo.setEditable(false);
		tfBookNo.setHorizontalAlignment(SwingConstants.CENTER);
		tfBookNo.setColumns(5);
		add(tfBookNo);
		
		JLabel label_1 = new JLabel("		도서구분:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_1);
		
		tfBookKind = new JTextField();
		tfBookKind.setEditable(false);
		tfBookKind.setHorizontalAlignment(SwingConstants.CENTER);
		tfBookKind.setColumns(5);
		add(tfBookKind);
		
		label_2 = new JLabel("		대출여부:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_2);
		
		tfBookCan = new JTextField();
		tfBookCan.setEditable(false);
		tfBookCan.setHorizontalAlignment(SwingConstants.CENTER);
		tfBookCan.setColumns(5);
		add(tfBookCan); 
	}
	
	public BookInfo getItemBookCan() {
		String bookCan = tfBookCan.getText().trim();
		return new BookInfo(bookCan);
	}
	
	public BookInfo getItemBookNo() {
		int bookNo = Integer.parseInt(tfBookNo.getText().trim());
		return new BookInfo(bookNo);
	}
	
	public void setItem(BookInfo bookInfo) {
		System.out.println(bookInfo);
		tfBookName.setText(bookInfo.getBookName());
		tfBookNo.setText(bookInfo.getBookNum()+"");
		tfBookKind.setText(bookInfo.getBookKind().getKindTitle());
		tfBookCan.setText(bookInfo.getBookCan());
	}
	
	public void clearTf() {
		tfBookName.setText("");
		tfBookNo.setText("");;
		tfBookKind.setText("");
		tfBookCan.setText("");
		
	}

}
