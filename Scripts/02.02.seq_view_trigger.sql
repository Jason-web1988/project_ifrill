-- 접속자 확인
SELECT USER FROM DUAL;


/*****************************************
VIEW 생성 
******************************************/

-- 신상품
CREATE OR REPLACE VIEW NEW_PRO_VIEW
AS
SELECT NO, NAME, SALEPRICE, IMAGE 
FROM (SELECT ROWNUM, NO, NAME, SALEPRICE, IMAGE 
      FROM PRODUCT  
      WHERE DEL_YN='y' 
      ORDER BY REG_DATE DESC)
WHERE  ROWNUM <=4;


-- 베스트 상품
CREATE OR REPLACE VIEW BEST_PRO_VIEW
AS
SELECT NO, NAME, SALEPRICE, IMAGE 
FROM( SELECT ROWNUM, NO, NAME, SALEPRICE, IMAGE 
      FROM PRODUCT  
      WHERE BEST_YN='Y' 
      ORDER BY REG_DATE DESC)
WHERE  ROWNUM <=4;

 SELECT *
      FROM PRODUCT ;
-- 장바구니(CART)
CREATE OR REPLACE VIEW CART_VIEW
AS
SELECT C.NO , C.MEMBERID , C.PNO , M.NAME MNAME, P.NAME PNAME, C.QUANTITY, C.REG_DATE, P.SALEPRICE , C.RESULT 
  FROM CART C JOIN MEMBER M ON C.MEMBERID = M.ID JOIN PRODUCT P ON C.PNO =P."NO" 
 WHERE RESULT = '1';


--ORDER VIEW
CREATE OR REPLACE VIEW ORDER_VIEW
AS
SELECT D.NO DNO, O.NO ONO, O.ID MID, O.ORDER_DATE , D.PNO PNO, D.QUANTITY, M.NAME MNAME,
       M.ZIP_NUM, M.ADDRESS, M.PHONE, P.NAME PNAME, P.SALEPRICE , D.RESULT_YN RESULT   
  FROM ORDERS O JOIN ORDER_DETAIL D ON O.NO = D.ONO JOIN MEMBER M ON O.ID =M.ID 
       JOIN PRODUCT P ON D.PNO = P.NO;

/*****************************************
시퀀스 삭제
******************************************/
DROP SEQUENCE PRODUCT_NO_SEQ; 
DROP SEQUENCE CART_NO_SEQ;
DROP SEQUENCE ORDERS_NO_SEQ;
DROP SEQUENCE ORDER_DETAIL_NO_SEQ;
DROP SEQUENCE QNA_NO_SEQ;
  
  
/*****************************************
시퀀스 생성
******************************************/

-- PRODUCT(NO), 
CREATE SEQUENCE PRODUCT_NO_SEQ
	START WITH 1
	INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRI_PRODUCT_NO_SEQ
BEFORE INSERT ON PRODUCT
FOR EACH ROW 
BEGIN 
	IF INSERTING AND :NEW.NO IS NULL THEN 
		SELECT PRODUCT_NO_SEQ.NEXTVAL INTO :NEW.NO FROM DUAL;
	END IF;
END; 


--CART(NO),
CREATE SEQUENCE CART_NO_SEQ
	START WITH 1
	INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRI_CART_NO_SEQ
BEFORE INSERT ON CART
FOR EACH ROW 
BEGIN 
	IF INSERTING AND :NEW.NO IS NULL THEN 
		SELECT CART_NO_SEQ.NEXTVAL INTO :NEW.NO FROM DUAL;
	END IF;
END; 

--ORDERS
CREATE SEQUENCE ORDERS_NO_SEQ
	START WITH 1
	INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRI_ORDERS_NO_SEQ
BEFORE INSERT ON ORDERS
FOR EACH ROW 
BEGIN 
	IF INSERTING AND :NEW.NO IS NULL THEN 
		SELECT ORDERS_NO_SEQ.NEXTVAL INTO :NEW.NO FROM DUAL;
	END IF;
END; 

--ORDER_DETAIL(NO),
CREATE SEQUENCE ORDER_DETAIL_NO_SEQ
	START WITH 1
	INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRI_ORDER_DETAIL_NO_SEQ
BEFORE INSERT ON ORDER_DETAIL
FOR EACH ROW 
BEGIN 
	IF INSERTING AND :NEW.NO IS NULL THEN 
		SELECT ORDER_DETAIL_NO_SEQ.NEXTVAL INTO :NEW.NO FROM DUAL;
	END IF;
END; 

--QNA(NO)
CREATE SEQUENCE QNA_NO_SEQ
	START WITH 1
	INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRI_QNA_NO_SEQ
BEFORE INSERT ON QNA
FOR EACH ROW 
BEGIN 
	IF INSERTING AND :NEW.NO IS NULL THEN 
		SELECT QNA_NO_SEQ.NEXTVAL INTO :NEW.NO FROM DUAL;
	END IF;
END; 


