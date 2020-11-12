package project_ifrill.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import project_ifrill.dto.Member;
import project_ifrill.dto.Orders;

public interface OrderService {
	ArrayList<Integer> selectSeqOrderIng(Member member, String result);
	
	Orders orderListByMember(String memberId, int orderNo, String result);
	
	int maxOrderNo();
	
	ArrayList<Orders> listOrders(String memberName);
	
	int updateOrderResult(int orderNo);
	
	int addOrderAndDetail(Orders orders);
	
	void rollbackUtill(Connection con, SQLException e);
	
	void closeUtil(Connection con, PreparedStatement dPstmt, PreparedStatement tPstmt);
}
