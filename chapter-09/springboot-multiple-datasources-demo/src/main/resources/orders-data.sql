delete from order_items;
delete from orders;

insert into orders(id, cust_name, cust_email) values(1,'Siva','siva@gmail.com');
insert into orders(id, cust_name, cust_email) values(2,'Prasad','prasad@gmail.com');
insert into orders(id, cust_name, cust_email) values(3,'Reddy','reddy@gmail.com');

insert into order_items(id, productcode,quantity,order_id) values(1,'P100', 2, 1);
insert into order_items(id, productcode,quantity,order_id) values(2,'P101', 1, 1);
insert into order_items(id, productcode,quantity,order_id) values(3,'P102', 5, 1);
insert into order_items(id, productcode,quantity,order_id) values(4,'P103', 2, 2);
insert into order_items(id, productcode,quantity,order_id) values(5,'P104', 1, 2);
