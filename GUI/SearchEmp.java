import java.awt.EventQueue;
import java.util.ArrayList;

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

public class SearchEmp extends JFrame {

	private JPanel contentPane;
	private JTextField ans;
	private JTextField ans2;
	private JTextField ans3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEmp frame = new SearchEmp();
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
	public SearchEmp() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Number");
		lblNewLabel.setBounds(72, 41, 126, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAllowance = new JLabel("Allowance Type");
		lblAllowance.setBounds(72, 89, 126, 14);
		contentPane.add(lblAllowance);
		
		ans = new JTextField();
		ans.setBounds(239, 38, 295, 20);
		contentPane.add(ans);
		ans.setColumns(10);
		
		ans2 = new JTextField();
		ans2.setEditable(false);
		ans2.setBounds(239, 86, 295, 20);
		contentPane.add(ans2);
		ans2.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Utility ut = new Utility();
					
//					String results[] = new String[10];
//					String sql = "select a.allowancename, a.amount from employee e, allowance a where e.position = a.positionname and e.empno=?";
//					ut.pstmt = ut.conn.prepareStatement(sql);
//					ut.pstmt.setString(1, ans.getText());
//					ut.rs = ut.pstmt.executeQuery();
					
					ArrayList<String> all_name = new ArrayList<>();
					ArrayList<String> amount = new ArrayList<>();
					String sql = "select a.allowancename, a.amount from employee e, allowance a where e.position = a.positionname and e.empno=?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, ans.getText());
					ut.reslt = ut.pstmt.execute();
					
					int x = 0;
					
					while(ut.reslt)
					{
						 ut.rs = ut.pstmt.getResultSet();
						 
						 while(ut.rs.next())
						 {
							 all_name.add(ut.rs.getString(1));
							 amount.add(ut.rs.getString(2));
							 x++;
						 }
						 ut.rs.close();
						 
						 ut.reslt = ut.pstmt.getMoreResults();
					}
					
					String allowance_name = String.join(",",all_name);
					String allowance_amount = String.join(",",amount);
					
					
					if(x == 0) 
					{
						ans2.setText(null);
						ans3.setText(null);
						JOptionPane.showMessageDialog(null, "Invalid Employee Number OR Employee has no Allowance");
						
					}
					else 
					{
						ans2.setText(allowance_name);
						ans3.setText(allowance_amount);
					}
					
				} catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(290, 210, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblAllowance_1 = new JLabel("Allowance Amount");
		lblAllowance_1.setBounds(72, 138, 121, 14);
		contentPane.add(lblAllowance_1);
		
		ans3 = new JTextField();
		ans3.setEditable(false);
		ans3.setColumns(10);
		ans3.setBounds(239, 135, 295, 20);
		contentPane.add(ans3);
	}

}
