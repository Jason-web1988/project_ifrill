package project_ifrill.service;

import java.util.ArrayList;
import java.util.List;

import project_ifrill.dto.Cart;
import project_ifrill.dto.Member;

public interface CartService {
	int addCart(Cart cart);
	
	int removeCart(int Cart);
	
	ArrayList<Cart> getCartByMember(String mId);
}
