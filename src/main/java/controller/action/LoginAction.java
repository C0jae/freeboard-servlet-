package controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dto.SessionDto;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
		
		String id=request.getParameter("userid");
		String password=request.getParameter("password");
		
		if(session.getAttribute("readIdx") ==null){
			StringBuilder readIdx=new StringBuilder("/");
			session.setAttribute("readIdx", readIdx);
		}
		
		//1)id는 'admin' 이고 password 'jcpdev' 라고 가정하고 합니다.
		Map<String,String> map = new HashMap<>();
		map.put("email",id);
		map.put("password",password);

		//2) db 테이블 select 쿼리 실행	
		CustomerDao dao = CustomerDao.getInstance();
		SessionDto user = dao.login(map);
		if(user !=null){
		//로그인 정보 일치
			//session 객체에 로그인 id 저장합니다.
			session.setAttribute("user", user);


			request.setAttribute("message", "로그인 되었습니다.");
			request.setAttribute("url", "./");
			
		}else {
			//로그인 정보 불일치
			
			request.setAttribute("message", "로그인 정보가 올바르지 않습니다.");
			request.setAttribute("url", "login.do");   //변경
			//pageContext.include("error/alert.jsp");
		}
		
		forward.isRedirect = false;
		forward.url="error/alert.jsp";   
		return forward;
	}

}
