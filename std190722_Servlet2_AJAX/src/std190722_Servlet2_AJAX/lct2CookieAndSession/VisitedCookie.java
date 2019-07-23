package std190722_Servlet2_AJAX.lct2CookieAndSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lct2CookieAndSession/visitedCookie")
public class VisitedCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok VisitedCookie doGet");

		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello VisitedCookie Servlet doGet</h3>");
		Cookie cookies[] = req.getCookies();
		Cookie visitCookie = null;
		if(cookies != null) {//쿠키가 있는 경우 쿠키를 검색
			for(Cookie c : cookies) {
				if("visited".equals(c.getName())) {
					visitCookie = c;
					break;
				}
			}
			
			if( visitCookie != null) { // 쿠키를 찾았다? 방문회수 보여주고 쿠키 갱신
				int count = Integer.parseInt(visitCookie.getValue()) + 1;
				pw.println("<h3>You have visited here, " + count + "times</h3>");
				visitCookie.setValue(count + "");
				visitCookie.setMaxAge( 3 );
				resp.addCookie(visitCookie);
			}else {//쿠키를 못찾았다? 첫방문
				pw.println("<h3>You are a newbie, because you have no any cookie</h3>");
				Cookie newCookie = new Cookie("visited","1");
				resp.addCookie(newCookie);
			}
			
		}else {//쿠키가 없는 경우? 클라이언트에 쿠키를 생성해줌
			pw.println("<h3>You are a newbie, because you have no any cookie</h3>");
			Cookie newCookie = new Cookie("visited","1");
			resp.addCookie(newCookie);
		}
		
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok VisitedCookie doPost");

		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello VisitedCookie Servlet doPost</h3>");

		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

}
