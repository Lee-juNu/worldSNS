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

ALTER TABLE alarmTbl RENAME COLUMN alam_recently TO alam_lastTime
ALTER TABLE alarmTbl MODIFY alam_recently not null;
create table alamReply_Tbl
(
	alamRp_Num 		varchar2(8 char) 	not null		, 
	alamRp_ReplyNum varchar2(10 char) 	not null 		,
	alamRp_regDate 	date								,
	CONSTRAINT alam_c_reply
			foreign key(alamRp_Num)
				references alarmTbl(alam_Num)
					on delete cascade,
			foreign key(alamRp_ReplyNum)
				references BoardTbl(Board_Num)
					on delete cascade
)



create table alamLike_Tbl
(
	alamLk_Num		varchar2(8 char) 	not null		, 
	alamLk_LikeNum	varchar2(10 char) 	not null 		,
	alamLk_regDate	date								,
	CONSTRAINT alam_c_like
			foreign key(alamLk_Num)
				references alarmTbl(alam_Num)
					on delete cascade,
			foreign key(alamLk_LikeNum)
				references BoardTbl(Board_Num)
					on delete cascade						
)

create table alamShare_Tbl
(
	alamShr_Num		varchar2(8 char) 	not null		, 
	alamShr_ShareNum	varchar2(10 char) 	not null 		,
	alamShr_regDate	date								,
	CONSTRAINT alam_c_share
			foreign key(alamShr_Num)
				references alarmTbl(alam_Num)
					on delete cascade,
			foreign key(alamShr_ShareNum)
				references ShareTbl(Share_Num)
					on delete cascade						
)
drop table alamAtTag_Tbl

create table alamAtTag_Tbl
(
	alamAtTag_Num		varchar2(8 char) 	not null		, 
	alamAtTag_BoardNum	varchar2(10 char) 	not null 		,
	alamAtTag_regDate	date								,
	
	CONSTRAINT alam_c_atTag
			foreign key(alamAtTag_Num)
				references alarmTbl(alam_Num)
					on delete cascade,
			foreign key(alamAtTag_BoardNum)
				references boardTbl(Board_Num)
					on delete cascade
)

