package sun.spring.dto;

import java.sql.Timestamp;

public class CommentDTO {
	private int seq; //sunportfolio SEQ
	private int comment_seq;
	private String user_idntf_id;
	private String comment_text;
	private Timestamp comment_date;
	private Timestamp frst_reg_dt;
	private String frst_rgtr_id;
	private Timestamp last_mdfcn_dt;
	private String last_mdfr_id;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getComment_seq() {
		return comment_seq;
	}

	public void setComment_seq(int comment_seq) {
		this.comment_seq = comment_seq;
	}

	public String getUser_idntf_id() {
		return user_idntf_id;
	}

	public void setUser_idntf_id(String user_idntf_id) {
		this.user_idntf_id = user_idntf_id;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public Timestamp getComment_date() {
		return comment_date;
	}

	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}

	public Timestamp getFrst_reg_dt() {
		return frst_reg_dt;
	}

	public void setFrst_reg_dt(Timestamp frst_reg_dt) {
		this.frst_reg_dt = frst_reg_dt;
	}

	public String getFrst_rgtr_id() {
		return frst_rgtr_id;
	}

	public void setFrst_rgtr_id(String frst_rgtr_id) {
		this.frst_rgtr_id = frst_rgtr_id;
	}

	public Timestamp getLast_mdfcn_dt() {
		return last_mdfcn_dt;
	}

	public void setLast_mdfcn_dt(Timestamp last_mdfcn_dt) {
		this.last_mdfcn_dt = last_mdfcn_dt;
	}

	public String getLast_mdfr_id() {
		return last_mdfr_id;
	}

	public void setLast_mdfr_id(String last_mdfr_id) {
		this.last_mdfr_id = last_mdfr_id;
	}
}
