package project_ifrill.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import project_ifrill.dto.Orders;

public interface OrderMapper {

    /*    
    OrderService로 이동
    int insertOrder(Member member);	//orders테이블과 detail테이블 추가 트랜잭션적용
    void insertOrderDetail(Cart cart, int ordersNo);
      */      
	int selectMaxOrdersNo();
    
    List<Orders> listOrderByMember(Map<String, Object> maps);
    
    ArrayList<Integer> selectSeqOrderIng(Map<String, Object> maps);
    
    ArrayList<Orders> listOrders(String memberName);
    
    int updateOrderResult(int orderNo);
    
}
