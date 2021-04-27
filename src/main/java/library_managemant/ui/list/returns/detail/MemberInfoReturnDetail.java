package library_managemant.ui.list.returns.detail;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import library_managemant.dto.MemberInfo;

@SuppressWarnings("serial")
public class MemberInfoReturnDetail extends JPanel {
	private JTextField tfHomeNo;
	private JTextField tfPhoneNo;
	private JTextField tfName;
	private JTextField tflYear;
	private JTextField tfMonth;
	private JTextField tfDay;
	private JTextField tfAddress;
	private JPanel panel1;
	private JPanel panel1_1;
	private JPanel panel1_2;
	private JPanel panel1_3;
	private JPanel panel2;
	

	public MemberInfoReturnDetail() {
		initialize();
	}

	public JTextField getTfHomeNo() {
		return tfHomeNo;
	}

	public void setTfHomeNo(JTextField tfHomeNo) {
		this.tfHomeNo = tfHomeNo;
	}

	public JTextField getTfPhoneNo() {
		return tfPhoneNo;
	}

	public void setTfPhoneNo(JTextField tfPhoneNo) {
		this.tfPhoneNo = tfPhoneNo;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}

	public JTextField getTflYear() {
		return tflYear;
	}

	public void setTflYear(JTextField tflYear) {
		this.tflYear = tflYear;
	}

	public JTextField getTfMonth() {
		return tfMonth;
	}

	public void setTfMonth(JTextField tfMonth) {
		this.tfMonth = tfMonth;
	}

	public JTextField getTfDay() {
		return tfDay;
	}

	public void setTfDay(JTextField tfDay) {
		this.tfDay = tfDay;
	}

	public JTextField getTfAddress() {
		return tfAddress;
	}

	public void setTfAddress(JTextField tfAddress) {
		this.tfAddress = tfAddress;
	}
	

	private void initialize() {
		setBorder(new TitledBorder(null, "\uB300\uC5EC\uD68C\uC6D0\uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 0, 0));

		panel1 = new JPanel();
		add(panel1);
		panel1.setLayout(new GridLayout(0, 1, 3, 3));

		panel1_1 = new JPanel();
		panel1.add(panel1_1);
		panel1_1.setLayout(new GridLayout(0, 2, 3, 3));

		JLabel lblName = new JLabel("이름:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1_1.add(lblName);

		tfName = new JTextField();
		tfName.setEditable(false);
		panel1_1.add(tfName);
		tfName.setColumns(5);

		panel1_2 = new JPanel();
		panel1.add(panel1_2);
		panel1_2.setLayout(new GridLayout(0, 7, 3, 3));

		JLabel lblBirths = new JLabel("생년월일:");
		lblBirths.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1_2.add(lblBirths);

		tflYear = new JTextField();
		tflYear.setEditable(false);
		panel1_2.add(tflYear);
		tflYear.setColumns(4);

		JLabel lblYear = new JLabel("년:");
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1_2.add(lblYear);

		tfMonth = new JTextField();
		tfMonth.setEditable(false);
		tfMonth.setColumns(2);
		panel1_2.add(tfMonth);

		JLabel lblMonth = new JLabel("월:");
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1_2.add(lblMonth);

		tfDay = new JTextField();
		tfDay.setEditable(false);
		tfDay.setColumns(2);
		panel1_2.add(tfDay);

		JLabel lblDay = new JLabel("일");
		lblDay.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1_2.add(lblDay);

		panel1_3 = new JPanel();
		panel1.add(panel1_3);
		panel1_3.setLayout(new GridLayout(0, 2, 3, 3));

		JLabel lblAddress = new JLabel("주소:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1_3.add(lblAddress);

		tfAddress = new JTextField();
		tfAddress.setEditable(false);
		tfAddress.setColumns(12);
		panel1_3.add(tfAddress);

		panel2 = new JPanel();
		add(panel2);
		panel2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_2 = new JPanel();
		panel2.add(panel_2);

		JPanel panel2_2 = new JPanel();
		panel2.add(panel2_2);
		panel2_2.setLayout(new GridLayout(0, 2, 3, 3));

		JLabel lblNewLabel = new JLabel("전화번호:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2_2.add(lblNewLabel);

		tfHomeNo = new JTextField();
		tfHomeNo.setEditable(false);
		panel2_2.add(tfHomeNo);
		tfHomeNo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("휴대전화:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2_2.add(lblNewLabel_1);

		tfPhoneNo = new JTextField();
		tfPhoneNo.setEditable(false);
		panel2_2.add(tfPhoneNo);
		tfPhoneNo.setColumns(10);
	}
	
	public void setItem(MemberInfo memberInfo) { 
		tfName.setText(memberInfo.getName());
		System.out.println(memberInfo.getName());
		tflYear.setText(memberInfo.getBirths().getYear()+1900+"");
		tfMonth.setText(memberInfo.getBirths().getMonth()+1+"");
		tfDay.setText(memberInfo.getBirths().getDay()+"");
		tfHomeNo.setText(memberInfo.getHomeNo());
		tfPhoneNo.setText(memberInfo.getPhoneNo());
		tfAddress.setText(memberInfo.getAdress());
	}

	public void clearTf() {
		tfHomeNo.setText("");
		tfPhoneNo.setText("");
		tfName.setText("");
		tflYear.setText("");
		tfMonth.setText("");
		tfDay.setText("");
		tfAddress.setText("");
	}

}
