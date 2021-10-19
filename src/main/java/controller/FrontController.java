package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import controller.action.ActionForward;
import controller.action.CommentAction;
import controller.action.DeleteAction;
import controller.action.DetailAction;
import controller.action.GalleryListAction;
import controller.action.GalleryRegistAction;
import controller.action.InsertAction;
import controller.action.ListAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.ModifyAction;
import controller.action.UpdateAction;

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

	// 요청Method 구별없이 실행 -> doGet() 또는 doPost()메소드 실행내용 있으면 실행.
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 콘솔출력
		//System.out.println(request.getContextPath());
		//System.out.println(request.getServletPath());
		ActionForward forward = null;
		
		String spath = request.getServletPath();
		String path = "index.jsp";
		String url = "./";	// 또는 request.getContextPath();
		
		if (spath.equals("/list.do")) {
			Action action = new ListAction();
			forward = action.execute(request, response);	// 해당 코드가 많기 때문에 -> Action 구현 클래스로 변경
			forward.setUrl("community/list.jsp");
		}
		else if (spath.equals("/login.do")) {
			path = "login.jsp";
			forward = new ActionForward(false, path);
		}
		else if (spath.equals("/insert.do")) {
			path = "community/insert.jsp";
			forward = new ActionForward(false, path);
		}
		else if (spath.equals("/detail.do")) {
			Action action = new DetailAction();
			forward = action.execute(request, response);
		}
		else if (spath.equals("/save.do")) {
			Action action = new InsertAction();
			forward = action.execute(request, response);
			url = "list.do";
			forward.setUrl(url);	// action에서 줘도되고 여기서 값을 줘도 된다. vs list.do 와 비교
		} // 이 시점에서 forward에 isRedirect와 url 값이 저장되어 있기만 하면 된다.
		else if(spath.equals("/update.do")) {
			Action action = new UpdateAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/modify.do")) {
			Action action = new ModifyAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/delete.do")) {
			Action action = new DeleteAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/comment.do")) {
			Action action = new CommentAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/loginAction.do")) {
			Action action = new LoginAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/logout.do")) {
			Action action = new LogoutAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/gallery.do")) {
			Action action = new GalleryListAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/regist.do")) {
			Action action = new GalleryRegistAction();
			forward = action.execute(request, response);
		}
		
		
		if (!forward.isRedirect()) {	// 타입이 boolean 일때는 getXXX 아니고 isXXX 이다.
			RequestDispatcher rd = request.getRequestDispatcher(forward.getUrl());
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(forward.getUrl());
		}
		
	}
	
}
