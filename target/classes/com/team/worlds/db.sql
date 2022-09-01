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
	select rm_lastindex from ROOMMEMBERTBL where rm_userid = 'admin'
	select * from chatroomTbl
select rm_roomnum from RoomMemberTbl where rm_userid like '%9%'
	select * from chatroomTbl where cr_num in (select rm_roomnum from RoomMemberTbl where rm_userid like '%5%') 
insert into messageTbl values('0', 'CR216', 'admin', sysdate, '0', 'cont', 'cont')	
insert into userTbl values('yorunohosi','team802!@$','yorunohosi','01089854474','이준우','yorunohosi@naver.com',sysdate);

select max(msg_index) from messageTbl where msg_roomnum ='CR477'
select msg_index from MESSAGETBL where msg_index =(
select distinct msg_roomnum, msg_index from MESSAGETBL where msg_index = (
select msg_index, msg_roomnum from MESSAGETBL where msg_roomnum in (select distinct msg_roomnum from MESSAGETBL)
	
select max(msg_index) from MESSAGETBL group by msg_roomnum
select rm_lastindex from RoomMemberTbl where rm_userid = 'admin' 
select msg_roomnum, msg_index from MESSAGETBL


select max(msg_index) from messageTbl where msg_roomnum in (select rm_roomNum from roomMemberTbl where rm_roomNum='CR455' )