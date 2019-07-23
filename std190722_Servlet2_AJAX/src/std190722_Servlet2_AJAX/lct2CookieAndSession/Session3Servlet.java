package std190722_Servlet2_AJAX.lct2CookieAndSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lct2CookieAndSession/delsession")
public class Session3Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok Delete session get");
		
		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello Delete Session doGet</h3>");
		
		
		HttpSession session = req.getSession();
		session.removeAttribute("age");
				
		pw.println("<p>등록된 session object 표시</p>");
		
		Enumeration<String> enumSession = session.getAttributeNames();
		
		while( enumSession.hasMoreElements() ) {
			String key = enumSession.nextElement();
			String val = session.getAttribute(key) + "";
			pw.println("<p>key: " + key + ", value: " + val + "</p>");
		}		
		
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
