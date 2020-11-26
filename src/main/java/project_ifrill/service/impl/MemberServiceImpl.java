package project_ifrill.service.impl;

import java.util.ArrayList;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_ifrill.dto.Address;
import project_ifrill.dto.Member;
import project_ifrill.mapper.AddressMapper;
import project_ifrill.mapper.MemberMapper;
import project_ifrill.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	protected static final Log log = LogFactory.getLog(CartServiceImpl.class);

	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private AddressMapper addressMapper;

	@Override
	public int confirmId(String userId) {
		log.debug("service - confirmId() userId >> " + userId);
		return mapper.confirmID(userId);
	}

	@Override
	public ArrayList<Address> showAddressByDong(String dong) {
		ArrayList<Address> list = addressMapper.selectAddressByDong(dong);
		log.debug("service - confrimId() dong >> " + dong);
		return list;
	}

	@Override
	public int joinMember(Member member) {
		log.debug("service - joinMember() member >> " + member);
		return mapper.insertMember(member);
	}

	@Override
	public Member getMember(String id) {
		log.debug("service - getMember() id >> " + id);
		return mapper.getMember(id);
	}

	@Override
	public ArrayList<Member> getMemberList(String memberName) {
		ArrayList<Member> list = mapper.listMember(memberName);
		log.debug("service - getMemberList");
		return mapper.listMember(memberName);
	}

	@Override
	public int updateMember(Member member) {
		log.debug("service - updateMember() member >> " + member);
		return mapper.updateMember(member);
	}

	@Override
	public int changePass1(Member member) {
		log.debug("service - changePass1() member >> " + member);
		return mapper.changePass1(member);
	}

	@Override
	public int leaveMember(Member member) {
		log.debug("service - leaveMember() member >> " + member);
		return mapper.leaveMember(member);
	}

	@Override
	public int deleteMember(Member member) {
		log.debug("service - deleteMember() member >> " + member);
		return mapper.deleteMember(member);
	}


}
