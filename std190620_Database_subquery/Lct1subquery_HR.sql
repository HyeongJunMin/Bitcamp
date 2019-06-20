--conn to hr    

--SELECT SUB QUERY
SELECT employee_id, SALARY, (SELECT SUM(SALARY) FROM employees)
FROM employees;

--FROM SUB QUERY
SELECT *
FROM ( SELECT employee_id, last_name, salary, department_id 
        FROM EMPLOYEES 
        WHERE department_id =20);
SELECT employee_id, last_name, salary, department_id 
FROM (SELECT * 
        FROM employees 
        WHERE SALARY >= 6000)
WHERE department_id =20;
        
--WHERE SUB QUERY
SELECT * 
FROM employees
WHERE salary > (SELECT AVG(SVRQUER) FROM employees);

SELECT *
FROM employees WHERE (SALARY, department_id) IN (SELECT MIN(SALARY), department_id FROM employees GROUP BY department_id);
SELECT FIRST_NAME, SALARY
FROM employees WHERE (SALARY) IN (SELECT MIN(SALARY) FROM employees GROUP BY department_id);