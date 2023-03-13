package poly;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upLoad")
public class upLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public upLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	request.getRequestDispatcher("/views/upload/form.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File dir = new File(request.getServletContext().getRealPath("/files"));
		if(!dir.exists()) { // tạo nếu chưa tồn tại
		dir.mkdirs();
		}
		// lưu các file upload vào thư mục files
		Part photo = request.getPart("photo_file"); // file hình
		File photoFile = new File(dir, photo.getSubmittedFileName());
		photo.write(photoFile.getAbsolutePath());
		Part doc = request.getPart("doc_file"); // file tài liệu
		File docFile = new File(dir, doc.getSubmittedFileName());
		doc.write(docFile.getAbsolutePath());
		// chia sẻ cho result.jsp để hiển thị
		request.setAttribute("img", photoFile);
		request.setAttribute("doc", docFile);
	}

}
