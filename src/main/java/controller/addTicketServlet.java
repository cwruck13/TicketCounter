package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ticket;

/**
 * Servlet implementation class addTicketServlet
 */
@WebServlet("/addTicketServlet")
public class addTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StoreHelper sh = new StoreHelper();
		request.setAttribute("allStores", sh.showAllStores());
		
		String path = "/add-ticket.jsp";
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TicketHelper dao = new TicketHelper();
		String storeCode = request.getParameter("storeCode");
		String description = request.getParameter("description");
		String completed = request.getParameter("isCompleted");
		boolean isCompleted = false;
		if(completed.contentEquals("true")) {
			isCompleted = true;
		}else {
			isCompleted = false;
		}
		
		Ticket newTicket = new Ticket(storeCode,description,isCompleted);
		
		dao.insertTicket(newTicket);
		
		List<Ticket> allTickets = dao.showAllTickets();
		request.setAttribute("allTickets", allTickets);
		
		getServletContext().getRequestDispatcher("/ticket-list.jsp").forward(request, response);
		
	}
	
	protected void doTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//first step grab stores toss to add ticket view.
		StoreHelper sh = new StoreHelper();
		request.setAttribute("allStores", sh.showAllStores());
		
		String path = "/add-ticket";
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
