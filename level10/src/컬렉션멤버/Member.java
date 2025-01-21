package 컬렉션멤버;

public class Member{
	private String id;
	private String pw;
	private String name;
	Member(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getName() {
		return name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "[ID = " + id + ", \t PW = " + pw + ", \t name = " + name + "]";
	}
	
}
