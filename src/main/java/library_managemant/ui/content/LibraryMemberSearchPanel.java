package library_managemant.ui.content;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import library_managemant.service.MemberService;
import library_managemant.ui.main.LibraryManagemantMain;

public class LibraryMemberSearchPanel extends JPanel implements ActionListener {
	private JTextField textField;
	private JButton btnSearch;
	private JComboBox cmb1;
	private String[] memInfo = {"회원 번호","회원 이름"};
	private LibraryManagemantMain libMan;
	private MemberService service;
	
	public LibraryMemberSearchPanel() {
		initialize();
		addDateCmb1();
	}
	
	//콤보박스.
	private void addDateCmb1(){
		
		for(String f : memInfo) {
			cmb1.addItem(f);
		}
		
	}
	
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel label = new JLabel("빠른 회원 검색:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label);
		
		cmb1 = new JComboBox();
		cmb1.setSelectedIndex(-1);
		cmb1.setMaximumRowCount(12);
		panel.add(cmb1 );
		
		textField = new JTextField();
		textField.addActionListener(this);
		textField.setColumns(10);
		panel.add(textField);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		panel.add(btnSearch);
			
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == textField) {
			textFieldActionPerformed(arg0);
		}
		if (arg0.getSource() == btnSearch) {
			btnNewButtonActionPerformed(arg0);
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(null, "cmb1");
		
	}
	protected void textFieldActionPerformed(ActionEvent arg0) {
		
	}
}
