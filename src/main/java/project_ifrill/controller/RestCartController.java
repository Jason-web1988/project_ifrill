package project_ifrill.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project_ifrill.dto.Cart;
import project_ifrill.exception.DuplicateException;
import project_ifrill.service.CartService;

@RestController						//Spring MVC Controller에 @ResponseBody가 추가된것, 주용도로 JSON형태로 객체 데이터를 반환
@RequestMapping("/api")				//api만들기
public class RestCartController {

	@Autowired
	private CartService service;
	
	@GetMapping("/getCartByMember/{mId}")
	public ResponseEntity<Object> getCartByMember(@PathVariable("mId") String mId){
		System.out.println("getCartByMember() mId >> " + mId);
		List<Cart> list = service.getCartByMember(mId);
		
		if(list == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/addCart")
	public ResponseEntity<Object> addCart(@RequestBody Cart cart){
		System.out.println("addCart() Cart >> " + cart);
		try {
			service.addCart(cart);
			URI uri = URI.create("/api/addCart/" + cart.getNo());
			return ResponseEntity.created(uri).body(cart.getNo());
		}catch (DuplicateException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@DeleteMapping("/removeCart/{Cart}")
	public ResponseEntity<Object> removeCart(@PathVariable int Cart){
		System.out.println("removeCart() + no >> "+ Cart);
		return ResponseEntity.ok(service.removeCart(Cart));
	}
}
