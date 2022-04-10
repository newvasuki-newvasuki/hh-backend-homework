create table area
(
	id bigint not null
		constraint area_pk
			primary key,
	name varchar(64)
);


create table employer
(
	id bigint not null
		constraint employer_pk
			primary key,
	comment varchar(1024),
	name varchar(256),
	description text,
	date_create timestamp not null,
	area_id bigint not null
		constraint employer___fk___for___area___id
			references area(id),
	views_count integer default 0 not null
);

create unique index employer_id_uindex
	on employer (id);

create table vacancy
(
	id bigint not null
		constraint vacancy_pkey
			primary key,
	name varchar(256),
	area_id bigint not null
		constraint vacancy___fk___for___area___id
			references area(id),
	date_create timestamp not null,
	comment varchar(1024),
	views_count integer default 0 not null,
	gross boolean,
	employer varchar(256),
	to_to integer,
	from_from integer,
	currency varchar(8),
	created_at varchar(32)
);





