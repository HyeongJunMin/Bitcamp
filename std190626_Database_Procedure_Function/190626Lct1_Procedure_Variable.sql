--conn to hr
SET SERVEROUT ON

--�Ű����� �ִ� PROCEDURE
CREATE OR REPLACE PROCEDURE fnc1(num1 IN NUMBER, num2 IN NUMBER)
IS tmp NUMBER;
BEGIN
    num2 := num1;
END;
/

VAR v1 NUMBER;
v1 := 123;
PRINT v1;

EXEC fnc1(321,v1);
print v1;

--�Ű������� ���� PROCEDURE
CREATE OR REPLACE PROCEDURE fnc2
IS char1 VARCHAR(100);
BEGIN
    char1 := '111111';
    DBMS_OUTPUT.PUT_LINE(char1);
END;
/
EXEC fnc2;

--ROW �߰��غ���
CREATE OR REPLACE PROCEDURE 

--�����ȣ�� �Է¹޾Ƽ� �޿��� 30% �λ����ִ� update_sal ���ν��� �ۼ�

--�����ȣ�� �Է¹����� �� ����� �̸�, �����ȣ, ����޿��� ������ִ� ���ν��� �ۼ�
select * from user_objects where object_type = 'PROCEDURE';