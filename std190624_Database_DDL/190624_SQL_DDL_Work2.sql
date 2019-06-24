--conn to scott

--문제1) EMP 테이블에서 EMPNO,ENAME,SAL,HIREDATE의 COLUMN만 선택하여 EMP_10 테이블을 생성한 후 10번 부서만 선택하여 이에 대응하는 값을 EMP_10테이블에 입력하여라.
create table emp_10 as 
select EMPNO, ENAME, SAL, HIREDATE
from emp;
select * from emp_10;

create table emp2 as select * from emp;
select * from emp2;

-- 문제2) EMP 테이블에서 사원 번호가7788인 사원의 부서를 10번으로 변경하여라.
update emp2 set deptno = 10 where empno = 7788;
select * from emp2;
insert into emp2 values(7788,'MAN','CLERK',7900,'19/06/24', 2000,500,30);

-- 문제3) EMP 테이블에서 사원 번호가7788인 사원의 부서를 20, 급여를 3500으로 변경하여라.
update emp2 set deptno = 20, sal = 3500 where empno=7788;
select * from emp2;

-- 문제4) EMP 테이블에서 10번 부서의 사원을 모두 91번 부서로 갱신하여라.
update emp2 set deptno = 91 where deptno = 10;
select * from emp2 order by deptno;

-- 문제5) DEPT 테이블에서 부서 번호 10을 15로 갱신하여라.
update emp2 set deptno = 15 where deptno = 10;
select * from emp2 order by deptno;

-- 문제6) EMP 테이블에서 사원번호가 7499인 사원의 정보를 삭제하여라.
select * from emp2 where empno = 7499;
delete from emp2 where empno= 7499;

-- 문제7) EMP 테이블에서 입사일자가 83년인 사원의 정보를 삭제하여라.
select * from emp2 where substr(hiredate,1,2)='83';
select * from emp2;
delete from emp2 where  substr(hiredate,1,2)='83';

-- 1. 아래의 구조를 만족하는 MY_DATA 테이블을 생성하시오. 단 ID가 PRIMARY KEY이다.
create table MY_DATA  (ID varchar2(10) primary key, NAME varchar2(10) ,SALARY number);

-- 2. 1번에 의해 생성된 테이블에 아래의 값을 입력하여라.
select * from my_data;
insert into my_data (ID, NAME, SALARY) values('1','Ord',3000);
insert into my_data (ID, NAME, SALARY) values('2','Rd',6000.50);
insert into my_data (ID, NAME, SALARY) values('3','Ford',6200.50);

-- 3. ID가 3번인 사람의 급여를 65,000.00으로 갱신하고 영구적으로 데이터베이스에 반영하여라.
update my_data set salary = 65000.00 where id='3';
commit;
select * from my_data;

-- 4. 이름이 Ford인 사원을 영구 제명하여라.
delete from my_data where name = 'Ford';
commit;
select * from my_data;

-- 5. 급여가 15,000이하인 사람의 급여를 15,000로 변경하여라.
update my_data set SALARY = 15000 where salary <= 15000;
select * from my_data;

-- 6. 1번에서 생성한 테이블을 삭제하여라.
drop table my_data;
select * from my_data;