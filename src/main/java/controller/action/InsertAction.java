package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeboardDao;
import dto.Freeboard;



public class InsertAction implements Action {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String subject = request.getParameter("subject");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		
		Freeboard dto = new Freeboard();
		dto.setIp(ip);
		dto.setName(name);
		dto.setPassword(password);
		dto.setSubject(subject);
		dto.setContent(content);
		
		
		FreeboardDao dao = FreeboardDao.getInstance();
		dao.insert(dto);
		
		//response.sendRedirect("listAction.jsp");
		
		boolean isRedirect = true;
		return isRedirect;
	}

}
