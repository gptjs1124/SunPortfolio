package sun.spring.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.web.multipart.MultipartFile;

public class ContactDTO {
	private int seq;
	private int row_num;
	//private int rnum;
	private String category;
	private String title;
	private String company;
	private String grade;
	private String name;
	private String tel;
	private String content;
	private Timestamp con_date; //데이터베이스에서 가지고 온  저장시간
	private String startDate;
	private String endDate;
	private String dateWrite; //저장시간 변경한 시간
	private String boardck;
	private MultipartFile file;
	private String filename;
	private byte[] fileVolume;
	private String contact;
	
	private StringBuilder sb;	
	private String selTel;
	private String phone01;
	private String phone02;

	//codeGroup
	private int contactstepseq;
	private String cmns_cd;
	private String cmns_cd_nm;
	
	public ContactDTO() {
		super();
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getRow_num() {
		return row_num;
	}

	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCon_date() {
		return con_date;
	}

	public void setCon_date(Timestamp con_date) {
		this.con_date = con_date;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDateWrite() {
		/* 데이터베이스에서 가지고온 게시글 저장시간 커스텀 */
		long con_data = this.con_date.getTime(); // 데이터베이스에서 가지고온 시간
		long current_time = System.currentTimeMillis(); //현재시간
		long getTime = (current_time - con_data)/1000; // 지금시간 - 데이터베이스에서 가지고온 시간을 뺀것
		if(getTime < 60) {
			return "방금 전";
		}else if(getTime < 300) {
			return "5분 이내";
		}else if(getTime < 3600) {
			return "1시간 이내";
		}else {
			this.dateWrite = new SimpleDateFormat("YYYY-MM-dd").format(con_data);
			//SimpleDateFormat은 .format에 들어간 데이터를 SimpleDateFormat("YYYY-MM-dd")처럼 변경한다는 뜻
			return dateWrite;
		}
	}

	public void setDateWrite(String dateWrite) {
		this.dateWrite = dateWrite;
	}

	public String getBoardck() {
		return boardck;
	}

	public void setBoardck(String boardck) {
		this.boardck = boardck;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getFileVolume() {
		return fileVolume;
	}

	public void setFileVolume(byte[] fileVolume) {
		this.fileVolume = fileVolume;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}

	public String getSelTel() {
		return selTel;
	}

	public void setSelTel(String selTel) {
		this.selTel = selTel;
	}

	public String getPhone01() {
		return phone01;
	}

	public void setPhone01(String phone01) {
		this.phone01 = phone01;
	}

	public String getPhone02() {
		return phone02;
	}

	public void setPhone02(String phone02) {
		this.phone02 = phone02;
	}

	public int getContactstepseq() {
		return contactstepseq;
	}

	public void setContactstepseq(int contactstepseq) {
		this.contactstepseq = contactstepseq;
	}

	public String getCmns_cd() {
		return cmns_cd;
	}

	public void setCmns_cd(String cmns_cd) {
		this.cmns_cd = cmns_cd;
	}

	public String getCmns_cd_nm() {
		return cmns_cd_nm;
	}

	public void setCmns_cd_nm(String cmns_cd_nm) {
		this.cmns_cd_nm = cmns_cd_nm;
	}
}
