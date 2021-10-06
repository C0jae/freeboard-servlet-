package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeboardDao;
import dto.Freeboard;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
				
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int pageNo = Integer.parseInt(request.getParameter("page"));
		FreeboardDao dao = FreeboardDao.getInstance();
		Freeboard bean = dao.getOne(idx);
		
		/* out.print(dto); */
		request.setAttribute("page", pageNo);
		request.setAttribute("bean", bean);
		/* pageContext.forward("updateView.jsp"); */
		
		forward.isRedirect = false;
		forward.url = "community/update.jsp";
		return forward;
	}

}
