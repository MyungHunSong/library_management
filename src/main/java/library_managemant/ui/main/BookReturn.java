package library_managemant.ui.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import library_managemant.ui.Detail.BookInfoDetail;
import library_managemant.ui.Detail.MemberInfoDetail;
import library_managemant.ui.content.BookInfoSearchPanel;
import library_managemant.ui.content.MemberSearchPanel;
import library_managemant.ui.list.BookInfoSearchTablePanel;
import library_managemant.ui.list.MemberSearchTablePanel;

@SuppressWarnings("serial")
public class BookReturn extends JFrame {

	private JPanel contentPane;
	
	private MemberSearchPanel pMemSearch;
	private MemberSearchTablePanel pMemInfo;
	private BookInfoSearchPanel pBookSearch;
	private BookInfoSearchTablePanel  pBookInfo;
	
	
	

	
	public BookReturn() {
		initialize();
	}
	private void initialize() {
		setTitle("반납하기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		pMemSearch = new MemberSearchPanel();
		
		panel.add(pMemSearch, BorderLayout.NORTH);
		
		pMemInfo = new MemberSearchTablePanel();
		pMemInfo.loadData();
		panel.add(pMemInfo, BorderLayout.CENTER);
		
		MemberInfoDetail panel_1 = new MemberInfoDetail();
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		pBookSearch = new BookInfoSearchPanel();
		panel_2.add(pBookSearch, BorderLayout.NORTH);
		
		pBookInfo = new BookInfoSearchTablePanel();
		pBookInfo.loadData();
		panel_2.add(pBookInfo, BorderLayout.CENTER);
		
		BookInfoDetail panel_3 = new BookInfoDetail();
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_4);
		
		JButton btnReturn = new JButton("반납하기");
		panel_4.add(btnReturn);
		
		JButton btnCansle = new JButton("취소");
		panel_4.add(btnCansle);
	}

}
