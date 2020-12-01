-- codify_security.perfil_funcionalidad definition

CREATE TABLE `codify_security`.`perfil_funcionalidad` (
  `id_perfil_funcionalidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `escritura` int(11) NOT NULL,
  `lectura` int(11) NOT NULL,
  `id_funcionalidad` bigint(20) NOT NULL,
  `id_perfil` bigint(20) NOT NULL,
  PRIMARY KEY (`id_perfil_funcionalidad`),
  KEY `FK2mgp27b1if3dflyprckf3dvyc` (`id_funcionalidad`),
  KEY `FKiogwsqckc3ulwyu825ylmnr8h` (`id_perfil`),
  CONSTRAINT `FK2mgp27b1if3dflyprckf3dvyc` FOREIGN KEY (`id_funcionalidad`) REFERENCES `funcionalidad` (`id_funcionalidad`),
  CONSTRAINT `FKiogwsqckc3ulwyu825ylmnr8h` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;