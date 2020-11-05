package project_ifrill.dto;

import java.util.ArrayList;
import java.util.Date;

public class Orders {
    private int no; // 주문번호
    private Member member; // 주문자정보(id, mname, zipNum, address, phone)
    private Date orderDate; // 주문일
    private ArrayList<OrderDetail> details;
    private OrderDetail detail;
    //product get,set 추가
    private Product product;
    
    

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public ArrayList<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<OrderDetail> details) {
        this.details = details;
    }

    
    public OrderDetail getDetail() {
        return detail;
    }

    public void setDetail(OrderDetail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return String.format("Orders [no=%s, member=%s, orderDate=%s, details=%s, detail=%s]", no, member, orderDate, details, detail);
    }

}
