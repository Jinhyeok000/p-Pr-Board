package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.ReplyDTO;

public class ReplyDAO {
	//singletone
	private ReplyDAO() {}
	public static ReplyDAO instance;

	public synchronized static ReplyDAO getInstance() {
		if(instance==null) {
			instance=new ReplyDAO();
		}
		return instance;
	}

	//JNDI
	private Connection getConnection() throws Exception{
		Context ctx=new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	//1. 글 추가하기 insert
	public ReplyDTO insert(ReplyDTO dto) throws Exception {
		String sql = "insert into preply values(preply_seq.nextval,?,?,sysdate,?)";
		try (Connection con = this.getConnection(); PreparedStatement ps = con.prepareStatement(sql, new String[]{"seq", "write_date"})) {
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getContent());
			ps.setInt(3, dto.getParent_seq());
			ps.executeUpdate();

			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					int seq = rs.getInt(1);
					Timestamp writeDate = rs.getTimestamp(2);
					return new ReplyDTO(seq, dto.getWriter(), dto.getContent(), writeDate, dto.getParent_seq());
				} else {
					return null;
				}
			}
		}
	}

	//2. 전체 댓글 출력하기 select(ALL)
	public ArrayList<ReplyDTO> selectAll() throws Exception{
		String sql="select * from preply order by 1";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();){
			ArrayList<ReplyDTO> list=new ArrayList<ReplyDTO>();
			while(rs.next()){
				int seq=rs.getInt(1);
				String writer=rs.getString(2);
				String content=rs.getString(3);
				Timestamp write_date=rs.getTimestamp(4);
				int parent_seq=rs.getInt(5);

				list.add(new ReplyDTO(seq, writer, content, write_date, parent_seq));

			}
			return list;
		}
	}

	//3. delete
	public int deleteBySeq(int targetseq) throws Exception{
		String sql="delete from preply where seq=?";
		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setInt(1, targetseq);    
			return ps.executeUpdate();
		}
	}

	//4. update
	public int updateBySeq(int targetseq, String targetcontent) throws Exception{
		String sql="update preply set content=? where seq=? ";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, targetcontent);
			ps.setInt(2, targetseq);
			return ps.executeUpdate();

		}
	}


}
