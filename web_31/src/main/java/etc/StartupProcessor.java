package etc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import vo.MemberInfo;
import vo.NoticeInfo;

// 이 서블릿을 직접 등록하고
// 등록할 때 load-on-startup 태그를 사용해서
// 서버가 시작되면서 서블릿이 만들어지도록하세요

// 서블릿이 만들어질때 우리에게 필요한 계정을 생성해서
// DB에 저장하도록하세요

public class StartupProcessor extends HttpServlet{
	// 클래스를 http서블릿으로
	// loadonStartup할때 생성해주기
	// 서블릿의 라이프사이클
	// 클라이언트가 서블릿으로 최초로 접근했을때 ->
	// 1. init()
	// 2. service()
	//	-> 서블릿 안에 service() 오버라이딩을 했다면 service() 호출
	//	그렇지 않고 doGet, doPost 등의 메서드를 오버라이딩 했다면
	//		클라이언트의 요청방식(Method)에 따라서 알맞는 do~()메서드가 호출
	//
	// 클라이언트가 서블릿으로 두번째로 접근했을 때 실행되는 메서드 순서 ->
	// 1. service()
	//	-> 서블릿 안에 service() 오버라이딩을 했다면 service() 호출
	//	그렇지 않고 doGet, doPost 등의 메서드를 오버라이딩 했다면
	//		클라이언트의 요청방식(Method)에 따라서 알맞는 do~()메서드가 호출
	
	// init 오버라이딩하는데 매개변수있는건 
	@Override
	public void init() throws ServletException {
		System.out.println("<<StartupProcessor 동작>>");
		
		MemberInfo memberInfo = new MemberInfo("id1", "pw1", "name1");
		MemberInfo adminInfo = new MemberInfo("admin", "admin123", "관리자");
		
		Database.memberInfoTable.add(memberInfo);
		Database.memberInfoTable.add(adminInfo);
	
		
		NoticeInfo noticeInfo = new NoticeInfo("제목1", "내용1");
		Database.noticeInfoTable.add(noticeInfo);
		noticeInfo = new NoticeInfo("제목2", "내용2");
		Database.noticeInfoTable.add(noticeInfo);
		noticeInfo = new NoticeInfo("제목3", "내용3");
		Database.noticeInfoTable.add(noticeInfo);
		noticeInfo = new NoticeInfo("제목4", "내용4");
		Database.noticeInfoTable.add(noticeInfo);
	
		
	}
	
	
	
	
	
}


