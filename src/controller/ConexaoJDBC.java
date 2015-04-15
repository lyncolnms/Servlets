package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {
	public Connection getConnection() {
		try {

			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:3465/servlet", "postgres",
					"postgresql");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws SQLException {
		Connection con = new ConexaoJDBC().getConnection();
		System.out.println("Aberto");
		con.close();
	}

}
