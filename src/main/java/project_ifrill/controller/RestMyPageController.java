package project_ifrill.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project_ifrill.dto.Kind;
import project_ifrill.dto.Member;
import project_ifrill.service.MemberService;

@RestController
@RequestMapping("/api")
public class RestMyPageController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/myPage/{kind}")
	public ResponseEntity<Object> getMemberInfo(@PathVariable String id){
		System.out.println("getMemberInfo()");
		Member member = service.getMember(id);
		
		if(member == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(member);
	}
	
	@GetMapping("/myPageList")		// 목록 불러오기
	public ResponseEntity<Object> myPageList(){
		List<Kind> myPageList = Arrays.asList(
					new Kind(1, "회원 정보 수정"),
					new Kind(2, "구매내역"),
					new Kind(3, "환불내역"),
					new Kind(4, "장바구니")
				);
		myPageList.stream().forEach(System.out::println);
		return ResponseEntity.ok(myPageList);
	}
	
	
}
