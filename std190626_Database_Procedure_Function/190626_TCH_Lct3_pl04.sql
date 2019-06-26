-- ȣ���ؾ� ���� execute
-- procedure    insert, delete, update
-- function     select                  retrun ���� �ݵ�� �־�� �Ѵ�.

-- trigger  - �˹߽�Ű��. ������ �߻�
-- insert    old ����
-- delete    new ����
-- update    old new ��� ���


SET SERVEROUTPUT on

CREATE OR REPLACE TRIGGER triger_test
    BEFORE 
        UPDATE ON departments
        FOR EACH ROW   
BEGIN
    DBMS_OUTPUT.PUT_LINE('������ �÷��� ��:'|| :OLD.department_name );
    DBMS_OUTPUT.PUT_LINE('������ �÷��� ��:'|| :NEW.department_name );
END;
/

UPDATE departments
SET department_name = '���ߺ�'
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
    
    DBMS_OUTPUT.PUT_LINE('�޿����:'|| avg_sal);
END;
/

SELECT ROUND(AVG(salary), 3)
FROM employees; -- 6587.185

INSERT INTO employees(employee_id, last_name, hire_date, department_id, job_id, salary, email)
VALUES(500, 'tiger', SYSDATE, 60, 'IT_PROG', 10000, 'tiger@naver.com');


-- ����� �������� ���ϰ� �� ���
-- ���� �Ҽ� ���� �� ���
-- �Է� �Ҽ� ���� �� ���
CREATE OR REPLACE TRIGGER emp_trigger
    BEFORE
    UPDATE OR DELETE OR INSERT ON employees
    FOR EACH ROW
BEGIN
    IF UPDATING THEN
        IF :OLD.employee_id = '100' THEN
            RAISE_APPLICATION_ERROR(-20001, '�̹�ȣ�� ������ �� �����ϴ�');
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









