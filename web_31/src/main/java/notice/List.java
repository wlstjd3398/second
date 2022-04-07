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

@WebServlet(name = "list", urlPatterns = { "/notice/list" })
public class List extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지사항의 목록을 불러와 전달해주는 서블릿
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("{\"noticeList\":[");
		
		String data = "";
		
		for(NoticeInfo noticeInfo : Database.noticeInfoTable) {
			data = data + "{\"title\":\""+ noticeInfo.getTitle() + "\","
					+ "\"contents\":\"" + noticeInfo.getContents() +"\"},";
		}
			data = data.substring(0, data.length()-1);
			// 마지막,를 substring으로 data.length()-2로 잘라줌
			// -2를 -1로 수정하면 원하는대로 수정됨
			
			out.print(data);
			
		
		
		// json으로 공지사항정보를 전달해줘야함
		
		out.print("]}");
		out.close();
		
	}


}
