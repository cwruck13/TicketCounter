package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Store;

/**
 * Servlet implementation class addStoreServlet
 */
@WebServlet("/addStoreServlet")
public class addStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStoreServlet() {
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
		
		String path = "/add-store.jsp";
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StoreHelper dao = new StoreHelper();
		
		
		String storeCode = request.getParameter("storeCode");
		String storeName = request.getParameter("storeName");
		String storeAddress = request.getParameter("storeAddress");
		String phoneNumber = request.getParameter("phoneNumber");
		
		Store newStore = new Store(storeCode,storeName,storeAddress,phoneNumber);
		
		dao.insertStore(newStore);
		
		
		StoreHelper sh = new StoreHelper();
		request.setAttribute("allStores", sh.showAllStores());
		String path = "/store-list.jsp";
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

}
