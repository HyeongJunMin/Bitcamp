--오라클 11g hr계정 연습문제
 
--1. 직책(Job Title)이 Sales Manager인 사원들의 입사년도와 입사년도(hire_date)별 평균 급여를 출력하시오. 
--   출력 시 년도를 기준으로 오름차순 정렬하시오. 
select b.employee_id, b.last_name, a.job_title, b.salary, b.hire_date, to_char(b.hire_date,'yy'), c.uuu
from (select e.employee_id, e.last_name, j.job_title, e.salary, e.hire_date
        from employees e, jobs j 
        where job_title = 'Sales Manager' 
            and e.job_id = j.job_id
        ) a, employees b,
            (select to_char(hire_date, 'yy') as ttt, round(avg(salary),2) as uuu
            from employees
            group by to_char(hire_date,'yy')
            order by to_char(hire_date, 'yy')
            ) c
where a.employee_id = b.employee_id
    and to_char(b.hire_date, 'yy') = c.ttt
order by c.ttt;
    
--2. 각 도시(city)에 있는 모든 부서 직원들의 평균급여를 조회하고자 한다. 
--   평균급여가 가장 낮은 도시부터 도시명(city)과 평균연봉, 해당 도시의 직원수를 출력하시오. 
--   단, 도시에 근무하는 직원이 10명 이상인 곳은 제외하고 조회하시오.
select *
from (select distinct l.city, round(avg(e.salary)OVER(PARTITION BY l.city),2) as cityavg, count(l.city)OVER(PARTITION BY l.city) as cnt
        from employees e, departments d, locations l
        where e.department_id = d.department_id
            and d.location_id = l.location_id
        order by cityavg asc
        )
where cnt < 10;


--3. ‘Public  Accountant’의 직책(job_title)으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 출력하시오. 
--   (현재 ‘Public Accountant’의 직책(job_title)으로 근무하는 사원은 고려 하지 않는다.)      
--   이름은 first_name, last_name을 아래의 실행결과와 같이 출력한다.
select e.first_name, e.last_name, jj.job_title
from employees e, job_history j, jobs jj
where e.employee_id = j.employee_id
    and j.job_id = jj.job_id
    and jj.job_title = 'Public Accountant';

--4. 자신의 매니저보다 연봉(salary)를 많이 받는 직원들의 성(last_name)과 연봉(salary)를 출 력하시오. 
select a.last_name, a.salary
from employees a, employees b
where a.manager_id = b.employee_id
    and a.salary > b.salary;

--5. 2007년에 입사(hire_date)한 직원들의 사번(employee_id), 이름(first_name), 성(last_name), 
--   부서명(department_name)을 조회합니다.  
--   이때, 부서에 배치되지 않은 직원의 경우, ‘<Not Assigned>’로 출력하시오. 
select e.employee_id, e.first_name, e.last_name, nvl(d.department_name,'<Not Assigned>')
from employees e left outer join departments d
on e.department_id = d.department_id(+)
where to_char(e.hire_date, 'yy') = '07';
 
--6. 업무명(job_title)이 ‘Sales Representative’인 직원 중에서 연봉(salary)이 9,000이상, 10,000 이하인 
--   직원들의 이름(first_name), 성(last_name)과 연봉(salary)를 출력하시오
select e.first_name, e.last_name, e.salary
from employees e, jobs j
where e.job_id = j.job_id
    and j.job_title = 'Sales Representative'
    and (e.salary between 9000 and 10000);

--7. 부서별로 가장 적은 급여를 받고 있는 직원의 이름, 부서이름, 급여를 출력하시오. 
--   이름은 last_name만 출력하며, 부서이름으로 오름차순 정렬하고, 
--   부서가 같은 경우 이름을 기준 으로 오름차순 정렬하여 출력합니다. 
select e.last_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id
    and (e.salary, e.department_id) in (select min(salary), department_id
                                        from employees
                                        group by department_id)
order by d.department_name, e.last_name;

--8. EMPLOYEES 테이블에서 급여를 많이 받는 순서대로 조회했을 때 결과처럼 6번째부터 10 번째까지 
--   5명의 last_name, first_name, salary를 조회하는 sql문장을 작성하시오.
select *
from (select ROWNUM as RNUM, employee_id, first_name,last_name, salary
       from (select * from employees order by salary desc)
       )
    where RNUM between 6 and 10;

 

--9. 사원의 부서가 속한 도시(city)가 ‘Seattle’인 사원의 이름, 해당 사원의 매니저 이름, 사원 의 부서이름을 출력하시오. 
--   이때 사원의 매니저가 없을 경우 ‘<없음>’이라고 출력하시오. 이름은 last_name만 출력하며, 
--   사원의 이름을 오름차순으로 정렬하시오. 
select e.last_name, nvl(b.last_name,'<없음>'), d.department_name, l.city
from employees e, departments d, locations l, employees b
where e.department_id = d.department_id(+)
    and d.location_id = l.location_id(+)
    and e.manager_id = b.employee_id(+)
    and l.city = 'Seattle'
order by e.last_name;

 
--10. 각 업무(job) 별로 연봉(salary)의 총합을 구하고자 한다. 연봉 총합이 가장 높은 업무부터 
--    업무명(job_title)과 연봉 총합을 조회하시오. 단 연봉총합이 30,000보다 큰 업무만 출력하시오. 
select j.job_title, sum(salary)
from employees e, jobs j
where e.job_id = j.job_id 
group by j.job_title
having sum(salary) > 30000
order by sum(salary) desc;


--11. 각 사원(employee)에 대해서 사번(employee_id), 이름(first_name), 업무명(job_title), 
--    부서 명(department_name)을 조회하시오. 
--    단 도시명(city)이 ‘Seattle’인 지역(location)의 부서 (department)에 근무하는 직원을 사원번호 오름차순순으로 출력하시오.
select e.employee_id, e.first_name, j.job_title, d.department_name
from employees e, departments d, jobs j, locations l
where e.department_id = d.department_id(+)
    and e.job_id = j.job_id
    and d.location_id = l.location_id
    and l.city = 'Seattle'
order by e.employee_id;


--12. 2001~20003년사이에 입사한 직원의 이름(first_name), 입사일(hire_date), 관리자사번 (employee_id), 
--    관리자 이름(fist_name)을 조회합니다. 단, 관리자가 없는 사원정보도 출력 결과에 포함시켜 출력한다.
select e.first_name, e.hire_date, e.manager_id, b.first_name
from employees e, departments d, employees b
where e.department_id = d.department_id(+) 
    and e.manager_id = b.employee_id(+)
    and (to_char(e.hire_date, 'yy') between '01' and '03')
order by e.hire_date;

--13. ‘Sales’ 부서에 속한 직원의 이름(first_name), 급여(salary), 부서이름(department_name)을 조회하시오. 
--    단, 급여는 100번 부서의 평균보다 적게 받는 직원 정보만 출력되어야 한다. 
select e.first_name, e.salary, d.department_name
from employees e, departments d
where e.department_id = d.department_id(+)
    and e.salary < (select avg(salary) from employees where department_id = '100')
    and d.department_name = 'Sales'
order by salary desc;

--14. Employees 테이블에서 입사한달(hire_date)별로 인원수를 조회하시오.
select count(*), mon||'월' as 입사월
from (select employee_id, to_char(hire_date,'mm') as mon from employees)
group by mon
order by mon;


--15. 부서별 직원들의 최대, 최소, 평균급여를 조회하되, 
--    평균급여가 ‘IT’ 부서의 평균급여보다 많고, ‘Sales’ 부서의 평균보다 적은 부서 정보만 출력하시오. 
select *
from (select max(salary) as max, min(salary) as min, round(avg(salary),2) as avg from employees group by department_id)
where avg > (select round(avg(salary),2) from employees e, departments d where e.department_id = d.department_id and d.department_name = 'IT')
    and avg < (select round(avg(salary),2) from employees e, departments d where e.department_id = d.department_id and d.department_name = 'Sales');

--16. 각 부서별로 직원이 한명만 있는 부서만 조회하시오. 
--    단, 직원이 없는 부서에 대해서는 ‘<신생부서>’라는 문자열이 출력되도록 하고,
--    출력결과는 다음과 같이 부서명이 내림차순 으로 정렬되어야한다. 
select 부서명, 
            CASE 인원
                WHEN 0 THEN '<신생부서>'
                ELSE '1'
            END AS "지역"
from (select d.department_name as 부서명, count(e.department_id) as 인원
        from employees e , departments d 
        where e.department_id(+) = d.department_id
        group by d.department_name
        )
where 인원 in (1,0);


--17. 부서별 입사월별 직원수를 출력하시오. 
--    단, 직원수가 5명 이상인 부서만 출력되어야 하며 출력결과는 부서이름 순으로 한다.
select *
from    (select d.department_name as 부서이름 , count(d.department_name) as 입사인원
        from employees e, departments d
        where e.department_id = d.department_id
        group by d.department_name
        )
where 입사인원 >= 5
order by 부서이름;


--18. 국가(country_name) 별 도시(city)별 직원수를 조회하시오. 
--    단, 부서에 속해있지 않은 직원 이 있기 때문에 106명의 직원만 출력이 된다. 
--    부서정보가 없는 직원은 국가명과 도시명 대신에 ‘<부서없음>’이 출력되도록 하여 107명 모두 출력되게 한다.
select nvl(c.country_name,'<부서없음>') as country_name, nvl(l.city,'<부서없음>'), count(l.city)
from employees e, departments d, locations l, countries c
where e.department_id = d.department_id(+)
    and d.location_id = l.location_id(+)
    and l.country_id = c.country_id(+)
group by c.country_name, l.city
order by c.country_name;

 
--19. 각 부서별 최대 급여자의 아이디(employee_id), 이름(first_name), 급여(salary)를 출력하시오. 
--    단, 최대 급여자가 속한 부서의 평균급여를 마지막으로 출력하여 평균급여와 비교할 수 있게 할 것.
select e.employee_id, e.first_name, e.salary, avgOfDpt
from (select e.department_id as maxId, round(max(salary),2) as maxOfDpt from employees e group by e.department_id) a,
    (select department_id as avgId, round(avg(salary),2) as avgOfDpt  from employees group by department_id) b,
    employees e
    where maxId = avgId
        and (e.department_id = maxId and e.salary = maxOfdpt)
order by e.department_id;
                    

--20. 커미션(commission_pct)별 직원수를 조회하시오. 
--    커미션은 아래실행결과처럼 0.2, 0.25는 모두 .2로, 0.3, 0.35는 .3 형태로 출력되어야 한다. 
--    단, 커미션 정보가 없는 직원들도 있는 데 커미션이 없는 직원 그룹은 ‘<커미션 없음>’이 출력되게 한다.
select nvl(to_char(commission_pct),'<커미션 없음>') as comm, count(*) as cnt
from employees
group by commission_pct;

--21. 커미션(commission_pct)을 가장 많이 받은 상위 4명의 부서명(department_name), 
--    직원명 (first_name), 급여(salary), 커미션(commission_pct) 정보를 조회하시오. 
--    출력결과는 커미션 을 많이 받는 순서로 출력하되 동일한 커미션에 대해서는 급여가 높은 직원이 먼저 출력 되게 한다.
select first_name, salary, commission_pct
from (select ROWNUM, first_name, salary, commission_pct 
        from (select * from employees order by nvl(commission_pct,0) desc, salary desc)
        )
    where ROWNUM < 5;

