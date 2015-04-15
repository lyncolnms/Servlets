package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Scanner scanner;
	String cidades;
	ArrayList<String> cidadesA = new ArrayList<String>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			scanner = new Scanner(
					new FileReader(
							"/Users/Usuário/workspace/ExServlets/WebContent/resources/arquivotexto/frutas.txt"));
			while (scanner.hasNextLine()) {
				cidades = scanner.nextLine();
				if (cidades.startsWith("A")) {
					cidadesA.add(cidades);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\"></meta>");
		out.println("<title>Cidades com A</title>");
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
		out.println("<h1>Cidades com <img src=\"./resources/img/A.png\" alt=\"Letra A\" height=\"42\" width=\"42\"></h1>");
		out.println("<ul>");
		for (int i = 0; i < this.cidadesA.size(); i++) {
			out.println("<li>");
			out.println(this.cidadesA.get(i));
			out.println("</li>");
		}
		out.println("</ul>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
