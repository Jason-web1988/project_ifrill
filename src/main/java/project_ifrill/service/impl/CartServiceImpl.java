package project_ifrill.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_ifrill.dto.Cart;
import project_ifrill.dto.Member;
import project_ifrill.mapper.CartMapper;
import project_ifrill.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	protected static final Log log = LogFactory.getLog(CartServiceImpl.class);

	@Autowired
	private CartMapper mapper;
	
	@Override
	public int addCart(Cart cart) {
		log.debug("service - addCart() Cart >> " + cart);
		return mapper.insertCart(cart);
	}

	@Override
	public int removeCart(int Cart) {
		log.debug("service - removeCart() cart >> " + Cart);
		return mapper.deleteCart(Cart);
	}

	@Override
	public ArrayList<Cart> getCartByMember(String mId) {
		ArrayList<Cart> list = mapper.listCart(mId);
		log.debug("service - getCartByMember MemberId >> " + mId);
		return list;
	}

}
