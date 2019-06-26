--conn to scott
--입력받은 값으로 부터 10%의 세율을 취득하는 함수

CREATE OR REPLACE FUNCTION tax_value(p_val IN NUMBER) RETURN NUMBER
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('함수 끝');
    RETURN (p_val * 0.1);
END;
/

EXEC tax_value(100); --이렇게는 못씀
SELECT tax_value(100) FROM DUAL; -- 요렇게하면 조회만

VAR t_val NUMBER;   --변수하나 선언해주고
EXEC :t_val := tax_value(100); --EXEC으로 함수 실행 및 리턴값 저장
PRINT t_val;
select * from user_objects ;