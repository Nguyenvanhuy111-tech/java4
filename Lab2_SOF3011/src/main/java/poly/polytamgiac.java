package poly;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/tam-giac", "/dien-tich", "/chu-vi"})
public class polytamgiac extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public polytamgiac() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/tam-giac.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double a = Double.parseDouble(request.getParameter("a"));
		double b = Double.parseDouble(request.getParameter("b"));
		double c = Double.parseDouble(request.getParameter("c"));
		
		if((a+b >c) && (a+c >b) && (b+c >a)){
			double chuVi = a+ b+c;
			String uri = request.getRequestURI();
			if(uri.contains("dien-tich")) {
				double dientich =Math.sqrt(chuVi*(a+b-c)*(a+c-b)*(b+c-a))/4;
				request.setAttribute("message", "Dien tich la: "+dientich);
			}else {
				request.setAttribute("message", "Chu vi la: "+chuVi);
			}
		}
		else {
			request.setAttribute("message", "Error");
		}
		request.getRequestDispatcher("/views/tam-giac.jsp").forward(request, response);
	}

}
