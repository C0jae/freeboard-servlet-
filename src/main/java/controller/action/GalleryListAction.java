package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryDao;
import dto.Gallery;

public class GalleryListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GalleryDao gdao = GalleryDao.getInstance();
		List<Gallery> list = gdao.getList();
		
		request.setAttribute("glist", list);
		
		return new ActionForward(false, "gallery/gallery.jsp");
	}

}
