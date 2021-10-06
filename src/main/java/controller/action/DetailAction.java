package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDao;
import dao.FreeboardDao;
import dto.Comment;
import dto.Freeboard;

public class DetailAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int pageNo = Integer.parseInt(request.getParameter("page"));
		
		FreeboardDao dao = FreeboardDao.getInstance();
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("readIdx") != null) {
			StringBuilder readIdx = (StringBuilder)session.getAttribute("readIdx");
			boolean status = readIdx.toString().contains("/"+idx+"/");
			if(!status) {	// 읽은 글 목록 문자열에 idx가 포함되어 있지 않으면
				dao.readCount(idx);	// 조회수 증가
				readIdx.append(idx + "/");
			}
		}
		
		
		Freeboard bean = dao.getOne(idx);
		
		CommentDao cdao = CommentDao.getInstance();
		cdao.updateCountAll(idx);	// 댓글 갯수 update
		List<Comment> cmts = cdao.getCommens(idx);
		request.setAttribute("cmtlist", cmts);
		
		request.setAttribute("page",pageNo);
		
		request.setAttribute("bean", bean);
		//pageContext.forward("detailView.jsp");
		
		forward.isRedirect = false;
		forward.url = "community/detail.jsp";
		return forward;
	}
}
