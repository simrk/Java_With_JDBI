drop table if exists orders;

create table orders (
    id integer not null primary key ,
    order_name varchar(400) not null,
    price integer not null,
    quantity integer not null,
    purchase_date date
);

CREATE TABLE songs (_id INTEGER PRIMARY KEY, track INTEGER, title TEXT NOT NULL, album INTEGER);
CREATE TABLE albums (_id INTEGER PRIMARY KEY, name TEXT NOT NULL, artist INTEGER);
CREATE TABLE artists (_id INTEGER PRIMARY KEY, name TEXT NOT NULL);