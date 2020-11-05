package project_ifrill.mapper;

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
		
		int res = mapper.selectMaxOrdersNo();
		Assert.assertEquals(3, res);
		
	}

	@Test
	public void test02ListOrderByMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		//안함
		Member memberId = new Member();
		memberId.setId("two");
		OrderDetail orderResult = new OrderDetail();
		orderResult.setResult("1");
		
		Map<String, Object> maps = new HashMap<>();
		maps.put("MemberId", memberId.getId());
//		maps.put("orderResult", "'%" + orderResult.getResult() + "%'");
//		maps.put("ono", 1);
		
		
		List<Orders> orders = mapper.listOrderByMember(maps);
		Assert.assertNotNull(orders); 
		 
	}

	@Test
	public void test03SelectSeqOrderIng() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		Member member = new Member();
		member.setId("two");
		OrderDetail result = new OrderDetail();
		result.setResult("1");
		
		Map<String, Object> maps = new HashMap<>();
		maps.put("MemberId", member.getId());
		maps.put("Result", result.getResult());
	
		List<Integer> list = mapper.selectSeqOrderIng(maps);
		Assert.assertNotNull(list);
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

		int res = mapper.updateOrderResult(2);
		Assert.assertEquals(1, res);
	}

}
