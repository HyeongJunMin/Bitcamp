--conn to hr
--subquery work1

--문제1) EMPLOYEES 테이블에서 Kochhar의 급여보다 많은 사원의 정보를 사원번호,이름,담당업무,급여를 출력하라.
select employee_id, first_name, job_id, salary
from employees
where salary > (select salary from employees where last_name = 'Kochhar');

--문제2) EMPLOYEES 테이블에서 급여의 평균보다 적은 사원의 정보를 사원번호,이름,담당업무,급여,부서번호를 출력하여라.
select employee_id, first_name, job_id, salary, department_id
from employees
where salary < (select avg(salary) from employees)
order by salary desc;

--문제3) EMPLOYEES 테이블에서 100번 부서의 최소 급여보다 최소 급여가 많은 다른 모든 부서를 출력하라
select department_id, min(salary) as av
from employees
where salary > (select min(salary) from employees where department_id =100)
group by department_id;

--문제4) 업무별로 최소 급여를 받는 사원의 정보를 사원번호,이름,업무,부서번호를 출력하여라. 단 업무별로 정렬하여라.
select employee_id, first_name, job_id, salary, department_id
from employees
where (salary, job_id) in (select min(salary), job_id from employees group by job_id)
order by job_id;

--문제5) EMPLOYEES 과 DEPARTMENTS 테이블에서 업무가 SA_MAN 사원의 정보를 이름,업무,부서명,근무지를 출력하라.
select first_name, job_id, d.department_name, d.location_id
from employees e , departments d
where e.job_id = 'SA_MAN' and e.department_id = d.department_id;

--문제6) EMPLOYEES ?테이블에서?가장?많은?사원을?갖는?MANAGER의?사원번호를?출력하라.
select manager_id
from EMPLOYEES
group by manager_id
having count(manager_id) = (select max(count(*)) from employees group by manager_id);

--문제7) EMPLOYEES ?테이블에서?가장?많은?사원이?속해있는?부서번호와?사원수를?출력하라.
select department_id, count(*)
from employees
group by department_id
having count(department_id) = (select max(count(*)) from employees group by department_id);

--문제8) EMPLOYEES ?테이블에서?사원번호가?123인?사원의?직업과?같고?사원번호가?192인?사원의?급여(SAL)보다?
--급여가 많은?사원의?사원번호,?이름,?직업,?급여를?출력하라.
select employee_id, first_name, job_id, salary
from employees
where employee_id = 123 and salary > (select salary from employees where employee_id = 192);

--문제9) ? 직업(JOB)별로?최소?급여를?받는?사원의?정보를?사원번호,?이름,?업무,?부서명을?출력하라.
--조건1 :?직업별로?내림차순?정렬
select employee_id, first_name, job_id, e.department_id, d.department_name
from employees e, departments d
where (job_id, salary) in ( select job_id, min(salary) from employees group by job_id)
    and e.department_id = d.department_id
order by job_id desc;

--문제10) EMPLOYEES 테이블에서 50번 부서의 최소 급여를 받는 사원 보다 많은 급여를 받는 사원의 정보를 
--사원번호,이름,업무,입사일자,급여,부서번호를 출력하라. 단 50번은 제외
select employee_id, first_name, job_id, hire_date, salary, department_id
from employees
where salary > (select min(salary) from employees where department_id=50)
    and department_id <> 50;

--문제11) EMPLOYEES 테이블에서 50번 부서의 최고 급여를 받는 사원 보다 많은 급여를 받는 사원의 정보를 
--사원번호,이름,업무,입사일자,급여,부서번호를 출력하라. 단50번은 제외
select employee_id, first_name, job_id, hire_date, salary, department_id
from employees
where salary > (select max(salary) from employees where department_id=50)
    and department_id <> 50;