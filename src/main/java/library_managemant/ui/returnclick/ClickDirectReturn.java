package library_managemant.ui.returnclick;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import library_managemant.ui.list.returns.MemberSearchReturnTablePanel;

@SuppressWarnings("serial")
public class ClickDirectReturn extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	
	private MemberSearchReturnTablePanel returnMemInfo = new MemberSearchReturnTablePanel();
	private ClickMemDetail panel;
	
	public MemberSearchReturnTablePanel getReturnMemInfo() {
		return returnMemInfo;
	}
	public void setReturnMemInfo(MemberSearchReturnTablePanel returnMemInfo) {
		this.returnMemInfo = returnMemInfo;
	}
	

	
	
	
	public ClickDirectReturn() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 4, 4));
		
		panel = new ClickMemDetail();
		contentPane.add(panel);
		
		ClickBookTable panel_1 = new ClickBookTable();
		contentPane.add(panel_1);
		
		ClickBookDetail panel_2 = new ClickBookDetail();
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		btnNewButton = new JButton("반납");
		btnNewButton.addActionListener(this);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		panel_3.add(btnNewButton_1);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			btnNewButtonActionPerformed(arg0);
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent arg0) {
	}
	
}
