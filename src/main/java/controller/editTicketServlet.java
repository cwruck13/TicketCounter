package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ticket;

/**
 * Servlet implementation class editTicketServlet
 */
@WebServlet("/editTicketServlet")
public class editTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TicketHelper dao = new TicketHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		String storeCode = request.getParameter("storeCode");
		String description = request.getParameter("description");
		String completed = request.getParameter("isCompleted");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		boolean isCompleted;
		if(completed.contentEquals("true")){
			isCompleted = true;
		}
		else {
			isCompleted = false;	
	}
		
		Ticket ticketToUpdate = dao.searchForTicketById(tempId);
		
		ticketToUpdate.setIsCompleted(isCompleted);
		ticketToUpdate.setDescription(description);
		ticketToUpdate.setStoreCode(storeCode);
		ticketToUpdate.setTicketDate(ld);
		
		dao.updateTicket(ticketToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllTicketsServlet").forward(request,response);
	}
}
