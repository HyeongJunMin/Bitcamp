package std190722_Servlet2_AJAX.lct1Servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lct1Servlet2/sample")
public class Lct1Servlet2_3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok servlet2-3 get");

		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		String myData = req.getParameter("hiddenData");
		System.out.println("id : " + id + ", pw : " + inputPw + ", myData : " + myData);

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello Servlet2 lct3 doGet</h3>");
		pw.println("<p>" + "ID : " + id + "</p>");
		pw.println("<p>" + "PW : " + inputPw + "</p>");
		pw.println("<p>" + "hidden : " + myData + "</p>");
		pw.println("<a href=\"sample?inputId=" + id + "&inputPw" + inputPw + "\">send Data</a>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok servlet2-3 doPost");

		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");

		MemberVO vo = (MemberVO) req.getAttribute("mem");

		/*
		 * String id = req.getParameter("inputId"); String inputPw =
		 * req.getParameter("inputPw"); String myData = req.getParameter("hiddenData");
		 * System.out.println("id : " + id + ", pw : " + inputPw + ", myData : " +
		 * myData);
		 */
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello Servlet2 lct3 doPost</h3>");
		pw.println("<p>" + "ID : " + vo.getInputId() + "</p>");
		pw.println("<p>" + "PW : " + vo.getInputPw() + "</p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

}
