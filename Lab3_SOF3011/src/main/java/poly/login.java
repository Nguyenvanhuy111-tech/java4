package poly;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CookieUtils.CookieUtils;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = CookieUtils.get("username", request);
		String password = CookieUtils.get("password", request);
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		// kiểm tra tài khoản đăng nhập
		if(!username.equalsIgnoreCase("poly")) {
		request.setAttribute("message", "Sai tên đăng nhập!");
		}
		else if(password.length() < 6) {
		request.setAttribute("message", "Sai mật khẩu!");
		}
		else {
		request.setAttribute("message", "Đăng nhập thành công!");
		// ghi nhớ hoặc xóa tài khoản đã ghi nhớ bằng cookie
		int hours = (remember == null) ? 0 : 30*24; // 0 = xóa
		CookieUtils.add("username", username, hours, response);
		CookieUtils.add("password", password, hours, response);
		}
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	
	}

}
