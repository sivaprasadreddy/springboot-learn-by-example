delete from addresses;
delete from users;

insert into users(id, name, email,disabled) values(1,'Siva','siva@gmail.com', false);
insert into users(id, name, email,disabled) values(2,'Prasad','prasad@gmail.com', false);
insert into users(id, name, email,disabled) values(3,'Reddy','reddy@gmail.com', true);

insert into addresses(id,city,user_id) values(1, 'City1',1);
insert into addresses(id,city,user_id) values(2, 'City2',1);
insert into addresses(id,city,user_id) values(3, 'City3',2);
insert into addresses(id,city,user_id) values(4, 'City4',3);
insert into addresses(id,city,user_id) values(5, 'City5',3);
insert into addresses(id,city,user_id) values(6, 'City6',3);
