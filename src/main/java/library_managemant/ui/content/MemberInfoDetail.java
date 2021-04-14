package library_managemant.ui.content;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MemberInfoDetail extends JPanel {
	private JTextField tfArea;

	public MemberInfoDetail() {
		
		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "\uB300\uC5EC\uD68C\uC6D0\uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		tfArea = new JTextField();
		tfArea.setEditable(false);
		scrollPane.setViewportView(tfArea);
		tfArea.setColumns(10);
	}

}
