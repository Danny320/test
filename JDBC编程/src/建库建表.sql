create database luodan;

use luodan;

create table student (
     id int,
     sn int comment '学号',
     name varchar (20) comment '姓名',
     qq_mail varchar (20) comment 'qq邮箱'

);

insert into student value (100,10000,'唐三藏','111111');
insert into student value (101,10001,'孙悟空','111112');
insert into student (id, sn, name, qq_mail)  value
(102,10002,'曹孟德','111113'),
(103,10003,'猪悟能','111114'),
(104,10004,'刘玄德','111115'),
(105,10005,'曹孟德','111116'),
(106,10006,'孙权','111117'),
(107,10007,'宋公明','111118'),
(108,10008,'孙仲谋','111119');

create table exam_result (
     id int,
     name varchar (20),
     chinese decimal (3,1),
     math decimal (3,1),
     english decimal (3,1)
);

insert into exam_result(id, name, chinese, math, english) value
(1,'唐三藏', 67, 98, 56),
 (2,'孙悟空', 87.5, 78, 77),
 (3,'猪悟能', 88, 98.5, 90),
 (4,'曹孟德', 82, 84, 67),
 (5,'刘玄德', 55.5, 85, 45),
 (6,'孙权', 70, 73, 78.5),
 (7,'宋公明',75,65,30);


 delete * from exam_result where name = ('唐三藏','孙悟空',
 '猪悟能','曹孟德','刘玄德','孙权');