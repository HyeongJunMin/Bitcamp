package std190719_Servlet.lct5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Lct5Servlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("왔다요녀석");
				
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
				
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello Servlet lct5</h3>");
		RequestDispatcher dispatch = req.getRequestDispatcher("include");
		dispatch.include(req, resp);
		req.getRequestDispatcher("goForward").forward(req, resp);
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("왔다요녀석 Post");
	}
	
}
