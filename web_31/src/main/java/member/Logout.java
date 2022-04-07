package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout")
public class Logout extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//-> 세션에 들어있는 로그인 관련 상태 정보를 삭제한다
		HttpSession session = request.getSession();
		session.removeAttribute("isLogin");
		session.removeAttribute("loginUserName");
		
		// 로그인말고 다른 상태정보가 있을 경우에는 invalidate 사용하면 안됨
		//session.invalidate();
		
		
//		RequestDispatcher rd = request.getRequestDispatcher("/main");
//		rd.forward(request, response);
		
		//url이 바뀌는게 좋음(sendRedirect)
		response.sendRedirect("/web_31/main");
		



		//-> 메인 페이지로 이동한다
		
		
	}


}
