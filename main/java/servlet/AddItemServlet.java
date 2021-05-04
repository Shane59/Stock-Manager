package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;
import model.Item;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addItem.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String itemName = request.getParameter("name");
		String desc = request.getParameter("description");
		String expDate = request.getParameter("expDate");
		
		if (expDate.equals("")|| expDate == null) {
			String errorMsg = "expiration date is empty!";
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addItem.jsp");
			dispatcher.forward(request, response);
		} else {
			ServletContext application = request.getServletContext();
			List<Item> itemList = (List<Item>) application.getAttribute("itemList");
			
			// redirect when itemList is null in application scope
			if (itemList == null) {
				response.sendRedirect("/StockManager/LoginServlet");
			} else {
				if (itemList.size() == 0) {
					itemList = new ArrayList<Item>();
				}
				Item newItem = new Item(itemList.size() + 1, itemName, desc, expDate);
				
				ItemDAO dao = new ItemDAO();
				
				if (dao.addItem(newItem)) {
					itemList = dao.getAllItem();
					application.setAttribute("itemList", itemList);
					
					response.sendRedirect("/StockManager/ItemServlet");
				} else {
					//
				}	
			}	
		}
	}

}
