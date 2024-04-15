package sun.spring.dto;

/* DB에 파일 테이블 하나 만들어서 넣기
 * 파일 저장하기
 * */
public class FileDTO {
	private int seq;
	private String sysname;
	private String oriname;
	private String realpath;
	private int contactSeq;
	
	public FileDTO() {
		super();
	}
	
	public FileDTO(int seq, String sysname, String oriname, String realpath, int contactSeq) {
		super();
		this.seq = seq;
		this.sysname = sysname;
		this.oriname = oriname;
		this.realpath = realpath;
		this.contactSeq = contactSeq;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getSysname() {
		return sysname;
	}
	public int getContactSeq() {
		return contactSeq;
	}
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getRealpath() {
		return realpath;
	}
	public void setRealpath(String realpath) {
		this.realpath = realpath;
	}
	public int setContactSeq(int contactSeq) {
		return contactSeq;
	}
}
