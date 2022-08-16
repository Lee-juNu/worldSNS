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

alter table proFileTbl add unique(pf_userID)
create table proFileTbl
(
	pf_userID 			varchar2(16 char) 	not null,
	pf_Img 				varchar2(256 char)			,
	pf_bgImg 			varchar2(256 char)			,
	pf_contents 		varchar2(160 char)			,

		CONSTRAINT pf_c_user
			foreign key(pf_userID)
				references userTbl(user_id)
					on delete cascade
)


select * from  userTbl;
ss
	select * from messageTbl where msg_RoomNum = 'CR216' order by msg_sendTime
insert into userTbl values('yorunohosi','team802!@$','yorunohosi','01089854474','이준우','yorunohosi@naver.com',sysdate);