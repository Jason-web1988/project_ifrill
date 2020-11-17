package project_ifrill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project_ifrill.dto.Product;
import project_ifrill.service.ProductService;

@RestController
@RequestMapping("/api")
public class RestProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/newProducts")
	public ResponseEntity<Object> newProducts(){
		System.out.println("newProducts()");
		return ResponseEntity.ok(service.newProducts());
	}
	
	@GetMapping("/bestProducts")
	public ResponseEntity<Object> bestProducts(){
		System.out.println("bestProducts()");
		return ResponseEntity.ok(service.bestProducts());
	}
	
	@GetMapping("/getProduct/{no}")
	public ResponseEntity<Object> getProduct(@PathVariable int no){
		System.out.println("getProduct()");
		Product product = service.getProduct(no);
		
		if(product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("/kindProducts/{name}")
	public ResponseEntity<Object> kindProducts(@PathVariable("name") String name){
		System.out.println("kindProducts()");
		return ResponseEntity.ok(service.kindProducts(name));
	}
	

	
	
}