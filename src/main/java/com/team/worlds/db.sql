
테이블 이름
UserTbl
proFileTbl
FollowTbl
alarmTbl
ChatRoomTbl
RoomMemberTbl
messageTbl
ShareTbl
likeTbl
BoardTbl

/*-------------------*/
/*-------------------*/
/*-----User Table----*/
/*-------------------*/
/*-------------------*/
drop table userTbl CASCADE CONSTRAINTS
create table UserTbl 
(
user_ID varchar2(16 char) primary key,
user_PW varchar2(16 char) not null,
user_nickName varchar2(8 char) not null,
user_phoneNumber varchar2(16 char) unique not null,
user_name varchar2(40 char) not null,
user_email varchar2(60 char) not null,
user_country varchar2(50 char),
user_city varchar2(40 char),
user_birthDay date not null,
user_level number(2) not null,
user_regDate date not null
)


insert into userTbl values('yorunohosi','0624','yorurun','01089854474','이준우','yorunohosi@naver.com'
,'Republic of Korea', 'korea', '1996-06-24',99,sysdate);

select * from UserTbl
delete userTbl where user_id='yanagi'



/*-------------------*/
/*-------------------*/
/*---Profile Table---*/
/*-------------------*/
/*-------------------*/


drop table proFileTbl
create table proFileTbl
(
pf_userID varchar2(16 char) not null,
pf_Img varchar2(256 char),
pf_bgImg varchar2(256 char),
pf_contents varchar2(160 char),
CONSTRAINT pf_c_user
foreign key(pf_userID)
    references userTbl(user_id)
    on delete cascade
)


insert into proFileTbl values('yorunohosi',null,null,null)
select * from profileTbl



/*-------------------*/
/*-------------------*/
/*---Follow Table----*/
/*-------------------*/
/*-------------------*/

drop table FollowTbl
create table FollowTbl
(
Flw_num varchar2(10 char) primary key,
Flw_FromId varchar2(16 char) not null,
Flw_ToId varchar2(16 char) not null,
Flw_time date not null,
CONSTRAINT flw_c_user
foreign key(Flw_FromId)
    references userTbl(user_id)
    on delete cascade,
foreign key(Flw_ToId)
    references userTbl(user_id)
    on delete cascade
)

create sequence Follow_Seq
insert into FollowTbl values ('FW'||Follow_Seq.nextval,'yorunohosi','yanagi',sysdate)
select * from FollowTbl 

/*-------------------*/
/*-------------------*/
/*----alarm Table----*/
/*-------------------*/
/*-------------------*/

create alarmTbl
(
	alm_Num varchar2(10 char) primary key
	alm_senderId varchar2(16 char) not null,
	alm_ReceiverId varchar2(16 char) not null,
	alm_time date,
	alm_Type varchar2(8 char),
	alm_Msg varchar2(10 char),
	CONSTRAINT flw_c_user
	foreign key(Flw_FromId)
    	references userTbl(user_id)
    	on delete cascade,
	foreign key(Flw_ToId)
    	references userTbl(user_id)
    	on delete cascade
)



/*-------------------*/
/*-------------------*/
/*----Board Table----*/
/*-------------------*/
/*-------------------*/

drop table BoardTbl CASCADE CONSTRAINTS
create table BoardTbl(
Board_Num varchar2(10 char) primary key,
Board_ParentNum varchar2(10 char),
Board_userID varchar2(16 char) not null,
Board_img1 varchar2(256 char),
Board_img2 varchar2(256 char),
Board_img3 varchar2(256 char),
Board_img4 varchar2(256 char),
Board_Contents varchar2(400 char),
Board_Country varchar2(50 char) not null,
Board_City varchar2(40 char) not null,
CONSTRAINT board_c_user
foreign key(Board_userID)
    references userTbl(user_id)
    on delete cascade,
    foreign key(Board_ParentNum)
    references BoardTbl(Board_Num)
    on delete cascade
)


/*-------------------*/
/*-------------------*/
/*-----Like Table----*/
/*-------------------*/
/*-------------------*/


drop table likeTbl
create table likeTbl(
like_Num varchar2(10 char) primary key,
like_SenderID varchar2(16 char) not null,
like_ReceiverID varchar2(16 char) not null,
like_BoardNum varchar2(10 char) not null,
	CONSTRAINT like_c_user
	foreign key(like_SenderID)
    	references userTbl(user_id)
    	on delete cascade,
	foreign key(like_ReceiverID)
    	references userTbl(user_id)
    	on delete cascade,
	foreign key(like_BoardNum)
    	references BoardTbl(Board_Num)
    	on delete cascade
)


/*-------------------*/
/*-------------------*/
/*----Share Table----*/
/*-------------------*/
/*-------------------*/

drop table ShareTbl

create table ShareTbl(
Share_Num varchar2(10 char) primary key,
Share_SenderID varchar2(16 char) not null,
Share_ReceiverID varchar2(16 char) not null,
Share_BoardNum varchar2(10 char) not null,
	CONSTRAINT share_c_user
	foreign key(Share_SenderID)
    	references userTbl(user_id)
    	on delete cascade,
	foreign key(Share_ReceiverID)
    	references userTbl(user_id)
    	on delete cascade,
	foreign key(Share_BoardNum)
    	references BoardTbl(Board_Num)
    	on delete cascade
)


select * from ChatRoomTbl 
drop table ChatRoomTbl cascade CONSTRAINTS
create table ChatRoomTbl(
cr_Num varchar2(10 char) primary key, 
cr_ownerID varchar2(16 char) not null,
cr_date date not null,
CONSTRAINT cr_c_id
foreign key(cr_ownerID)
    references userTbl(user_id)
    on delete cascade
);

create sequence ChatRoom_Seq;
select * from ChatRoomTbl



drop table RoomMemberTbl cascade constraint
create table RoomMemberTbl
(
	rm_roomNum varchar2(10 char) not null,
	rm_userID varchar2(16 char) not null,
	rm_lastIndex number(10) not null,
	CONSTRAINT rm_c_id
	foreign key(rm_roomNum)
    references ChatRoomTbl(cr_Num)
    on delete cascade,
		foreign key(rm_userID)
    references userTbl(user_id)
    on delete cascade
)



drop table messageTbl cascade constraint

create table messageTbl
(
	msg_Num varchar2(16 char) primary key,
	msg_RoomNum varchar2(10 char) not null,
	msg_sendUserID varchar2(16 char) not null,
	msg_receiverUserID varchar2(16 char) not null,
	msg_sendTime date not null,
	msg_index number(10) not null,
	msg_img varchar2(256 char),
	msg_Contents varchar2(400 char),
	CONSTRAINT msg_c_id
	foreign key(msg_RoomNum)
    references ChatRoomTbl(cr_Num)
    on delete cascade,
		foreign key(msg_sendUserID)
    references userTbl(user_id)
    on delete cascade,
		foreign key(msg_receiverUserID)
    references userTbl(user_id)
    on delete cascade
)


