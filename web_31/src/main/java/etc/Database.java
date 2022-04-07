package etc;

import java.util.ArrayList;
import java.util.List;

import vo.MemberInfo;
import vo.NoticeInfo;

public class Database {
	public static List<MemberInfo> memberInfoTable = new ArrayList<>();
	//클래스의 정보가 읽힐때 static 사용
	
	//공지사항 테이블
	public static List<NoticeInfo> noticeInfoTable = new ArrayList<>();
	
}
