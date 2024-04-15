package sun.spring.dto;

public class AdminIpCkDTO {
	private String ip;
	private int visiteCnt;
	private String visitDate;
	
	public AdminIpCkDTO() {
		super();
	}

	public AdminIpCkDTO(String ip, int visiteCnt, String visitDate) {
		super();
		this.ip = ip;
		this.visiteCnt = visiteCnt;
		this.visitDate = visitDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getVisiteCnt() {
		return visiteCnt;
	}

	public void setVisiteCnt(int visiteCnt) {
		this.visiteCnt = visiteCnt;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}	
	
}
