package project_ifrill.mapper;

import static org.junit.Assert.fail;

import java.util.ArrayList;

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
import project_ifrill.dto.Orders;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderMapperTest {
	protected static final Log log = LogFactory.getLog(OrderMapperTest.class);

	@Autowired
	private OrderMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test01SelectMaxOrdersNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		//안함
		fail("Not yet implemented");
	}

	@Test
	public void test02ListOrderByMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		//안함
		fail("Not yet implemented");
		/*
		 * Orders orders = mapper.listOrderByMember("two", 1, "1");
		 * Assert.assertNotNull(orders); log.debug(orders.toString());
		 */
	}

	@Test
	public void test03SelectSeqOrderIng() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		fail("Not yet implemented");
	}

	@Test
	public void test04ListOrders() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		ArrayList<Orders> orderList = mapper.listOrders("김나리");
		Assert.assertNotNull(orderList);
		orderList.forEach(order -> log.debug(order.toString()));
	}

	@Test
	public void test5UpdateOrderResult() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		int res = mapper.updateOrderResult(1);
		Assert.assertEquals(1, res);
	}

}
