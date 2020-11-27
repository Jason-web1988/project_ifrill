package project_ifrill.dto;

import java.util.Date;

public class OrderDetail {
    private int no;
    private Cart cart;
    private String result; // 1:미처리 2:처리
    private Date orderDate;
    
    public OrderDetail() {
    }

    public OrderDetail(Cart cart) {
		this.cart = cart;
	}

	public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return String.format("OrderDetail [no=%s, cart=%s, result=%s, orderDate=%s]", no, cart, result, orderDate);
    }

}
