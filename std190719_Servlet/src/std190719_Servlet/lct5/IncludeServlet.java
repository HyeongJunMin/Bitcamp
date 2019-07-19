package std190719_Servlet.lct5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncludeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("include servlet ok");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
				
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h2>Hello Include Servlet</h2>");
		pw.println("<a href=\"./main.html\">rrrrrr</a>");
		pw.println("</body>");
		pw.println("</html>");
//		pw.flush();
//		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
