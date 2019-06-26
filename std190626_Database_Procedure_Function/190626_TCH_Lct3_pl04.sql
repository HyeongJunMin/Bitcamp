-- 호출해야 실행 execute
-- procedure    insert, delete, update
-- function     select                  retrun 값이 반드시 있어야 한다.

-- trigger  - 촉발시키다. 스스로 발생
-- insert    old 없음
-- delete    new 없음
-- update    old new 모두 사용


SET SERVEROUTPUT on

CREATE OR REPLACE TRIGGER triger_test
    BEFORE 
        UPDATE ON departments
        FOR EACH ROW   
BEGIN
    DBMS_OUTPUT.PUT_LINE('변경전 컬럼의 값:'|| :OLD.department_name );
    DBMS_OUTPUT.PUT_LINE('변경후 컬럼의 값:'|| :NEW.department_name );
END;
/

UPDATE departments
SET department_name = '개발부'
WHERE department_id = 60;

ROLLBACK;

CREATE OR REPLACE TRIGGER sum_triger
    BEFORE
        INSERT OR UPDATE ON employees
        FOR EACH ROW
DECLARE
    avg_sal NUMBER;
BEGIN
    SELECT ROUND(AVG(salary), 3) INTO avg_sal
    FROM employees;
    
    DBMS_OUTPUT.PUT_LINE('급여평균:'|| avg_sal);
END;
/

SELECT ROUND(AVG(salary), 3)
FROM employees; -- 6587.185

INSERT INTO employees(employee_id, last_name, hire_date, department_id, job_id, salary, email)
VALUES(500, 'tiger', SYSDATE, 60, 'IT_PROG', 10000, 'tiger@naver.com');


-- 사번을 수정하지 못하게 할 경우
-- 삭제 할수 없게 할 경우
-- 입력 할수 없게 할 경우
CREATE OR REPLACE TRIGGER emp_trigger
    BEFORE
    UPDATE OR DELETE OR INSERT ON employees
    FOR EACH ROW
BEGIN
    IF UPDATING THEN
        IF :OLD.employee_id = '100' THEN
            RAISE_APPLICATION_ERROR(-20001, '이번호는 수정할 수 없습니다');
        END IF;
    END IF;
    
END;
/

UPDATE employees
SET salary = 2500
WHERE employee_id = 100;
    
/*
IF DELETING THEN
    
END IF;
IF INSERTING THEN
    
END IF;     
*/    









