--conn to hr
SET SERVEROUT ON

--매개변수 있는 PROCEDURE
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

--매개변수가 없는 PROCEDURE
CREATE OR REPLACE PROCEDURE fnc2
IS char1 VARCHAR(100);
BEGIN
    char1 := '111111';
    DBMS_OUTPUT.PUT_LINE(char1);
END;
/
EXEC fnc2;

--ROW 추가해보기
CREATE OR REPLACE PROCEDURE 

--사원번호를 입력받아서 급여를 30% 인상해주는 update_sal 프로시저 작성

--사원번호를 입력받으면 그 사원의 이름, 사원번호, 사원급여를 출력해주는 프로시저 작성
select * from user_objects where object_type = 'PROCEDURE';