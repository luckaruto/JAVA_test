package Question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Employee {
	private String name;
	private String location;
	private String phone;
	private String degree;
	private String part;
	private Date birthday;
	private String position;

	public Employee(String name, String location, Date birthday, String phone, String degree, String part,
			String position) {
		this.name = name;
		this.location = location;
		this.birthday = birthday;
		this.phone = phone;
		this.degree = degree;
		this.part = part;
		this.position = position;
	}

	public void print() {
		System.out.println(this.name + "\n");
		System.out.println(this.location + "\n");
		System.out.println(this.birthday + "\n");
		System.out.println(this.phone + "\n");
		System.out.println(this.degree + "\n");
		System.out.println(this.part + "\n");
		System.out.println(this.position + "\n");
	}

	Connection getConnection(String dbURL, String userName, String password) {
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

	public void save() throws SQLException {
		String DB_URL = "jdbc:mysql://localhost:3306/company";
		String USER_NAME = "root";
		String PASSWORD = "";

		Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
		String query = "INSERT INTO employee " + "(Name,Address,Birthday,Phone,Degree,Part,Position)"
				+ " VALUES(?,?,?,?,?,?,?) ";
		PreparedStatement mystmt = conn.prepareStatement(query);
		mystmt.setString(1, this.name);
		mystmt.setString(2, this.location);
		mystmt.setDate(3, new java.sql.Date(this.birthday.getTime()));
		mystmt.setString(4, this.phone);
		mystmt.setString(5, this.degree);
		mystmt.setString(6, this.part);
		mystmt.setString(7, this.position);
		mystmt.execute();
		conn.close();

	}

}
