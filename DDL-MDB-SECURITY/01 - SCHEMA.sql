-- codify_security.tenant definition

CREATE TABLE `codify_security`.`tenant` (
  `id_tenant` bigint(20) NOT NULL AUTO_INCREMENT,
  `llave` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tenant`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- codify_security.perfil definition

CREATE TABLE `codify_security`.`perfil` (
  `id_perfil` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
  KEY `fk_usuario_id_tenant` (`id_tenant`),
  CONSTRAINT `FK_ID_TENANT` FOREIGN KEY (`id_tenant`) REFERENCES `tenant` (`id_tenant`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- codify_security.funcionalidad definition

CREATE TABLE `codify_security`.`funcionalidad` (
  `id_funcionalidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_funcionalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


-- codify_security.usuario_perfil definition

CREATE TABLE `codify_security`.`usuario_perfil` (
  `id_usuario` bigint(20) NOT NULL,
  `id_perfil` bigint(20) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_perfil`),
  KEY `fk_usuario_perfil_id_perfil` (`id_perfil`),
  CONSTRAINT `FK_ID_USUARIO` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FK_ID_PERFIL` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- codify_security.perfil_funcionalidad definition

CREATE TABLE `codify_security`.`perfil_funcionalidad` (
  `id_perfil_funcionalidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `escritura` int(11) NOT NULL,
  `lectura` int(11) NOT NULL,
  `id_funcionalidad` bigint(20) NOT NULL,
  `id_perfil` bigint(20) NOT NULL,
  PRIMARY KEY (`id_perfil_funcionalidad`),
  KEY `fk_perfil_funcionalidad_id_funcionalidad` (`id_funcionalidad`),
  KEY `fk_perfil_funcionalidad_id_perfil` (`id_perfil`),
  CONSTRAINT `fk_perfil_funcionalidad_id_funcionalidad` FOREIGN KEY (`id_funcionalidad`) REFERENCES `funcionalidad` (`id_funcionalidad`),
  CONSTRAINT `fk_perfil_funcionalidad_id_perfil` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;