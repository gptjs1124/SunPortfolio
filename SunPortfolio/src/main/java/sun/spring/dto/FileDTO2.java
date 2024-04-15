package sun.spring.dto;

public class FileDTO2 {
	private int seq;
	private String sysname;
	private String oriname;
	private String realpath;
	
	public FileDTO2() {
		super();
	}
	
	public FileDTO2(int seq, String sysname, String oriname, String realpath) {
		super();
		this.seq = seq;
		this.sysname = sysname;
		this.oriname = oriname;
		this.realpath = realpath;
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
	
}
