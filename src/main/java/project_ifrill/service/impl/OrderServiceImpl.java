package project_ifrill.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.datasource.jndi.JndiDataSourceFactory;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_ifrill.dto.Orders;
import project_ifrill.mapper.OrderMapper;
import project_ifrill.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	protected static final Log log = LogFactory.getLog(OrderServiceImpl.class);
	
	@Autowired
	private OrderMapper mapper;
	
	@Override
	public ArrayList<Integer> selectSeqOrderIng(Map<String, Object> maps) {
		ArrayList<Integer> list = mapper.selectSeqOrderIng(maps);
		log.debug("service - selectSeqOrderIng() maps >> " + maps);
		return list;
	}

	@Override
	public List<Orders> orderListByMember(Map<String, Object> maps) {
		List<Orders> list = mapper.listOrderByMember(maps);
		log.debug("service - orderListByMember()  maps >> " + maps);
		return list;
	}

	@Override
	public int maxOrderNo() {
		return mapper.selectMaxOrdersNo();
	}

	@Override
	public ArrayList<Orders> listOrders(String memberName) {
		ArrayList<Orders> list = mapper.listOrders(memberName);
		log.debug("service - listOrders() memberName >> " + memberName);
		return list;
	}

	@Override
	public int updateOrderResult(int orderNo) {
		log.debug("service - updateOrderResult() orderNo >> " + orderNo);
		return mapper.updateOrderResult(orderNo);
	}

	@Override
	public int addOrderAndDetail(Orders orders) {
		return 0;
	
	}

	@Override
	public void rollbackUtill(Connection con, SQLException e) {
	

	}

	@Override
	public void closeUtil(Connection con, PreparedStatement dPstmt, PreparedStatement tPstmt) {
	
	}

}
