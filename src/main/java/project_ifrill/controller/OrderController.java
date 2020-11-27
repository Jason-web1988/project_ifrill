package project_ifrill.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project_ifrill.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@RequestMapping(value = "/selectSeqOrderIng", method = RequestMethod.GET)
	public ArrayList<Integer> selectSeqOrderIng(@RequestParam Map<String, Object> param){
//		String url = "mypage/mypage.jsp";
		
		String id = (String) param.get("MemberId");
		String result = (String) param.get("result");
		
		Map<String, Object> maps = new HashMap<>();
		maps.put("MemberId", id);
		maps.put("result", result);
		
		ArrayList<Integer> list = service.selectSeqOrderIng(maps);
		
		return list;
	}
}
