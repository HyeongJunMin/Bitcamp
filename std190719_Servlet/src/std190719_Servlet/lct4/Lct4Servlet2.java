package std190719_Servlet.lct4;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lct4Servlet2
 */

public class Lct4Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lct4Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> enum1 = request.getParameterNames();
		String name = "";
		String value = "";
		
		while(enum1.hasMoreElements()) {
			name = enum1.nextElement().toString();
			
			if( name.equals("selectFruits") ) {
				String[] valueArr = request.getParameterValues(name);
				for(String s : valueArr) {
					System.out.println(s);
				}
			}else {
				value = request.getParameter(name);
				System.out.println(value);
			}
			
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
