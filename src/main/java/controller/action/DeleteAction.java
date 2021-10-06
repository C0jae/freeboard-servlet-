package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeboardDao;

public class DeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ActionForward forward = new ActionForward();

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String password = request.getParameter("password");
		// 비밀번호이기 때문에 url로 받으면 안된다 -> 폼데이터(POST)로 받아와야한다.
		int pageNo = Integer.parseInt(request.getParameter("page"));
		
		FreeboardDao dao = FreeboardDao.getInstance();
		Map<String, Object> map = new HashMap<>();
		map.put("idx", idx);	// "" 안의 값은 xml파일에 작성한 값과 같게 작성해야 한다.
		map.put("password", password);
		
		/* int n = dao.delete(map); */
		int n = dao.delete(map);
		
		out.print("<script>");
		String message = null;
		String href = null;
		if (n==1) {	// 정상 delete 실행
			message = "삭제가 완료되었습니다.";
			href = "list.do?page="+pageNo;		
		}
		else {	// n=0 : password가 틀릴때
			message = "글 비밀번호가 일치하지 않습니다.";
			href = "detail.do?page="+pageNo+"&idx=" +idx;
		}
		
		out.print("alert('" +message+ "');");
		out.print("location.href='" +href+ "';");
		out.print("</script>");
		

		//forward.isRedirect = false;
		//forward.url = "";
		return null;
	}

}
