--conn to scott


--문제1) 사원번호가 7369인 사원의 급여에 1500을 더하여 갱신하여라.
UPDATE EMP SET SAL = SAL+1500 WHERE EMPNO = 7369;
--문제2) 업무를 입력받아 급여의 합을 출력하는 SCRIPT를 작성하여라.
select sum(sal) from emp where job = 'CLERK';

SET SERVEROUT ON
ACCEPT v_Job PROMPT '업무를 입력하세요:'
DECLARE
    v_salTotal NUMBER;
BEGIN    
    SELECT sum(sal) INTO v_salTotal FROM emp WHERE job = &v_job;
    DBMS_OUTPUT.PUT_LINE(&v_job || '직무의 급여 총합 : ' || TO_CHAR(v_salTotal,'$999,999'));
END;
/

--문제3) EMP 테이블에 EMPNO_SEQUENCE의 SEQUENCE를 이용하여 
--이름.급여,부서번호를 입력받아 등록하는 SCRIPT를 작성하여라. 
--단 10번부서는 입력된 급여에 20%의 가산하여 등록하고 30번부서는 10% 가산 점이 있다.
select * from emp;

create sequence EMPNO_SEQUENCE start with 9000 increment by 1 maxvalue 999999;

ACCEPT vName PROMPT '이름을 입력하세요:'
ACCEPT vSal PROMPT '급여를 입력하세요:'
ACCEPT vDeptno PROMPT '부서번호를 입력하세요:'
DECLARE
    sal1 NUMBER;
BEGIN
    IF &vDeptno = 10 then
        sal1 := &vSal * 1.2;
    ELSIF &vDeptno = 30  THEN
        sal1 := &vSal * 1.1;
    END IF;
    
    INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM ,DEPTNO) 
    VALUES( EMPNO_SEQUENCE.NEXTVAL, &vName, 'CLERK' ,NULL ,'190625' , sal1, NULL, &vDeptno);
END;
/
SELECT * FROM EMP;

--문제4) EMP 테이블에서 이름을 입력 받아 아래의 형태로 출력하는 SCRIPT를 작성하여라.
--조회하고자 하는 사원의 이름을 입력하시오 : scott
ACCEPT vName PROMPT '조회하고자 하는 사원의 이름을 입력하시오 : '
DECLARE
    E EMP%ROWTYPE;
BEGIN
    SELECT EMPNO, ENAME INTO E.EMPNO, E.ENAME
    FROM EMP WHERE ENAME = &vName;
    DBMS_OUTPUT.PUT_LINE(E.EMPNO ||'   ' || E.ENAME);
END;
/
select * from emp;


--문제5) 이름을 입력받아 급여와 입사일을 출력하는 SCRIPT를 작성하여라.
ACCEPT vName PROMPT '조회하고자 하는 사원의 이름을 입력하시오 : '
DECLARE
    E EMP%ROWTYPE;
    nm varchar(10);
BEGIN
    nm := &vName;
    SELECT EMPNO, ENAME, HIREDATE INTO E.EMPNO, E.ENAME, E.HIREDATE
    FROM EMP WHERE ENAME = nm;
    DBMS_OUTPUT.PUT_LINE(E.EMPNO ||'   ' || E.ENAME || '  ' || E.HIREDATE);
    DBMS_OUTPUT.PUT_LINE(&vName);
END;
/
select * from emp;

ACCEPT vName PROMPT '조회하고자 하는 사원의 이름을 입력하시오 : '
DECLARE
    E EMP%ROWTYPE;
    nm varchar(10);
    cnt NUMBER;
BEGIN
    nm := '1111';
    DBMS_OUTPUT.PUT_LINE(nm);
    
    nm := '''MANAGER''';
    DBMS_OUTPUT.PUT_LINE(nm);
    
    select count(job) into cnt from emp where job = nm;
    DBMS_OUTPUT.PUT_LINE(cnt);
    DBMS_OUTPUT.PUT_LINE(nm);
END;