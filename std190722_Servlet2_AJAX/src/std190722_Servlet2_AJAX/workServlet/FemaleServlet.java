package std190722_Servlet2_AJAX.workServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/work/workFemale")
public class FemaleServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("workFemale Servlet doGet");
		
		
		
		HumanDTO dto = (HumanDTO)req.getAttribute("human");
		
		System.out.println(dto.toString());
		
		String hobby = "";
		
		for(String str : dto.getHobby()) {
			hobby += str + ", ";
		}
		
		// 인코딩 방식 지정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>Hello Female Session doGet</h3>");
		pw.println("<p>" + dto.toString() + "</p>");
		pw.println("<input type=\"text\" value=\"" + dto.toString() + "\"><br/>");
		pw.println("name:<input type=\"text\" value=\"" + dto.getName() + "\"><br/>");
		pw.println("age:<input type=\"text\" value=\"" + dto.getAge() + "\"><br/>");
		pw.println("gender:<input type=\"text\" value=\"" + dto.getGender() + "\"><br/>");
		pw.println("hobby:<input type=\"text\" value=\"" + hobby + "\"><br/>");
		pw.println("birth:<input type=\"text\" value=\"" + dto.getBirth() + "\"><br/>");
		pw.println("salary:<input type=\"text\" value=\"" + ( (dto.getSalary() < 2)?"0~3,000":"3,000~" ) + "\"><br/>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("workFemale Servlet doPost");
	}

}
