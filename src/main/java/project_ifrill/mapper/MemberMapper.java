package project_ifrill.mapper;

import java.util.ArrayList;

import project_ifrill.dto.Member;

public interface MemberMapper {
	
	

	// 회원 가입
	  int insertMember(Member member);
	// 회원 수정
	int updateMember(Member member);
	
	// 비밀번호 변경
	int changePass1(Member member);
	
	// 회원 탈퇴
	int leaveMember(Member member);
	
	
	// 관리자 회원 탈퇴
	int deleteMember(Member member);



	
	
	
	
	
	 	int confirmID(String userId);
	    Member getMember(String id);
	 
	    
	    //관리자모드 사용
	    ArrayList<Member> listMember(String name);
}
