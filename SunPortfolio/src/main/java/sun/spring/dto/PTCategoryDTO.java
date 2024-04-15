package sun.spring.dto;

public class PTCategoryDTO {
	private String ctg_no;
	private String ctg_nm;
	private String up_ctg_no;
	private String disp_yn;
	private int seq;
	private String note;
	
	
	public PTCategoryDTO() {}
	
	public PTCategoryDTO(String ctg_no, String ctg_nm, String up_ctg_no, String disp_yn, int seq, String note) {
		super();
		this.ctg_no = ctg_no;
		this.ctg_nm = ctg_nm;
		this.up_ctg_no = up_ctg_no;
		this.disp_yn = disp_yn;
		this.seq = seq;
		this.note = note;
	}
	
	public String getCtg_no() {
		return ctg_no;
	}
	public void setCtg_no(String ctg_no) {
		this.ctg_no = ctg_no;
	}
	public String getCtg_nm() {
		return ctg_nm;
	}
	public void setCtg_nm(String ctg_nm) {
		this.ctg_nm = ctg_nm;
	}
	public String getUp_ctg_no() {
		return up_ctg_no;
	}
	public void setUp_ctg_no(String up_ctg_no) {
		this.up_ctg_no = up_ctg_no;
	}
	public String getDisp_yn() {
		return disp_yn;
	}
	public void setDisp_yn(String disp_yn) {
		this.disp_yn = disp_yn;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
