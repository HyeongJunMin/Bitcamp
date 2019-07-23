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

@WebServlet("/lct2CookieAndSession/session2")
public class Session2Servlet extends HttpServlet {

	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok session servlet2 get");
		
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
			pw.println("<p>session을 등록합니다.</p>");
			session = req.getSession(true);//세션 생성
			session.setAttribute("name", "min");
			session.setAttribute("age", "29");
		}
		pw.println("<p>등록된 session object 표시</p>");
		
		Enumeration<String> enumSession = session.getAttributeNames();
		
		while( enumSession.hasMoreElements() ) {
			String key = enumSession.nextElement();
			String val = session.getAttribute(key) + "";
			pw.println("<p>key: " + key + ", value: " + val + "</p>");
		}		
		
		pw.println("<a href=\"session1\">다시 표시</a>");
		pw.println("<a href=\"delsession\">세션 삭제</a>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
