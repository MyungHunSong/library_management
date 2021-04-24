package library_managemant.ui.Detail;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class BookInfoDetail extends JPanel {
	private JTextField textField;

	
	public BookInfoDetail() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "\uB300\uC5EC\uB3C4\uC11C\uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setEditable(false);
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
	}

}
