package Day_0527.javaBean;

public class MemberBean {
	private String name;
	private String userid;

	public MemberBean() {

	}

	public MemberBean(String name, String userid) {
		this.name = name;
		this.userid = userid;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MemberVO [name=" + name + ", userid=" + userid + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}
