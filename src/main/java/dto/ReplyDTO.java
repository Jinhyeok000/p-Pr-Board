package dto;

import java.sql.Timestamp;

public class ReplyDTO {
	private int seq;
	private String writer;
	private String content;
	private Timestamp write_date;
	private int parent_seq;
	public ReplyDTO(int seq, String writer, String content, Timestamp write_date, int parent_seq) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.content = content;
		this.write_date = write_date;
		this.parent_seq = parent_seq;
	}
	public ReplyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	
	

}
