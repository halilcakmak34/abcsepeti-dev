create table language
(
    id          bigserial,
    table_name  varchar(32),
    column_name varchar(64),
    lang        varchar(3) not null,
    key         varchar(128),
    value       varchar(256),
    pagename    varchar(64),
    type        varchar(16)
);