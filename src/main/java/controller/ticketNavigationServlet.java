package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Ticket;

/**
 * Servlet implementation class ticketNavigationServlet
 */
@WebServlet("/ticketNavigationServlet")
public class ticketNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ticketNavigationServlet() {
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
		//create a ticket helper and grab the value of the action.
		TicketHelper dao = new TicketHelper();
		String act = request.getParameter("doThisToTicket");

		// after all changes, we should redirect to the viewAllITickets servlet
		// The only time we don't is if they select to add a new ticket or edit
		String path = "/viewAllTicketsServlet";

		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Ticket ticketToDelete = dao.searchForTicketById(tempId);
				dao.deleteTicket(ticketToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a ticket");
			}

		} else if (act.equals("edit")) {
			try {
				// grabbing all the stores so the view can have a list to select what
				//stores are available
				
				StoreHelper sh = new StoreHelper();
				request.setAttribute("allStores", sh.showAllStores());
				
				
				
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Ticket ticketToEdit = dao.searchForTicketById(tempId);
				request.setAttribute("ticketToEdit", ticketToEdit);
				path = "/edit-ticket.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a ticket");
			}

		} else if (act.equals("add")) {
			path = "/index.html";

		}
				
		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}
	

