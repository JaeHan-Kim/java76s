create table student (
	sno		int auto_increment,
	name 	varchar(10) not null,
	email	varchar(30) not null,
	tel 	varchar(15) not null,
	cid		varchar(20),
	constraint project_pk primary key (sno)
);

insert into project(name,email,tel,cid) values('aaaa','test1@test','111-1111','78');