--CONN TO SCOTT
--SQL_JOIN_1_SCOTT

--50) 모든 사원의 이름, 부서번호, 부서이름을 표시하시오.(emp,dept)
SELECT ENAME, E.DEPTNO, D.DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;

--51) 업무가 MANAGER인 사원의 정보를 이름,업무,부서명,근무지 순으로 출력하시오.(emp,dept)
SELECT ENAME, JOB, D.DNAME, D.LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;

--52) 커미션을 받고 급여가 1,600이상인 사원의 사원이름,부서명,근무지를 출력하시오
SELECT ENAME, D.DNAME, D.LOC FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL AND SAL >= 1600;

--53) 근무지가 CHICAGO인 모든 사원의 이름,업무,부서번호 및 부서이름을 표시하시오.
SELECT ENAME, E.JOB, D.DEPTNO, DNAME, LOC FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO';

--54) 근무지별로 근무하는 사원의 수가 5명 이하인 경우, 인원이 적은 도시순으로 정렬하시오.
--(근무 인원이 0명인 곳도 표시)
--SELECT E.DEPTNO, D.DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO(+) = D.DEPTNO GROUP BY D.DEPTNO;
SELECT COUNT(E.DEPTNO) 
FROM EMP E FULL OUTER JOIN DEPT D 
ON E.DEPTNO = D.DEPTNO 
GROUP BY LOC 
HAVING COUNT(E.DEPTNO) <= 5 
ORDER BY COUNT(E.DEPTNO);

--55) 사원의 이름 및 사원 번호를 관리자의 이름과 관리자 번호와 함께 표시하고 각각의 열 레이블은
--employee, emp#, manager, mgr#로 지정하시오.
SELECT DISTINCT A.ENAME AS EMPLOYEE, A.EMPNO AS "EMP#", B.ENAME AS MANAGER, B.EMPNO AS MGR#
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO(+)
CONNECT BY PRIOR A.EMPNO = A.MGR
ORDER BY MANAGER;

--56) 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과
--함께 표시하고 열 레이블을 각각 employee, emp hired, manager, mgr hired로 지정
SELECT A.ENAME AS EMPLOYEE, A.HIREDATE AS "EMP HIRED", B.ENAME AS MANAGER, B.HIREDATE AS "MGR HIRED"
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO AND A.HIREDATE < B.HIREDATE;

--57) 사원의 이름 및 사원번호를 관리자의 이름과 관리자 번호와 함께 표시하고 각각의 열 레이블은 employee, emp#, manager, mgr#로 
--지정하는데 King을 포함하여 관리자가 없는 모든 사원을 표시하도록 하고 결과를 사원번호를 기준으로 정렬
SELECT DISTINCT A.ENAME AS EMPLOYEE, A.EMPNO AS "EMP#", B.ENAME AS MANAGER, B.EMPNO AS MGR#
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO(+) AND B.ENAME IS NULL
CONNECT BY PRIOR A.EMPNO = A.MGR
ORDER BY B.EMPNO;

--58) 지정한 부서번호, 사원이름 및 지정한 사원과 동일한 부서에서 근무하는 모든 사원을
--표시하도록 질의를 작성하고 부서번호는 department, 사원이름은 employee, 동일한
--부서에서 근무하는 사원은 colleague로 표시하시오.(부서번호, 사원이름,동료 순으로 오름차순 정렬
SELECT DISTINCT A.DEPTNO, A.ename, B.ENAME AS COLLEAGUE
FROM EMP A, EMP B
WHERE a.deptno = B.deptno
    AND 30 = B.DEPTNO
    AND 'WARD' = A.ENAME
    AND B.ENAME NOT IN('WARD')
ORDER BY DEPTNO, A.ENAME, COLLEAGUE;



--59)10번부서에서 근무하는 사원들의 부서번호, 부서이름, 사원이름,월급,급여등급을 출력하시오.(emp,dept,salgrade)
SELECT DISTINCT E.DEPTNO, ENAME, SAL, GRADE
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO = 10 
    AND (SAL > LOSAL AND SAL < HISAL);