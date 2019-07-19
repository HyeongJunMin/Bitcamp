package std190719_Servlet.lct4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lct4Servlet1
 */

public class ErrMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrMsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String code = request.getParameter("slcCode");
		String tax = this.getInitParameter("tax");
		
		
		if( code.equals("200") ) {
			
		}else {
			if( code.equals("404") ) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND,"페이지못찾아요 :(");
			}else {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Server 문제 :(");
			}
		}
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>");		
		pw.println("제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>code: " + code + "</p>");
		pw.println("<p>tax: " + tax + "</p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String code = request.getParameter("slcCode");
		
		if( code.equals("200") ) {
			
		}else {
			if( code.equals("404") ) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND,"페이지못찾아요 :(");
			}else {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Server 문제 :(");
			}
		}
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>");		
		pw.println("제목ㅎㅎ</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>code: " + code + "</p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}

}
