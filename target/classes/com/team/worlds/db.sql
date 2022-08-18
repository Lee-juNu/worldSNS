drop table alarmTbl cascade constraints; ;
create table alarmTbl
(
	alam_Num varchar2(10 char) primary key	,
	alam_ReceiverID varchar2(16 char)		  	,
	alam_type varchar2(8 char) not null		,
	alam_lastTime date			not null,
		CONSTRAINT alam_c_main
			foreign key(alam_ReceiverID)
				references userTbl(user_ID)
					on delete cascade
)
ALTER TABLE alamReply_Tbl RENAME COLUMN alamRp_Num 		TO almDetail_Num;
ALTER TABLE alamReply_Tbl RENAME COLUMN alamRp_ReplyNum TO almDetail_LinkNum;
ALTER TABLE alamReply_Tbl RENAME COLUMN alamRp_regDate 	TO alamRp_regDate;



drop table alamReply_Tbl
create table alamReplyTbl
(
	almDetail_Num 		varchar2(8 char) 	not null		, 
	almDetail_LinkNum 	varchar2(10 char) 	not null 		,
	almDetail_regDate 	date								,
	CONSTRAINT alam_c_reply
			foreign key(almDetail_Num)
				references alarmTbl(alam_Num)
					on delete cascade,
			foreign key(almDetail_LinkNum)
				references BoardTbl(Board_Num)
					on delete cascade
)




create table alamLikeTbl
(
	almDetail_Num		varchar2(8 char) 	not null		, 
	almDetail_LinkNum	varchar2(10 char) 	not null 		,
	almDetail_regDate	date								,
	CONSTRAINT alam_c_like
			foreign key(almDetail_Num)
				references alarmTbl(alam_Num)
					on delete cascade,
			foreign key(almDetail_LinkNum)
				references BoardTbl(Board_Num)
					on delete cascade						
)


drop table alamShare_Tbl
select * from alamShareTbl
create table alamShareTbl
(
	almDetail_Num		varchar2(8 char) 	not null		, 
	almDetail_LinkNum	varchar2(10 char) 	not null 		,
	almDetail_regDate	date								,
	CONSTRAINT alam_c_share
			foreign key(almDetail_Num)
				references alarmTbl(alam_Num)
					on delete cascade,
			foreign key(almDetail_LinkNum)
				references ShareTbl(Share_Num)
					on delete cascade						
)
drop table alamAtTag_Tbl

create table alamAtTagTbl
(
	almDetail_Num		varchar2(8 char) 	not null		, 
	almDetail_LinkNum	varchar2(10 char) 	not null 		,
	almDetail_regDate	date								,
	
	CONSTRAINT alam_c_atTag
			foreign key(almDetail_Num)
				references alarmTbl(alam_Num)
					on delete cascade,
			foreign key(almDetail_LinkNum)
				references boardTbl(Board_Num)
					on delete cascade
)









