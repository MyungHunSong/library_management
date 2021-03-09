package library_managemant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Library_Management_Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnRentAndReturn;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library_Management_Main frame = new Library_Management_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Library_Management_Main() {
		initialize();
	}
	private void initialize() {
		setTitle("도서 관리자");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pImFor = new JPanel();
		pImFor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "도서 관리자", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pImFor, BorderLayout.NORTH);
		pImFor.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pMenu = new JPanel();
		contentPane.add(pMenu, BorderLayout.CENTER);
		pMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 125));
		
		btnRentAndReturn = new JButton("대출/반납");
		btnRentAndReturn.addActionListener(this);
		pMenu.add(btnRentAndReturn);
		
		JButton btnExist = new JButton("종료");
		pMenu.add(btnExist);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRentAndReturn) {
			btnRentAndReturnActionPerformed(arg0);
		}
	}
	protected void btnRentAndReturnActionPerformed(ActionEvent arg0) {
		Library_Management_Maininfo frame = new Library_Management_Maininfo();
		frame.setVisible(true);
	}
}
