package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/busca")
public class Busca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\"></meta>");
		out.println("<title>Formulário de Busca</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"./resources/css/estilo.css\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"tudo\">");
		out.println("<div id=\"menu\">");
		out.println("<ul>");
		out.println("<li><a href=\"servletA\">A</a></li>");
		out.println("<li><a href=\"servletB\">B</a></li>");
		out.println("<li><a href=\"servletC\">C</a></li>");
		out.println("<li><a href=\"busca\">Busca</a></li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("<h1>Busca</h1>");
		out.println("<div class=\"busca\">"
				+ "<form action =\"./query\" method=\"get\" accept-charset=\"utf-8\">"
				+ "<label id=\"busca\">Busca:</label> "
				+ "<input for=\"busca\" type=\"text\" name=\"parametro\"> "
				+ "<input type=\"submit\" name=\"enviar\" value=\"Enviar\">"
				+ "</form>" + "</div>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
