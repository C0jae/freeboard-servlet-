package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.GalleryDao;
import dto.Gallery;

public class GalleryRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GalleryDao gdao = GalleryDao.getInstance();
		String path="E:\\Program\\upload";     	// 서버 컴퓨터 로컬경로
		//프로젝트 폴더와 관련 없는 경로일때  url 매핑을 server.xml에 설정한다.
		
	    //String path = request.getServletContext().getRealPath("/image");
		//		ㄴ프로젝트 폴더의 하위 경로 image 폴더일때 사용한다.

	      
	      int size=10*1024*1024;	// 10MByte, 최대파일 크기
	      try {
	    	  
	    	 // 업로드된 파일을 받을 수 있는 MultipartRequest 타입의 request 객체 생성.
	         MultipartRequest multi_request = new MultipartRequest(request,path,size,"UTF-8",
	                                    new DefaultFileRenamePolicy());
	         // 기존 파일명과 중복된 파일명은 이름을 변경 -> 기본방식은 파일명 뒤에 순차적으로 번호 부여
	         //title(text), pic(file) 2개 파라미터
	         String title= multi_request.getParameter("title");
	         String filename = multi_request.getFilesystemName("pic");
	         // 파일을 받아오고 지정된 path에 저장, 저장된 파일명 리턴
	         
	         Gallery vo = new Gallery(0, title, filename);
	         gdao.insert(vo);    //업로드한 파일을 테이블 컬럼 값으로 저장.
	         System.out.println("gallery insert 성공!");
	      }catch(Exception e){   e.printStackTrace();   }
		
		
		
		
		return new ActionForward(true, "gallery.do");
	}

}
