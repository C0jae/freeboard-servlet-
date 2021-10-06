package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		//response.sendRedirect("home.jsp");
		/* out.print("<script>");
		out.print("alert('로그아웃 되었습니다.');");
		out.print("location.href='home.jsp';"); //home.jsp로 url 이동
		out.print("</script>"); */
		
		request.setAttribute("message", "로그아웃 되었습니다.");
		request.setAttribute("url", "index.jsp");
		// pageContext.include("error/alert.jsp");
		// pageContext.forward : 페이지 이동, 이하 아래의 코드가 실행되지 않는다.
		// pageContext.include 해당페이지 *이 자리에 포함*, 이하 아래의 코드가 실행 된다.

		session.invalidate();		// 세션 무효화(끊기)
		
		forward.isRedirect = false;
		forward.url = "error/alert.jsp";
		return forward;
	}

}
