package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Store;
import model.Ticket;

/**
 * Servlet implementation class storeNavigationServlet
 */
@WebServlet("/storeNavigationServlet")
public class storeNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public storeNavigationServlet() {
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
		StoreHelper dao = new StoreHelper();
		String act = request.getParameter("doThisToStore");

		// after all changes, we should redirect to the viewAllITickets servlet
		// The only time we don't is if they select to add a new ticket or edit
		String path = "/viewAllStoresServlet";

		if (act.equals("edit")) {
			try {
				String storeCode = request.getParameter("id");
				Store storeToEdit = dao.findStore(storeCode);
				request.setAttribute("storeToEdit", storeToEdit);
				path = "/edit-store.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a ticket");
			}

		} else if (act.equals("add")) {
			path = "/index.html";

		}
				
		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}
