create table restaurant(id serial primary key, name varchar(200) not null, rating numeric(4,2) not null default 4, open_time varchar(10) not null, closing_time varchar(10) not null, cost_for_one integer not null, image_url varchar(300));
insert into restaurant values(1,'Hauz Khas Social',4.2,'10:00','20:00',420,'https://image-url.net');
create table user_details(id serial primary key, name varchar(200) not null, email varchar(200) not null);
insert into user_details values(1,'Test','test@gmail.com');
create table reservations(id serial primary key, user_id integer references user_details(id) not null, restaurant_id integer references restaurant(id) not null, reservation_time timestamp not null);
create table ride_details(id serial primary key, user_id integer references user_details(id) not null, source_lat numeric(10,5) not null, source_long numeric(10,5) not null, dest_lat numeric(10,5) not null, dest_long numeric(10,5) not null, fare numeric(5,2) not null, start_time timestamp, end_time timestamp, cab_type varchar(100) not null);
insert into ride_details values(1,1,123.32,231.42,53.22,43.44,235.65,'2021-03-29 08:00:00', '2021-03-29 10:00:00', 'GO');