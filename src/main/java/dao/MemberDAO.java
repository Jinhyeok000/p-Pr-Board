package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

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
        String sql = "insert into p_member values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int result = 0;
        try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
            pstat.setString(1, dto.getId());
            pstat.setString(2, dto.getPw());
            pstat.setString(3, dto.getName());
            pstat.setString(4, dto.getPhone());
            pstat.setString(5, dto.getEmail());
            pstat.setString(6, dto.getGender());
            pstat.setTimestamp(7, dto.getJoin_date());
            pstat.setString(8, dto.getProfile_img());
            pstat.setInt(9, dto.getUser_level());

            result = pstat.executeUpdate();
        }
        return result;
	}
	
	/*
	 * 아이디 찾기 메소드
	 * @author Jin hyeok Jo
	 */
    public boolean findId(String id) throws Exception {
        String sql = "select * from p_member where id = ?";
        try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
            pstat.setString(1, id);
            try (ResultSet rs = pstat.executeQuery();) {
                return rs.next();
            }
        }
    }

	/*
	 * 로그인 메소드
	 * @author Jin hyeok Jo
	 */
    public boolean loginId(String id, String pw) throws Exception {
        String sql = "select * from p_member where id = ? and pw = ?";
        try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
            pstat.setString(1, id);
            pstat.setString(2, pw);
            try (ResultSet rs = pstat.executeQuery();) {
                return rs.next();
            }
        }
    }

	
	/*
	 * 회원 정보 마이페이지 출력 메소드
	 * @author Ji Yeon Kim
	 */
	
	public MemberDTO selectMyMemberdata(String target) throws Exception{
		
		String sql = "select * from p_member where id=?";
		
				try(Connection con = this.getConnection();
						PreparedStatement pstst = con.prepareStatement(sql);){
					pstst.setString(1, target);
					
					try(ResultSet rs= pstst.executeQuery();){
						MemberDTO dto = null;
						while (rs.next()) {
							String id = rs.getString("id");
							String pw = rs.getString("pw");
							String name = rs.getString("name");
							String phone = rs.getString("phone");
							String email = rs.getString("email");
							String gender = rs.getString("gender");
							Timestamp join_date = rs.getTimestamp("join_data");
							String profile_img = rs.getString("profile_img");
							int user_level = rs.getInt("user_level");
							
							dto = new MemberDTO(id, pw, name, phone, email, gender ,join_date, profile_img,user_level);
						}
						return dto;
					}
				}
				
	}
	
	

}
