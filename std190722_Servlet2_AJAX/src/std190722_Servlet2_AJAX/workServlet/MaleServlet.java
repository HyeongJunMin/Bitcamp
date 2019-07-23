package std190722_Servlet2_AJAX.workServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/work/workMale")
public class MaleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("workMale Servlet doGet");
		
		HttpSession session = req.getSession(true);
		
		HumanDTO dto = (HumanDTO)session.getAttribute("human");
		
		System.out.println(dto.toString());
		
		
		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello Male Session doGet</h3>");
		pw.println("<p>" + dto.toString() + "</p>");
		pw.println("<input type=\"text\" value=\"" + dto.toString() + "\">");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("workMale Servlet doPost");
	}

}
