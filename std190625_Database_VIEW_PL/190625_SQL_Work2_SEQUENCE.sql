--conn to hr

--1. �ʱⰪ1���� �ִ밪999,999���� 1�� �����ϴ� TEST_SEQ SEQUENCE�� �����Ͽ���.
create sequence test_seq start with 1 increment by 1 maxvalue 999999;

-- 2. 1������ �ۼ��� SRQUENCE�� ���� ���� ��ȸ�Ͽ���.
select * from user_sequences where sequence_name = 'TEST_SEQ';
  
-- 3. CURRVAL�� NEXTVAL�� �����Ͽ���.
create table test_s (aaa number(10));
select * from test_s;
insert into test_s values(6);

insert into test_s values(TEST_SEQ.nextval);
--���� �ش� �������� ���� �������� ������ ��
select TEST_SEQ.CURRVAL from dual;
--���� �ش� �������� ��
select * from test_s;

-- 4. 1������ ������ SRQUENCE�� �����Ͽ���.
drop SEQUENCE TEST_SEQ;
select * from user_sequences where sequence_name = 'TEST_SEQ';