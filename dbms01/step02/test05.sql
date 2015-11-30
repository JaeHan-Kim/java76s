/* 주제 : 자동 증가 컬럼 설정
 * => 자동 증가 걸럼 
 * => 비록 PK는 아니지만 PK처럼 중복되어서는 안되는 컬럼을 설정하는 방법
 * => unique 옵션!
 */

-- 1) 테이블 정의1
create table test14 ( 
	no	 	int primary key auto_increment,
	email varchar(100) not null unique,	
	name  varchar(20) not null default '홍길동',
	age   int default 20,
	tel   varchar(20) unique
);


insert into test14(email) values ('aaa@test.com');
insert into test14(email) values ('bbb@test.com');

-- 1) 테이블 정의1
create table test15 ( 
	no	 	int,
	email varchar(100) not null,	
	name  varchar(20) not null default '홍길동',
	age   int default 20,
	tel   varchar(20) unique
);
alter table test15
	add constraint test15_pk primary key(no);
alter table test15
	add constraint test15_uq1 unique(email);
alter table test15
	add constraint test15_uq2 unique(tel);
alter table test15
	modify column no int auto_increment;
	
	insert into test15(email) values ('aaa@test.com');
	insert into test15(email) values ('bbb@test.com');
	insert into test15(email) values ('ccc@test.com');

	
	