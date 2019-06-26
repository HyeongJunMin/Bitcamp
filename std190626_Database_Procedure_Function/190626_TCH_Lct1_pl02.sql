/*
    block�Ǿ� �ִ� ó�� -> �Լ�ȭ
    PROCEDURE   - INSERT, DELETE, UPDATE 
                1.IN, OUT(RETURN VALUE) 
    FUNCTION    - SELECT 
                1. �Ű�����
                2. RETURN VALUE
*/

SET SERVEROUTPUT ON

CREATE OR REPLACE PROCEDURE pl_func(inNumber IN NUMBER, outNumber OUT NUMBER)
IS
    -- �����
BEGIN
    -- �����
    DBMS_OUTPUT.PUT_LINE('inNumber:'||inNumber);
    
    outNumber := 112233;
    -- ����ó��
END;
/

-- �ܺ� ����
VAR val NUMBER;
-- ���ν��� ȣ��
EXECUTE pl_func(111, :val);
-- ���� ���
PRINT val;

-- �Ű����� ���� ���
CREATE OR REPLACE PROCEDURE hello_pro
IS
    msg VARCHAR2(100);
BEGIN
    msg := 'hello PROCEDURE';
    DBMS_OUTPUT.PUT_LINE(msg);
END;
/

EXEC hello_pro;

-- DEPARTMENTS ROW �߰�
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
    DBMS_OUTPUT.PUT_LINE('�߰��� ���� �Ͽ����ϴ�');
    --ROLLBACK;
END;
/

EXEC add_dept(300, '�űԺμ�', 2500);

-- update_sal ���ν����� �����ȣ�� �Է¹޾Ƽ� �޿��λ� 30%
CREATE OR REPLACE PROCEDURE update_sal(v_empno IN NUMBER)
IS
BEGIN
    UPDATE employees
    SET salary = salary * 1.3
    WHERE employee_id = v_empno;
END;
/

ACCEPT empno PROMPT '�����ȣ �Է�:'
EXEC update_sal(&empno);
ROLLBACK;

-- �����ȣ�� �Է� ������ �� ����� �̸�, �����ȣ, ����޿��� ����� �ǵ��� �϶�.
CREATE OR REPLACE PROCEDURE emp_info(p_empno IN employees.employee_id%TYPE)
IS
    v_emp employees%ROWTYPE;
BEGIN
    SELECT first_name, salary, hire_date
        INTO v_emp.first_name, v_emp.salary, v_emp.hire_date
    FROM employees
    WHERE employee_id = p_empno;
    
    DBMS_OUTPUT.PUT_LINE('�̸�:'||v_emp.first_name);
    DBMS_OUTPUT.PUT_LINE('�޿�:'||v_emp.salary);
    DBMS_OUTPUT.PUT_LINE('�Ի���:'||v_emp.hire_date);
END;
/

EXECUTE emp_info(102);

/*
    Cursor : ���� �ּҰ��� -> pointer
    
    �Ͻ��� Ŀ�� : �ڵ�����
        SQL%ROWCOUNT : ROW�� ��
        SQL%FOUND : ROW���� �Ѱ��̻��� ���
        SQL%NOTFOUND : ROW���� 0
        
    ����� Ŀ�� : ���� ����
*/
-- �Ͻ��� Ŀ��
CREATE OR REPLACE PROCEDURE implicit_cursor(p_empno IN employees.employee_id%TYPE)
IS
    v_sal employees.salary%TYPE;
    v_update_row NUMBER;    -- ��� ���� �����Ǵ� �����ϴ� ���� ����
BEGIN
    -- �˻�
    SELECT salary INTO v_sal
    FROM employees
    WHERE employee_id = p_empno;
    
    -- �˻��� �� �����Ͱ� �ִ� ���
    IF SQL%FOUND THEN
        DBMS_OUTPUT.PUT_LINE('�˻��� �����Ͱ� �ֽ��ϴ�:'|| v_sal);
    END IF;
    
    -- ����
    UPDATE employees
    SET salary = salary * 1.1
    WHERE employee_id = p_empno;
    
    -- ���
    v_update_row := SQL%ROWCOUNT;
    DBMS_OUTPUT.PUT_LINE('�޿��� �λ�� �����:'||v_update_row);
    
-- ����
EXCEPTION
WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE('�˻��� �����Ͱ� �����ϴ�');    
END;
/

EXECUTE implicit_cursor(101);

EXECUTE implicit_cursor(333);

ROLLBACK;

-- ����� Ŀ��
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
    
    -- CURSOR�� PATCH�ϱ� ���� �������� ����
    v_dname departments.department_name%TYPE;
    emp_cnt NUMBER;
    sal_avg NUMBER;
    
BEGIN
    -- CURSOR OPEN
    OPEN dept_avg;
    
    -- CURSOR FATCH
    FETCH dept_avg INTO v_dname, emp_cnt, sal_avg;

    DBMS_OUTPUT.PUT_LINE('�μ���:'||v_dname);
    DBMS_OUTPUT.PUT_LINE('�����:'||emp_cnt);
    DBMS_OUTPUT.PUT_LINE('�޿����:'||sal_avg);

    -- CURSOR CLOSE
    CLOSE dept_avg;
END;
/

EXEC expcursor_test(50);









































