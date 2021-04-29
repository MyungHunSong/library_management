package library_managemant.ui.returnclick;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import library_managemant.dto.BookInfo;

@SuppressWarnings("serial")
public class ClickBookDetail extends JPanel {
	private JTextField tfBookNum;
	private JTextField tfBookName;
	private JTextField tfBookKind;

	public ClickBookDetail() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 4, 4));
		
		JLabel lblNewLabel = new JLabel("도서번호:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel);
		
		tfBookNum = new JTextField();
		tfBookNum.setEditable(false);
		tfBookNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfBookNum);
		tfBookNum.setColumns(10);
		
		JLabel label = new JLabel("도서제목:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label);
		
		tfBookName = new JTextField();
		tfBookName.setEditable(false);
		tfBookName.setHorizontalAlignment(SwingConstants.RIGHT);
		tfBookName.setColumns(10);
		add(tfBookName);
		
		JLabel label_1 = new JLabel("도서구분:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_1);
		
		tfBookKind = new JTextField();
		tfBookKind.setEditable(false);
		tfBookKind.setHorizontalAlignment(SwingConstants.RIGHT);
		tfBookKind.setColumns(10);
		add(tfBookKind);
	}
	
	public void setItem(BookInfo bookInfo) {
		tfBookNum.setText(bookInfo.getBookNum()+"");
		tfBookName.setText(bookInfo.getBookName());
		tfBookKind.setText(bookInfo.getBookKind().getKindTitle());
	}
	
	public void clearTf() {
		tfBookNum.setText("");
		tfBookName.setText("");
		tfBookKind.setText("");
	}

}
