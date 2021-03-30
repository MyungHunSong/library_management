package library_managemant.ui.list;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AbstratctCustomTablePanel<T> extends JPanel {
	private JTable table;
	public AbstratctCustomTablePanel() {
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
}
