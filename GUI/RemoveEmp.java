import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RemoveEmp extends JFrame {

	private JPanel contentPane;
	private JTextField num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveEmp frame = new RemoveEmp();
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
	public RemoveEmp() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Number");
		lblNewLabel.setBounds(60, 99, 126, 14);
		contentPane.add(lblNewLabel);
		
		num = new JTextField();
		num.setBounds(226, 96, 128, 20);
		contentPane.add(num);
		num.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Utility ut = new Utility();
					String sql = "select name from employee where empno=?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, num.getText());
					ut.rs = ut.pstmt.executeQuery();
					
					if(ut.rs.next())
					{
						
						String sql1 = "Delete from overtime where empno = ?";
						ut.pstmt = ut.conn.prepareStatement(sql1);
						ut.pstmt.setString(1, num.getText());
						ut.rs = ut.pstmt.executeQuery();
						
						String sql3 = "Delete from vehicle where empno = ?";
						ut.pstmt = ut.conn.prepareStatement(sql3);
						ut.pstmt.setString(1, num.getText());
						ut.rs = ut.pstmt.executeQuery();
						
						String sql5 = "Delete from employee where empno = ?";
						ut.pstmt = ut.conn.prepareStatement(sql5);
						ut.pstmt.setString(1, num.getText());
						ut.rs = ut.pstmt.executeQuery();
						
						JOptionPane.showMessageDialog(null, "Employee Deleted");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Invalid Employee Number");
					}
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnNewButton.setBounds(169, 169, 89, 23);
		contentPane.add(btnNewButton);
	}

}
