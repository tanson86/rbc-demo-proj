insert into creator(id,name) values (1,'user');
insert into creator(id,name) values (2,'admin');

insert into post(id,title,content,creator_id) values (1,'User 1 post','Created by user 1 in January',1);
insert into post(id,title,content,creator_id) values (2,'User 1 post','Created by user 1 in February',1);
insert into post(id,title,content,creator_id) values (3,'User 2 post','Created by user 2 in March',2);