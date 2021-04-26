package library_managemant.ui.list.returns;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import library_managemant.dto.MemberInfo;

@SuppressWarnings("serial")
public class MemberSearchReturnPanel extends JPanel implements ActionListener {
	private MemberSearchReturnTablePanel mstrpReturn;


	public void setMstrpReturn(MemberSearchReturnTablePanel mstrpReturn) {
		this.mstrpReturn = mstrpReturn;
	}
	private JTextField tfSearch;
	private JButton btnSearch;
	
	private JComboBox cmb1;
	private String[] memInfo= {"회원번호", "회원이름"};
	
	
	
	
	public MemberSearchReturnPanel() {
		initialize();
		addDateCmb1();
		cmb1.setSelectedIndex(-1);
	}
	
	private void addDateCmb1() {
		for(String s: memInfo) {
			cmb1.addItem(s);
		}
	}
	
	public void clearTf() {
		tfSearch.setText("");
	}
	
	private void initialize() {
		setLayout(new GridLayout(1, 0, 5, 5));
		
		JLabel lblSearch = new JLabel("빠른 회원 검색:");
		lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSearch);
		
		cmb1 = new JComboBox();
		add(cmb1);
		
		tfSearch = new JTextField();
		add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		add(btnSearch);
	}
	
	public void actionPerformed(ActionEvent arg0) {
	try {
		if (arg0.getSource() == btnSearch) {
			btnSearchActionPerformed(arg0);
		}
		
	}catch (NullPointerException e) {
		mstrpReturn.loadData();
		
	}
	
		
	}
	protected void btnSearchActionPerformed(ActionEvent arg0) {
		if(cmb1.getSelectedItem().equals("회원번호")) {
			int memInt = Integer.parseInt(tfSearch.getText());
			MemberInfo memInfo = new MemberInfo(memInt,"뭐고!");
			System.out.println(mstrpReturn);
			mstrpReturn.loadDataReturn(memInfo);
			clearTf();
			cmb1.setSelectedIndex(-1);
		}else if(cmb1.getSelectedItem().equals("회원이름")) {
			String memName = tfSearch.getText();
			MemberInfo memInfo = null;
			memInfo = new MemberInfo(99999, memName);
			mstrpReturn.loadDataReturn(memInfo);
			clearTf();
		}
		
	}

}
