package cz.fio;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StoreContact extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ContactsFileFactory factory;

	protected ContactsFileFactory getContactsFileFactory() {
		if (this.factory == null) {
			this.factory = new ContactsFileFactory();
		}
		return this.factory;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// load contact from request
		Contact contact = new Contact();

		contact.setFirstName(request.getParameter("firstName"));
		contact.setLastName(request.getParameter("lastName"));
		contact.setEmail(request.getParameter("email"));

		// store contact if valid
		if (!contact.isValid()) {
			response.setStatus(400);
			response.getWriter().print("No valid contact provided!");
		} else {
			ContactsFile file = this.getContactsFileFactory().getInstance();
			try {
				if (file.exists(contact)) {
					response.setStatus(200);
					response.getWriter().print("Contact already exists.");
				} else {
					file.add(contact);
					response.setStatus(200);
					response.getWriter().print("OK");
				}
			} catch (ContactsFileException ex) {
				response.setStatus(500);
				response.getWriter().print(ex.getMessage());
			}
		}
	}

}
