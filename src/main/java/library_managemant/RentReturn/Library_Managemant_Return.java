package library_managemant.RentReturn;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Library_Managemant_Return extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField tfName;
	private JTextField tfMemNo;
	private JTextField tfYear;
	private JTextField tfMon;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	
	public Library_Managemant_Return() {
		initialize();
	}
	private void initialize() {
		setTitle("반납");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 10));
		
		JPanel pMain1 = new JPanel();
		contentPane.add(pMain1);
		pMain1.setLayout(new BorderLayout(0, 0));
		
		JPanel pMain1Sub1 = new JPanel();
		FlowLayout fl_pMain1Sub1 = (FlowLayout) pMain1Sub1.getLayout();
		fl_pMain1Sub1.setAlignment(FlowLayout.LEFT);
		pMain1.add(pMain1Sub1, BorderLayout.NORTH);
		
		JLabel lblSearch = new JLabel("검색방법:");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		pMain1Sub1.add(lblSearch);
		
		
		JComboBox comboBox = new JComboBox();
		pMain1Sub1.add(comboBox);
		
		textField = new JTextField();
		pMain1Sub1.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		pMain1Sub1.add(btnSearch);
		
		JPanel pMain1Sub2 = new JPanel();
		pMain1.add(pMain1Sub2, BorderLayout.CENTER);
		pMain1Sub2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		pMain1Sub2.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		pMain1Sub2.add(scrollPane, BorderLayout.EAST);
		
		JTextArea textArea = new JTextArea();
		pMain1Sub2.add(textArea, BorderLayout.CENTER);
		
		JPanel pMain2 = new JPanel();
		pMain2.setBorder(new TitledBorder(null, "\uB300\uC5EC\uD68C\uC6D0\uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pMain2);
		pMain2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pMain2Sub1 = new JPanel();
		FlowLayout fl_pMain2Sub1 = (FlowLayout) pMain2Sub1.getLayout();
		fl_pMain2Sub1.setAlignment(FlowLayout.LEFT);
		pMain2.add(pMain2Sub1);
		
		JLabel lblName = new JLabel("이름:");
		pMain2Sub1.add(lblName);
		
		tfName = new JTextField();
		pMain2Sub1.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblMemNo = new JLabel("회원번호:");
		pMain2Sub1.add(lblMemNo);
		
		tfMemNo = new JTextField();
		pMain2Sub1.add(tfMemNo);
		tfMemNo.setColumns(10);
		
		JPanel pMain2Sub2 = new JPanel();
		pMain2.add(pMain2Sub2);
		pMain2Sub2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblBirth = new JLabel("생년월일:");
		pMain2Sub2.add(lblBirth);
		
		tfYear = new JTextField();
		tfYear.setColumns(5);
		pMain2Sub2.add(tfYear);
		
		JLabel lblYear = new JLabel("년");
		pMain2Sub2.add(lblYear);
		
		tfMon = new JTextField();
		tfMon.setColumns(2);
		pMain2Sub2.add(tfMon);
		
		JLabel lblMon = new JLabel("월");
		pMain2Sub2.add(lblMon);
		
		textField_5 = new JTextField();
		textField_5.setColumns(2);
		pMain2Sub2.add(textField_5);
		
		JLabel label_3 = new JLabel("일");
		pMain2Sub2.add(label_3);
		
		JLabel lblNewLabel_3 = new JLabel("전화번호");
		pMain2Sub2.add(lblNewLabel_3);
		
		textField_6 = new JTextField();
		pMain2Sub2.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel pMain2Sub3 = new JPanel();
		FlowLayout fl_pMain2Sub3 = (FlowLayout) pMain2Sub3.getLayout();
		fl_pMain2Sub3.setAlignment(FlowLayout.LEFT);
		pMain2.add(pMain2Sub3);
		
		JLabel lblNewLabel_4 = new JLabel("주소:");
		pMain2Sub3.add(lblNewLabel_4);
		
		textField_7 = new JTextField();
		pMain2Sub3.add(textField_7);
		textField_7.setColumns(18);
		
		JLabel lblNewLabel_5 = new JLabel("휴대전화:");
		pMain2Sub3.add(lblNewLabel_5);
		
		textField_8 = new JTextField();
		pMain2Sub3.add(textField_8);
		textField_8.setColumns(12);
		
		JPanel pMain3 = new JPanel();
		pMain3.setBorder(new TitledBorder(null, "\uB300\uC5EC\uB3C4\uC11C\uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pMain3);
		pMain3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		pMain3.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JTextArea textArea_1 = new JTextArea();
		pMain3.add(textArea_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pMain3.add(scrollPane_1, BorderLayout.EAST);
		
		JPanel pMain4 = new JPanel();
		pMain4.setBorder(new TitledBorder(null, "\uB300\uC5EC\uB3C4\uC11C \uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pMain4);
		pMain4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("도서제목:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain4.add(lblNewLabel_7);
		
		textField_9 = new JTextField();
		pMain4.add(textField_9);
		textField_9.setColumns(15);
		
		JLabel lblNewLabel_8 = new JLabel("도서번호:");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain4.add(lblNewLabel_8);
		
		textField_10 = new JTextField();
		pMain4.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("도서구분:");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain4.add(lblNewLabel_9);
		
		textField_11 = new JTextField();
		pMain4.add(textField_11);
		textField_11.setColumns(10);
		
		JPanel pMain5 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pMain5.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		contentPane.add(pMain5);
		
		JButton btnNewButton = new JButton("New button");
		pMain5.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		pMain5.add(btnNewButton_1);
	}

}
