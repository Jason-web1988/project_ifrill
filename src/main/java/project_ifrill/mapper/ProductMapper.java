package project_ifrill.mapper;

import java.util.ArrayList;
import java.util.Map;

import project_ifrill.dto.Product;

public interface ProductMapper {
    // 신상품 리스트 얻어오기
    ArrayList<Product> listNewProduct();
    // 베스트 상품 리스트 얻어오기
    ArrayList<Product> listBestProduct();
    // 상품번호로 상품 정보 한개 얻어오기
    Product getProduct(int no);
    // 상품종류별 상품 리스트 얻어오기
    ArrayList<Product> listKindProduct(String kind);
    
    //관리자용 - 상품관리 페이징
    int totalRecord(String productName);
    public String pageNumber(int tpage, String name);
//    ArrayList<Product> listProduct(int tpage, String product_name);
    ArrayList<Product> listProduct(Map<String, Object> maps);
    
    //관리자용 - 상품 등록 및 수정
    int insertProduct(Product product);
    int updateProduct(Product product);
}
