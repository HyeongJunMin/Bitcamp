package std190719_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lct2Servlet
 */
@WebServlet("/Lct2Servlet")
public class Lct2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lct2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println( createHTML("GET", request, response));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println( createHTML("POST", request, response));
	}
	
	public String createHTML(String methodType, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		StringBuffer sb = new StringBuffer();
		String val = request.getParameter("name1");
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
		sb.append("니가보낸거" + val + "</p>");
		sb.append("<p>");
		sb.append("</body>");
		sb.append("</html>");
		
		return (new String(sb));
	}
}
