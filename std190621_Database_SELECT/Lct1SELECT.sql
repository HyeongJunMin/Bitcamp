--conn to hr

select first_name, salary
    , rank()over(order by salary desc) as rank
    , dense_rank()over(order by salary desc) as dense_rank
    , row_number()over(order by salary desc) as row_num
from employees;

select ROWNUM, employee_id, first_name, salary
from employees
where ROWNUM <= 10;

select ROWNUM, employee_id, first_name, salary
from employees
where ROWNUM between 11 and 20;
--�䷸���ϸ� �ȵ�. 

select RNUM, employee_id
from (select ROWNUM AS RNUM,    -- 2.ROWNUM �ϼ�
        employee_id, first_name, salary
        from( select employee_id, first_name, salary    -- 1.DATA�� ����
                from employees)
        )
    where RNUM > 10 AND RNUM <= 20;     -- 3.������ ����