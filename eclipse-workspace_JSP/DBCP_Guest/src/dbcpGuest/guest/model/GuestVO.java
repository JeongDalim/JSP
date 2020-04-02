package dbcpGuest.guest.model;

public class GuestVO {
	private int idx;
	private String name;
	private String subject;
	private String content;
	private String indate;
	private String readcnt;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(String readcnt) {
		this.readcnt = readcnt;
	}

}