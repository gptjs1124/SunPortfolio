package sun.spring.dto;

public class AdminDTO {
	private int seq = 0;
	private String id = "";
	private String pw = "";
	
	public AdminDTO(int seq, String id, String pw) {
		super();
		this.seq = seq;
		this.id = id;
		this.pw = pw;
	}
	
	public AdminDTO() {
		super();
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
