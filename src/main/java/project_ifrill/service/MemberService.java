package project_ifrill.service;

import java.util.ArrayList;

import project_ifrill.dto.Address;
import project_ifrill.dto.Member;

public interface MemberService {
	int confirmId(String userId);
	
	ArrayList<Address> showAddressByDong(String dong);
	
	int joinMember(Member member);
	
	Member getMember(String id);
	
	ArrayList<Member> getMemberList(String memberName);
}
