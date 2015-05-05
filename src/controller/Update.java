package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("logado") != null) {
			Connection con = new ConexaoJDBC().getConnection();

			PreparedStatement ps = null;

			try {
				ps = con.prepareStatement("UPDATE cidades SET nome = '"
						+ request.getParameter("cidade") + "', estado = '"
						+ request.getParameter("estado") + "' WHERE id = "
						+ request.getParameter("id") + "");
				ps.executeUpdate();

				PrintWriter out = response.getWriter();

				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset=\"UTF-8\"></meta>");
				out.println("<title>Formulário de Edição</title>");
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
				out.println("<h1>Inserir</h1>");
				out.println("<h2>Operação realizada com sucesso!!</h2>");
				out.println("Cidade: " + request.getParameter("cidade")
						+ " - Estado: " + request.getParameter("estado"));
				out.println("</body>");
				out.println("</html>");

				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("./login");
		}

	}
}
