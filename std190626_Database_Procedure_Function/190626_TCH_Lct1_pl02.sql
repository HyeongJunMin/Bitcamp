/*
    block되어 있는 처리 -> 함수화
    PROCEDURE   - INSERT, DELETE, UPDATE 
                1.IN, OUT(RETURN VALUE) 
    FUNCTION    - SELECT 
                1. 매개변수
                2. RETURN VALUE
*/

SET SERVEROUTPUT ON

CREATE OR REPLACE PROCEDURE pl_func(inNumber IN NUMBER, outNumber OUT NUMBER)
IS
    -- 선언부
BEGIN
    -- 실행부
    DBMS_OUTPUT.PUT_LINE('inNumber:'||inNumber);
    
    outNumber := 112233;
    -- 예외처리
END;
/

-- 외부 변수
VAR val NUMBER;
-- 프로시저 호출
EXECUTE pl_func(111, :val);
-- 변수 출력
PRINT val;

-- 매개변수 없는 경우
CREATE OR REPLACE PROCEDURE hello_pro
IS
    msg VARCHAR2(100);
BEGIN
    msg := 'hello PROCEDURE';
    DBMS_OUTPUT.PUT_LINE(msg);
END;
/

EXEC hello_pro;

-- DEPARTMENTS ROW 추가
CREATE OR REPLACE PROCEDURE add_dept(
    p_deptno IN departments.department_id%type,
    p_deptname IN departments.department_name%type,
    p_loc IN departments.location_id%type )
IS
BEGIN
    INSERT INTO departments(department_id, department_name, location_id)
    VALUES(p_deptno, p_deptname, p_loc);    
    --COMMIT;    
EXCEPTION WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('추가에 실패 하였습니다');
    --ROLLBACK;
END;
/

EXEC add_dept(300, '신규부서', 2500);

-- update_sal 프로시저는 사원번호를 입력받아서 급여인상 30%
CREATE OR REPLACE PROCEDURE update_sal(v_empno IN NUMBER)
IS
BEGIN
    UPDATE employees
    SET salary = salary * 1.3
    WHERE employee_id = v_empno;
END;
/

ACCEPT empno PROMPT '사원번호 입력:'
EXEC update_sal(&empno);
ROLLBACK;

-- 사원번호를 입력 받으면 그 사원의 이름, 사원번호, 사원급여도 출력이 되도록 하라.
CREATE OR REPLACE PROCEDURE emp_info(p_empno IN employees.employee_id%TYPE)
IS
    v_emp employees%ROWTYPE;
BEGIN
    SELECT first_name, salary, hire_date
        INTO v_emp.first_name, v_emp.salary, v_emp.hire_date
    FROM employees
    WHERE employee_id = p_empno;
    
    DBMS_OUTPUT.PUT_LINE('이름:'||v_emp.first_name);
    DBMS_OUTPUT.PUT_LINE('급여:'||v_emp.salary);
    DBMS_OUTPUT.PUT_LINE('입사일:'||v_emp.hire_date);
END;
/

EXECUTE emp_info(102);

/*
    Cursor : 저장 주소공간 -> pointer
    
    암시적 커서 : 자동생성
        SQL%ROWCOUNT : ROW의 수
        SQL%FOUND : ROW수의 한개이상일 경우
        SQL%NOTFOUND : ROW수가 0
        
    명시적 커서 : 수동 생성
*/
-- 암시적 커서
CREATE OR REPLACE PROCEDURE implicit_cursor(p_empno IN employees.employee_id%TYPE)
IS
    v_sal employees.salary%TYPE;
    v_update_row NUMBER;    -- 몇개의 행이 수정되는 조사하는 저장 변수
BEGIN
    -- 검색
    SELECT salary INTO v_sal
    FROM employees
    WHERE employee_id = p_empno;
    
    -- 검색이 된 데이터가 있는 경우
    IF SQL%FOUND THEN
        DBMS_OUTPUT.PUT_LINE('검색된 데이터가 있습니다:'|| v_sal);
    END IF;
    
    -- 수정
    UPDATE employees
    SET salary = salary * 1.1
    WHERE employee_id = p_empno;
    
    -- 출력
    v_update_row := SQL%ROWCOUNT;
    DBMS_OUTPUT.PUT_LINE('급여가 인상된 사원수:'||v_update_row);
    
-- 예외
EXCEPTION
WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE('검색된 데이터가 없습니다');    
END;
/

EXECUTE implicit_cursor(101);

EXECUTE implicit_cursor(333);

ROLLBACK;

-- 명시적 커서
CREATE OR REPLACE PROCEDURE expCursor_test(v_deptno IN departments.department_id%TYPE)
IS  
    CURSOR dept_avg
    IS
    SELECT d.department_name, COUNT(e.employee_id) CNT,
        ROUND(AVG(e.salary), 3) SAL
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
        AND e.department_id = v_deptno
    GROUP BY d.department_name;
    
    -- CURSOR에 PATCH하기 위한 변수들을 선언
    v_dname departments.department_name%TYPE;
    emp_cnt NUMBER;
    sal_avg NUMBER;
    
BEGIN
    -- CURSOR OPEN
    OPEN dept_avg;
    
    -- CURSOR FATCH
    FETCH dept_avg INTO v_dname, emp_cnt, sal_avg;

    DBMS_OUTPUT.PUT_LINE('부서명:'||v_dname);
    DBMS_OUTPUT.PUT_LINE('사원수:'||emp_cnt);
    DBMS_OUTPUT.PUT_LINE('급여평균:'||sal_avg);

    -- CURSOR CLOSE
    CLOSE dept_avg;
END;
/

EXEC expcursor_test(50);









































