package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\"></meta>");
		out.println("<title>Login</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"./resources/css/estilo.css\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"tudo\">");
		out.println("<h1>LOGIN</h1>");
		out.println("<form action=\"./login\" method=\"POST\">");
		out.println("<fieldset>");
		out.println("<legend>Login</legend>");
		out.println("<input type=\"text\" name=\"username\" value=\"\"> ");
		out.println("<input type=\"password\" name=\"password\" value=\"\"> ");
		out.println("<input type=\"submit\" value=\"Logar\"> ");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Connection con = new ConexaoJDBC().getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * FROM login");
			rs = ps.executeQuery();

			while (rs.next()) {
				if (request.getParameter("username").equals(
						rs.getString("username"))
						&& request.getParameter("password").equals(
								rs.getString("password"))) {
					request.getSession().setAttribute("logado",
							new Boolean(true));
					PrintWriter out = response.getWriter();

					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("<meta charset=\"UTF-8\"></meta>");
					out.println("<title>Logado</title>");
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
					out.println("<h2>Seja Bem Vindo!</h2>");
					out.println("</div>");
					out.println("</body>");
					out.println("</html>");

				} else {
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
					response.getWriter().println(
							"<h1>Usuário ou senha incorretos");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
