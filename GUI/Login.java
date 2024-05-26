import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username_info;
	private JTextField pass_info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel vx = new JLabel("Username");
		vx.setBounds(93, 77, 80, 14);
		contentPane.add(vx);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(93, 132, 80, 14);
		contentPane.add(lblPassword);
		
		username_info = new JTextField();
		username_info.setBounds(206, 74, 131, 20);
		contentPane.add(username_info);
		username_info.setColumns(10);
		
		pass_info = new JTextField();
		pass_info.setColumns(10);
		pass_info.setBounds(206, 129, 131, 20);
		contentPane.add(pass_info);
		
		JButton login_button = new JButton("Login");
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Utility ut = new Utility();
					
					
					String sql = "select username,password from log_in where username=? and password=?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, username_info.getText());
					ut.pstmt.setString(2, pass_info.getText());
					ut.rs = ut.pstmt.executeQuery();
					
					if (ut.rs.next())
					{
						JOptionPane.showMessageDialog(null, "LogIn Is Successful");
						
						String sql1 = "delete from username_stor";
						ut.rs = ut.stmt.executeQuery(sql1);
						
						String sql2 = "insert into username_stor values(?)";
						ut.pstmt = ut.conn.prepareStatement(sql2);
						ut.pstmt.setString(1, username_info.getText());
						ut.rs = ut.pstmt.executeQuery();
						
						Main_page.main(null);

					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Not authorized User, Try Again");
						ut.conn.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		login_button.setBounds(98, 186, 89, 23);
		contentPane.add(login_button);
		
		JButton close_button = new JButton("Close");
		close_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(DO_NOTHING_ON_CLOSE);
			}
		});
		close_button.setBounds(244, 186, 89, 23);
		contentPane.add(close_button);
	}

}
