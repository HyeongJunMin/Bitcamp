--conn to hr

--인스턴스 포함 테이블 복제
create table tb_test1
as select * from jobs;

--인스턴스 미포함 테이블 복제

create table tb_test2 as select * from jobs where 1=2 ;

select * from tab;

drop table TB_TEST2;

select * from tab;