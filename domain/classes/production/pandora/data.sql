INSERT INTO AUTHORITIE VALUES('ADMIN');
INSERT INTO AUTHORITIE VALUES('SUPERVISOR');
INSERT INTO AUTHORITIE VALUES('USER');


/** INSERT USERS**/
INSERT INTO USER (id, name, city, password, email) VALUES(9999,'admin', 'Denver', '$2a$10$abvg0EaEDyxpK3YzyDbBG.MQAMpWbIU0Sm6arvtYGncwDy2MFXXSC', 'admin@pandora.com');
INSERT INTO USER (id, name, city, password, email) VALUES(2,'user', 'New York', '$2a$10$abvg0EaEDyxpK3YzyDbBG.MQAMpWbIU0Sm6arvtYGncwDy2MFXXSC', 'user@user.com');

/** INSER USER AUTHORITIES**/
INSERT INTO USER_AUTHORITIES (user_id, authoritie)  VALUES(9999,'ADMIN');
INSERT INTO USER_AUTHORITIES (user_id, authoritie)  VALUES(2,'ADMIN');
