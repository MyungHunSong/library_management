package library_managemant.RentReturn;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Library_Managemant_Rent extends JFrame {

	private JPanel contentPane;
	private JTextField tfMemTyping;
	private JTextField tfName;
	private JTextField tfMemNo;
	private JTextField tfYear;
	private JTextField tfMonth;
	private JTextField tfDay;
	private JTextField tflblHomePhone;
	private JTextField tfAdress;
	private JTextField tfPhone;
	private JTextField tfBookTyping;
	private JTextField tfBookName;
	private JTextField tfBookNo;
	private JTextField tfBookKind;

	
	

	
	public Library_Managemant_Rent() {
		initialize();
	}
	private void initialize() {
		setTitle("대여");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 670);
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
		
		JLabel lblFind1 = new JLabel("검색방법:");
		lblFind1.setHorizontalAlignment(SwingConstants.CENTER);
		pMain1Sub1.add(lblFind1);
		
		JComboBox cmbMemNo = new JComboBox();
		pMain1Sub1.add(cmbMemNo);
		
		tfMemTyping = new JTextField();
		pMain1Sub1.add(tfMemTyping);
		tfMemTyping.setColumns(10);
		
		JButton btnMemSearch = new JButton("검색");
		pMain1Sub1.add(btnMemSearch);
		
		JPanel pMain1Sub2 = new JPanel();
		pMain1.add(pMain1Sub2, BorderLayout.CENTER);
		pMain1Sub2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMember = new JLabel("회원번호            이름            전화번호            휴대전화");
		pMain1Sub2.add(lblMember, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		pMain1Sub2.add(scrollPane, BorderLayout.EAST);
		
		JTextArea textArea = new JTextArea();
		pMain1Sub2.add(textArea, BorderLayout.CENTER);
		
		JPanel pMain2 = new JPanel();
		pMain2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uB300\uC5EC\uD68C\uC6D0\uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		JLabel lblNewLabel_3 = new JLabel("회원번호:");
		pMain2Sub1.add(lblNewLabel_3);
		
		tfMemNo = new JTextField();
		pMain2Sub1.add(tfMemNo);
		tfMemNo.setColumns(10);
		
		JPanel pMain2Sub2 = new JPanel();
		pMain2Sub2.setBorder(new EmptyBorder(0, 0, 0, 0));
		pMain2.add(pMain2Sub2);
		pMain2Sub2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pSub2Sub1 = new JPanel();
		FlowLayout fl_pSub2Sub1 = (FlowLayout) pSub2Sub1.getLayout();
		fl_pSub2Sub1.setHgap(7);
		fl_pSub2Sub1.setAlignment(FlowLayout.LEFT);
		pMain2Sub2.add(pSub2Sub1);
		
		JLabel lblBirths = new JLabel("생년월일:");
		pSub2Sub1.add(lblBirths);
		
		tfYear = new JTextField();
		pSub2Sub1.add(tfYear);
		tfYear.setColumns(8);
		
		JLabel lblYear = new JLabel("년");
		pSub2Sub1.add(lblYear);
		
		tfMonth = new JTextField();
		pSub2Sub1.add(tfMonth);
		tfMonth.setColumns(2);
		
		JLabel lblMonth = new JLabel("월");
		pSub2Sub1.add(lblMonth);
		
		tfDay = new JTextField();
		pSub2Sub1.add(tfDay);
		tfDay.setColumns(2);
		
		JLabel lblDay = new JLabel("일");
		pSub2Sub1.add(lblDay);
		
		JPanel pSub2Sub2 = new JPanel();
		FlowLayout fl_pSub2Sub2 = (FlowLayout) pSub2Sub2.getLayout();
		fl_pSub2Sub2.setHgap(8);
		fl_pSub2Sub2.setAlignment(FlowLayout.LEFT);
		pMain2Sub2.add(pSub2Sub2);
		
		JLabel lblHomePhone = new JLabel("전화번호:");
		pSub2Sub2.add(lblHomePhone);
		
		tflblHomePhone = new JTextField();
		pSub2Sub2.add(tflblHomePhone);
		tflblHomePhone.setColumns(18);
		
		JPanel pMain2Sub3 = new JPanel();
		pMain2.add(pMain2Sub3);
		pMain2Sub3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pSub3Sub1 = new JPanel();
		FlowLayout fl_pSub3Sub1 = (FlowLayout) pSub3Sub1.getLayout();
		fl_pSub3Sub1.setAlignment(FlowLayout.LEFT);
		pMain2Sub3.add(pSub3Sub1);
		
		JLabel lblAdress = new JLabel("주소:");
		pSub3Sub1.add(lblAdress);
		
		tfAdress = new JTextField();
		pSub3Sub1.add(tfAdress);
		tfAdress.setColumns(15);
		
		JPanel pSub3Sub2 = new JPanel();
		FlowLayout fl_pSub3Sub2 = (FlowLayout) pSub3Sub2.getLayout();
		fl_pSub3Sub2.setAlignment(FlowLayout.LEFT);
		pMain2Sub3.add(pSub3Sub2);
		
		JLabel lblPhone = new JLabel("휴대전화:");
		pSub3Sub2.add(lblPhone);
		
		tfPhone = new JTextField();
		pSub3Sub2.add(tfPhone);
		tfPhone.setColumns(15);
		
		JPanel pMain3 = new JPanel();
		contentPane.add(pMain3);
		pMain3.setLayout(new BorderLayout(0, 0));
		
		JPanel pMain3Sub1 = new JPanel();
		FlowLayout fl_pMain3Sub1 = (FlowLayout) pMain3Sub1.getLayout();
		fl_pMain3Sub1.setAlignment(FlowLayout.LEFT);
		pMain3.add(pMain3Sub1, BorderLayout.NORTH);
		
		JLabel lblFind2 = new JLabel("검색방법:");
		pMain3Sub1.add(lblFind2);
		
		JComboBox cmbBookNo = new JComboBox();
		pMain3Sub1.add(cmbBookNo);
		
		tfBookTyping = new JTextField();
		pMain3Sub1.add(tfBookTyping);
		tfBookTyping.setColumns(10);
		
		JButton btnBookSearch = new JButton("검색");
		pMain3Sub1.add(btnBookSearch);
		
		JPanel pMain3Sub2 = new JPanel();
		pMain3.add(pMain3Sub2, BorderLayout.CENTER);
		pMain3Sub2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBook = new JLabel("도서번호            도서제목            도서구분            대출여부");
		lblBook.setHorizontalAlignment(SwingConstants.LEFT);
		pMain3Sub2.add(lblBook, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pMain3Sub2.add(scrollPane_1, BorderLayout.EAST);
		
		JPanel pMain4 = new JPanel();
		pMain4.setBorder(new TitledBorder(null, "\uB300\uC5EC\uB3C4\uC11C\uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pMain4);
		pMain4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblBookName = new JLabel("도서제목:");
		lblBookName.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain4.add(lblBookName);
		
		tfBookName = new JTextField();
		pMain4.add(tfBookName);
		tfBookName.setColumns(10);
		
		JLabel lblBookNo = new JLabel("도서번호:");
		lblBookNo.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain4.add(lblBookNo);
		
		tfBookNo = new JTextField();
		pMain4.add(tfBookNo);
		tfBookNo.setColumns(10);
		
		JLabel lblBookKind = new JLabel("도서구분:");
		lblBookKind.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain4.add(lblBookKind);
		
		tfBookKind = new JTextField();
		pMain4.add(tfBookKind);
		tfBookKind.setColumns(10);
		
		JPanel pMain5 = new JPanel();
		contentPane.add(pMain5);
		pMain5.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnRent = new JButton("대여하기");
		pMain5.add(btnRent);
		
		JButton btnExit = new JButton("취소");
		pMain5.add(btnExit);
	}

}
