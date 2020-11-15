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
import project_ifrill.dto.Member;
import project_ifrill.dto.OrderDetail;
import project_ifrill.dto.Orders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderServiceTest {
	protected static final Log log = LogFactory.getLog(OrderServiceTest.class);
	
	@Autowired
	private OrderService service;
	
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	
	
	@Test
	public void test01SelectSeqOrderIng() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		Member member = new Member();
		member.setId("two");
		OrderDetail result = new OrderDetail();
		result.setResult("1");
		
		Map<String, Object> maps = new HashMap<>();
		maps.put("MemberId", member.getId());
		maps.put("Result", result.getResult());
		
		ArrayList<Integer> list = service.selectSeqOrderIng(maps);
		Assert.assertNotNull(list);
	}

	@Test
	public void test02OrderListByMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		Member memberId = new Member();
		memberId.setId("one");
		OrderDetail orderResult = new OrderDetail();
		orderResult.setResult("1");
		
		Map<String, Object> maps = new HashMap<>();
		maps.put("MemberId", memberId.getId());
		
		List<Orders> list = service.orderListByMember(maps);
		Assert.assertNotNull(list);
		
		list.forEach(orders -> log.debug(orders.toString()));
	}

	@Test
	public void test03MaxOrderNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		int res = service.maxOrderNo();
		Assert.assertEquals(3, res);
		
	}

	@Test
	public void test04ListOrders() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		ArrayList<Orders> list = service.listOrders("김나리");
		Assert.assertNotNull(list);
		
		list.forEach(orders -> log.debug(orders.toString()));
	}

	@Test
	public void test05UpdateOrderResult() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		int res = service.updateOrderResult(3);
		Assert.assertEquals(4, res);
		
	}

	@Test
	public void test06AddOrderAndDetail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		fail("Not yet implemented");
	}

	@Test
	public void testRollbackUtill() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		fail("Not yet implemented");
	}

	@Test
	public void testCloseUtil() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		fail("Not yet implemented");
	}

}
