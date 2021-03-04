-- 1、从employee中查询出，工资比经理高的员工姓名
-- 创建表
CREATE TABLE `employee` (
  `id` tinyint(3) unsigned DEFAULT NULL,
  `e_name` varchar(20) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `m_id` tinyint(3) unsigned DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
-- 插入记录
INSERT INTO `employee` (`id`, `e_name`, `salary`, `m_id`) VALUES ('1', 'Joe', '70000.00', '3');
INSERT INTO `employee` (`id`, `e_name`, `salary`, `m_id`) VALUES ('2', 'Henry', '80000.00', '4');
INSERT INTO `employee` (`id`, `e_name`, `salary`, `m_id`) VALUES ('3', 'Sam', '60000.00', NULL);
INSERT INTO `employee` (`id`, `e_name`, `salary`, `m_id`) VALUES ('4', 'Max', '90000.00', NULL);
-- test
SELECT t1.e_name
FROM employee t1
LEFT JOIN employee t2 ON t1.id=t2.m_id
WHERE t1.m_id IS NOT NULL AND t1.salary>t2.salary 
-- sql
SELECT em1.e_name
FROM(SELECT id,e_name,salary,m_id FROM employee_1 WHERE m_id IS NOT NULL) em1
INNER JOIN employee_1 em2 ON em1.m_id=em2.id
WHERE em1.salary>em2.salary
-- 
SELECT e1.e_name 
FROM employee_1 e1
INNER JOIN employee_1 e2 ON e1.m_id=e2.id
WHERE e1.salary>e2.salary


-- 2、Write a SQL query to find all duplicate emails in a table named Person.
-- 创建表
CREATE TABLE Person(
	Id TINYINT UNSIGNED,
	Email VARCHAR(20)
)ENGINE=MyISAM CHARSET=utf8;
-- 插入记录
INSERT Person VALUES(1,'a@b.com');
INSERT Person VALUES(2,'c@d.com');
INSERT Person VALUES(3,'a@b.com');
INSERT Person VALUES(4,'e@f.com');
INSERT Person VALUES(5,'c@d.com');
-- 查询sql
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(Email)>1


-- 3、Suppose that a website contains two tables, the Customers table and the Orders table. 
-- Write a SQL query to find all customers who never order anything.
-- 创建表
CREATE TABLE Customers(
	Id TINYINT UNSIGNED,
	Name VARCHAR(20)
)ENGINE=MyISAM CHARSET=utf8;
CREATE TABLE Orders(
	Id TINYINT UNSIGNED,
	CustomerId TINYINT UNSIGNED
)ENGINE=MyISAM CHARSET=utf8;
-- sql
-- NOT EXISTS 的作用与 EXISTS 正相反
SELECT t1.Name 
FROM Customers t1
WHERE NOT EXISTS(
	SELECT * FROM Orders t2 WHERE t2.CustomerId=t1.Id
) 



-- 4、Write a SQL query for a report that provides the following information for each person 
-- in the Person table,regardless if there is an address for each of those people
CREATE TABLE Person(
 PersonId  TINYINT UNSIGNED auto_increment PRIMARY KEY,     
 FirstName  varchar(20),
 LastName   varchar(20) 
)ENGINE=MyISAM CHARSET=utf8;
CREATE TABLE Address(
	AddressId  TINYINT UNSIGNED auto_increment PRIMARY KEY,
	PersonId   TINYINT UNSIGNED,
	City  VARCHAR(20),
	State  VARCHAR(20) 
)ENGINE=MyISAM CHARSET=utf8;
-- SQL
SELECT t1.FirstName,t1.LastName,t2.City,t2.State
FROM Person t1
LEFT JOIN Address t2 ON t1.PersonId=t2.PersonId 



-- 5、Write a SQL query to get the second highest salary from the Employee table.
-- If there is no second highest salary, then the query should return null.
SELECT MAX(t1.salary)
FROM employee t1,(
	SELECT MAX(salary) mx FROM employee
) t2
WHERE t1.salary<t2.mx



-- 6、Given a Weather table, write a SQL query to find all dates' Ids 
-- with higher temperature compared to its previous (yesterday's) dates.
-- 创建表
CREATE TABLE Weather(
	Id TINYINT UNSIGNED,
	Date date,
	Temperature TINYINT
)ENGINE=MyISAM CHARSET=utf8;
-- SQL
SELECT t1.Id
FROM Weather t1
WHERE t1.Temperature>(SELECT t2.Temperature 
											FROM Weather t2 
											WHERE t2.Date=ADDDATE(t1.Date,INTERVAL -1 DAY))


-- 7.Write a SQL query to delete all duplicate email entries in a table named Person, 
-- keeping only unique emails based on its smallest Id.
-- 备份记录
INSERT INTO `leetcode`.`persons` (`Id`, `Email`) VALUES ('1', 'a@b.com');
INSERT INTO `leetcode`.`persons` (`Id`, `Email`) VALUES ('2', 'c@d.com');
INSERT INTO `leetcode`.`persons` (`Id`, `Email`) VALUES ('3', 'a@b.com');
INSERT INTO `leetcode`.`persons` (`Id`, `Email`) VALUES ('4', 'e@f.com');
INSERT INTO `leetcode`.`persons` (`Id`, `Email`) VALUES ('5', 'c@d.com');
-- 使用现成的表
DELETE t1 FROM persons t1 LEFT JOIN(
	SELECT MIN(Id) Id,Email FROM Persons GROUP BY Email HAVING COUNT(Email)>1
)t2 ON t1.Email=t2.Email
WHERE t1.Id>t2.Id



-- 8、Write a SQL query to find employees who have the highest salary in each of the departments
-- 创建表
CREATE TABLE Employee(
	Id TINYINT UNSIGNED,
	Name VARCHAR(20),
	Salary DECIMAL(10,2),
	DepartmentId TINYINT
)ENGINE=MyISAM CHARSET=utf8;
CREATE TABLE Department(
	Id TINYINT UNSIGNED,
	Name VARCHAR(20) 
)ENGINE=MyISAM CHARSET=utf8;
-- test
SELECT t2.Name,t1.Name,MAX(t1.salary)
FROM employee t1
INNER JOIN department t2 ON t1.DepartmentId=t2.Id
GROUP BY t1.DepartmentId 
-- sql
SELECT b.nm,a.Name,a.salary
FROM employee a INNER JOIN (
	SELECT t2.Id,t2.Name nm,MAX(t1.salary) sal
	FROM employee t1 INNER JOIN department t2 ON t1.DepartmentId=t2.Id
	GROUP BY t1.DepartmentId 
)b ON a.salary=b.sal AND a.DepartmentId=b.Id




-- 10、Write a SQL query to get the nth highest salary from the Employee table.
-- 创建表
CREATE TABLE Employee(
	Id TINYINT UNSIGNED,
	Salary DECIMAL(10,2) 
)ENGINE=MyISAM CHARSET=utf8;
-- sql 使用 limit 和 ORDER BY
DROP FUNCTION IF EXISTS getNthHighestSalary;
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
	DECLARE m INT;
	SET m = n -1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT salary FROM employee ORDER BY salary DESC LIMIT m,1
  );
END
-- test
SELECT getNthHighestSalary(1) mx
SELECT getNthHighestSalary(2) mx
SELECT getNthHighestSalary(3) mx
SELECT getNthHighestSalary(4) mx


-- 178、Rank Scores
-- Write a SQL query to rank scores. If there is a tie between two scores, 
-- both should have the same ranking. Note that after a tie, the next ranking number 
-- should be the next consecutive integer value. In other words, there should be no "holes" 
-- between ranks.
-- 创建表
CREATE TABLE Scores(
	Id TINYINT UNSIGNED,
	Score DECIMAL(10,2)
)ENGINE=MyISAM;
-- test
SELECT t1.Score,1 AS 'Rank'
FROM Scores t1
ORDER BY t1.Score DESC
-- SQL 用户自定义变量
SELECT t1.Score,t1.Rank
FROM (
SELECT s.Score,@curRank:=@curRank+IF(@prevScore = s.Score, 0, 1) AS 'Rank',@prevScore:=s.Score
FROM Scores s,(SELECT @curRank:=0) c,(SELECT @prevScore:=NULL) p
ORDER BY s.Score DESC
) t1


-- 180. Consecutive Numbers
-- Write a SQL query to find all numbers that appear at least three times consecutively.
-- 创建表
CREATE TABLE Logs(
	Id TINYINT UNSIGNED,
	Num INT UNSIGNED
)ENGINE=MyISAM;
-- 思路和Rank Scores类似
-- 执行结果中的rank列将Num转化为从1开始递增的序号，但序号只在Num出现变化时增加，
-- 连续出现的相同数字序号也相同，只需要统计3次或以上的记录
SELECT DISTINCT t2.Num
FROM(
	SELECT t1.Num,t1.Rank
	FROM(
		SELECT l.Num,@curRank:=@curRank+IF(@prevValue=l.Num, 0, 1) 'Rank',@prevValue:=l.Num
		FROM Logs l,(SELECT @curRank:=0) c,(SELECT @prevValue:=NULL) p
	)t1
)t2
GROUP BY t2.Rank 
HAVING COUNT(t2.Rank)>=3


-- 185. Department Top Three Salaries
-- Write a SQL query to find employees who earn the top three salaries in each of the department.
-- For the above tables, your SQL query should return the following rows.
-- test
SELECT t2.Name dName,t1.Name eName,t1.Salary
FROM Employee t1,Department t2
WHERE (SELECT COUNT(t.Salary) FROM Employee t 
			WHERE t1.DepartmentId=t.DepartmentId AND t.Salary>t1.Salary)<3
	AND t1.DepartmentId=t2.Id
ORDER BY t1.DepartmentId,t1.Salary DESC

-- 有点难，没解出来，参考LeetCode上的答案
-- 解法一、
select D.Name as Department, E.Name as Employee, E.Salary as Salary 
from Employee E, Department D
 where (select count(distinct(Salary)) from Employee 
				 where DepartmentId = E.DepartmentId and Salary > E.Salary) in (0, 1, 2)
			 and 
				 E.DepartmentId = D.Id 
			 order by E.DepartmentId, E.Salary DESC;
-- 解法二、
-- 一、先查询出按 部门ID升序 工资降序 排列的数据
-- 二、把(一)查询出来的数据，再关联employee表
-- 三、再对每条工资进行统计，DISTINCT的作用是查询出并列的工资的员工
SELECT D.Name AS Department, E.Name AS Employee, E.Salary AS Salary 
FROM Employee E, Department D
WHERE 1=1 AND (SELECT COUNT(DISTINCT(Salary)) FROM Employee 
       WHERE DepartmentId = E.DepartmentId AND Salary > E.Salary) < 3
AND E.DepartmentId = D.Id 
ORDER BY E.DepartmentId, E.Salary DESC;




-- 262. Trips and Users
/*The Trips table holds all taxi trips. Each trip has a unique Id, 
while Client_Id and Driver_Id are both foreign keys to the Users_Id at the Users table. 
Status is an ENUM type of (‘completed’, ‘cancelled_by_driver’, ‘cancelled_by_client’).
The Users table holds all users. Each user has an unique Users_Id, and Role is an ENUM type of (‘client’, ‘driver’, ‘partner’).

Write a SQL query to find the cancellation rate of requests made by unbanned clients 
between Oct 1, 2013 and Oct 3, 2013. */
-- 创建表
create table Trips(
	Id tinyint unsigned auto_increment primary key,
	Client_Id tinyint unsigned ,
	Driver_Id tinyint unsigned ,
	City_Id tinyint unsigned,
	Status enum('completed', 'cancelled_by_driver', 'cancelled_by_client'),
	Request_at date,
	foreign key(Client_Id) references Users(Users_Id),
	foreign key(Driver_Id) references Users(Users_Id)
)ENGINE=MyISAM;
create table Users(
	Users_Id tinyint unsigned auto_increment primary key,
	Banned varchar(10),
	Role enum('client', 'driver', 'partner')
)ENGINE=MyISAM;
-- 插入数据
INSERT Trips(Id,Client_Id,Driver_Id,City_Id,Status,Request_at)
VALUES(1,1,10,1 ,'completed','2013-10-01'),
( 2 ,2,11,1 ,'cancelled_by_driver','2013-10-01'),
(3 ,3,12,6 ,'completed','2013-10-01'),
( 4 ,4,13,6 ,'cancelled_by_client','2013-10-01'),
( 5 ,1,10,1 ,'completed','2013-10-02'),
( 6 ,2,11,6 ,'completed','2013-10-02'),
( 7 ,3,12,6 ,'completed','2013-10-02'),
( 8 ,2,12,12,'completed','2013-10-03'),
( 9 ,3,10,12,'completed','2013-10-03'),
( 10,4,13,12,'cancelled_by_driver','2013-10-03')
-- Write a SQL query to find the cancellation rate of requests made by unbanned clients 
-- between Oct 1, 2013 and Oct 3, 2013.
-- 查询 由未绑定的客户端发起的已经取消的订单的占比
SELECT t1.Request_at AS 'Day',COUNT(*)
FROM Trips t1
LEFT JOIN Users t2 ON t2.Users_Id=t1.Client_Id
WHERE t2.Role='client' AND t2.Banned='No' AND t1.Status LIKE 'cancelled%'
GROUP BY t1.Request_at

-- SQL
SELECT a.dt AS 'Day',IF(b.cnt/a.total IS NULL,0.00,ROUND(b.cnt/a.total,2)) AS 'Cancellation Rate'
FROM (
	SELECT t1.Request_at AS dt,COUNT(*) AS total
	FROM Trips t1 LEFT JOIN Users t2 ON t2.Users_Id=t1.Client_Id
	WHERE t2.Role='client' AND t2.Banned='No' AND t1.Request_at BETWEEN '2013-10-01' AND '2013-10-03'
	GROUP BY Request_at
) a LEFT JOIN(
	SELECT t1.Request_at AS dt,COUNT(*) AS cnt
	FROM Trips t1
	LEFT JOIN Users t2 ON t2.Users_Id=t1.Client_Id
	WHERE t2.Role='client' AND t2.Banned='No' AND t1.Status LIKE 'cancelled%'
			AND t1.Request_at BETWEEN '2013-10-01' AND '2013-10-03'
	GROUP BY t1.Request_at
) b ON a.dt=b.dt


-- 统计每天的订单总量
SELECT Request_at dt,COUNT(*) total
FROM Trips t1 LEFT JOIN Users t2 ON t2.Users_Id=t1.Client_Id
WHERE t2.Role='client' AND t2.Banned='No'
GROUP BY Request_at



































































