package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletC")
public class ServletC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Connection con = new ConexaoJDBC().getConnection();
		System.out.println("Aberto");

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT nome FROM cidades WHERE nome LIKE 'C%' ");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			rs = ps.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\"></meta>");
		out.println("<title>Cidades com C</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"./resources/css/estilo.css\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"tudo\">");
		out.println("<div id=\"menu\">");
		out.println("<ul>");
		out.println("<li><a href=\"servletA\">A</a></li>");
		out.println("<li><a href=\"servletB\">B</a></li>");
		out.println("<li><a href=\"servletC\">C</a></li>");
		out.println("<li><a href=\"inserir\">Inserir</a></li>");
		out.println("<li><a href=\"busca\">Busca</a></li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("<h1>Cidades com <img src=\"./resources/img/C.png\" alt=\"Letra C\" height=\"42\" width=\"42\"></h1>");
		out.println("<ul>");
		try {
			while (rs.next()) {
				out.println("<li>");
				out.println(rs.getString("nome"));
				out.println("</li>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</ul>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
