-- codify_security.tenant definition

CREATE TABLE `codify_security`.`tenant` (
  `id_tenant` bigint(20) NOT NULL AUTO_INCREMENT,
  `llave` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tenant`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;