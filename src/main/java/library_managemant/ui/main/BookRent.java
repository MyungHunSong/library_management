package library_managemant.ui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import library_managemant.ui.content.MemberSearchPanel;
import library_managemant.ui.list.MemberSearchTablePanel;
import library_managemant.ui.content.BookInfoSearchPanel;
import library_managemant.ui.list.BookInfoSearchTablePanel;
import library_managemant.ui.content.MemberInfoDetail;
import library_managemant.ui.content.BookInfoDetail;

public class BookRent extends JFrame {

	private JPanel contentPane;
	// 테이블 로드 해주는 것들
	private MemberSearchPanel pMemSearch;
	private BookInfoSearchPanel pBookSearch;
	private MemberSearchTablePanel pMemInfo;
	private BookInfoSearchTablePanel pBookInfo;

	
	public BookRent() {
		initialize();
	}
	private void initialize() {
		setTitle("대여하기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		MemberSearchPanel panel_5 = new MemberSearchPanel();
		panel.add(panel_5, BorderLayout.NORTH);
		
		MemberSearchTablePanel panel_7 = new MemberSearchTablePanel();
		panel.add(panel_7, BorderLayout.CENTER);
		
		MemberInfoDetail panel_1 = new MemberInfoDetail();
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		BookInfoSearchPanel panel_6 = new BookInfoSearchPanel();
		panel_2.add(panel_6, BorderLayout.NORTH);
		
		BookInfoSearchTablePanel panel_8 = new BookInfoSearchTablePanel();
		panel_2.add(panel_8, BorderLayout.CENTER);
		
		BookInfoDetail panel_3 = new BookInfoDetail();
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_4);
		
		JButton btnRent = new JButton("대여하기");
		panel_4.add(btnRent);
		
		JButton btnCansle = new JButton("취소");
		btnCansle.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(btnCansle);
	}

}
