--����Ŭ 11g hr���� ��������
 
--1. ��å(Job Title)�� Sales Manager�� ������� �Ի�⵵�� �Ի�⵵(hire_date)�� ��� �޿��� ����Ͻÿ�. 
--   ��� �� �⵵�� �������� �������� �����Ͻÿ�. 
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
    
--2. �� ����(city)�� �ִ� ��� �μ� �������� ��ձ޿��� ��ȸ�ϰ��� �Ѵ�. 
--   ��ձ޿��� ���� ���� ���ú��� ���ø�(city)�� ��տ���, �ش� ������ �������� ����Ͻÿ�. 
--   ��, ���ÿ� �ٹ��ϴ� ������ 10�� �̻��� ���� �����ϰ� ��ȸ�Ͻÿ�.
select *
from (select distinct l.city, round(avg(e.salary)OVER(PARTITION BY l.city),2) as cityavg, count(l.city)OVER(PARTITION BY l.city) as cnt
        from employees e, departments d, locations l
        where e.department_id = d.department_id
            and d.location_id = l.location_id
        order by cityavg asc
        )
where cnt < 10;


--3. ��Public  Accountant���� ��å(job_title)���� ���ſ� �ٹ��� ���� �ִ� ��� ����� ����� �̸��� ����Ͻÿ�. 
--   (���� ��Public Accountant���� ��å(job_title)���� �ٹ��ϴ� ����� ��� ���� �ʴ´�.)      
--   �̸��� first_name, last_name�� �Ʒ��� �������� ���� ����Ѵ�.
select e.first_name, e.last_name, jj.job_title
from employees e, job_history j, jobs jj
where e.employee_id = j.employee_id
    and j.job_id = jj.job_id
    and jj.job_title = 'Public Accountant';

--4. �ڽ��� �Ŵ������� ����(salary)�� ���� �޴� �������� ��(last_name)�� ����(salary)�� �� ���Ͻÿ�. 
select a.last_name, a.salary
from employees a, employees b
where a.manager_id = b.employee_id
    and a.salary > b.salary;

--5. 2007�⿡ �Ի�(hire_date)�� �������� ���(employee_id), �̸�(first_name), ��(last_name), 
--   �μ���(department_name)�� ��ȸ�մϴ�.  
--   �̶�, �μ��� ��ġ���� ���� ������ ���, ��<Not Assigned>���� ����Ͻÿ�. 
select e.employee_id, e.first_name, e.last_name, nvl(d.department_name,'<Not Assigned>')
from employees e left outer join departments d
on e.department_id = d.department_id(+)
where to_char(e.hire_date, 'yy') = '07';
 
--6. ������(job_title)�� ��Sales Representative���� ���� �߿��� ����(salary)�� 9,000�̻�, 10,000 ������ 
--   �������� �̸�(first_name), ��(last_name)�� ����(salary)�� ����Ͻÿ�
select e.first_name, e.last_name, e.salary
from employees e, jobs j
where e.job_id = j.job_id
    and j.job_title = 'Sales Representative'
    and (e.salary between 9000 and 10000);

--7. �μ����� ���� ���� �޿��� �ް� �ִ� ������ �̸�, �μ��̸�, �޿��� ����Ͻÿ�. 
--   �̸��� last_name�� ����ϸ�, �μ��̸����� �������� �����ϰ�, 
--   �μ��� ���� ��� �̸��� ���� ���� �������� �����Ͽ� ����մϴ�. 
select e.last_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id
    and (e.salary, e.department_id) in (select min(salary), department_id
                                        from employees
                                        group by department_id)
order by d.department_name, e.last_name;

--8. EMPLOYEES ���̺��� �޿��� ���� �޴� ������� ��ȸ���� �� ���ó�� 6��°���� 10 ��°���� 
--   5���� last_name, first_name, salary�� ��ȸ�ϴ� sql������ �ۼ��Ͻÿ�.
select *
from (select ROWNUM as RNUM, employee_id, first_name,last_name, salary
       from (select * from employees order by salary desc)
       )
    where RNUM between 6 and 10;

 

--9. ����� �μ��� ���� ����(city)�� ��Seattle���� ����� �̸�, �ش� ����� �Ŵ��� �̸�, ��� �� �μ��̸��� ����Ͻÿ�. 
--   �̶� ����� �Ŵ����� ���� ��� ��<����>���̶�� ����Ͻÿ�. �̸��� last_name�� ����ϸ�, 
--   ����� �̸��� ������������ �����Ͻÿ�. 
select e.last_name, nvl(b.last_name,'<����>'), d.department_name, l.city
from employees e, departments d, locations l, employees b
where e.department_id = d.department_id(+)
    and d.location_id = l.location_id(+)
    and e.manager_id = b.employee_id(+)
    and l.city = 'Seattle'
order by e.last_name;

 
--10. �� ����(job) ���� ����(salary)�� ������ ���ϰ��� �Ѵ�. ���� ������ ���� ���� �������� 
--    ������(job_title)�� ���� ������ ��ȸ�Ͻÿ�. �� ���������� 30,000���� ū ������ ����Ͻÿ�. 
select j.job_title, sum(salary)
from employees e, jobs j
where e.job_id = j.job_id 
group by j.job_title
having sum(salary) > 30000
order by sum(salary) desc;


--11. �� ���(employee)�� ���ؼ� ���(employee_id), �̸�(first_name), ������(job_title), 
--    �μ� ��(department_name)�� ��ȸ�Ͻÿ�. 
--    �� ���ø�(city)�� ��Seattle���� ����(location)�� �μ� (department)�� �ٹ��ϴ� ������ �����ȣ �������������� ����Ͻÿ�.
select e.employee_id, e.first_name, j.job_title, d.department_name
from employees e, departments d, jobs j, locations l
where e.department_id = d.department_id(+)
    and e.job_id = j.job_id
    and d.location_id = l.location_id
    and l.city = 'Seattle'
order by e.employee_id;


--12. 2001~20003����̿� �Ի��� ������ �̸�(first_name), �Ի���(hire_date), �����ڻ�� (employee_id), 
--    ������ �̸�(fist_name)�� ��ȸ�մϴ�. ��, �����ڰ� ���� ��������� ��� ����� ���Խ��� ����Ѵ�.
select e.first_name, e.hire_date, e.manager_id, b.first_name
from employees e, departments d, employees b
where e.department_id = d.department_id(+) 
    and e.manager_id = b.employee_id(+)
    and (to_char(e.hire_date, 'yy') between '01' and '03')
order by e.hire_date;

--13. ��Sales�� �μ��� ���� ������ �̸�(first_name), �޿�(salary), �μ��̸�(department_name)�� ��ȸ�Ͻÿ�. 
--    ��, �޿��� 100�� �μ��� ��պ��� ���� �޴� ���� ������ ��µǾ�� �Ѵ�. 
select e.first_name, e.salary, d.department_name
from employees e, departments d
where e.department_id = d.department_id(+)
    and e.salary < (select avg(salary) from employees where department_id = '100')
    and d.department_name = 'Sales'
order by salary desc;

--14. Employees ���̺��� �Ի��Ѵ�(hire_date)���� �ο����� ��ȸ�Ͻÿ�.
select count(*), mon||'��' as �Ի��
from (select employee_id, to_char(hire_date,'mm') as mon from employees)
group by mon
order by mon;


--15. �μ��� �������� �ִ�, �ּ�, ��ձ޿��� ��ȸ�ϵ�, 
--    ��ձ޿��� ��IT�� �μ��� ��ձ޿����� ����, ��Sales�� �μ��� ��պ��� ���� �μ� ������ ����Ͻÿ�. 
select *
from (select max(salary) as max, min(salary) as min, round(avg(salary),2) as avg from employees group by department_id)
where avg > (select round(avg(salary),2) from employees e, departments d where e.department_id = d.department_id and d.department_name = 'IT')
    and avg < (select round(avg(salary),2) from employees e, departments d where e.department_id = d.department_id and d.department_name = 'Sales');

--16. �� �μ����� ������ �Ѹ� �ִ� �μ��� ��ȸ�Ͻÿ�. 
--    ��, ������ ���� �μ��� ���ؼ��� ��<�Ż��μ�>����� ���ڿ��� ��µǵ��� �ϰ�,
--    ��°���� ������ ���� �μ����� �������� ���� ���ĵǾ���Ѵ�. 
select �μ���, 
            CASE �ο�
                WHEN 0 THEN '<�Ż��μ�>'
                ELSE '1'
            END AS "����"
from (select d.department_name as �μ���, count(e.department_id) as �ο�
        from employees e , departments d 
        where e.department_id(+) = d.department_id
        group by d.department_name
        )
where �ο� in (1,0);


--17. �μ��� �Ի���� �������� ����Ͻÿ�. 
--    ��, �������� 5�� �̻��� �μ��� ��µǾ�� �ϸ� ��°���� �μ��̸� ������ �Ѵ�.
select *
from    (select d.department_name as �μ��̸� , count(d.department_name) as �Ի��ο�
        from employees e, departments d
        where e.department_id = d.department_id
        group by d.department_name
        )
where �Ի��ο� >= 5
order by �μ��̸�;


--18. ����(country_name) �� ����(city)�� �������� ��ȸ�Ͻÿ�. 
--    ��, �μ��� �������� ���� ���� �� �ֱ� ������ 106���� ������ ����� �ȴ�. 
--    �μ������� ���� ������ ������� ���ø� ��ſ� ��<�μ�����>���� ��µǵ��� �Ͽ� 107�� ��� ��µǰ� �Ѵ�.
select nvl(c.country_name,'<�μ�����>') as country_name, nvl(l.city,'<�μ�����>'), count(l.city)
from employees e, departments d, locations l, countries c
where e.department_id = d.department_id(+)
    and d.location_id = l.location_id(+)
    and l.country_id = c.country_id(+)
group by c.country_name, l.city
order by c.country_name;

 
--19. �� �μ��� �ִ� �޿����� ���̵�(employee_id), �̸�(first_name), �޿�(salary)�� ����Ͻÿ�. 
--    ��, �ִ� �޿��ڰ� ���� �μ��� ��ձ޿��� ���������� ����Ͽ� ��ձ޿��� ���� �� �ְ� �� ��.
select e.employee_id, e.first_name, e.salary, avgOfDpt
from (select e.department_id as maxId, round(max(salary),2) as maxOfDpt from employees e group by e.department_id) a,
    (select department_id as avgId, round(avg(salary),2) as avgOfDpt  from employees group by department_id) b,
    employees e
    where maxId = avgId
        and (e.department_id = maxId and e.salary = maxOfdpt)
order by e.department_id;
                    

--20. Ŀ�̼�(commission_pct)�� �������� ��ȸ�Ͻÿ�. 
--    Ŀ�̼��� �Ʒ�������ó�� 0.2, 0.25�� ��� .2��, 0.3, 0.35�� .3 ���·� ��µǾ�� �Ѵ�. 
--    ��, Ŀ�̼� ������ ���� �����鵵 �ִ� �� Ŀ�̼��� ���� ���� �׷��� ��<Ŀ�̼� ����>���� ��µǰ� �Ѵ�.
select nvl(to_char(commission_pct),'<Ŀ�̼� ����>') as comm, count(*) as cnt
from employees
group by commission_pct;

--21. Ŀ�̼�(commission_pct)�� ���� ���� ���� ���� 4���� �μ���(department_name), 
--    ������ (first_name), �޿�(salary), Ŀ�̼�(commission_pct) ������ ��ȸ�Ͻÿ�. 
--    ��°���� Ŀ�̼� �� ���� �޴� ������ ����ϵ� ������ Ŀ�̼ǿ� ���ؼ��� �޿��� ���� ������ ���� ��� �ǰ� �Ѵ�.
select first_name, salary, commission_pct
from (select ROWNUM, first_name, salary, commission_pct 
        from (select * from employees order by nvl(commission_pct,0) desc, salary desc)
        )
    where ROWNUM < 5;

