use arkham;

drop table if exists reply;
drop table if exists deck_card;
drop table if exists deck;
drop table if exists card;
drop table if exists investigator;
drop table if exists member;


create table member (
	idx bigint primary key auto_increment,
    id varchar(20) unique,
    password char(64) not null,
    admin boolean not null default false
);

create table card (
	id int primary key,
    title varchar(20) not null,
    subtitle varchar(30) null,
    orgImgPath varchar(20) not null,
    realImgPath char(20) not null,
    traits varchar(30),
    icons varchar(8),
    ability varchar(1000),
    plainText varchar(150),
    xp tinyint default 0,
    resourceCost tinyint unsigned default 0,
    deptId tinyint default 0
);

create table investigator (
	id int primary key,
    title varchar(20) not null,
    subtitle varchar(20) null,
    orgImgPath varchar(20) not null,
    realImgPath char(20) not null,
    traits varchar(30),
    stats char(6),
    ability varchar(1000),
    plainText varchar(150),
    xp tinyint default 0,
    deptId tinyint default 0
);

create table deck (
	id bigint primary key,
    title varchar(30) not null,
    writerId varchar(20) not null,
    investigatorId int not null,
    xp tinyint not null default 0
);

create table reply (
	idx bigint primary key auto_increment,
	deckId bigint,
    content varchar(300),
    writeTime timestamp default (current_timestamp())
);

create table deck_card (
	deckId bigint,
    cardId bigint,
    amount tinyint default 1,
    primary key (deckId, cardId)
);

insert into member
(id, password)
values
('admin', 'admin'),
('mtavares', 'marion'),
('mmcglen', 'michael'),
('acrane', 'agatha');

update member set
admin = true
where id = 'admin';

insert into card
(id, title, subtitle, orgImgPath, realImgPath,
traits, icons, ability, plainText, xp, resourceCost, deptId)
values
(901010, 'Motivational speech', null, 'sample.jpg', 'sample.jpg',
'spirit','wi',
'{"act":"Parley. Choose an investigator at your location. That investigator may play an Ally asset from their hand, reducing its cost by 3."}',
'"Think they bought it?"
"They certainly do not suspect the world is ending, Mr. Kane."',
0,0,1);

insert into investigator
(id, title, subtitle, orgImgPath, realImgPath,
traits, stats, ability, plainText, xp, deptId)
values
(901001, 'Roland Banks', 'The Fed', 'Roland Banks.jpg', 'Roland Banks.jpg',
'Agency,Detective', '334295',
'{"rea":"After you defeat an enemy: Discover 1 clue at your location. (Limit once per round.)","eld":"+1 for each clue on your location."}',
'Everything by the book: every "i" dotted, every "t" crossed. It has worked, until now.',
0,1);