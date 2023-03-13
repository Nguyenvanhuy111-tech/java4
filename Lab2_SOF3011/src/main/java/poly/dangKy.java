package poly;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dangKy")
public class dangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public dangKy() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/dang-ky/form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
		boolean married = (request.getParameter("married") != null);
		String country = request.getParameter("country");
		String[] hobbies = request.getParameterValues("hobbies");
		
		System.out.println(">>username: " + username);
		System.out.println(">>gender: " + gender);
		System.out.println(">>married: " + married);
		System.out.println(">>country: " + country);
		System.out.println(">>hobbies: " + Arrays.toString(hobbies));
		
		request.getRequestDispatcher("/views/dang-ky/result.jsp").forward(request, response);
	}

}
