package notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "header", urlPatterns = { "/notice/header" })
public class Header extends HttpServlet {
	//doget dopost 접근할지 모를때 일단 doget으로 하고 나중에 get post만 바꾸면됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
//		세션에 있는 것을 우선 꺼내고
		
		try {
			//같이 꺼내서 담는 형식을 소스코드로 읽기 쉽게 모아서 두어야함!!
			boolean isLogin = (boolean) session.getAttribute("isLogin");
			String loginUserName = (String) session.getAttribute("loginUserName");
			String userLevel = (String) session.getAttribute("userLevel");
			
			//json의 MIME타입을 모르니 모질라에서 찾으면 application/json을 넣어줘야함
			response.setContentType("application/json;charset=utf-8");
			
			PrintWriter out = response.getWriter();
			
//			out.print("isLogin=true"); // 전달할 값들이 많아서 이름에 값을 담음
			

			
//			out.print("loginUserName="+loginUserName);
			//ajax를 이용하여 javascript에서 사용할것
			
			//앞에 정보들을 json에 담아서 출력해줘야함
			out.print("{\"isLogin\":true,\"loginUserName\":\"" + loginUserName + ",\"userLevel\":\"" + userLevel + "\"}");
			
			out.close();
			
		}catch(NullPointerException e) {
			// 로그인 하지 않은 사용자의 경우 예외가 발생함
			PrintWriter out = response.getWriter();
			
			out.print("{\"isLogin\":false}"); // 전달할 값들이 많아서 이름에 값을 담음
			// 하나의 형식으로 출력해주는게 좋음 따라서 위처럼 json으로 바꾸어야함
		}
		//마지막으로 url을 경로설정 잘이어지도록 해줘야함
		
		
		
		
//		헤더가 사용할 서블릿(서비스)
//		-> 로그인 여부 알려줘야함
//		-> 로그인했다면 isLogin=true
//		-> 로그인한 사용자의 이름 loginUserName=name1
//		-> 로그인한 사용자의 레벨 loginUserLevel=user
		
	}

		
		

}
