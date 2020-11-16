package project_ifrill.controller;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project_ifrill.dto.Address;
import project_ifrill.dto.Member;
import project_ifrill.exception.DuplicateException;
import project_ifrill.service.MemberService;

@RestController
@RequestMapping("/api")
public class RestMemberController {
	@Autowired
	private MemberService service;
	
	@GetMapping("/confirmId/{userId}")
	public ResponseEntity<Object> confirmId(@PathVariable("userId") String userId ){
		System.out.println("confirmId() userId >> " + userId);
		int res = service.confirmId(userId);
		
		if(res == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/showAddressByDong/{dong}")
	public ResponseEntity<Object> showAddressByDong(@PathVariable("dong") String dong){
		System.out.println("showAddressByDong() dong >> " + dong);
		ArrayList<Address> list = service.showAddressByDong(dong);
		if(list == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/joinMember")
	public ResponseEntity<Object> joinMember(@RequestBody Member member){
		System.out.println("joinMember() member >> " + member);
		try {
			service.joinMember(member);
			URI uri = URI.create("/api/joinMember/" + member.getId());
			return ResponseEntity.created(uri).body(member.getId());
		}catch (DuplicateException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@GetMapping("/getMember/{id}")
	public ResponseEntity<Object> getMember(@PathVariable("id") String id){
		System.out.println("getMember() id >> " + id);
		Member getMember = service.getMember(id);
		
		if(getMember == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(getMember);
	}
	
	
	//관리자모드
	@GetMapping("/getMemberList/{memberName}")
	public ResponseEntity<Object> getMemberList(@PathVariable("memberName") String memberName){
		System.out.println("getMemberList() memberName>> " + memberName );
		ArrayList<Member> list = service.getMemberList(memberName);
		
		if(list == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(list);
	}
	
}
