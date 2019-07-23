package std190722_Servlet2_AJAX.lct2CookieAndSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lct2CookieAndSession/session1")
public class Session1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok session servlet get");
		
		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
				
		HttpSession session = null;

		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello Session Servlet doGet</h3>");
		
		if(session == null) {
			pw.println("<p>세션없음. 새 세션시작.</p>");
			session = req.getSession(true);
			session.setMaxInactiveInterval(30);
			session.setAttribute("visited", "1");
		}else {
			String visited = session.getAttribute("visited") + "";
			int count = Integer.parseInt(visited);
			count++;
			pw.println("<p>방문회수 : " + count + "회</p>");
			
			session.setAttribute("visited", count + "");
		}
		
		pw.println("<a href=\"session1\">다시 표시</a>");
		pw.println("<a href=\"session2\">session object 확인</a>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok session servlet post");
		
		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
				
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello Session Servlet doPost</h3>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

}
