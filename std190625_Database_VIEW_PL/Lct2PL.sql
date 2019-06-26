SET SERVEROUT ON

DECLARE
    message VARCHAR2(10);
BEGIN
    message := 'hello pl';
    DBMS_OUTPUT.PUT_LINE(message);
END;
/

--���ǹ� IF
SET SERVEROUT ON
DECLARE
    cnt INTEGER;
BEGIN
    cnt := 10;
    IF cnt IS NULL THEN
        DBMS_OUTPUT.PUT_LINE('IS NULL');
    ELSE
        DBMS_OUTPUT.PUT_LINE('NOT NULL');
    END IF;
END;
/

--���ǹ�  GO TO
DECLARE     v_name VARCHAR2(10) := 'LEE';     v_case NUMBER := 1;
BEGIN
    CASE WHEN MOD(v_case,2) = 0 then 
            GOTO test1;
        WHEN MOD(v_case,2) = 1 then 
            GOTO test2;
        ELSE
            GOTO ERR;
    END CASE;
<<test1>>
    DBMS_OUTPUT.PUT_LINE(v_name || ' is woman ');   
    GOTO SUB_END;
<<test2>>
    DBMS_OUTPUT.PUT_LINE(v_name || ' is man ');   
    GOTO SUB_END;
<<ERR>>
    DBMS_OUTPUT.PUT_LINE(' 0 ');   
    GOTO SUB_END;
<<SUB_END>>
    DBMS_OUTPUT.PUT_LINE(' exit ');   
END;
/

--�ݺ���
DECLARE
    cnt INTEGER;
    i INTEGER;
BEGIN
    FOR i IN 1..9 LOOP
        DBMS_OUTPUT.PUT_LINE('i = ' || i);   
        cnt := 2 * i;
        DBMS_OUTPUT.PUT_LINE('cnt = ' || cnt);   
    END LOOP;
END;
/

DECLARE cnt INTEGER; v_cnt NUMBER := 0; v_tot NUMBER := 0;
BEGIN
    LOOP
        EXIT WHEN v_cnt = 10;
        v_cnt := v_cnt + 1;
        v_tot := v_tot + v_cnt;        
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('v_cnt = ' || v_cnt);   
    DBMS_OUTPUT.PUT_LINE('v_tot = ' || v_tot);   
END;
/

DECLARE cnt INTEGER; v_cnt NUMBER := 0; v_tot NUMBER := 0;
BEGIN
    WHILE v_cnt < 11
    LOOP
        v_cnt := v_cnt + 1;
        v_tot := v_tot + v_cnt;        
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('v_cnt = ' || v_cnt);   
    DBMS_OUTPUT.PUT_LINE('v_tot = ' || v_tot);   
END;
/


--����ó��
DECLARE cnt INTEGER := 10;
BEGIN
    cnt := cnt/0;
    DBMS_OUTPUT.PUT_LINE('cnt = ' || cnt);   
EXCEPTION WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('OTHERS EXCEPTION');   
END;
/

--�迭 varray
DECLARE
    TYPE varray_test IS VARRAY(3) OF INTEGER; --Ÿ�Լ���
    varray1 varray_test ;--��������
    i INTEGER;
BEGIN
    varray1 := varray_test(11,22,33);
    DBMS_OUTPUT.PUT_LINE('EXIT');
    FOR i IN 1..3 LOOP
        DBMS_OUTPUT.PUT_LINE(varray1(i));
    END LOOP;
END;
/


ACCEPT p_deptno PROMPT '�μ� ��ȣ�� �Է��ϼ���(�޿��� ��):'
DECLARE
    v_salTotal NUMBER;
    p_deptno NUMBER;
BEGIN    
    SELECT SUM(SALARY) INTO v_salTotal FROM employees WHERE department_id = &p_deptno;
    DBMS_OUTPUT.PUT_LINE(&p_deptno || '�� �μ��� �޿��� �� : ' || TO_CHAR(v_salTotal,'$999,999'));
END;
/

ACCEPT p_empno PROMPT '��� ��ȣ�� �Է��ϼ���:'
DECLARE
    v_sal EMPLOYEES.SALARY%TYPE := 1000; --�ش� �÷��� Ÿ������ ������
    v_salTotal NUMBER;
BEGIN    
    UPDATE employees SET SALARY = SALARY + v_sal WHERE employee_id = &p_empno;
    SELECT SALARY INTO v_salTotal FROM employees WHERE employee_id = &p_empno;
    DBMS_OUTPUT.PUT_LINE(&p_empno || '�� ����� �޿� +1000 : ' || TO_CHAR(v_salTotal,'$999,999'));
END;
/
ROLLBACK;

--ROWTYPE
DECLARE
    v_emp employees%ROWTYPE;
BEGIN
    select employee_id, first_name, last_name, salary
        INTO v_emp.employee_id, v_emp.first_name, v_emp.last_name, v_emp.salary
    from employees 
    where employee_id = 100;
    DBMS_OUTPUT.PUT_LINE('�����ȣ  ' || v_emp.employee_id);
    DBMS_OUTPUT.PUT_LINE('�̸�    ' || v_emp.first_name);
    DBMS_OUTPUT.PUT_LINE('��     ' || v_emp.last_name);
    DBMS_OUTPUT.PUT_LINE('�޿�    ' || v_emp.salary);
END;
/
