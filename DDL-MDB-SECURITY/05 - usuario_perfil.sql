-- codify_security.usuario_perfil definition

CREATE TABLE `codify_security`.`usuario_perfil` (
  `id_usuario` bigint(20) NOT NULL,
  `id_perfil` bigint(20) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_perfil`),
  KEY `FK3cxlmf5q4y8mllkos025n9px8` (`id_perfil`),
  CONSTRAINT `FK2qe6tjawyl6ojl32uhbwllldh` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FK3cxlmf5q4y8mllkos025n9px8` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;