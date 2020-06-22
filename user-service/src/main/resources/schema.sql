
create table users (
    id bigint not null primary key,
	username varchar_ignorecase(50) not null unique,
	uuid varchar_ignorecase(50) not null unique,
	name varchar_ignorecase(50) not null,
	password varchar_ignorecase(200) not null,
	email varchar(100) not null unique,
	enabled boolean not null
);

create table authorities (
	id bigint not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(id) references users(id)
);

create unique index ix_auth_username on authorities (id, authority);
