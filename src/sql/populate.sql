 
INSERT INTO credentials(username,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  users (firstname, lastname,age,title,usernumber, user_id) VALUES ('Curious','George',12,'Boy Monkey', 8754,'admin');
INSERT INTO users (firstname, lastname,age,title,usernumber,user_id) VALUES ('Allen','Rench',123,'Torque Master', 8733,'guest');

INSERT INTO category (description, name) VALUES ('Sport', 'Sport'), ('Book', 'Book');

INSERT INTO item (description, itemId, name, price, category_ID) VALUES ('Book 1', 'B001', 'The Silent Wife', 11.99, 1);
INSERT INTO item (description, itemId, name, price, category_ID) VALUES ('Book 2', 'B002', 'Dog Man: From the Creator of Captain Underpants (Dog Man #1)', 5.99, 2);
INSERT INTO item (description, itemId, name, price, category_ID) VALUES ('Sport 1', 'S001', 'Skechers WomenS Sport Flex Appeal Pretty City Sneakers - Black, 7.5', 40, 1);
INSERT INTO item (description, itemId, name, price, category_ID) VALUES ('Sport 2', 'S002', 'Easy Spirit Motion Sport Casuals - White 9.5 B White', 60, 2);
INSERT INTO cart (cartname, version) VALUES ('cart_BoyMonkey_1',1), ('cart_TorqueMaster_2',1)


SET FOREIGN_KEY_CHECKS=0;

INSERT INTO `shoppingcart`.`category_item` (`Category_ID`, `item_ID`) VALUES ('1', '1'), ('1', '2'), ('2', '3'), ('2', '4');