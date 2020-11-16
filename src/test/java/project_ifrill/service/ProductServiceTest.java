package project_ifrill.service;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import project_ifrill.config.ControllerConfig;
import project_ifrill.dto.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest {
	protected static final Log log = LogFactory.getLog(OrderServiceTest.class);
	
	@Autowired
	private ProductService service;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	
	
	@Test
	public void test01NewProducts() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		ArrayList<Product> list = service.newProducts();
		Assert.assertNotNull(list);
		
		list.forEach(product -> log.debug(product.toString()));
	}

	@Test
	public void test02BestProducts() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		ArrayList<Product> list = service.bestProducts();
		Assert.assertNotNull(list);
		
		list.forEach(product -> log.debug(product.toString()));
	}

	@Test
	public void test03GetProduct() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		Product getProduct = service.getProduct(9);
		Assert.assertNotNull(getProduct);
		
		log.debug(getProduct.toString());
	}

	@Test
	public void test04KindProducts() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		
		ArrayList<Product> list = service.kindProducts("3");
		Assert.assertNotNull(list);
		
		list.forEach(product -> log.debug(product.toString()));
	}

	@Test
	public void test05TotalRecord() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		int res = service.totalRecord("스니커즈");
		Assert.assertEquals(2, res);
		
	}

	@Test	//paging
	public void test06PageNumber() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		fail("Not yet implemented");
	}

	@Test
	public void test09ListProduct() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		Product listProduct = new Product();
		listProduct.setName("%스%");
		
		Map<String, Object> maps = new HashMap<>();
		maps.put("NAME",listProduct.getName());
		
		ArrayList<Product> list = service.listProduct(maps);
		Assert.assertNotNull(list);
		list.forEach(product -> log.debug(product.toString()));
	}

	@Test
	public void test07InsertProduct() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		Product insertProduct = new Product();
		
		insertProduct.setName("크록스-1");
		insertProduct.setKind("3");
		insertProduct.setPrice(22000);
		insertProduct.setSalePrice(30000);
		insertProduct.setMargin(7000);
		insertProduct.setContent("유용 슬리퍼입니다.");
		insertProduct.setImage("crocs.jpg");
		insertProduct.setBestYn("N");
		
		int res = service.insertProduct(insertProduct);	
		Assert.assertEquals(1, res);
		
		log.debug(insertProduct.toString());
	}

	@Test
	public void test08UpdateProduct() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		Product upProduct = new Product();
		
		upProduct.setName("코록소-수정");
		upProduct.setKind("4");
		upProduct.setPrice(10000);
		upProduct.setSalePrice(25000);
		upProduct.setMargin(15000);
		upProduct.setContent("수정수정중입니다.");
		upProduct.setImage("crocs.jpg");
		upProduct.setDelYn("N");
		upProduct.setBestYn("N");
		upProduct.setNo(25);
		
		int res = service.updateProduct(upProduct);
		
		log.debug(upProduct.toString());
	}

}
