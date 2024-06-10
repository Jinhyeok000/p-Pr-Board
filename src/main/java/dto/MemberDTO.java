package dto;

import java.sql.Timestamp;

public class MemberDTO {
	private String id; // 아이디
	private String pw; // 비밀번호
	private String name; // 이름
	private String phone; // 폰 번호
	private String email; // 이메일
	private String gender; // 성별
	private Timestamp join_date; // 가입 날짜
	private String profile_img; // 프로필 이미지
	private int user_level; // 레벨 
	
	public MemberDTO(String id, String pw, String name, String phone, String email, String gender, Timestamp join_date,
			String profile_img, int user_level) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.join_date = join_date;
		this.profile_img = profile_img;
		this.user_level = user_level;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Timestamp getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Timestamp join_date) {
		this.join_date = join_date;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public int getUser_level() {
		return user_level;
	}
	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}
}
