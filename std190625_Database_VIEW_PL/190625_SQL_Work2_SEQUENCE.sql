--conn to hr

--1. 초기값1부터 최대값999,999까지 1씩 증가하는 TEST_SEQ SEQUENCE를 생성하여라.
create sequence test_seq start with 1 increment by 1 maxvalue 999999;

-- 2. 1번에서 작성한 SRQUENCE의 현재 값을 조회하여라.
select * from user_sequences where sequence_name = 'TEST_SEQ';
  
-- 3. CURRVAL과 NEXTVAL을 설명하여라.
create table test_s (aaa number(10));
select * from test_s;
insert into test_s values(6);

insert into test_s values(TEST_SEQ.nextval);
--현재 해당 시퀀스의 값에 증가분을 적용한 값
select TEST_SEQ.CURRVAL from dual;
--현재 해당 시퀀스의 값
select * from test_s;

-- 4. 1번에서 생성한 SRQUENCE를 삭제하여라.
drop SEQUENCE TEST_SEQ;
select * from user_sequences where sequence_name = 'TEST_SEQ';