--conn to hr

--�ν��Ͻ� ���� ���̺� ����
create table tb_test1
as select * from jobs;

--�ν��Ͻ� ������ ���̺� ����

create table tb_test2 as select * from jobs where 1=2 ;

select * from tab;

drop table TB_TEST2;

select * from tab;