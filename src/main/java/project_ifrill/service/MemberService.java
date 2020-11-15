package project_ifrill.service;

import java.util.ArrayList;

import project_ifrill.dto.Address;
import project_ifrill.dto.Member;

public interface MemberService {
	int confirmId(String userId);
	
	ArrayList<Address> showAddressByDong(String dong);
	
	int joinMember(Member member);	//insert 구문A
	
	Member getMember(String id);
	
	
	//관리자모드
	ArrayList<Member> getMemberList(String memberName);
}
