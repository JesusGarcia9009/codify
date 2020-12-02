-- PERFIL
INSERT INTO codify_security.perfil (descripcion,nombre) VALUES ('Administrador Codify','Administrador');

-- FUNCIONALIDAD
INSERT INTO codify_security.funcionalidad (descripcion,nombre) VALUES ('Modulo de seguridad de la aplicacion codify','Seguridad');

-- TENANT
INSERT INTO codify_security.tenant (llave,nombre) VALUES ('codify','Codify App');


-- PERFIL_FUNCIONALIDAD
INSERT INTO codify_security.perfil_funcionalidad (id_perfil_funcionalidad,escritura,lectura,id_funcionalidad,id_perfil)	
VALUES (1,1,1,(select id_funcionalidad from codify_security.funcionalidad f where f.nombre like('Seguridad')),(select id_perfil from codify_security.perfil p where p.nombre like('Administrador')));


-- USUARIO
INSERT INTO codify_security.usuario (apellido_materno,apellido_paterno,email,nombre,pass,rut,id_tenant) VALUES ('Hernadez','Garcia','jesusmanuelgarcia9009@gmail.com','Jesus','$2a$04$nEZr2jGP4zZUt09XAKAGLezJzaTaDpIuylVgHOv2RNl9MrETKHiRq','26873611-5',(select id_tenant from codify_security.tenant t where t.llave like('codify')));

-- USUARIO_PERFIL
INSERT INTO codify_security.usuario_perfil (id_usuario,id_perfil) VALUES ((select id_usuario from codify_security.usuario u where u.email like('jesusmanuelgarcia9009@gmail.com')),(select id_perfil from codify_security.perfil p where p.nombre like('Administrador')));


COMMIT;