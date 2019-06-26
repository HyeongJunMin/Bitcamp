--conn to scott


--����1) �����ȣ�� 7369�� ����� �޿��� 1500�� ���Ͽ� �����Ͽ���.
UPDATE EMP SET SAL = SAL+1500 WHERE EMPNO = 7369;
--����2) ������ �Է¹޾� �޿��� ���� ����ϴ� SCRIPT�� �ۼ��Ͽ���.
select sum(sal) from emp where job = 'CLERK';

SET SERVEROUT ON
ACCEPT v_Job PROMPT '������ �Է��ϼ���:'
DECLARE
    v_salTotal NUMBER;
BEGIN    
    SELECT sum(sal) INTO v_salTotal FROM emp WHERE job = &v_job;
    DBMS_OUTPUT.PUT_LINE(&v_job || '������ �޿� ���� : ' || TO_CHAR(v_salTotal,'$999,999'));
END;
/

--����3) EMP ���̺� EMPNO_SEQUENCE�� SEQUENCE�� �̿��Ͽ� 
--�̸�.�޿�,�μ���ȣ�� �Է¹޾� ����ϴ� SCRIPT�� �ۼ��Ͽ���. 
--�� 10���μ��� �Էµ� �޿��� 20%�� �����Ͽ� ����ϰ� 30���μ��� 10% ���� ���� �ִ�.
select * from emp;

create sequence EMPNO_SEQUENCE start with 9000 increment by 1 maxvalue 999999;

ACCEPT vName PROMPT '�̸��� �Է��ϼ���:'
ACCEPT vSal PROMPT '�޿��� �Է��ϼ���:'
ACCEPT vDeptno PROMPT '�μ���ȣ�� �Է��ϼ���:'
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

--����4) EMP ���̺��� �̸��� �Է� �޾� �Ʒ��� ���·� ����ϴ� SCRIPT�� �ۼ��Ͽ���.
--��ȸ�ϰ��� �ϴ� ����� �̸��� �Է��Ͻÿ� : scott
ACCEPT vName PROMPT '��ȸ�ϰ��� �ϴ� ����� �̸��� �Է��Ͻÿ� : '
DECLARE
    E EMP%ROWTYPE;
BEGIN
    SELECT EMPNO, ENAME INTO E.EMPNO, E.ENAME
    FROM EMP WHERE ENAME = &vName;
    DBMS_OUTPUT.PUT_LINE(E.EMPNO ||'   ' || E.ENAME);
END;
/
select * from emp;


--����5) �̸��� �Է¹޾� �޿��� �Ի����� ����ϴ� SCRIPT�� �ۼ��Ͽ���.
ACCEPT vName PROMPT '��ȸ�ϰ��� �ϴ� ����� �̸��� �Է��Ͻÿ� : '
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

ACCEPT vName PROMPT '��ȸ�ϰ��� �ϴ� ����� �̸��� �Է��Ͻÿ� : '
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