package project_ifrill.service;

import java.util.List;

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
import project_ifrill.dto.Cart;
import project_ifrill.dto.Member;
import project_ifrill.dto.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CartServiceTest {
	protected static final Log log = LogFactory.getLog(CartServiceTest.class);
		
	@Autowired
	private CartService service;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test01AddCart() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		Cart cart = new Cart();
		cart.setMember(new Member("one"));
		cart.setProduct(new Product(2));
		cart.setQuantity(2);
		
		int res = service.addCart(cart);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03RemoveCart() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		
		int res = service.removeCart(66);
		Assert.assertEquals(1, res);
		
	}

	@Test
	public void test02GetCartByMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		
		
		List<Cart> list = service.getCartByMember("one");
		Assert.assertNotNull(list);
		
		list.forEach(cart -> log.debug(cart.toString()));
		
	}

}
