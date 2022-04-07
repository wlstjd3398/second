package vo;

// 회원 가입 시 입력할 회원 정보를 저장할 클래스
public class MemberInfo {
	private String nickname;
	private String id;
	private String pw;
	
	//생성자를 자동으로 추가하는법(alt + shift + o)
	public MemberInfo(String id, String pw, String nickname) {
//		super(); //부모생성자인 object를 불러옴 의미없음
		this.nickname = nickname;
		this.id = id;
		this.pw = pw;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}
