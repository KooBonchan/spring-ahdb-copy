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
    subtitle varchar(20) null,
    org_img_path varchar(20) not null,
    real_img_path char(20) not null,
    traits varchar(30),
    ability varchar(30),
    plain_text varchar(50),
    xp tinyint default 0,
    class tinyint default 0
);

create table investigator (
	id int primary key,
    title varchar(20) not null,
    subtitle varchar(20) null,
    org_img_path varchar(20) not null,
    real_img_path char(20) not null,
    traits varchar(30),
    ability varchar(30),
    plain_text varchar(50),
    xp tinyint default 0,
    class tinyint default 0
);

create table deck (
	id bigint primary key,
    title varchar(30) not null,
    writer_id varchar(20) not null,
    investigator_id int not null,
    xp tinyint not null default 0
);

create table reply (
	idx bigint primary key auto_increment,
	deck_id bigint,
    content varchar(300),
    write_time timestamp default (current_timestamp())
);

create table deck_card (
	deck_id bigint,
    card_id bigint,
    amount tinyint default 1,
    primary key (deck_id, card_id)
);