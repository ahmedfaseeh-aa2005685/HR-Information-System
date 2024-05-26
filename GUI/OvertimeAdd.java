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

public class OvertimeAdd extends JFrame {

	private JPanel contentPane;
	private JTextField empnum;
	private JTextField dn;
	private JTextField wh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OvertimeAdd frame = new OvertimeAdd();
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
	public OvertimeAdd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Num");
		lblNewLabel.setBounds(81, 52, 87, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDaynightdOr = new JLabel("Day/Night (D or N)");
		lblDaynightdOr.setBounds(81, 92, 99, 14);
		contentPane.add(lblDaynightdOr);
		
		JLabel lblWorkingHours = new JLabel("Working Hours");
		lblWorkingHours.setBounds(81, 134, 87, 14);
		contentPane.add(lblWorkingHours);
		
		empnum = new JTextField();
		empnum.setBounds(200, 49, 182, 20);
		contentPane.add(empnum);
		empnum.setColumns(10);
		
		dn = new JTextField();
		dn.setColumns(10);
		dn.setBounds(200, 89, 182, 20);
		contentPane.add(dn);
		
		wh = new JTextField();
		wh.setColumns(10);
		wh.setBounds(200, 131, 182, 20);
		contentPane.add(wh);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Utility ut = new Utility();
					String sql = "insert into overtime values(?,?,?,0)";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, dn.getText());
					ut.pstmt.setString(2, wh.getText());
					ut.pstmt.setString(3, empnum.getText());
					
					ut.rs=ut.pstmt.executeQuery();
					
					int enumber = Integer.parseInt(empnum.getText());
					int workh = Integer.parseInt(wh.getText());
					
					String results[] = new String[1];
					String sql1 = "select hourlypay from grade where gradename = (select salgrade from employee where empno=?)";
					ut.pstmt = ut.conn.prepareStatement(sql1);
					ut.pstmt.setString(1, empnum.getText());
					ut.rs = ut.pstmt.executeQuery();
					
					if(ut.rs.next())
					{
						results[0] = ut.rs.getString(1);
					}
					
					int hourpay = Integer.parseInt(results[0]);
					
					ut.cstmt = ut.conn.prepareCall("{call overtime_calc(?,?,?,?)}"); 
					ut.cstmt.setString(1, dn.getText());
					ut.cstmt.setInt(2, enumber);
					ut.cstmt.setInt(3, hourpay);
					ut.cstmt.setInt(4, workh);
					ut.cstmt.execute();
					
					JOptionPane.showMessageDialog(null, "Overtime Added");
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(167, 194, 89, 23);
		contentPane.add(btnNewButton);
	}
}
