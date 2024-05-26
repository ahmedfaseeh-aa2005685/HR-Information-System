import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateEmp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField newsal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmp frame = new UpdateEmp();
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
	public UpdateEmp() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Number");
		lblNewLabel.setBounds(89, 73, 118, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewSalary = new JLabel("New Salary");
		lblNewSalary.setBounds(89, 124, 89, 14);
		contentPane.add(lblNewSalary);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Utility ut = new Utility();
					
					String sql = "Update employee set salary = ? where empno = ?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, newsal.getText());
					ut.pstmt.setString(2, textField.getText());
					ut.rs = ut.pstmt.executeQuery();
					
					if(ut.rs.next())
					{
						JOptionPane.showMessageDialog(null, "Salary Updated Successfully");
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
		btnNewButton.setBounds(169, 184, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(217, 70, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		newsal = new JTextField();
		newsal.setColumns(10);
		newsal.setBounds(217, 118, 136, 20);
		contentPane.add(newsal);
	}

}
