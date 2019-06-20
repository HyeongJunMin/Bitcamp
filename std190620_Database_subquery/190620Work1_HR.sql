--conn to hr
--subquery work1

--����1) EMPLOYEES ���̺��� Kochhar�� �޿����� ���� ����� ������ �����ȣ,�̸�,������,�޿��� ����϶�.
select employee_id, first_name, job_id, salary
from employees
where salary > (select salary from employees where last_name = 'Kochhar');

--����2) EMPLOYEES ���̺��� �޿��� ��պ��� ���� ����� ������ �����ȣ,�̸�,������,�޿�,�μ���ȣ�� ����Ͽ���.
select employee_id, first_name, job_id, salary, department_id
from employees
where salary < (select avg(salary) from employees)
order by salary desc;

--����3) EMPLOYEES ���̺��� 100�� �μ��� �ּ� �޿����� �ּ� �޿��� ���� �ٸ� ��� �μ��� ����϶�
select department_id, min(salary) as av
from employees
where salary > (select min(salary) from employees where department_id =100)
group by department_id;

--����4) �������� �ּ� �޿��� �޴� ����� ������ �����ȣ,�̸�,����,�μ���ȣ�� ����Ͽ���. �� �������� �����Ͽ���.
select employee_id, first_name, job_id, salary, department_id
from employees
where (salary, job_id) in (select min(salary), job_id from employees group by job_id)
order by job_id;

--����5) EMPLOYEES �� DEPARTMENTS ���̺��� ������ SA_MAN ����� ������ �̸�,����,�μ���,�ٹ����� ����϶�.
select first_name, job_id, d.department_name, d.location_id
from employees e , departments d
where e.job_id = 'SA_MAN' and e.department_id = d.department_id;

--����6) EMPLOYEES ?���̺���?����?����?�����?����?MANAGER��?�����ȣ��?����϶�.
select manager_id
from EMPLOYEES
group by manager_id
having count(manager_id) = (select max(count(*)) from employees group by manager_id);

--����7) EMPLOYEES ?���̺���?����?����?�����?�����ִ�?�μ���ȣ��?�������?����϶�.
select department_id, count(*)
from employees
group by department_id
having count(department_id) = (select max(count(*)) from employees group by department_id);

--����8) EMPLOYEES ?���̺���?�����ȣ��?123��?�����?������?����?�����ȣ��?192��?�����?�޿�(SAL)����?
--�޿��� ����?�����?�����ȣ,?�̸�,?����,?�޿���?����϶�.
select employee_id, first_name, job_id, salary
from employees
where employee_id = 123 and salary > (select salary from employees where employee_id = 192);

--����9) ? ����(JOB)����?�ּ�?�޿���?�޴�?�����?������?�����ȣ,?�̸�,?����,?�μ�����?����϶�.
--����1 :?��������?��������?����
select employee_id, first_name, job_id, e.department_id, d.department_name
from employees e, departments d
where (job_id, salary) in ( select job_id, min(salary) from employees group by job_id)
    and e.department_id = d.department_id
order by job_id desc;

--����10) EMPLOYEES ���̺��� 50�� �μ��� �ּ� �޿��� �޴� ��� ���� ���� �޿��� �޴� ����� ������ 
--�����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ�� ����϶�. �� 50���� ����
select employee_id, first_name, job_id, hire_date, salary, department_id
from employees
where salary > (select min(salary) from employees where department_id=50)
    and department_id <> 50;

--����11) EMPLOYEES ���̺��� 50�� �μ��� �ְ� �޿��� �޴� ��� ���� ���� �޿��� �޴� ����� ������ 
--�����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ�� ����϶�. ��50���� ����
select employee_id, first_name, job_id, hire_date, salary, department_id
from employees
where salary > (select max(salary) from employees where department_id=50)
    and department_id <> 50;