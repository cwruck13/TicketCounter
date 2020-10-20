package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Store;
import model.Ticket;

/**
 * Servlet implementation class viewTheQueueServlet
 */
@WebServlet("/viewTheQueueServlet")
public class viewTheQueueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewTheQueueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StoreHelper dao = new StoreHelper();
		TicketHelper tih = new TicketHelper();
		List<Ticket> allTickets = tih.showAllTickets();
		List<Store> allStores = dao.showAllStores();
		
		request.setAttribute("allStores", allStores);
		request.setAttribute("allTickets", allTickets);
		
		String path = "/queue.jsp";
		
		getServletContext().getRequestDispatcher(path).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
