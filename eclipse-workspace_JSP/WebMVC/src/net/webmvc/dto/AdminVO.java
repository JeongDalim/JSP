package net.webmvc.dto;

public class AdminVO {
	private int idx;
	private String adid;
	private String adpass;
	private String regdate;
	private String updatedate;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

	public String getAdpass() {
		return adpass;
	}

	public void setAdpass(String adpass) {
		this.adpass = adpass;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
}
