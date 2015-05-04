package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inserir")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\"></meta>");
		out.println("<title>Formul�rio de Busca</title>");
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
		out.println("<h1>Busca</h1>");
		out.println("<div class=\"inserir\">"
				+ "<form>"
				+ "<label id=\"cidade\">Cidade:</label> "
				+ "<input for=\"cidade\" type=\"text\" name=\"parametro\"> </br:"
				+ "<label id=\"estado\">Estado:</label> "
				+ "<select>"
				+ "<option value=\"pr\">Parana</option>"
				+ "<option value=\"sc\">Santa Catarina</option>"
				+ "<option value=\"sp\">Sao Paulo</option>"
				+ "</select>"
				+ "</br> <input type=\"submit\" name=\"enviar\" value=\"Enviar\">"
				+ "</form>" + "</div>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
