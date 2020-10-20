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
 * Servlet implementation class editStoreServlet
 */
@WebServlet("/editStoreServlet")
public class editStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editStoreServlet() {
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
		String storeCode = request.getParameter("id");
		String storeName = request.getParameter("storeName");
		String storeAddress = request.getParameter("storeAddress");
		String phoneNumber = request.getParameter("phoneNumber");

		
		Store storeToUpdate = dao.findStore(storeCode);
		
		storeToUpdate.setPhoneNumber(phoneNumber);
		storeToUpdate.setStoreAddress(storeAddress);
		storeToUpdate.setStoreCode(storeCode);
		storeToUpdate.setStoreName(storeName);
		
		
		dao.updateStore(storeToUpdate);
		
		List<Store> allStores = dao.showAllStores();
		
		request.setAttribute("allStores", allStores);
		
		getServletContext().getRequestDispatcher("/viewAllStoresServlet").forward(request,response);
	}
	
}
