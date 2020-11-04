package project_ifrill.dto;

import java.util.Date;

public class Cart {
	private int no;            // 장바구니번호
	private Member member;     // 주문자 아이디
	private Product product;   // 상품번호
	private int quantity;      // 수량
	private Date regDate;      // 등록일
	private boolean isResult;

	public Cart() {}


	public Cart(Member member) {
		super();
		this.member = member;
	}


	public Cart(int no, Member member, Product product, int quantity, Date regDate, boolean isResult) {
		super();
		this.no = no;
		this.member = member;
		this.product = product;
		this.quantity = quantity;
		this.regDate = regDate;
		this.isResult = isResult;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public boolean isResult() {
		return isResult;
	}

	public void setResult(boolean isResult) {
		this.isResult = isResult;
	}

	@Override
	public String toString() {
		return String.format("Cart [no=%s, member=%s, product=%s, quantity=%s, regDate=%s, isResult=%s]", no, member,
				product, quantity, regDate, isResult);
	}

	

}
