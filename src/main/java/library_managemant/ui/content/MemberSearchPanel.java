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

import library_managemant.dto.MemberInfo;
import library_managemant.service.MemberService;
import library_managemant.ui.main.LibraryManagemantMain;

@SuppressWarnings("serial")
public class MemberSearchPanel extends JPanel implements ActionListener {
	private JTextField textField;
	private JButton btnSearch;
	
	private JComboBox cmb1;
	private String[] memInfo = {"회원 번호","회원 이름"};
	
	private LibraryManagemantMain libMan;
	private MemberService service;
	
	public MemberSearchPanel() {
		initialize();
		addDateCmb1();
	}
	
	//콤보박스.
	private void addDateCmb1(){
		
		for(String f : memInfo) {
			cmb1.addItem(f);
		}
		
	}
	
	// 요 기능 사용
	public MemberInfo getMemberInfo() {
		int memberNo = Integer.parseInt(textField.getText().trim());
		String memberName = textField.getText().trim();
		
		return new MemberInfo(memberNo, memberName);
	}
	public void setMemberInfo(MemberInfo memberInfo) {
		textField.setText(memberInfo.getMemberNo()+"");
		textField.setText(memberInfo.getName());
	}
	public void clearTf() {
		textField.setText("");
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
		panel.add(cmb1 );
		
		textField = new JTextField();
		textField.addActionListener(this);
		textField.setColumns(10);
		panel.add(textField);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		panel.add(btnSearch);
			
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == textField) {
			textFieldActionPerformed(e);
		}
		if (e.getSource() == btnSearch) {
			btnNewButtonActionPerformed(e);
			if(cmb1.equals("회원번호")&& textField.equals("회원번호")) {
				
			}
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "cmb1");
		
	}
	protected void textFieldActionPerformed(ActionEvent e) {
		 
		 
	}
}
