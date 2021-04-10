package library_managemant;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import library_managemant.ui.main.LibraryManagemantUiMain;

@SuppressWarnings("serial")
public class library_managemant extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					library_managemant frame = new library_managemant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public library_managemant() {
		initialize();
	}
	private void initialize() {
		setTitle("들어가기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnNewButton = new JButton("들어가기");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		contentPane.add(btnNewButton_1);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			btnNewButtonActionPerformed(arg0);
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent arg0) {
		LibraryManagemantUiMain frame = new LibraryManagemantUiMain();
		frame.setVisible(true);
	}
}
