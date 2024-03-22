-- 오라클의 한 줄 주석

/*
여러 줄 주석
아무 말 대잔치
*/

-- SELECT [컬럼명(여러개 가능)] FROM [테이블 이름]
SELECT
    * 
FROM 
    employees;
    
SELECT
    employee_id,
    first_name,
    last_name
FROM 
    employees;
    
SELECT
    email,
    phone_number,
    hire_date
FROM
    employees;
    
-- 컬럼을 조회하는 위치 에서 * / + - 연산이 가능
SELECT 
    employee_id,
    first_name,
    last_name,
    salary,
    salary + salary * 0.1 AS 성과금
FROM
    employees;
    
--NULL 값의 확인 (숫자 0이나 공백과는 다른 존재임)
SELECT 
    department_id,
    commission_pct
FROM
    employees;
    
-- alias(컬럼명, 테이블명의 이름을 변경해서 조회)    
SELECT
    first_name AS 이름,
    last_name AS 성,
    salary AS 급여
FROM 
    employees;

/*
오라클은  홑따옴표로 문자를 표현하고, 문자열 안에 홑따옴표 특수기호를
표현 하고 싶다면 '' 를 두번 연속으로 쓰면 된다
문자열 연결 기호는 || 이다. 문자열의 덧셈 연산을 허용하지 않는다. 
*/
SELECT
    first_name || ' ' || last_name || '''s salary is $' || salary AS 급여내역
FROM
    employees;

-- DISTINCT (중복 행의 제거)
SELECT DISTINCT
    department_id 
FROM
    employees;

-- ROWNUM, ROWID
-- (** 로우넘 : 쿼리에 의해 반환되는 행 번호를 반환)
-- (로우아이디 : 데이터베이스 내의 행의 주소를 반환)
SELECT ROWNUM, ROWID,
    employee_id
FROM 
    employees;
    
    




