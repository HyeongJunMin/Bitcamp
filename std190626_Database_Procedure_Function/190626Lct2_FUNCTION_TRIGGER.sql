--conn to scott
--�Է¹��� ������ ���� 10%�� ������ ����ϴ� �Լ�

CREATE OR REPLACE FUNCTION tax_value(p_val IN NUMBER) RETURN NUMBER
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('�Լ� ��');
    RETURN (p_val * 0.1);
END;
/

EXEC tax_value(100); --�̷��Դ� ����
SELECT tax_value(100) FROM DUAL; -- �䷸���ϸ� ��ȸ��

VAR t_val NUMBER;   --�����ϳ� �������ְ�
EXEC :t_val := tax_value(100); --EXEC���� �Լ� ���� �� ���ϰ� ����
PRINT t_val;
select * from user_objects ;