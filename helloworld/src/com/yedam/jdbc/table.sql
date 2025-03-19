INSERT INTO emp(empno, ename, job, mgr, hiredate, sal)
       VALUES (9999, '홍길동', 'CLERK', 7788, '2020-01-01', 1000);

SELECT empno
FROM   emp;

delete from emp
where empno= 9999;

commit;

--table 생성
--도서코드, 도서명, 저자, 출판사, 도서가격
CREATE TABLE tbl_book(
   book_code   VARCHAR2(5) PRIMARY KEY,
   book_title  VARCHAR2(50) NOT NULL,
   author      VARCHAR2(30) NOT NULL,
   publisher   VARCHAR2(30) NOT NULL,
   price       NUMBER DEFAULT 1000
);

INSERT INTO tbl_book(book_code,
                     book_title,
                     author,
                     publisher,
                     price)
       VALUES(BOOK_SEQ.nextval,
              '이것이 자바다',
              '신용권',
              '한빛출판사',
              20000);

CREATE SEQUENCE book_seq;
SELECT book_seq.nextval
FROM   dual;

rollback;

SELECT *
FROM   tbl_book;

UPDATE tbl_book
   SET price = 34000
WHERE price = 0;

DELETE FROM tbl_book
WHERE book_code = 6;

commit;