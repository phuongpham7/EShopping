 
INSERT INTO credentials(username,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  users (firstname, lastname,age,title,usernumber, user_id) VALUES ('Curious','George',12,'Boy Monkey', 8754,'admin');
INSERT INTO users (firstname, lastname,age,title,usernumber,user_id) VALUES ('Allen','Rench',123,'Torque Master', 8733,'guest');

					