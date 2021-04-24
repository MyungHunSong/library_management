package library_managemant.ui.content;

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
import library_managemant.service.MemberService;
import library_managemant.ui.list.MemberSearchRentTablePanel;
import library_managemant.ui.list.MemberSearchTablePanel;

@SuppressWarnings("serial")
public class MemberSearchPanel extends JPanel implements ActionListener {
	private JTextField textField;
	private JButton btnSearch;
	
	private JComboBox cmb1;
	private String[] memInfo = {"회원 번호","회원 이름"};

	private MemberSearchTablePanel mstp; // 테이블 패널을 쓰기위해서 set 까지 해준모습이다.
	
	private MemberService service = new MemberService();
	
	public void setMstp(MemberSearchTablePanel mstp) {
		this.mstp = mstp;
	}

	public MemberSearchPanel() {
		initialize();
		addDateCmb1();
		cmb1.setSelectedIndex(-1);
	}
	
	private void addDateCmb1() {
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
		try {
			if (e.getSource() == btnSearch) {
				btnSearchActionPerformed(e);
			}
		}catch (NullPointerException e1) {
			mstp.loadData();
			e1.printStackTrace();
		}
		
	}

	protected void btnSearchActionPerformed(ActionEvent e) {
		if(cmb1.getSelectedItem().equals("회원 번호")){ // getSelectedItem:선택된 객체의 내용
				int memInt = Integer.parseInt(textField.getText());
				MemberInfo memInfo = new MemberInfo(memInt,"뭐하게");
				System.out.println(mstp);
				mstp.loadData2(memInfo);
				clearTf();
				cmb1.setSelectedIndex(-1);
		}else if(cmb1.getSelectedItem().equals("회원 이름")){
				String memName = textField.getText();
				MemberInfo memInfo = null;
				memInfo = new MemberInfo(999999,memName);
				mstp.loadData2(memInfo);
				clearTf();
		}	
	}
}
