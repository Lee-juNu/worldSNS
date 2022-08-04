create table userTbl
(
	user_id varchar(16 char) primary key,
	user_pw varchar(16 char) not null,
	user_nickName varchar(16 char) not null,
	user_phoneNum varchar(16 char) not null,
	user_name varchar(40 char) not null,
	user_email varchar(60 char) not null,
	user_regDate date not null
)


select * from  userTbl;

insert into userTbl values('yorunohosi','team802!@$','yorunohosi','01089854474','이준우','yorunohosi@naver.com',sysdate);