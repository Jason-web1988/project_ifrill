package project_ifrill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project_ifrill.dto.Worker;
import project_ifrill.service.WorkerService;

@Controller
@RequestMapping("/workerCheck")
public class WorkerController {
	@Autowired
	private WorkerService service;
	
	@RequestMapping("/worker/{worker}")
	public int checkWorker(@PathVariable("worker") Worker worker){
		System.out.println("Worker() worker >> " + worker);
		int getWorker = service.workerCheck(worker);
		return getWorker;
		
		일부러 에러~~~ 여기부터시작입니다.
	}
}
