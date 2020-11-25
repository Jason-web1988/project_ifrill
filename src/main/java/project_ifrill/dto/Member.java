package project_ifrill.dto;

import java.util.Date;

public class Member {
	private String id; /* 회원아이디 */
	private String pwd; /* 회원암호 */
	private String name; /* 회원이름 */
	private String email; /* 회원이메일 */
	private String zipNum; /* 우편번호 */
	private String address; /* 주소 */
	private String phone; /* 전화번호 */
	private String leave_yn; /* 탈퇴여부 */
	private Date joinDate;/* 가입일 */

	public Member() {
	}

	public Member(String id) {
		super();
		this.id = id;
	}

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Member(String id, String pwd, String name, String email, String zipNum, String address, String phone) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.zipNum = zipNum;
		this.address = address;
		this.phone = phone;
	}

	public Member(String id, String pwd, String name, String email, String zipNum, String address, String phone,
			String leave_yn, Date joinDate) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.zipNum = zipNum;
		this.address = address;
		this.phone = phone;
		this.leave_yn = leave_yn;
		this.joinDate = joinDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipNum() {
		return zipNum;
	}

	public void setZipNum(String zipNum) {
		this.zipNum = zipNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLeave_yn() {
		return leave_yn;
	}

	public void setLeave_yn(String leave_yn) {
		this.leave_yn = leave_yn;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return String.format(
				"Member [id=%s, pwd=%s, name=%s, email=%s, zip_num=%s, address=%s, phone=%s, leave_yn=%s, join_date=%s]",
				id, pwd, name, email, zipNum, address, phone, leave_yn, joinDate);
	}

}
