package project_ifrill.mapper;

import java.util.ArrayList;
import java.util.List;

import project_ifrill.dto.Cart;
import project_ifrill.dto.Member;

public interface CartMapper {
	int insertCart(Cart cart);				//장바구니에 상품 등록
	ArrayList<Cart> listCart(String id);	//사용자별 상품목록
	int deleteCart(int cartNo);				//장바구니의 상품 삭제	
	int updateCartResult(Cart cart);
	
//	List<Cart> listCart(Member member);
}
