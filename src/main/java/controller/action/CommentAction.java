package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dto.Comment;

public class CommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		request.setCharacterEncoding("UTF-8");
		int mref;
		CommentDao dao = CommentDao.getInstance();
		int pageNo = Integer.parseInt(request.getParameter("page"));

		if (request.getParameter("del") != null) {	// 댓글 삭제
			int cmtidx = Integer.parseInt(request.getParameter("cmtidx"));
			int idx = Integer.parseInt(request.getParameter("idx"));
			dao.delete(cmtidx);
			mref=idx;
		}
		else {		// 댓글 추가
		//request.setCharacterEncoding("UTF-8");	// method=post로 받아온 것이기 때문에 utf-8 설정 필요
		mref = Integer.parseInt(request.getParameter("mref"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		
		Comment dto = new Comment(0, mref, name, password, content, null, ip);
		dao.insert(dto);
		
		// 댓글 갯수 +1
		//dao.updateCommentCnt(mref);	// mref = idx
		}

		dao.updateCountAll(mref);
		/* response.sendRedirect("detailAction.jsp?page="+pageNo+"&idx=" +mref); */
		
		forward.isRedirect = false;
		forward.url = "detail.do?page="+pageNo+"&idx="+mref;
		
		return forward;
	}

}
