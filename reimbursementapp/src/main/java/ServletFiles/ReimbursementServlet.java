package ServletFiles;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAOFiles.*;

public class ReimbursementServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String ticketType = request.getParameter("ticketType");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String description = request.getParameter("description");
		
		Cookie[] cookieE = request.getCookies();
		String email = cookieE[0].getValue();
		
		Cookie[] cookieP = request.getCookies();
		String password = cookieP[0].getValue();
		
		Cookie[] cookieN = request.getCookies();
		String name = cookieN[0].getValue();
		
//		Cookie[] cookieM = request.getCookies();
//		String managerc = cookieN[0].getValue();
//		int manager = String.format(managerc);
		
		try {
			EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAO();
			int empId = dao.getEmployeeId(cookieE[0].getValue());
			
			dao.addTicket(empId, ticketType, amount, description, "pending");
			int manager = dao.getManagerStatus(cookieE[0].getValue());
			request.setAttribute("manager", manager);
			//RequestDispatcher reqD =  
			request.getRequestDispatcher("/reimbursementf.jsp").forward(request, response);
//			RequestDispatcher reqD =  request.getRequestDispatcher("/reimbursementf.jsp");
//			reqD.include(request, response);
			
//			ticket.setTicketOwnerId(empId);
//			ticket.setTicketType(ticketType);
//			ticket.setAmount(amount);
//			ticket.setDescription(description);
//			ticket.setStatus("pending");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}

}
