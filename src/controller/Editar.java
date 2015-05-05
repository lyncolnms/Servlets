package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/editar")
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("logado") != null) {

			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\"></meta>");
			out.println("<title>EDIÇÃO</title>");
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
			out.println("<h1>Editar</h1>");
			out.println("<div class=\"inserir\">"
					+ "<form action =\"./update\" method=\"post\" accept-charset=\"utf-8\">"
					+ "<label id=\"cidade\">Cidade:</label> "
					+ "<input for=\"cidade\" type=\"text\" name=\"cidade\" value=\""
					+ request.getParameter("cidade")
					+ "\"> </br:"
					+ "<label id=\"estado\">Estado:</label> "
					+ "<select name=\"estado\" value=\""
					+ request.getParameter("estado")
					+ "\">"
					+ "<option value=\"Paraná\">Parana</option>"
					+ "<option value=\"Santa Catarina\">Santa Catarina</option>"
					+ "<option value=\"São Paulo\">Sao Paulo</option>"
					+ "</select>"
					+ "</br> <input type=\"submit\" name=\"enviar\" value=\"Enviar\">"
					+ "</form>" + "</div>");
			out.println("</body>");
			out.println("</html>");
		} else {
			response.sendRedirect("./login");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
