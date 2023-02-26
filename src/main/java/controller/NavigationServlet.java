package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacts;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		doGet(request, response);		
		
		ContactsHelper chc = new ContactsHelper();
		
		String act = request.getParameter("doThisToContact");
		String path = "/viewAllContactsServlet";
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));			
				Contacts itemToDelete = chc.searchForContactById(tempId);
				chc.deleteItem(itemToDelete);
			}catch (NumberFormatException e){
				System.out.println("Something went wrong when trying to select a contact.");
			}						
		} else if (act.equals("edit contact")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Contacts contactToEdit = chc.searchForContactById(tempId);
				request.setAttribute("contactToEdit", contactToEdit);
				path = "/edit-contact.jsp";
			}catch (NumberFormatException e) {
				System.out.println("Something went wrong when trying to select a contact.");
			}			
			
		} else if (act.equals("edit contact pets")){
			try {
				PetsHelper ph = new PetsHelper();								
				request.setAttribute("petsList", ph.showAllPets());
				path = "/pets-List.jsp";
			}catch (NumberFormatException e) {
				System.out.println("Something went wrong when trying to select a contact.");
			}
		}else if (act.equals("add")) {		
			path = "/index.html";
		}
		
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		

	}

}
