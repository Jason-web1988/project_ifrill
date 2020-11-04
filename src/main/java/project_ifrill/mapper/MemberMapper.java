package project_ifrill.mapper;

import java.util.ArrayList;

import project_ifrill.dto.Member;

public interface MemberMapper {
	 	int confirmID(String userId);
	    Member getMember(String id);
	    int insertMember(Member member);
	    
	    //관리자모드 사용
	    ArrayList<Member> listMember(String name);
}
