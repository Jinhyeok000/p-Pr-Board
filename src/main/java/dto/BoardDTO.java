package dto;

import java.sql.Timestamp;

public class BoardDTO {
	private int seq;
	private String writer;
	private String title;
	private String content;
	private Timestamp write_date;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public BoardDTO() {
		super();
	}
	public BoardDTO(int seq, String writer, String title, String content, Timestamp write_date) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.write_date = write_date;
	}
	
}
