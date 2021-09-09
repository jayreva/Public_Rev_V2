package ServletFiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAOFiles.EmployeeDAO;
import DAOFiles.EmployeeDAOFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewAllTicketsServlet extends HttpServlet {
	static int manager;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie[] cookieE = request.getCookies();
        String email = cookieE[0].getValue();
        EmployeeDAO dao;
		
        try {
			dao = EmployeeDAOFactory.getEmployeeDAO();
			manager = dao.getManagerStatus(email);
			int manager = dao.getManagerStatus(cookieE[0].getValue());
			request.setAttribute("manager", manager);
			RequestDispatcher reqD = request.getRequestDispatcher("/reimbursementf.jsp");
			//reqD.forward(request, response);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\"\r\n"
				+ "        integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">\r\n"
				+ "        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"\r\n"
				+ "        integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\r\n"
				+ "        crossorigin=\"anonymous\"></script>\r\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "        integrity=\"sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns\"\r\n"
				+ "        crossorigin=\"anonymous\"></script>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<style>\r\n"
				+ "    nav {\r\n"
				+ "        background-color: #191919;\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    .navbar a {\r\n"
				+ "        color: #c9c613;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .navbar input {\r\n"
				+ "            background-color: #191919;\r\n"
				+ "            border: none;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "    btn-group {\r\n"
				+ "        margin-bottom: 30 px;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    body {\r\n"
				+ "        margin-bottom: 20 px;\r\n"
				+ "        padding: 0;\r\n"
				+ "        font-family: sans-serif;\r\n"
				+ "        background: linear-gradient(to right, #81802b, #23538a)\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .jumbotron {\r\n"
				+ "        background: linear-gradient(to right, #81802b, #23538a)\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .jumbotron h1 {\r\n"
				+ "        color: black;\r\n"
				+ "        font-weight: 500\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    tbody {\r\n"
				+ "        background-color: #494949;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    thead {\r\n"
				+ "        background-color: #191919;\r\n"
				+ "    }\r\n"
				+ "</style>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <!-- navbar -->\r\n"
				+ "    <nav class=\"navbar fixed-top navbar-expand-lg navbar-light\">\r\n"
				+ "        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
				+ "            <ul class=\"navbar-nav mr-auto\">\r\n"
				+ "                <li class=\"nav-item dropdown\">\r\n"
				+ "                    <a class=\"nav-link dropdown-toggle text-warning\" href=\"#\" id=\"navbarDropdown\" role=\"button\"\r\n"
				+ "                        data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n"
				+ "                        Actions\r\n"
				+ "                    </a>\r\n"
				+ "                    <div class=\"dropdown-menu bg-dark\" aria-labelledby=\"navbarDropdown\">\r\n"
				+ "                        <form action=\"ViewTicketsServlet\" method=\"POST\">\r\n"
				+ "                            <input type=\"submit\" class=\"dropdown-item text-warning bg-dark\" name=\"\" value=\"Pending Tickets\">\r\n"
				+ "                        </form>\r\n"
				+ "                        <form action=\"ViewTicketsServlet\" method=\"POST\">\r\n"
				+ "                            <input type=\"submit\" class=\"dropdown-item text-warning bg-dark\" name=\"\" value=\"All Tickets\">\r\n"
				+ "                        </form>        \r\n"
				+ "                </li>\r\n"
				+ "\r\n"
				+ "                <li class=\"nav-item\">\r\n"
				+ "                    <a class=\"nav-link text-warning\" href=\"reimbursementf.jsp\">Form</a>   \r\n"
				+ "                </li>\r\n"
				+ "            </ul>\r\n"
				+ "            <form class=\"form-inline my-2 my-lg-0\" action=\"index.html\">\r\n"
				+ "                <button class=\"btn btn-outline-warning my-2 my-sm-0\" type=\"submit\">Logout</button>\r\n"
				+ "            </form>\r\n"
				+ "        </div>\r\n"
				+ "    </nav>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <!-- header -->\r\n"
				+ "    <div class=\"jumbotron\">\r\n"
				+ "        <h1 class=\"display-6 text-center text-light\">Pending Reimbursement Tickets</h1>\r\n"
				+ "        <hr color=\"#fff\">\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <!-- main -->\r\n"
				+ "    <div class=\"container\">\r\n"
				+ "<div class=\"btn-group\">"
				+ "  <button type=\"button\" class=\"btn btn-dark dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"
				+ "    Ticket Status"
				+ "  </button>"
				+ "  <div class=\"dropdown-menu\">"
				+ "    <a class=\"dropdown-item\" href=\"#\">Pending</a>"
				+ "    <a class=\"dropdown-item\" href=\"#\">Approved</a>"
				+ "    <a class=\"dropdown-item\" href=\"#\">Rejected</a>"
				+ "  </div>"
				+ "</div>"
				+ "        <table class=\"table text-light\">\r\n"
				+ "            <thead>\r\n"
				+ "                <tr>\r\n"
				+ "                    <th>Ticket #</th>\r\n"
				+ "                    <th>Employee #</th>\r\n"
				+ "                    <th>Type</th>\r\n"
				+ "                    <th>Request Amount</th>\r\n"
				+ "                    <th>Status</th>\r\n"
				+ "                    <th>Date Subtmit</th>\r\n"
				+ "                    <th>Description</th>\r\n"
				+ "                    <th>Actions</th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>\r\n"
				+ "            <tbody>");

		try {
			dao = EmployeeDAOFactory.getEmployeeDAO();
			String tickets = dao.viewAllTickets();
			out.print(tickets);
				
//			
			
//			int manager = dao.getManagerStatus(cookieE[0].getValue());
//			request.setAttribute("manager", manager);
//			//RequestDispatcher reqD =  
//			request.getRequestDispatcher("/reimbursementf.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		out.print("</tbody>\r\n"
				+ "        </table>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
}
