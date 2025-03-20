CREATE TABLE tbl_member (
   user_id   VARCHAR2(10) PRIMARY KEY, --사용자 ID
   user_name VARCHAR2(10) NOT NULL,    --사용자 이름
   password  VARCHAR2(30) NOT NULL     --비밀번호
);

INSERT INTO tbl_member
       VALUES ('user01', '홍길동', '1111');
INSERT INTO tbl_member
       VALUES ('user02', '김길동', '2222');
INSERT INTO tbl_member
       VALUES ('user03', '박길동', '3333');

INSERT INTO tbl_member
       VALUES ('user', '김유저', 'user');
INSERT INTO tbl_member
       VALUES ('root', '관리자', 'root');
       
COMMIT;

SELECT user_id,
       user_name,
       password
FROM   tbl_member;