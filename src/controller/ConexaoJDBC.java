package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ConexaoJDBC {
	public Connection getConnection() {
		try {

			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/servlet", "postgres",
					"postgresql");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws SQLException {
		Connection con = new ConexaoJDBC().getConnection();
		System.out.println("Aberto");

		Scanner scanner;

		String cidades;
//		try {
//			scanner = new Scanner(
//					new FileReader(
//							"/home/lcarmo/git/Servlets/WebContent/resources/arquivotexto/frutas.txt"));
//			System.out.println("Leu");

//			while (scanner.hasNextLine()) {
//				cidades = scanner.nextLine();
//				PreparedStatement ps = con
//						.prepareStatement("INSERT INTO cidades (nome) VALUES (?)");
//				ps.setString(1, cidades);
//				ps.executeUpdate();
//				System.out.println("Executou");
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

		con.close();
		System.out.println("Fechou");
	}

}
