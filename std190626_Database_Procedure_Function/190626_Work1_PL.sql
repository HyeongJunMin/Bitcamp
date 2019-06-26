-- 문제1) 이름을 입력받아 그 사원의 정보 중 부서명과 급여를 검색하는 프로시저를 생성하여라.
SET SERVEROUTPUT ON

CREATE OR REPLACE PROCEDURE emp_search(inName in VARCHAR2)
IS
    e_name VARCHAR2(10);
    sal NUMBER;
    -- 선언부
BEGIN
    select d.dname, e.sal into e_name, sal
    from EMP e, DEPT d
    where e.deptno = d.deptno
        and e.ename = inName;
    
    DBMS_OUTPUT.PUT_LINE('부서명 : ' || e_name);
    DBMS_OUTPUT.PUT_LINE('급여:'|| sal);
END;
/
exec EMP_SEARCH('KING');
select * from user_objects;
-- 문제2) EMP 테이블에서 이름으로 부서 번호를 검색하는 함수를 작성하여라.
CREATE OR REPLACE FUNCTION EMP_REPLACE(E_NAME IN VARCHAR2) RETURN NUMBER
IS
    E_NUM NUMBER;
BEGIN
    SELECT EMPNO INTO E_NUM FROM EMP WHERE ENAME = E_NAME;
    DBMS_OUTPUT.PUT_LINE('함수 끝');
    RETURN E_NUM;
    
    EXCEPTION WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('예외발생');
END;
/
select * from user_objects;
VAR e_num NUMBER;
EXEC :e_num := EMP_REPLACE('KING');
print e_num;
select * from emp where ename = 'KING';
-- 문제3) EMP 테이블에서 이름을 입력 받아 부서번호,부서명,급여를 검색하는 FUNCTION을 작성하여라. 
--단 부서번호를 RETURN에 사용하여라.
CREATE OR REPLACE FUNCTION EMP_INFO(INNAME IN VARCHAR2) RETURN NUMBER
IS
    F_DEPTNO NUMBER;
    F_DNAME VARCHAR2(20);
    F_SAL NUMBER;
BEGIN
    SELECT E.DEPTNO, D.DNAME, E.SAL INTO F_DEPTNO, F_DNAME, F_SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND E.ENAME = INNAME;
        
    DBMS_OUTPUT.PUT_LINE('대상자(매개변수) : ' || INNAME);    
    DBMS_OUTPUT.PUT_LINE('부서번호 : ' || F_DEPTNO);
    DBMS_OUTPUT.PUT_LINE('부서명 : ' || F_DNAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || F_SAL);
        
    DBMS_OUTPUT.PUT_LINE('함수 끝');
    RETURN F_DEPTNO;
    EXCEPTION WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('예외발생');
END;
/
VAR e_num2 NUMBER;
EXEC :e_num2 := EMP_INFO('KING');
select * from user_objects;