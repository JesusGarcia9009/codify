-- codify_security.funcionalidad definition

CREATE TABLE `codify_security`.`funcionalidad` (
  `id_funcionalidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_funcionalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;