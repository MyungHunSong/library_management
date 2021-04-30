package library_managemant.ui.returnclick;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import library_managemant.dto.MemberInfo;
import library_managemant.ui.list.returns.MemberSearchReturnTablePanel;

@SuppressWarnings("serial")
public class ClickMemDetail extends JPanel {
	private JTextField tfMemNo;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfPhoneNo;
	private JTextField tfAdress;

	private MemberSearchReturnTablePanel memsearch = new MemberSearchReturnTablePanel();
	
	public MemberSearchReturnTablePanel getMemsearch() {
		return memsearch;
	}
	public void setMemsearch(MemberSearchReturnTablePanel memsearch) {
		this.memsearch = memsearch;
	}
	
	
	public ClickMemDetail() {
		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 3, 4));
		
		JLabel lblNewLabel = new JLabel("회원번호:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel);
		
		tfMemNo = new JTextField();
		tfMemNo.setEditable(false);
		add(tfMemNo);
		tfMemNo.setColumns(10);
		
		JLabel label = new JLabel("이름:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label);
		
		tfName = new JTextField();
		tfName.setEditable(false);
		tfName.setColumns(10);
		add(tfName);
		
		JLabel label_1 = new JLabel("생년월일:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_1);
		
		tfBirth = new JTextField();
		tfBirth.setEditable(false);
		tfBirth.setColumns(10);
		add(tfBirth);
		
		JLabel label_2 = new JLabel("휴대전화");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_2);
		
		tfPhoneNo = new JTextField();
		tfPhoneNo.setEditable(false);
		tfPhoneNo.setColumns(10);
		add(tfPhoneNo);
		
		JLabel label_3 = new JLabel("주소");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_3);
		
		tfAdress = new JTextField();
		tfAdress.setEditable(false);
		tfAdress.setColumns(10);
		add(tfAdress);
	}
	
	public void setItem(MemberInfo memberInfo) {
		tfMemNo.setText(memberInfo.getMemberNo()+"");
		tfName.setText(memberInfo.getName());
		System.out.println(memberInfo.getName());
		tfBirth.setText(memberInfo.getBirths()+"");
		tfPhoneNo.setText(memberInfo.getPhoneNo());
		tfAdress.setText(memberInfo.getAdress());
	}

	public void clearTf() {
		tfMemNo.setText("");
		tfName.setText("");
		System.out.println("");
		tfBirth.setText("");
		tfPhoneNo.setText("");
		tfAdress.setText("");
	}

}
