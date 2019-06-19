--[190619 work 3]
--conn to scott
--SQL_SELECT_6_SCOTT

--23) emp���̺��� ����(job)�� ù���ڴ� �빮�� �������� �ҹ��ڷ� ����Ͻÿ�.
SELECT UPPER(SUBSTR(JOB,1,1)) || LOWER( SUBSTR(JOB,2)) AS JOB FROM EMP;

--24) emp���̺��� ����̸� �� A�� ���Ե� ����̸��� ���ϰ� �� �̸� �� �տ��� 3�ڸ� �����Ͽ� ���
SELECT SUBSTR(ENAME,3) FROM EMP WHERE ENAME LIKE '%A%';

--25) �̸��� ����° ���ڰ� A�� ��� ����� �̸��� ǥ���Ͻÿ�.
SELECT ENAME FROM EMP WHERE SUBSTR(ENAME,3,1) = 'A';

--26) �̸��� J,A �Ǵ� M���� �����ϴ� ��� ����� �̸�(ù ���ڴ� �빮�ڷ�, ������ ���ڴ� �ҹ��ڷ�ǥ��)
--�� �̸��� ���̸� ǥ���Ͻÿ�.(�� ���̺��� name�� length�� ǥ��)
SELECT ENAME, LENGTH(ENAME) FROM EMP WHERE SUBSTR(ENAME,1,1) IN ('J','A','M');

--27) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �ҹ��ڷ� �̸��� ����Ͻÿ�
SELECT LOWER(ENAME) FROM EMP WHERE LENGTH(ENAME) >= 6;

--28) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� ����Ͻÿ�.
SELECT LOWER(SUBSTR(ENAME,1,3)) FROM EMP WHERE LENGTH(ENAME) >= 6;

--29) ��� ����� �̸��� �޿��� ǥ���Ͻÿ�. �޿��� 15�� ���̷� ���ʿ� $��ȣ�� ä���� ��������
--ǥ���ϰ� �����̺��� SALARY�� �����Ͻÿ�.
SELECT ENAME, '$' || TO_CHAR(SAL,'000000000000000') AS SALARY FROM EMP;

