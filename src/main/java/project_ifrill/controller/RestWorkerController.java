package project_ifrill.controller;

import java.net.URI;

import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project_ifrill.dto.Worker;
import project_ifrill.service.WorkerService;

@RestController
@RequestMapping("/worker")
public class RestWorkerController {
	@Autowired
	private WorkerService service;
	
	@PostMapping("/check")
	public ResponseEntity<Object> workerCheck(@RequestBody Worker worker){
		System.out.println("workerCheck >> " + worker);
		try {
			int res = service.workerCheck(worker);
			if(res == 1) {
			return ResponseEntity.ok(res);
			}
		}catch (BindingException e) {}
			System.out.println("WorkService 비번틀리는 에러입니다.");
			return ResponseEntity.status(HttpStatus.CONFLICT).build(); 
	}
}
