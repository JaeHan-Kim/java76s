create table library(
no int auto_increment,
title varchar(100) not null,
authors	varchar(40) not null,
press varchar(40) not null,
tag	varchar(50),
lent	bool default true,
constraint library_pk primary key (no)
);

select no,title,left(authors,3) as authors.press,tag from library;
insert into library(title,authors,press,tag) values('aaaa','aaa,aaa,sss','바른','zzz');


SUBSTRING_INDEX('www.mysql.com', '.', 2)
TRIM(LEADING 'x' FROM 'xxxbarxxx')
select no,title,SUBSTRING_INDEX(authors,',',1) as authors,press,tag from library;