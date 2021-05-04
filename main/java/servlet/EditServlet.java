package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;
import model.ItemLogic;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		int itemId = Integer.valueOf(request.getParameter("itemId"));
		
		List<Item> itemList = (List<Item>) application.getAttribute("itemList");
		
		for (Item item: itemList) {
			if (item.getId() == itemId) {
				session.setAttribute("editItem", item);
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/editItem.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String expDate = request.getParameter("expDate");
		
		String mode = request.getParameter("edit") == null ? "delete" : null;
		ItemLogic logic = new ItemLogic();
		Item editItem = new Item(id, name, description, expDate);
		
		if (mode.equals("delete")) {
			if (logic.deleteItem(editItem.getId())) {
				response.sendRedirect("/StockManager/ItemServlet");
			} else {
				//send to a error message
			}
		} else {
			if (logic.editItem(editItem)) {
				response.sendRedirect("/StockManager/ItemServlet");
			} else {
				//send to a error message
			}
		}
	}

}
