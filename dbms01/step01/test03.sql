/* 주제 : primary key를 지정하는 다양한 방법
 */
-- 1) 컬럼 선언할 때 primary key를 지정한다.
create table test03(
	name	varchar(20) primary key,
	tel		varchar(20),
	age 	int
);

-- pk 지정 확인!
F

- name 컬럼 값이 같은 데이터를 다시 넣으려 하면 오류 발생!
insert into test03(name, tel, age) value('aaa', '111', 20);

-- test03 테이블 정보 확인 --> primary key 컬럼은 자동으로 null 값 불가로 설정된다.
desc test03;

-- 2) 컬럼 선언 후에 제약 조건으로 지정한다
create table test04(
	name	varchar(20),
	tel		varchar(20),
	age 	int,
	constraint test04_pk primary key (name)
);

-- 3) 테이블 생성 후에 테이블 변경 문법을 사용하여 PK 조건을 추가한다.
create table test05(
	name	varchar(20),
	tel		varchar(20),
	age 	int
);
alter table test05 add constraint test05_pk primary key (name)
