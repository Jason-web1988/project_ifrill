package project_ifrill.controller;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.List;

=======
>>>>>>> branch 'master' of https://github.com/Jason-web1988/project_ifrill.git
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import project_ifrill.dto.Kind;
=======
>>>>>>> branch 'master' of https://github.com/Jason-web1988/project_ifrill.git
import project_ifrill.service.ProductService;

@Controller
@RequestMapping("/order")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/totalRecord/{productName}")
	public int totlaRecord(@PathVariable("productName") String productName) {
		System.out.println("totlaRecord() productName >> " + productName);
		
		int res = service.totalRecord(productName);
		
		return res;
	}
	
	@RequestMapping("/kindList")
	public String kindList() {
		List<Kind> kindList = Arrays.asList(
				new Kind(1, "Heel"),
				new Kind(2, "Boots"),
				new Kind(3, "Sandals"),
				new Kind(4, "Sneakers"),
				new Kind(5, "On sale")
				);
		
			Gson gson = new Gson();
	        String result = gson.toJson(kindList, new TypeToken<List<Kind>>(){}.getType());
	        System.out.println(result);
	               
	       	        
	        return result;
	}
	
	
	
	//페이징기법 해야함
//    public String pageNumber(int tpage, String name);

	
	
	/*
	 * @RequestMapping("/listProduct") public ArrayList<Product> list (@RequestParam
	 * Map<String, Object> param){
	 * 
	 * }
	 */
}