create database if not exists test default character set utf8 collate utf8_general_ci;

use test;

drop table if exists detail;
create table if not exists detail (

  id              int(11) auto_increment, primary key(id),
  name            varchar(40) unique,
  required        tinyint(1) not null default 0,
  count           int not null default 0

) default character set utf8;

insert into detail(id, name, required, count) values (1, "Процессор", "1", "5");
insert into detail(id, name, required, count) values (2, "Материнская плата", "1", "6");
insert into detail(id, name, required, count) values (3, "Видеокарта", "0", "7");
insert into detail(id, name, required, count) values (4, "Монитор LED", "0", "8");
insert into detail(id, name, required, count) values (5, "Оперативная память ddr3", "1", "12");
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
insert into detail(id, name, required, count) values (16, "Процессор i5", "1", "9");
insert into detail(id, name, required, count) values (17, "Материнская плата x832", "1", "9");
insert into detail(id, name, required, count) values (18, "Видеокарта Radeon", "0", "8");
insert into detail(id, name, required, count) values (19, "Монитор LCD", "0", "7");
insert into detail(id, name, required, count) values (20, "Оперативная память ddr5", "1", "17");
insert into detail(id, name, required, count) values (21, "Мышь opt", "0", "27");
insert into detail(id, name, required, count) values (22, "Клавиатура x7", "0", "37");
insert into detail(id, name, required, count) values (23, "Накопитель SSD x900", "0", "57");
insert into detail(id, name, required, count) values (24, "Накопитель HDD Seagate", "0", "144");
insert into detail(id, name, required, count) values (25, "Накопитель flesh Transcend", "0", "343");
insert into detail(id, name, required, count) values (26, "Коврик для мыши Razor", "0", "842");
insert into detail(id, name, required, count) values (27, "Корпус black", "0", "241");
insert into detail(id, name, required, count) values (28, "Дисковод DVD-RW", "0", "141");
insert into detail(id, name, required, count) values (29, "Адаптер питания QDion", "1", "31");
insert into detail(id, name, required, count) values (30, "Батарейка bios CR32", "1", "47");
insert into detail(id, name, required, count) values (31, "Батарейка bios CR32++", "1", "46");
insert into detail(id, name, required, count) values (32, "Батарейка bios CR32 ULTIMATE", "1", "41");
insert into detail(id, name, required, count) values (33, "java", "1", "41");
