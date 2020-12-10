
--  Auto-generated SQL script #Languaje
INSERT INTO codify_security.languaje (code,name) VALUES ('EN','English');
INSERT INTO codify_security.languaje (code,name) VALUES ('ES','Spanish');
INSERT INTO codify_security.languaje (code,name) VALUES ('PT','Portuguese');
INSERT INTO codify_security.languaje (code,name) VALUES ('FR','French');
INSERT INTO codify_security.languaje (code,name) VALUES ('DE','German');

--  Auto-generated SQL script #state
INSERT INTO codify_security.state (id,name)	VALUES (1,'Uninitialized');
INSERT INTO codify_security.state (id,name)	VALUES (2,'Active');
INSERT INTO codify_security.state (id,name)	VALUES (3,'Blocked');
INSERT INTO codify_security.state (id,name)	VALUES (4,'Expired');

--  Auto-generated SQL script #permit
INSERT INTO codify_security.permit (id,description)	VALUES (1,'User Manager');

--  Auto-generated SQL script #permit
INSERT INTO codify_security.profile (id,name) VALUES (1,'Administrator');

--  Auto-generated SQL script #profile_permit
INSERT INTO codify_security.profile_permit (id_profile,id_permit)	VALUES (1,1);

--  Auto-generated SQL script #user
INSERT INTO codify_security.`user` (username,password,first_name,middle_name,last_name,email,code_languaje,id_state) VALUES ('jesusmanuelgarcia9009@gmail.com','$2a$04$nEZr2jGP4zZUt09XAKAGLezJzaTaDpIuylVgHOv2RNl9MrETKHiRq','Jesus','Garcia','Hernandez','jesusmanuelgarcia9009@gmail.com','EN',2);

--  Auto-generated SQL script #user_profile
INSERT INTO codify_security.user_profile (id_user,id_profile,id_object)	VALUES ('jesusmanuelgarcia9009@gmail.com',1,'125');

COMMIT;