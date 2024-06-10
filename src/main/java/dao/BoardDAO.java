package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance;

	public synchronized static BoardDAO getInstance() {
		if (instance == null) {
			return new BoardDAO();
		} else {
			return instance;
		}
	}

	private BoardDAO() {}

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	//전체 글 목록 반환
	public List<BoardDTO> getList() throws Exception{
		String sql = "select * from pboard order by write_date desc";
		
		try(Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			List<BoardDTO> list = new ArrayList<>();
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp write_date = rs.getTimestamp("write_date");
				
				list.add(new BoardDTO(seq, writer, title, content, write_date));
			}
			return list;
		}
	}
	//한 페이지의 글 목록 반환
		public List<BoardDTO> getList(int n, int m) throws Exception{
			String sql = "select * from (select board.*, row_number() over(order by seq desc) rown from board) where rown between ? and ?";
			
			try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
				pstat.setInt(1, n);
				pstat.setInt(2, m);
				try(ResultSet rs = pstat.executeQuery()){
					List<BoardDTO> list = new ArrayList<>();
					while (rs.next()) {
						int seq = rs.getInt(1);
						String writer = rs.getString(2);
						String title = rs.getString(3);
						String contents = rs.getString(4);
						Timestamp write_date = rs.getTimestamp(5);
						BoardDTO ctt = new BoardDTO(seq, writer, title, contents, write_date);
						list.add(ctt);
					}
					return list;
				}
			}
		}
	// 게시판 글 작성
	   public int insert(BoardDTO dto) throws Exception {

		      String sql = "insert into board values(board_seq.nextval,?,?,?,sysdate)";
		      
		      try (Connection con = this.getConnection(); 
		    		  PreparedStatement pstat = con.prepareStatement(sql)) {

		         pstat.setString(1, dto.getWriter());
		         pstat.setString(2, dto.getTitle());
		         pstat.setString(3, dto.getContent());

		         return pstat.executeUpdate();

		      }
		   }
}
