 
INSERT INTO credentials(username,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  users (firstname, lastname,age,title,usernumber, user_id) VALUES ('Curious','George',12,'Boy Monkey', 8754,'admin');
INSERT INTO users (firstname, lastname,age,title,usernumber,user_id) VALUES ('Allen','Rench',123,'Torque Master', 8733,'guest');

INSERT INTO cart (cartname, version) VALUES ('cart_BoyMonkey_1',1), ('cart_TorqueMaster_2',1)
   
INSERT INTO Category (description, name) VALUES ('Sport', 'Sport'), ('Book', 'Book');	
INSERT INTO Item (description, itemId, name, price) VALUES ('Kids Sport','1','Sport',8733);
INSERT INTO Item (description, itemId, name, price) VALUES ('Kids Book','2','Book',873);
INSERT INTO Category_item(category_id,item_id) VALUES ('1','1'),('2','2')