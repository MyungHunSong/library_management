package library_managemant.ui.list.returns.detail;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import library_managemant.dto.BookInfo;
import library_managemant.dto.RentReturn;
import library_managemant.service.RentReturnService;

@SuppressWarnings("serial")
public class BookInfoReturnDetail extends JPanel {
	private JTextField tfBookName;
	private JTextField tfBookNo;
	private JTextField tfBookKind;
	private BookInfo bookInfo;
	private RentReturn rentReturn;
	private RentReturnService returnService;
	private JLabel lblNewLabel_1;
	private JTextField tfRentNo;
	
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
	public BookInfoReturnDetail() {
		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "\uB300\uC5EC\uB3C4\uC11C\uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 5, 5));
		
		lblNewLabel_1 = new JLabel("대여번호:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		tfRentNo = new JTextField();
		tfRentNo.setEditable(false);
		add(tfRentNo);
		tfRentNo.setColumns(10);
		
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
	}
	
	public BookInfo getItmeBookNum() {
		String bookNum = tfBookNo.getText().trim();
		return new BookInfo(bookNum);
	}
	
	public BookInfo getItemRentNo() {
		int rentNo = Integer.parseInt(tfRentNo.getText().trim());
		return new BookInfo(new RentReturn(rentNo));	
	}
	
	public void setItem(BookInfo bookInfo) {
		tfRentNo.setText(bookInfo.getBookRent().getRentNo()+""); //도서 번호로 반납하기.		
		tfBookName.setText(bookInfo.getBookName());
		tfBookNo.setText(bookInfo.getBookNum()+"");
		tfBookKind.setText(bookInfo.getBookKind().getKindTitle());
	}
	
	public void clearTf() {
		tfRentNo.setText("");
		tfBookName.setText("");
		tfBookNo.setText("");;
		tfBookKind.setText("");
	}

}
