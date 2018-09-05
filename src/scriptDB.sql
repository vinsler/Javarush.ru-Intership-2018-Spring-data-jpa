create database if not exists test default character set utf8 collate utf8_general_ci;

use test;

drop table if exists detail;
create table if not exists detail (

  id              int(11) auto_increment, primary key(id),
  name            varchar(20) not null,
  required         tinyint(1) not null default 0,
  count           int not null default 0

) default character set utf8;

insert into detail(id, name, required, count) values (1, "Процессор", "1", "5");
insert into detail(id, name, required, count) values (2, "Материнская плата", "1", "6");
insert into detail(id, name, required, count) values (3, "Видеокарта", "0", "7");
insert into detail(id, name, required, count) values (4, "Монитор", "0", "8");
insert into detail(id, name, required, count) values (5, "Оперативная память", "1", "12");
insert into detail(id, name, required, count) values (6, "Мышь", "0", "25");
insert into detail(id, name, required, count) values (7, "Клавиатура", "0", "35");
insert into detail(id, name, required, count) values (8, "Накопитель SSD", "0", "54");
insert into detail(id, name, required, count) values (9, "Накопитель HDD", "0", "145");
insert into detail(id, name, required, count) values (10, "Накопитель flesh", "0", "345");
insert into detail(id, name, required, count) values (11, "Коврик для мыши", "0", "845");
insert into detail(id, name, required, count) values (12, "Корпус", "0", "245");
insert into detail(id, name, required, count) values (13, "Дисковод DVD", "0", "145");
insert into detail(id, name, required, count) values (14, "Адаптер питания", "1", "35");
insert into detail(id, name, required, count) values (15, "Батарейка bios", "1", "45");
