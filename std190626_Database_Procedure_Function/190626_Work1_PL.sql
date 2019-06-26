-- ����1) �̸��� �Է¹޾� �� ����� ���� �� �μ���� �޿��� �˻��ϴ� ���ν����� �����Ͽ���.
SET SERVEROUTPUT ON

CREATE OR REPLACE PROCEDURE emp_search(inName in VARCHAR2)
IS
    e_name VARCHAR2(10);
    sal NUMBER;
    -- �����
BEGIN
    select d.dname, e.sal into e_name, sal
    from EMP e, DEPT d
    where e.deptno = d.deptno
        and e.ename = inName;
    
    DBMS_OUTPUT.PUT_LINE('�μ��� : ' || e_name);
    DBMS_OUTPUT.PUT_LINE('�޿�:'|| sal);
END;
/
exec EMP_SEARCH('KING');
select * from user_objects;
-- ����2) EMP ���̺��� �̸����� �μ� ��ȣ�� �˻��ϴ� �Լ��� �ۼ��Ͽ���.
CREATE OR REPLACE FUNCTION EMP_REPLACE(E_NAME IN VARCHAR2) RETURN NUMBER
IS
    E_NUM NUMBER;
BEGIN
    SELECT EMPNO INTO E_NUM FROM EMP WHERE ENAME = E_NAME;
    DBMS_OUTPUT.PUT_LINE('�Լ� ��');
    RETURN E_NUM;
    
    EXCEPTION WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('���ܹ߻�');
END;
/
select * from user_objects;
VAR e_num NUMBER;
EXEC :e_num := EMP_REPLACE('KING');
print e_num;
select * from emp where ename = 'KING';
-- ����3) EMP ���̺��� �̸��� �Է� �޾� �μ���ȣ,�μ���,�޿��� �˻��ϴ� FUNCTION�� �ۼ��Ͽ���. 
--�� �μ���ȣ�� RETURN�� ����Ͽ���.
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
        
    DBMS_OUTPUT.PUT_LINE('�����(�Ű�����) : ' || INNAME);    
    DBMS_OUTPUT.PUT_LINE('�μ���ȣ : ' || F_DEPTNO);
    DBMS_OUTPUT.PUT_LINE('�μ��� : ' || F_DNAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || F_SAL);
        
    DBMS_OUTPUT.PUT_LINE('�Լ� ��');
    RETURN F_DEPTNO;
    EXCEPTION WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('���ܹ߻�');
END;
/
VAR e_num2 NUMBER;
EXEC :e_num2 := EMP_INFO('KING');
select * from user_objects;