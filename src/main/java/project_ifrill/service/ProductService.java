package project_ifrill.service;

import java.util.ArrayList;
import java.util.Map;

import project_ifrill.dto.Product;

public interface ProductService {
    // 신상품 리스트 얻어오기
    public ArrayList<Product> newProducts() ;

    // 베스트 상품 리스트 얻어오기
    public ArrayList<Product> bestProducts() ;

    // 상품번호로 상품 정보 한개 얻어오기
    public Product getProduct(int no);
    
    // 상품종류별 상품 리스트 얻어오기
    public ArrayList<Product> kindProducts(String kind);
    
    //관리자용 - 상품관리 페이징
    public int totalRecord(String productName);
    
    public String pageNumber(int tpage, String name);   //페이징 기법 활용
    
    public ArrayList<Product> listProduct(Map<String, Object> maps);   // int tpage, String product_name
    
    //관리자용 - 상품 등록 및 수정
    public int insertProduct(Product product);
    
    public int updateProduct(Product product);
}
