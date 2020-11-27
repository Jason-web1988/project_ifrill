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
	
	@GetMapping("/kindProducts/{kind}")
	public ResponseEntity<Object> kindProducts(@PathVariable String kind){
		System.out.println("kindProducts()");
		return ResponseEntity.ok(service.kindProducts(kind));
	}
	
	@GetMapping("/kindList")		//목록불러오기!
	public ResponseEntity<Object> kindList(){
		  List<Kind> kindList=Arrays.asList(
	                new Kind(1, "Heels"),
	                new Kind(2, "Boots"),
	                new Kind(3, "Sandals"),
	                new Kind(4, "Sneakers"),
	                new Kind(5, "On Sale")
	                );
		  kindList.stream().forEach(System.out::println);
		  return ResponseEntity.ok(kindList);
	}
	
}
