package notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etc.Database;
import vo.NoticeInfo;

@WebServlet(name = "write", urlPatterns = { "/notice/write" })
public class Write extends HttpServlet {
	// doGet과 doPost중 어느것을 쓸건지는 form.html에서 doPost을 써서 그것을 따라가면됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		// 공지사항 데이터들을 공지사항 정보로 뭉쳐줌
		NoticeInfo noticeInfo = new NoticeInfo(title, contents);
		
		
		// 공지사항 테이블에 공지사항 작성
		Database.noticeInfoTable.add(noticeInfo);
		
		
		// 공지사항 목록 페이지로 이동 url이 바뀌어야하니 sendRedirect사용
		response.sendRedirect("/web_31/notice/list.html");
		
		
	}

}
