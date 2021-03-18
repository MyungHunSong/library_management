package library_managemant.Main.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import library_managemant.RentReturn.Library_Managemant_Rent;
import library_managemant.RentReturn.Library_Managemant_Return;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Library_Management_Maininfo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnRent;
	private JButton btnReturn;
	private JTextField tfMemberNo;
	private JTextField tfBook;

	// 무엇을 어디서 활용할것이냐 가 중요 그곳코드만 건드려주면 댄다.

	
	public Library_Management_Maininfo() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pRent = new JPanel();
		FlowLayout fl_pRent = (FlowLayout) pRent.getLayout();
		fl_pRent.setAlignment(FlowLayout.LEFT);
		contentPane.add(pRent, BorderLayout.NORTH);
		
		btnRent = new JButton("대출하기");
		btnRent.addActionListener(this);
		pRent.add(btnRent);
		
		btnReturn = new JButton("대여하기");
		btnReturn.addActionListener(this);
		pRent.add(btnReturn);
		
		JPanel pInfoCenter = new JPanel();
		contentPane.add(pInfoCenter, BorderLayout.CENTER);
		pInfoCenter.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pMemberSearch = new JPanel();
		pInfoCenter.add(pMemberSearch);
		pMemberSearch.setLayout(new BorderLayout(0, 0));
		
		JPanel pFastFind1 = new JPanel();
		pMemberSearch.add(pFastFind1, BorderLayout.NORTH);
		pFastFind1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblFastFind1 = new JLabel("빠른회원검색:");
		lblFastFind1.setFont(new Font("굴림", Font.PLAIN, 13));
		pFastFind1.add(lblFastFind1);
		
		JComboBox cmbMemberNo = new JComboBox();
		pFastFind1.add(cmbMemberNo);
		
		tfMemberNo = new JTextField();
		pFastFind1.add(tfMemberNo);
		tfMemberNo.setColumns(10);
		
		JPanel pMemberTitle = new JPanel();
		pMemberSearch.add(pMemberTitle, BorderLayout.CENTER);
		pMemberTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFastFind2 = new JLabel("회원번호      이름      전화번호      휴대전화 ");
		pMemberTitle.add(lblFastFind2, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox();
		pMemberTitle.add(comboBox, BorderLayout.CENTER);
		
		JPanel pBookSearch = new JPanel();
		pInfoCenter.add(pBookSearch);
		pBookSearch.setLayout(new BorderLayout(0, 0));
		
		JPanel pFastFind2 = new JPanel();
		pBookSearch.add(pFastFind2, BorderLayout.NORTH);
		
		JLabel lblFastFind3 = new JLabel("빠른도서검색:");
		lblFastFind3.setFont(new Font("굴림", Font.PLAIN, 13));
		pFastFind2.add(lblFastFind3);
		
		JComboBox cmbBookNo = new JComboBox();
		pFastFind2.add(cmbBookNo);
		
		tfBook = new JTextField();
		pFastFind2.add(tfBook);
		tfBook.setColumns(10);
		
		JPanel pBookTitle = new JPanel();
		pBookSearch.add(pBookTitle, BorderLayout.CENTER);
		pBookTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFastFind4 = new JLabel("도서번호      도서제목      대출여부      도서구분 ");
		pBookTitle.add(lblFastFind4, BorderLayout.NORTH);
		
		JComboBox comboBox_1 = new JComboBox();
		pBookTitle.add(comboBox_1, BorderLayout.CENTER);
		
		JPanel pBookInfo = new JPanel();
		pBookInfo.setBorder(new TitledBorder(null, "\uD604\uC7AC \uB300\uC5EC\uC911\uC778 \uB3C4\uC11C\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pBookInfo, BorderLayout.SOUTH);
		pBookInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblBookNo = new JLabel("도서번호       도서제목       도서연체일       도서대여일       도서구분\t\t\t");
		pBookInfo.add(lblBookNo);
		
		JComboBox comboBox_2 = new JComboBox();
		pBookInfo.add(comboBox_2);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReturn) {
			btnReturnActionPerformed(arg0);
		}
		if (arg0.getSource() == btnRent) {
			btnRentActionPerformed(arg0);
		}
	}
	// 대출하기 클릭크
	protected void btnRentActionPerformed(ActionEvent arg0) {
		Library_Managemant_Rent frame = new Library_Managemant_Rent();
		frame.setVisible(true);
	}
	
	// 반납하기 클릭크
	protected void btnReturnActionPerformed(ActionEvent arg0) {
		Library_Managemant_Return frame = new Library_Managemant_Return();
		frame.setVisible(true);
	}
}
