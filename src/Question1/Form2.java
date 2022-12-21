package Question1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Form2 extends JFrame {

	private JPanel contentPane;

	private JTable table_1;
	private JScrollPane scrollPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form2 frame = new Form2();
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
	static Connection getConnection(String dbURL, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}

	public Form2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Form 2");
		lblNewLabel.setBounds(491, 10, 74, 29);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);

		table_1 = new JTable();
		table_1.setColumnSelectionAllowed(true);
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "H\u1ECD t\u00EAn", "\u0110\u1ECBa ch\u1EC9", "Ng\u00E0y sinh",
						"S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "B\u1EB1ng c\u1EA5p", "B\u1ED9 ph\u1EADn",
						"Ch\u1EE9c v\u1EE5" }) {
			/**
							 * 
							 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					Object.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(2).setPreferredWidth(124);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(96);
		table_1.setBounds(35, 67, 1011, 335);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 49, 1021, 390);
		scrollPane.setViewportView(table_1);
		contentPane.add(scrollPane);

		btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread th = new Thread() {
					public void run() {

						try {
							Form1 frame = new Form1();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				};
				th.start();

			}
		});
		btnNewButton.setBounds(907, 20, 85, 21);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DB_URL = "jdbc:mysql://localhost:3306/company";
				String USER_NAME = "root";
				String PASSWORD = "";
				Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
				Statement stmt;
				try {
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select * from student");
					while (rs.next()) {
						String con = "Id: " + rs.getString(1) + "   " + "Firstname: " + rs.getString(2) + "   "
								+ "LastName: " + rs.getString(3) + "    " + "Date: " + rs.getDate(4) + "   "
								+ "Address: " + rs.getString(5);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(26, 20, 85, 21);
		contentPane.add(btnNewButton_1);

	}
}
