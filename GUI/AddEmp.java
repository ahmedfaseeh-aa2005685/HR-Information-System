import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddEmp extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField hiredate;
	private JTextField commission;
	private JTextField salary;
	private JTextField salarygrade;
	private JTextField gender;
	private JTextField dob;
	private JTextField empno;
	private JTextField phoneno;
	private JTextField position;
	private JTextField dname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmp frame = new AddEmp();
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
	public AddEmp() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 735, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_6_2 = new JLabel("Name");
		lblNewLabel_6_2.setBounds(23, 30, 46, 14);
		contentPane.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("Hire Date");
		lblNewLabel_6_2_1.setBounds(23, 71, 64, 14);
		contentPane.add(lblNewLabel_6_2_1);
		
		JLabel lblNewLabel_6_2_2 = new JLabel("Commission");
		lblNewLabel_6_2_2.setBounds(23, 116, 74, 14);
		contentPane.add(lblNewLabel_6_2_2);
		
		JLabel lblNewLabel_6_2_3 = new JLabel("Salary");
		lblNewLabel_6_2_3.setBounds(23, 165, 46, 14);
		contentPane.add(lblNewLabel_6_2_3);
		
		JLabel lblNewLabel_6_2_4 = new JLabel("Salary Grade");
		lblNewLabel_6_2_4.setBounds(23, 215, 80, 14);
		contentPane.add(lblNewLabel_6_2_4);
		
		JLabel lblNewLabel_6_2_5 = new JLabel("Gender");
		lblNewLabel_6_2_5.setBounds(371, 30, 46, 14);
		contentPane.add(lblNewLabel_6_2_5);
		
		JLabel lblNewLabel_6_2_6 = new JLabel("Date Of Birth");
		lblNewLabel_6_2_6.setBounds(371, 71, 87, 14);
		contentPane.add(lblNewLabel_6_2_6);
		
		JLabel lblNewLabel_6_2_7 = new JLabel("Emp Number");
		lblNewLabel_6_2_7.setBounds(371, 116, 87, 14);
		contentPane.add(lblNewLabel_6_2_7);
		
		JLabel ssssuii = new JLabel("Phone No.");
		ssssuii.setBounds(371, 165, 74, 14);
		contentPane.add(ssssuii);
		
		JLabel lblNewLabel_6_2_9 = new JLabel("Position");
		lblNewLabel_6_2_9.setBounds(371, 215, 46, 14);
		contentPane.add(lblNewLabel_6_2_9);
		
		JLabel lblNewLabel_6_2_10 = new JLabel("Department Name");
		lblNewLabel_6_2_10.setBounds(170, 281, 135, 14);
		contentPane.add(lblNewLabel_6_2_10);
		
		name = new JTextField();
		name.setBounds(107, 27, 190, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		hiredate = new JTextField();
		hiredate.setColumns(10);
		hiredate.setBounds(107, 68, 190, 20);
		contentPane.add(hiredate);
		
		commission = new JTextField();
		commission.setColumns(10);
		commission.setBounds(107, 113, 190, 20);
		contentPane.add(commission);
		
		salary = new JTextField();
		salary.setColumns(10);
		salary.setBounds(107, 162, 190, 20);
		contentPane.add(salary);
		
		salarygrade = new JTextField();
		salarygrade.setColumns(10);
		salarygrade.setBounds(107, 212, 190, 20);
		contentPane.add(salarygrade);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(468, 27, 190, 20);
		contentPane.add(gender);
		
		dob = new JTextField();
		dob.setColumns(10);
		dob.setBounds(468, 68, 190, 20);
		contentPane.add(dob);
		
		empno = new JTextField();
		empno.setColumns(10);
		empno.setBounds(468, 113, 190, 20);
		contentPane.add(empno);
		
		phoneno = new JTextField();
		phoneno.setColumns(10);
		phoneno.setBounds(468, 162, 190, 20);
		contentPane.add(phoneno);
		
		position = new JTextField();
		position.setColumns(10);
		position.setBounds(468, 212, 190, 20);
		contentPane.add(position);
		
		dname = new JTextField();
		dname.setColumns(10);
		dname.setBounds(315, 278, 190, 20);
		contentPane.add(dname);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Utility ut = new Utility();
					String sql = "insert into employee values(?,?,?,?,?,?,?,?,?,?,?)";
					ut.pstmt=ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, name.getText());
					ut.pstmt.setString(2, hiredate.getText());
					ut.pstmt.setString(3, commission.getText());
					ut.pstmt.setString(4, salary.getText());
					ut.pstmt.setString(5, salarygrade.getText());
					ut.pstmt.setString(6, gender.getText());
					ut.pstmt.setString(7, dob.getText());
					ut.pstmt.setString(8, empno.getText());
					ut.pstmt.setString(9, phoneno.getText());
					ut.pstmt.setString(10, position.getText());
					ut.pstmt.setString(11, dname.getText());
					
					ut.rs=ut.pstmt.executeQuery();
					
					if(ut.rs.next())
					{
						JOptionPane.showMessageDialog(null, "Employee Added");
					}
				} 
				catch (SQLException e1) 
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(304, 344, 103, 30);
		contentPane.add(btnNewButton);
	}

}
