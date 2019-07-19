package std190719_Servlet.lct3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

public class Lct3HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lct3HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println( createHTML("GET", request, response));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println( createHTML("POST", request, response));
	}
	
	public String createHTML(String methodType, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		StringBuffer sb = new StringBuffer();
		String val = request.getParameter("dataHello");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>");		
		sb.append("제목ㅎㅎ</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h3>");
		sb.append("Hello Servlet "+ methodType + "</h3>");
		sb.append("<p>");
		sb.append("Hello Servlet p tag</p>");
		sb.append("<p>");
		sb.append("니가보낸거" + val + "</p>");
		sb.append("<a href=\"http://localhost:8090/std190719_Servlet/\">go to index</a><br/>");
		sb.append("<a href=\"http://localhost:8090/std190719_Servlet/\">go to get.html</a><br/>");
		sb.append("<a href=\"http://localhost:8090/std190719_Servlet/\">go to post.html</a><br/>");
		sb.append("<a href=\"http://localhost:8090/std190719_Servlet/ggggg\">go to sample</a><br/>");
		sb.append("</body>");
		sb.append("</html>");
		
		return (new String(sb));
	}
}
