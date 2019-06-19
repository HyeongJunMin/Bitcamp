--[190619 work 3]
--conn to scott
--SQL_SELECT_6_SCOTT

--23) emp테이블의 업무(job)을 첫글자는 대문자 나머지는 소문자로 출력하시오.
SELECT UPPER(SUBSTR(JOB,1,1)) || LOWER( SUBSTR(JOB,2)) AS JOB FROM EMP;

--24) emp테이블에서 사원이름 중 A가 포함된 사원이름을 구하고 그 이름 중 앞에서 3자만 추출하여 출력
SELECT SUBSTR(ENAME,3) FROM EMP WHERE ENAME LIKE '%A%';

--25) 이름의 세번째 문자가 A인 모든 사원의 이름을 표시하시오.
SELECT ENAME FROM EMP WHERE SUBSTR(ENAME,3,1) = 'A';

--26) 이름이 J,A 또는 M으로 시작하는 모든 사원의 이름(첫 글자는 대문자로, 나머지 글자는 소문자로표시)
--및 이름의 길이를 표시하시오.(열 레이블은 name과 length로 표시)
SELECT ENAME, LENGTH(ENAME) FROM EMP WHERE SUBSTR(ENAME,1,1) IN ('J','A','M');

--27) 이름의 글자수가 6자 이상인 사원의 이름을 소문자로 이름만 출력하시오
SELECT LOWER(ENAME) FROM EMP WHERE LENGTH(ENAME) >= 6;

--28) 이름의 글자수가 6자 이상인 사람의 이름을 앞에서 3자만 구하여 소문자로 출력하시오.
SELECT LOWER(SUBSTR(ENAME,1,3)) FROM EMP WHERE LENGTH(ENAME) >= 6;

--29) 모든 사원의 이름과 급여를 표시하시오. 급여는 15자 길이로 왼쪽에 $기호가 채워진 형식으로
--표기하고 열레이블을 SALARY로 지정하시오.
SELECT ENAME, '$' || TO_CHAR(SAL,'000000000000000') AS SALARY FROM EMP;

