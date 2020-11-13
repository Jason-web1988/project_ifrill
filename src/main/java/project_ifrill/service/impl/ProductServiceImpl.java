package project_ifrill.service.impl;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_ifrill.dto.Product;
import project_ifrill.mapper.ProductMapper;
import project_ifrill.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	protected static final Log log = LogFactory.getLog(ProductServiceImpl.class);
	
	@Autowired
	private ProductMapper mapper;
	
	@Override
	public ArrayList<Product> newProducts() {
		ArrayList<Product> list = mapper.listNewProduct();
		log.debug("service - newProduct() >> ");
		return list;
	}

	@Override
	public ArrayList<Product> bestProducts() {
		ArrayList<Product> list = mapper.listBestProduct();
		log.debug("service - bestProducts() >> ");
		return list;
	}

	@Override
	public Product getProduct(int no) {
		log.debug("service - getProduct() >> no " + no);
		return mapper.getProduct(no);
	}

	@Override
	public ArrayList<Product> kindProducts(String kind) {
		ArrayList<Product> list = mapper.listKindProduct(kind);
		log.debug("service - kindProduct() + kind >> " + kind);
		return list;
	}

	@Override
	public int totalRecord(String productName) {
		log.debug("service - totlaRecord() productName >> " + productName);
		return mapper.totalRecord(productName);
	}

	@Override
	public String pageNumber(int tpage, String name) {		//페이징기법
		log.debug("service - pageNumber() tpage >> , name >> " + tpage + " ," + name);
		return mapper.pageNumber(tpage, name);
	}

	@Override
	public ArrayList<Product> listProduct(Map<String, Object> maps) {
		ArrayList<Product> list = mapper.listProduct(maps);
		log.debug("service - listProduct() maps >> " + maps);
		return list;
	}

	@Override
	public int insertProduct(Product product) {
		log.debug("service - insertProduct() + product >> " + product);
		return mapper.insertProduct(product);
	}

	@Override
	public int updateProduct(Product product) {
		log.debug("servicec - updateProduct() + product >> " + product);
		return mapper.updateProduct(product);
	}

}
