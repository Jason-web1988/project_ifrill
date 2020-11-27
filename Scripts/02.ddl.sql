-- 접속자 확인
SELECT USER FROM DUAL;

DROP TABLE cart;
DROP TABLE order_detail;
DROP TABLE orders;
DROP  TABLE qna;
DROP TABLE worker;
DROP TABLE product;
DROP TABLE MEMBER;

/* 상품  */
CREATE TABLE product (
	no NUMBER(5) NOT NULL PRIMARY KEY, /* 상품번호 */
	name VARCHAR(100), /* 상품이름 */
	kind CHAR(1), /* 상품종류 */
	price NUMBER, /* 원가 */
	saleprice NUMBER, /* 판매가 */
	margin NUMBER, /* 수익 */
	content VARCHAR2(1000), /* 상품내용 */
	image VARCHAR(100) DEFAULT 'default.jpg', /* 상품이미지 */
	del_yn CHAR(1) DEFAULT 'y', /* 상품삭제여부 */
	best_yn CHAR(1) DEFAULT 'n', /* 베스트상품여부 */
	reg_date DATE DEFAULT sysdate /* 등록일 */
);
select * from PRODUCT;
/* 회원 */
CREATE TABLE member (
	id VARCHAR2(20) NOT NULL PRIMARY KEY, /* 회원아이디 */
	pwd VARCHAR(20), /* 회원암호 */
	name VARCHAR(100), /* 회원이름 */
	email VARCHAR2(40), /* 회원이메일 */
	zip_num CHAR(7), /* 우편번호 */
	address VARCHAR2(100), /* 주소 */
	phone CHAR(13), /* 전화번호 */
	leave_yn CHAR(1) DEFAULT 'y', /* 탈퇴여부 */
	join_date DATE DEFAULT sysdate/* 가입일 */
);

/* 장바구니  */
CREATE TABLE cart (
	no NUMBER(5) NOT NULL, /* 장바구니번호 */
	pno NUMBER(5), /* 상품번호 */
	memberId VARCHAR2(20), /* 회원아이디 */
	quantity NUMBER(5) default 1, /* 수량 */
	result CHAR(1) DEFAULT 1, /* 처리완료여부 */
	reg_date DATE DEFAULT sysdate/* 등록일 */
);

/* 주문 */
CREATE TABLE orders (
	no NUMBER(5) NOT NULL PRIMARY KEY , /* 주문번호 */
	id VARCHAR2(20), /* 주문아이디 */
	order_date DATE DEFAULT sysdate /* 주문일 */
);

/* 주문상세 */
CREATE TABLE order_detail (
	no NUMBER(5) NOT NULL PRIMARY KEY , /* 주문상세번호 */
	oNo NUMBER(5), /* 주문번호 */
	pNo NUMBER(5), /* 상품번호 */
	quantity NUMBER(5), /* 주문수량 */
	result_yn CHAR(1) DEFAULT '1' /* 처리완료여부 */
);


/* QNA 게시판 */
CREATE TABLE qna (
	no NUMBER(5) NOT NULL PRIMARY KEY , /* 번호 */
	subject VARCHAR(100), 				/* 제목 */
	content VARCHAR2(1000), 			/* 내용 */
	rep VARCHAR2(1000), 				/* 답변 */
	id VARCHAR2(20), 					/* 작성자아이디 */
	rep_yn CHAR(1) DEFAULT '1',			/* 답변여부 */
	write_date DATE DEFAULT sysdate 	/* 작성일 */
);

/* 관리자 */
CREATE TABLE worker (
	id VARCHAR2(20) NOT NULL PRIMARY KEY, 	/* 아이디 */
	pwd VARCHAR(20), 						/* 암호 */
	name VARCHAR(100), 						/* 이름 */
	phone CHAR(13) 							/* 전화번호 */
);

--------------------------------------------
ALTER TABLE cart ADD CONSTRAINT FK_product_TO_cart FOREIGN KEY (pno) REFERENCES product (no);
ALTER TABLE cart ADD CONSTRAINT FK_member_TO_cart  FOREIGN KEY (memberId) REFERENCES member (id);

ALTER TABLE orders ADD CONSTRAINT FK_member_TO_orders	FOREIGN KEY (id)REFERENCES member (id);

ALTER TABLE order_detail ADD CONSTRAINT FK_orders_TO_order_detail FOREIGN KEY (oNo)REFERENCES orders (	no);
ALTER TABLE order_detail ADD CONSTRAINT FK_product_TO_order_detail FOREIGN KEY (pNo)REFERENCES product (no);