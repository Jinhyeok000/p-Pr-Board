package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberDTO;

/*
 * Membership 관련 DAO
 * 로그인, 회원가입, 로그아웃, 회원탈퇴, 회원정보, 정보수정 
 */

public class MemberDAO {
	public static MemberDAO instance;
	
	public synchronized static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
			
		}return instance;
	}
	
	public MemberDAO() {
		
	}
	
	private Connection getConnection() throws Exception{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	/*
	 * 회원 가입 메소드
	 * @author Jin hyeok Jo
	 */
	public int registerMember(MemberDTO dto) throws Exception{
        String sql = "insert into members values(?, ?, ?, ?, ?, ?, ?, ?)";
        int result = 0;
        try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
            pstat.setString(1, dto.getId());
            pstat.setString(2, dto.getPw());
            pstat.setString(3, dto.getName());
            pstat.setString(4, dto.getPhone());
            pstat.setString(5, dto.getEmail());
            pstat.setTimestamp(6, dto.getJoin_date());
            pstat.setString(7, dto.getProfile_img());
            pstat.setInt(8, dto.getUser_level());

            result = pstat.executeUpdate();
        }
        return result;
	}

}
