package project_ifrill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
   
   
   
   
   //페이징기법 해야함
//    public String pageNumber(int tpage, String name);

   
   
   /*
    * @RequestMapping("/listProduct") public ArrayList<Product> list (@RequestParam
    * Map<String, Object> param){
    * 
    * }
    */
}