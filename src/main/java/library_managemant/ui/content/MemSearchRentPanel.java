package library_managemant.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import library_managemant.dto.MemberInfo;
import library_managemant.service.MemberService;
import library_managemant.ui.list.MemberSearchRentTablePanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MemSearchRentPanel extends JPanel implements ActionListener {
	private JTextField tfSearch;
	private JButton btnSearch;
	
	private JComboBox cmb1;
	private String[] memInfo= {"회원번호", "회원이름"};
	
	//테이블 끌고오기
	private MemberSearchRentTablePanel msrtp;
	private MemberService service = new MemberService();
	
	public void setMsrtp(MemberSearchRentTablePanel msrtp) {
		this.msrtp = msrtp;
	}
	public MemSearchRentPanel() {
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
		msrtp.loadData();
	}
	
		
	}
	protected void btnSearchActionPerformed(ActionEvent arg0) {
		if(cmb1.getSelectedItem().equals("회원번호")) {
			int memInt = Integer.parseInt(tfSearch.getText());
			MemberInfo memInfo = new MemberInfo(memInt,"뭐고!");
			System.out.println(msrtp);
			msrtp.loadDataRent(memInfo);
			clearTf();
			cmb1.setSelectedIndex(-1);
		}else if(cmb1.getSelectedItem().equals("회원이름")) {
			String memName = tfSearch.getText();
			MemberInfo memInfo = null;
			memInfo = new MemberInfo(99999, memName);
			msrtp.loadDataRent(memInfo);
			clearTf();
		}
		
	}
}
