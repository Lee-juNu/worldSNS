drop table userTbl

create table userTbl
(
	user_id varchar(16 char) primary key,
	user_pw varchar(16 char) not null,
	user_nickName varchar(16 char) not null,
	user_phoneNum varchar(16 char) not null,
	user_name varchar(40 char) not null,
	user_email varchar(60 char) not null,
	user_country varchar2(20 char),
	user_city varchar2(20 char),
	user_birthDay date not null,
	user_level number(2) not null,
	user_regDate date not null
)

create table profileTbl
(
	
)


