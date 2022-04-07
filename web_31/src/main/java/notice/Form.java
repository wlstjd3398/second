package notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 용도 : 공지사항쓰기 페이지로 들어갈 때 접근해야할 서블릿
// 		권한이 있는 사용자(관리자)가 접근했을 때만 공지사항 쓰기 페이지가 보이도록 하고
//		권한이 없는 사용자(로그인을 하지 않았거나 일반사용자로 로그인) 가 접근했을 때는 메인 페이지가 보이도록 하는 서블릿


@WebServlet(name = "form", urlPatterns = { "/notice/form" })
public class Form extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//권한이 있는 사용자(관리자)가 접근했을 때만 공지사항 쓰기 페이지가 보이도록 하고
		
//		String uri;
		
		try {
			HttpSession session = request.getSession();
			String userLevel = (String) session.getAttribute("userLevel");
			
			// 로그인하지않은 사용자가 Null로 공지사항쓰기로 접근 -> Null -> 예외처리
			
			if(userLevel.equals("admin")) {
				// 권한이 있는 사용자가 접근했을 때 공지사항 쓰기 페이지가 보이도록
				RequestDispatcher rd = request.getRequestDispatcher("/notice/form.html");
				rd.forward(request, response);
//				RequestDispatcher rd = request.getRequestDispatcher("/notice/form.html");
//				rd.forward(request, response);
			}else {
				// 권한이 없는 사용자가 접근했을때는 메인 페이지가 보이도록
				response.sendRedirect("/web_31/main");
//				RequestDispatcher rd = request.getRequestDispatcher("/main/index.html");
//				rd.forward(request, response);
			}
		}catch(NullPointerException e) {
			// 로그인을 하지 않은 사용자가 접근했을 때 메인 페이지가 보이도록
			response.sendRedirect("/web_31/main");
//			RequestDispatcher rd = request.getRequestDispatcher("/main/index.html");
//			rd.forward(request, response);
			
		}
		
		// rd를 catch 밖으로 꺼내고 uri 경로를 지정해주어서 코드가 더깔끔해짐
//		RequestDispatcher rd = request.getRequestDispatcher(uri);
//		rd.forward(request, response);
		
		
		
		
		//권한이 없는 사용자(로그인을 하지 않았거나 일반사용자로 로그인) 가 접근했을 때는 메인 페이지가 보이도록 하는 서블릿
		
	}

}
