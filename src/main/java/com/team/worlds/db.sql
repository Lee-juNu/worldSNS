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
 
 select user_nickName, boardTbl.* from USERTBL, boardTbl  where board_userId in (
	select Flw_toId from followTbl where Flw_FromId = 'admin'
) and user_id = board_userId or board_userId = 'admin'and user_Id = 'admin'  
order by  board_regdate desc


select * from alarmTbl

create sequence alarm_seq
create sequence like_seq

ALTER TABLE boardtbl ADD likeCount number(10) DEFAULT 0;

select * from boardtbl where board_num = 485
select * from likeTbl where like_boardNum = 485
UPDATE boardTbl
   		SET likeCount  = (SELECT Count(like_BoardNum) FROM liketbl WHERE #{like_BoardNum} = like_boardNum)
   		where board_num = '485';
select * from alarmtbl 
select * from alamLikeTbl
select * from boardtbl
insert into 
	like_Num 			varchar2(10 char) primary key	,
	like_SenderID 		varchar2(16 char) not null		,
	like_ReceiverID 	varchar2(16 char) not null		,
	like_BoardNum 		varchar2(10 char) not null		,

	delete alarmTbl
	select * from liketbl
select * from alarmTbl
select * from alamLikeTbl

 drop table alamLikeTbl 
 
 
create table alamLikeTbl(
	almDetail_Num 			varchar2(10 char) 	primary key	, 
	almDetail_LinkNum 		varchar2(16 char) 	not null	,
	
		CONSTRAINT al_c
			foreign key(almDetail_Num)
				references alarmTbl(alam_Num)
					on delete cascade,
			foreign key(almDetail_LinkNum)
				references likeTbl(like_Num)
					on delete cascade
);
insert into LIKETBL values(like_seq.nextval,'admin','yorunohosi',4)
select alarm_seq.currval from dual;
delete alarmTbl 
select * from alarmTbl 
insert into alarmTbl values(41,'yorunohosi','like',sysdate );
insert into alamLikeTbl values('41','1' );


delete LIKETBL

	select 
	(select Count(*) from liketbl where like_BoardNum = 22 and like_SenderID = 'yorunohosi') as isLike
	, (select Count(like_BoardNum) from liketbl where like_BoardNum = 22) as likeCount
	from likeTbl where like_BoardNum = 22 
	
	 select user_nickName, boardTbl.*,like_BoardNum
	 	from USERTBL,boardTbl,liketbl
	 		where board_userId in 
	 		(select Flw_toId from followTbl,USERTBL where Flw_FromId = 'admin' or user_id = 'admin')
	 		and user_id = board_userId and like_BoardNum(+) = board_num
			order by  board_regdate desc
select user_nickName, boardTbl.*,like_BoardNum
	 	from USERTBL,boardTbl,liketbl
	 		where board_userId = 'admin'
	 		and user_id = board_userId and like_BoardNum(+) = board_num and board_num = 263
			order by  board_regdate desc
			
			UPDATE boardTbl
   SET likeCount  = (SELECT Count(like_BoardNum) FROM liketbl WHERE 201 = like_boardNum)
   where board_num = 201
 WHERE a.job = 'ANALYST'
	
	select * from LIKETBL where like_BoardNum = 22 

	select * from LIKETBL
	
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
insert into regionTbl values ('North Chungcheong', 'KR');
insert into regionTbl values ('South Chungcheong', 'KR');
insert into regionTbl values ('Incheon', 'KR');
insert into regionTbl values ('Gyeonggi', 'KR');
insert into regionTbl values ('North Jeolla', 'KR');
insert into regionTbl values ('South Jeolla', 'KR');
insert into regionTbl values ('Daejeon', 'KR');
insert into regionTbl values ('Daegu', 'KR');
insert into regionTbl values ('South Gyeongsang', 'KR');
insert into regionTbl values ('North Gyeongsang', 'KR');
insert into regionTbl values ('Busan', 'KR');
insert into regionTbl values ('Ulsan', 'KR');
insert into regionTbl values ('Jeju', 'KR');
insert into regionTbl values ('Sejong', 'KR');
insert into regionTbl values ('Sejong', 'KR');
insert into regionTbl values ('Gangwon', 'KR');
insert into regionTbl values ('Gwangju', 'KR');

select * from regionTbl where region_country = 'JP'
insert into regionTbl values ('Osaka', 'JP')
insert into regionTbl values ('Tokyo', 'JP')



insert into regionTbl values ('Hiroshima', 'JP');
insert into regionTbl values ('Okayama', 'JP');
insert into regionTbl values ('Shimane', 'JP');
insert into regionTbl values ('Tottori', 'JP');
insert into regionTbl values ('Yamaguchi', 'JP');
insert into regionTbl values ('Saga', 'JP');
insert into regionTbl values ('Fukuoka', 'JP');
insert into regionTbl values ('Kumamoto', 'JP');
insert into regionTbl values ('Miyazaki', 'JP');
insert into regionTbl values ('Ehime', 'JP');
insert into regionTbl values ('Kagawa', 'JP');
insert into regionTbl values ('Kochi', 'JP');
insert into regionTbl values ('Oita', 'JP');
insert into regionTbl values ('Tokushima', 'JP');
insert into regionTbl values ('Aichi', 'JP');
insert into regionTbl values ('Gifu', 'JP');
insert into regionTbl values ('Ishikawa', 'JP');
insert into regionTbl values ('Mie', 'JP');
insert into regionTbl values ('Nagano', 'JP');
insert into regionTbl values ('Shizuoka', 'JP');
insert into regionTbl values ('Toyama', 'JP');
insert into regionTbl values ('Hokkaido', 'JP');
insert into regionTbl values ('Fukui', 'JP');
insert into regionTbl values ('Hyōgo', 'JP');
insert into regionTbl values ('Kyoto', 'JP');
insert into regionTbl values ('Nara', 'JP');
insert into regionTbl values ('Shiga', 'JP');
insert into regionTbl values ('Wakayama', 'JP');
insert into regionTbl values ('Chiba', 'JP');
insert into regionTbl values ('Ibaraki', 'JP');
insert into regionTbl values ('Kanagawa', 'JP');
insert into regionTbl values ('Saitama', 'JP');
insert into regionTbl values ('Tochigi', 'JP');
insert into regionTbl values ('Yamanashi', 'JP');
insert into regionTbl values ('Akita', 'JP');
insert into regionTbl values ('Aomori', 'JP');
insert into regionTbl values ('Fukushima', 'JP');
insert into regionTbl values ('Iwate', 'JP');
insert into regionTbl values ('Miyagi', 'JP');
insert into regionTbl values ('Niigata', 'JP');
insert into regionTbl values ('Yamagata', 'JP');
insert into regionTbl values ('Nagasaki', 'JP');
insert into regionTbl values ('Kagoshima', 'JP');
insert into regionTbl values ('Okinawa', 'JP');
insert into regionTbl values ('Gunma', 'JP');

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

select user_nickName, boardTbl.*,like_BoardNum
	 	from USERTBL,boardTbl,liketbl
	 		where board_userId in 
	 		(select Flw_toId from followTbl,USERTBL where Flw_FromId = 'admin' or user_id = 'admin')
	 		and user_id = board_userId and like_SenderID(+)= 'admin' and like_BoardNum(+) = board_num and Board_City = 'Kyoto'
			order by  board_regdate desc

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