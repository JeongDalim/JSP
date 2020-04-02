package Day_0527.javaBean;

public class NocticeBean {
	private int idx;
	private String subject;
	private String regdate;
	private int readcnt;

	public NocticeBean() {

	}

	public NocticeBean(int idx, String subject, String regdate, int readcnt) {
		this.idx = idx;
		this.subject = subject;
		this.regdate = regdate;
		this.readcnt = readcnt;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
}
