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

select * from chatroomTbl
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
	select * from messageTbl where msg_RoomNum = 'CR215' order by msg_sendTime
	select * from RoomMemberTbl
	select * from messageTbl
	select * from chatroomTbl
select rm_roomnum from RoomMemberTbl where rm_userid = '5'
	select * from chatroomTbl where cr_num= (select rm_roomnum from RoomMemberTbl where rm_userid like like '%5%') 
	delete from chatroomTbl
	delete from MESSAGETBL
insert into messageTbl values('0', 'CR216', 'admin', sysdate, '0', 'cont', 'cont')	
insert into userTbl values('yorunohosi','team802!@$','yorunohosi','01089854474','이준우','yorunohosi@naver.com',sysdate);