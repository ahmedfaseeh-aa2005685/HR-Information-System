import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_page frame = new Main_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 437);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Reports");
		mnNewMenu.setForeground(new Color(0, 0, 0));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Employee History");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				EmpHistory.main(null);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Vehicle History");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehicleHistory.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Project History");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjHistory.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Overtime ");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OvertimeHis.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JSeparator separator_5 = new JSeparator();
		mnNewMenu.add(separator_5);
		
		JMenu mnNewMenu_1 = new JMenu("Employee");
		mnNewMenu_1.setForeground(new Color(0, 0, 0));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Add Employee");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmp.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JSeparator separator_4 = new JSeparator();
		mnNewMenu_1.add(separator_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Remove Employee");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveEmp.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JSeparator separator_3 = new JSeparator();
		mnNewMenu_1.add(separator_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Update Employee");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmp.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JSeparator separator_7 = new JSeparator();
		mnNewMenu_1.add(separator_7);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Search Employee");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEmp.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_10);
		
		JSeparator separator_6 = new JSeparator();
		mnNewMenu_1.add(separator_6);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Add Overtime");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OvertimeAdd.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_11);
		
		JSeparator separator_8 = new JSeparator();
		mnNewMenu_1.add(separator_8);
		
		JMenu mnNewMenu_2 = new JMenu("EXIT");
		mnNewMenu_2.setForeground(new Color(0, 0, 0));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Close Screen");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(DO_NOTHING_ON_CLOSE);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
