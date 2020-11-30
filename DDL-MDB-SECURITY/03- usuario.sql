-- codify_security.usuario definition

CREATE TABLE `codify_security`.`usuario` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido_materno` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `pass` varchar(500) NOT NULL,
  `rut` varchar(50) NOT NULL,
  `id_tenant` bigint(20) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FKmsxlet5dv4rmhrn4cy3bt3vy4` (`id_tenant`),
  CONSTRAINT `FKmsxlet5dv4rmhrn4cy3bt3vy4` FOREIGN KEY (`id_tenant`) REFERENCES `tenant` (`id_tenant`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;