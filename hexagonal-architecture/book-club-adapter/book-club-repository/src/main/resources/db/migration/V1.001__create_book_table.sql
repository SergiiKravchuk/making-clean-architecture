create table if not exists book
(
    isbn         varchar(255) not null,
    author       varchar(255),
    title        varchar(255),
    description  varchar(255),
    published_at date,
    added_at     timestamp(6),
    primary key (isbn)
);
