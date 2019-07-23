package std190722_Servlet2_AJAX.lct2CookieAndSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lct2CookieAndSession/cookie1")
public class Cookie1Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok cookie servlet get");
		
		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		//쿠키 객체 생성 및 response servlet에 추가
		Cookie cookie = new Cookie("id", "abc123");
		resp.addCookie(cookie);
		cookie = new Cookie("pw", "1111");
		resp.addCookie(cookie);
		cookie = new Cookie("visited", "1");
		resp.addCookie(cookie);
		
		
		
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello Cookie Servlet doGet</h3>");
		pw.println("<a href=\"dispCookies\">show cookies doGet</h3>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok cookie servlet post");

		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello Cookie Servlet doPost</h3>");
		pw.println("<a href=\"dispCookies\">show cookies doPost</h3>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

}
