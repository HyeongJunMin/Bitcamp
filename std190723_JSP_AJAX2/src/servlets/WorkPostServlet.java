package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.WorkDTO;

@WebServlet("/work/workPost")
public class WorkPostServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok workPost doPost");
		
		String id = req.getParameter("inputId");
		String pw = req.getParameter("inputPw");
		String[] hobby = req.getParameterValues("hobby");
		String age = req.getParameter("ages") + "대";
		String txt = req.getParameter("gg");
		
		WorkDTO dto = new WorkDTO(id, pw, hobby, age, txt);
		
		req.setAttribute("WorkDTO", dto);
		req.setAttribute("itsPost", "ok");
		System.out.println("ok go to dest with : " + dto.toString());
		//resp.sendRedirect("./work2Dest.jsp");
		RequestDispatcher dispatch = req.getRequestDispatcher("./work2Dest.jsp");
		dispatch.forward(req, resp);
	}

}
