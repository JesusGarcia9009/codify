-- codify_security.perfil definition

CREATE TABLE `codify_security`.`perfil` (
  `id_perfil` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;