package std190722_Servlet2_AJAX.lct2CookieAndSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lct2CookieAndSession/dispCookies")
public class DispCookies extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok dispCookies doGet");

		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello dispCookies Servlet doGet</h3>");
		Cookie cookies[] = req.getCookies();
		if(cookies != null) {
			for(int i = 0 ; i < cookies.length ; i++) {
				String value = cookies[i].getValue();
				pw.println("<p>key: " + cookies[i].getName() +
						",  value: " + value + "</p>");
			}
		}
		pw.println("<a href=\"visitedCookie\">방문회수</a>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok dispCookies doPost");

		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello dispCookies Servlet doPost</h3>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

}
