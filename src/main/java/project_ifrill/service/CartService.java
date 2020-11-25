package project_ifrill.service;

import java.util.List;

import project_ifrill.dto.Cart;

public interface CartService {
	int addCart(Cart cart);
	
	int removeCart(int Cart);
	
	List<Cart> getCartByMember(String mId);
}
