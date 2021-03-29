#Install postgresql
- brew install postgresql
- brew services start postgresql
- psql postgres

#Setup Database
- CREATE DATABASE assistant;
- \c assistant
- create table restaurant(id serial primary key, name varchar(200) not null, rating numeric(4,2) not null default 4, open_time varchar(10) not null, closing_time varchar(10) not null, cost_for_one integer not null, image_url varchar(300));
