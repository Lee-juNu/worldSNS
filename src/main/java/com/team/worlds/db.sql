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
select * from profileTbl
 alter table userTbl add user_contents varchar2(160 char);

 update userTbl set user_contents = 'japan oosaka like' where user_id = 'yorunohosi'
 

 select * from BOARDTBL

 select * from usertbl

 
select * from followTbl
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'userTbl';
select * from profileTbl where pf_userID = 'sadfds321'

select * from userTbl where user_id = 'yorunohosi'
insert into profileTbl values ('admin', null, null, null)
select * from profileTbl where pf_userID = 'admin'
select * from profileTbl where pf_userID = 'admin'
delete userTbl where user_id ='worldIs'
delete profileTbl where pf_userID ='worldIs'
create table countryTbl
(
	country_Num  Num(3) primary key,
	country_Name varchar2(60 char) not null
)


create sequence board_seq

select * from boardTbl

drop table countryTbl
create table countryTbl
(
	country_id	varchar2(2 char) primary key,
	country_Name varchar2(60 char) not null
)


select * from BoardTbl 
 alter table BoardTbl add board_regDate date not null;

create table regionTbl
(
	region_Name		varchar2(60 char) primary key,
	region_country 	varchar2(60 char) not null,
		CONSTRAINT region_c_country
			foreign key(region_country)
				references countryTbl(country_id)
					on delete cascade
)

insert into countryTbl values ('KR','Republic of Korea')
insert into countryTbl values ('JP','Japan')


delete regionTbl
insert into regionTbl values ('Seoul', 'KR')
insert into regionTbl values ('Osaka', 'JP')
insert into regionTbl values ('Tokyo', 'JP')

select * from countryTbl;

SELECT *
FROM 
 (
select ROWNUM rm, user_nickName, boardTbl.* from USERTBL, boardTbl  where board_userId in (
	select Flw_toId from followTbl where Flw_FromId = 'admin'
) and user_id = board_userId or board_userId = 'admin' and user_id = board_userId
order by  board_regdate desc
)
where rm  between 3 and 6

인피니트 스크롤




select userTbl.*,followTbl.Flw_FromId,followTbl.Flw_ToId from userTbl ,followTbl 
where userTbl.user_id = 'admin'

select userTbl.*,followTbl.Flw_FromId,followTbl.Flw_ToId from userTbl ,followTbl 
where userTbl.user_id = followTbl.Flw_FromId

select * from followTbl
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
select * from roomMemberTbl

update roomMemberTbl
set rm_lastIndex=(select max(msg_index) from messageTbl where MSG_roomnum ='CR456')
        where
        rm_roomNum= 'CR456' and rm_userID='admin'

select max(msg_index) from messageTbl where msg_roomnum ='CR456'

select * from chatroomTbl

select * from messageTbl


select * from boardTbl
(#{board_num},#{board_parentNum},#{board_userid},#{board_img1},#{board_img2},#{board_img3},#{board_img4},#{board_contents},#{board_city})
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