package project_ifrill.service;

import java.util.ArrayList;

import project_ifrill.dto.Address;
import project_ifrill.dto.Member;

public interface MemberService {
	int confirmId(String userId);
	
	ArrayList<Address> showAddressByDong(String dong);
	
	int joinMember(Member member);	//insert 구문A
	
	Member getMember(String id);
	// 회원 수정
		int updateMember(Member member);
		
		// 비밀번호 변경
		int changePass1(Member member);
		
		// 회원 탈퇴
		int leaveMember(Member member);
		
		// 관리자 회원 탈퇴
		int deleteMember(Member member);
		
	//관리자모드
	ArrayList<Member> getMemberList(String memberName);
}
