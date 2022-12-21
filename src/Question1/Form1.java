package Question1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Form1 extends JFrame {

	private Employee person;
	private JPanel contentPane;
	private JTextField NameField;
	private JTextField AddressField;
	private JLabel lblNewLabel_2;
	private JTextField DateField;
	private JLabel lblNewLabel_3;
	private JTextField PhoneField;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JComboBox Degree;
	private JComboBox Position;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form1 frame = new Form1();
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

	public Form1() {
//		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 361);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Form 1");
		lblNewLabel.setBounds(437, 27, 74, 29);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Họ tên:");
		lblNewLabel_1.setBounds(56, 95, 66, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);

		NameField = new JTextField();
		NameField.setBounds(144, 95, 181, 34);
		contentPane.add(NameField);
		NameField.setColumns(10);

		AddressField = new JTextField();
		AddressField.setColumns(10);
		AddressField.setBounds(144, 154, 181, 34);
		contentPane.add(AddressField);

		lblNewLabel_2 = new JLabel("Địa chỉ:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(56, 154, 78, 25);
		contentPane.add(lblNewLabel_2);

		DateField = new JTextField();
		DateField.setColumns(10);
		DateField.setBounds(144, 198, 181, 34);
		contentPane.add(DateField);

		lblNewLabel_3 = new JLabel("Ngày:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(56, 198, 66, 25);
		contentPane.add(lblNewLabel_3);

		PhoneField = new JTextField();
		PhoneField.setColumns(10);
		PhoneField.setBounds(144, 254, 181, 34);
		contentPane.add(PhoneField);

		lblNewLabel_4 = new JLabel("ĐT:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(56, 254, 66, 25);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Chức vụ:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(458, 95, 121, 25);
		contentPane.add(lblNewLabel_5);

		final JComboBox Part = new JComboBox();
		Part.setModel(new DefaultComboBoxModel(
				new String[] { "Giam doc", "Pho giam doc", "Truong phòng", "Pho phong", "Nhan vien" }));
		Part.setBounds(578, 102, 169, 19);
		contentPane.add(Part);

		lblNewLabel_6 = new JLabel("Bằng cấp:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(458, 154, 105, 25);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Bộ phận:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(458, 208, 105, 25);
		contentPane.add(lblNewLabel_7);

		Degree = new JComboBox();
		Degree.setModel(new DefaultComboBoxModel(
				new String[] { "THPT", "Trung cap", "Cao dang", "Dai hoc", "Thac si", "Tien si" }));
		Degree.setBounds(578, 160, 169, 19);
		contentPane.add(Degree);

		Position = new JComboBox();
		Position.setModel(new DefaultComboBoxModel(new String[] { "Thu thu", "Thu kho", "Thu quy", "Ban giam doc" }));
		Position.setBounds(578, 211, 169, 21);
		contentPane.add(Position);

		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String s = e.getActionCommand();
				if (!s.equals(null)) {
					String name = NameField.getText();

					String address = AddressField.getText();

					String sDate1 = DateField.getText();
					Date date1 = null;
					try {
						date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					String phone = PhoneField.getText();
					String part = (String) Part.getSelectedItem().toString();
					String position = (String) Position.getSelectedItem().toString();
					String degree = (String) Degree.getSelectedItem().toString();

					person = new Employee(name, address, date1, phone, degree, part, position);

					try {
						person.save();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Add Successfully", "Msg", JOptionPane.PLAIN_MESSAGE);
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(573, 254, 126, 27);
		contentPane.add(btnNewButton);

	}
}
