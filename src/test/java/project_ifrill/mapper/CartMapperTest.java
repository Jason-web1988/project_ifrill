package project_ifrill.mapper;

import static org.junit.Assert.fail;

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
public class CartMapperTest {
	protected static final Log log = LogFactory.getLog(CartMapperTest.class);
	
	@Autowired
	private CartMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test02InsertCart() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		Cart cart = new Cart();
		cart.setMember(new Member("two"));
		cart.setProduct(new Product(2));
		cart.setQuantity(1);
		
		int res = mapper.insertCart(cart);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test01ListCart() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		
		Member member = new Member();
		member.setId("two");
		List<Cart> list = mapper.listCart(member.getId());
		Assert.assertNotNull(list);
		list.forEach(cart -> log.debug(cart.toString()));
		
				
	}

	@Test
	public void test04DeleteCart() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		int res =mapper.deleteCart(1);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03UpdateCartResult() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		Cart cart = new Cart();
		Member member = new Member();
		member.setId("one");
		cart.setMember(member);
		cart.setQuantity(5);
		int res = mapper.updateCartResult(cart);
		Assert.assertEquals(1, res);
		
	}

}
