package std190722_Servlet2_AJAX.workServlet;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/work/workmainChk")
public class WorkMainServlet1 extends HttpServlet {

	@SuppressWarnings("deprecation")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok doGet 190722 work");
		
		HumanDTO dto = new HumanDTO();
		dto.setName( req.getParameter("inputName") );
		dto.setAge( Integer.parseInt( req.getParameter("age") ) );
		dto.setGender( req.getParameter("gender") );
		dto.setHobby( req.getParameterValues("hobby") );
		dto.setBirth( new Date(req.getParameter("birth")) );
		dto.setSalary( Integer.parseInt( req.getParameter("salary") ) );
					
		Enumeration<String> enumHobby = req.getParameterNames();
		
		while( enumHobby.hasMoreElements() ) {
			System.out.print(enumHobby.nextElement().toString() + " ");
		}
				
		
		if( "m".equals(dto.getGender()) ){
			System.out.println("male!");
			
			HttpSession session = req.getSession(true);
			session.setAttribute("human", dto);
			resp.sendRedirect("workMale");
			
		}else {
			System.out.println("female!");
			
			req.setAttribute("human", dto);
			
			//HttpServletRequest에서 dispatcher를 받아옴. 매개변수는 servlet url-pattern
			RequestDispatcher dispatch = req.getRequestDispatcher("workFemale");			
			dispatch.forward(req, resp);
			//req.getRequestDispatcher("workFemale").forward(req, resp);
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok doPost 190722 work");
	}
	
}
