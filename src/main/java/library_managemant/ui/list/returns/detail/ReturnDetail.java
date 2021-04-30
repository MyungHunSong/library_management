package library_managemant.ui.list.returns.detail;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

import library_managemant.dto.BookInfo;
import library_managemant.dto.MemberInfo;
import library_managemant.dto.RentReturn;
import library_managemant.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class ReturnDetail extends JPanel {
	private JTextField tfRentNo;
	private JTextField tfMemberNo;
	private JTextField tfBooName;
	private JTextField tfBookNum;
	private JTextField tfBookRent;
	private JLabel lblNewLabel_1;
	private JTextField tfBookOver;

	
	public ReturnDetail() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 4, 4));
		
		JLabel lblNewLabel = new JLabel("대여번호:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		tfRentNo = new JTextField();
		tfRentNo.setEditable(false);
		add(tfRentNo);
		tfRentNo.setColumns(10);
		
		JLabel lblD = new JLabel("회원번호:");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblD);
		
		tfMemberNo = new JTextField();
		tfMemberNo.setEditable(false);
		tfMemberNo.setColumns(10);
		add(tfMemberNo);
		
		JLabel label_1 = new JLabel("도서제목:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_1);
		
		tfBooName = new JTextField();
		tfBooName.setEditable(false);
		tfBooName.setColumns(10);
		add(tfBooName);
		
		JLabel label_2 = new JLabel("도서번호:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_2);
		
		tfBookNum = new JTextField();
		tfBookNum.setEditable(false);
		tfBookNum.setColumns(10);
		add(tfBookNum);
		
		JLabel label_3 = new JLabel("대여일자:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_3);
		
		tfBookRent = new JTextField();
		tfBookRent.setEditable(false);
		tfBookRent.setHorizontalAlignment(SwingConstants.TRAILING);
		tfBookRent.setColumns(10);
		add(tfBookRent);
		
		lblNewLabel_1 = new JLabel("연체일자:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		tfBookOver = new JTextField();
		tfBookOver.setEditable(false);
		add(tfBookOver);
		tfBookOver.setColumns(10);
	}
	
	public void setItem(RentReturn item) {
		if (item == null) {
			throw new NotSelectedException();
		}
		tfRentNo.setText(String.valueOf(item.getRentNo()));
		tfMemberNo.setText(String.valueOf(item.getMemberNum().getMemberNo()));
		tfBooName.setText(String.valueOf(item.getBookName()));       
		tfBookNum.setText(String.valueOf(item.getBookNum1()));
		tfBookOver.setText(String.valueOf(item.getBookOver()));
		tfBookRent.setText(String.valueOf(item.getBookRent()));
	}
	
	public RentReturn getItem() {
		
		int rentNo = Integer.parseInt(tfRentNo.getText().trim());
		MemberInfo memNo = new MemberInfo(Integer.parseInt(tfMemberNo.getText().trim()));
	//	BookInfo bookName = new BookInfo(tfBooName.getText().trim());
		BookInfo bookNo = new BookInfo(Integer.parseInt(tfBookNum.getText().trim())); 
		int bookOver = Integer.parseInt(tfBookOver.getText().trim());
		return new RentReturn(rentNo, memNo, bookNo, bookOver);
	}
	
	public RentReturn getItemRentNo() {
		int rentNo = Integer.parseInt(tfRentNo.getText().trim());
		return new RentReturn(rentNo);
	}
	public RentReturn getItemBookNo() {
		BookInfo bookNo = new BookInfo(Integer.parseInt(tfBookNum.getText().trim()));
		return new RentReturn(bookNo);
	}
	
	public void clearTf() {
		  tfRentNo.setText("");
		 tfMemberNo.setText("");
		tfBooName.setText("");
		tfBookNum.setText("");
		tfBookRent.setText("");
		tfBookOver.setText("");
	}
	public JTextField getTfRentNo() {
		return tfRentNo;
	}
	public void setTfRentNo(JTextField tfRentNo) {
		this.tfRentNo = tfRentNo;
	}
	public JTextField getTfMemberNo() {
		return tfMemberNo;
	}
	public void setTfMemberNo(JTextField tfMemberNo) {
		this.tfMemberNo = tfMemberNo;
	}
	public JTextField getTfBooName() {
		return tfBooName;
	}
	public void setTfBooName(JTextField tfBooName) {
		this.tfBooName = tfBooName;
	}
	public JTextField getTfBookNum() {
		return tfBookNum;
	}
	public void setTfBookNum(JTextField tfBookNum) {
		this.tfBookNum = tfBookNum;
	}
	public JTextField getTfBookRent() {
		return tfBookRent;
	}
	public void setTfBookRent(JTextField tfBookRent) {
		this.tfBookRent = tfBookRent;
	}
	public JTextField getTfBookOver() {
		return tfBookOver;
	}
	public void setTfBookOver(JTextField tfBookOver) {
		this.tfBookOver = tfBookOver;
	}
	
	
}
