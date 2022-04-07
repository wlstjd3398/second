package vo;

public class NoticeInfo {
	private String title;
	private String contents;
	
	public NoticeInfo(String title, String contents) {
		this.title = title;
		this.contents = contents;
		
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
		
	
		
}
