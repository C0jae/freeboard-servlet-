package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import controller.action.InsertAction;
import controller.action.ListAction;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	// 요청Method 구병없이 실행 -> doGet() 또는 doPost()메소드 실행내용 있으면 실행.
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 콘솔출력
		//System.out.println(request.getContextPath());
		//System.out.println(request.getServletPath());
		
		String spath = request.getServletPath();
		boolean isRedirect = false;
		String path = "home.jsp";
		String url = "./";	// 또는 request.getContextPath();
		
		if (spath.equals("/list.do")) {
			Action action = new ListAction();
			isRedirect = action.execute(request, response);	// 해당 코드가 많기 때문에 -> Action 구현 클래스로 변경
			path = "community/list.jsp";
		}
		else if (spath.equals("/login.do")) {
			path = "login.jsp";
		}
		else if (spath.equals("/insert.do")) {
			path = "community/insert.jsp";
		}
		else if (spath.equals("/detail.do")) {
			path = "detailView.jsp";
		}
		else if (spath.equals("/save.do")) {
			Action action = new InsertAction();
			isRedirect = action.execute(request, response);
			url = "list.do";
		}
		
		if (!isRedirect) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(url);
		}
		
	}
	
}
