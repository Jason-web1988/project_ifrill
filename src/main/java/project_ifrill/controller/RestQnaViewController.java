package project_ifrill.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project_ifrill.dto.QnA;
import project_ifrill.service.QnAService;

@RestController
@RequestMapping("/api")
public class RestQnaViewController {

	@Autowired
	private QnAService service;
	
	@GetMapping("/getQnaLists")
	public ResponseEntity<Object> getQnaLists(@RequestBody QnA qnA){
		System.out.println("getQnaLists() Qna --> " + qnA);
		ArrayList<QnA> qnaList = service.listAllQnA();
		
		if(qnaList == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(qnaList);
	}
}
