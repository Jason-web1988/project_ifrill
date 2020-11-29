
 -- 怨꾩젙 異붽� 諛� 沅뚰븳 遺��뿬 --
	-- �쁽�옱 �뿰寃� 怨꾩젙 �솗�씤
SELECT USER FROM DUAL;

-- 怨꾩젙 �깮�꽦
DROP USER I_FRILL CASCADE;
CREATE USER I_FRILL IDENTIFIED BY rootroot;

-- 怨꾩젙 沅뚰븳 遺��뿬
GRANT CONNECT, RESOURCE, CREATE SYNONYM, CREATE VIEW TO I_FRILL;

-- 怨꾩젙 �솗�씤
SELECT * 
  FROM DBA_USERS
 WHERE USERNAME = 'I_FRILL';


GRANT EXECUTE ON MULTI_QUERY TO I_FRILL;


