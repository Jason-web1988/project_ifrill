package project_ifrill.mapper;

import java.util.ArrayList;

import project_ifrill.dto.Member;
import project_ifrill.dto.Orders;

public interface OrderMapper {
    int selectMaxOrdersNo();

    /*    
    OrderService로 이동
    int insertOrder(Member member);//orders테이블과 detail테이블 추가 트랜잭션적용
    void insertOrderDetail(Cart cart, int ordersNo);
      */      
    
    Orders listOrderByMember(String memberId, int orderNo, String result);
    
    ArrayList<Integer> selectSeqOrderIng(Member member, String result);
    
    ArrayList<Orders> listOrders(String memberName);
    
    int updateOrderResult(int orderNo);
}
