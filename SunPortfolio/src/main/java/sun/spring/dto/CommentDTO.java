package sun.spring.dto;

import java.sql.Timestamp;

public class CommentDTO {
	private int seq;
	private int sunportfolioSeq;
	private String name;
	private String commentText;
	private Timestamp commentDate;
	
	public CommentDTO() {
		super();
	}
	
	public CommentDTO(int seq, int sunportfolioSeq, String name, String commentText, Timestamp commentDate) {
		super();
		this.seq = seq;
		this.sunportfolioSeq = sunportfolioSeq;
		this.name = name;
		this.commentText = commentText;
		this.commentDate = commentDate;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getSunportfolioSeq() {
		return sunportfolioSeq;
	}
	public void setSunportfolioSeq(int sunportfolioSeq) {
		this.sunportfolioSeq = sunportfolioSeq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Timestamp getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}
	
	
}
