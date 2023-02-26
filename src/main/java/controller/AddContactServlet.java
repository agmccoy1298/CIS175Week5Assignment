package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import model.Contacts;
import model.Pets;

/**
 * Servlet implementation class AddContactServlet
 */
@WebServlet("/addContactServlet")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String petOne = request.getParameter("petOne");
		String petTwo = request.getParameter("petTwo");
		String petThree = request.getParameter("petThree");
		
		Contacts co = new Contacts(name, phoneNumber,address);
		List<String> PetNames = new ArrayList<String>();
		List<Pets> listOfPets = new ArrayList<Pets>();		
		PetNames.add(petOne);
		PetNames.add(petTwo);
		PetNames.add(petThree);
		for(var i : PetNames) {
			if(i.isEmpty() || i == null) {
				System.out.println("empty pet name value!");
			}else {
				Pets tempPet = new Pets(i, co);
				listOfPets.add(tempPet);
			}
		}

		co.setPets(listOfPets);
		ContactsHelper ch = new ContactsHelper();
		ch.inserItem(co);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
