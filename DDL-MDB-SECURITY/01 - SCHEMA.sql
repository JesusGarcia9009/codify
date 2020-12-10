-- codify_security.languaje definition
CREATE TABLE `codify_security`.`languaje` (
  `code` char(2) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- codify_security.state definition
CREATE TABLE `codify_security`.`state` (
  `id` bigint(10) NOT NULL ,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- codify_security.permit definition

CREATE TABLE `codify_security`.`permit` (
  `id` bigint(10) NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- codify_security.profile definition

CREATE TABLE `codify_security`.`profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- codify_security.profile_permit definition

CREATE TABLE `codify_security`.`profile_permit` (
  `id_profile` bigint(20) NOT NULL,
  `id_permit` bigint(10) NOT NULL,
  PRIMARY KEY (`id_profile`,`id_permit`),
  KEY `profile_permit_id_profile` (`id_profile`),
  KEY `FK_ID_PERMIT` (`id_permit`),
  CONSTRAINT `FK_ID_PERMIT` FOREIGN KEY (`id_permit`) REFERENCES `permit` (`id`),
  CONSTRAINT `FK_ID_PROFILE` FOREIGN KEY (`id_profile`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- codify_security.`user` definition

CREATE TABLE `codify_security`.`user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  `code_languaje` char(2) NOT NULL,
  `id_state` bigint(10) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `fk_user_code_languaje` (`code_languaje`),
  KEY `FK_USER_STATE` (`id_state`),
  CONSTRAINT `FK_USER_CODE_LANGUAJE` FOREIGN KEY (`code_languaje`) REFERENCES `languaje` (`code`),
  CONSTRAINT `FK_USER_STATE` FOREIGN KEY (`id_state`) REFERENCES `state` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- codify_security.user_profile definition

CREATE TABLE `codify_security`.`user_profile` (
  `id_user` varchar(50) NOT NULL,
  `id_profile` bigint(20) NOT NULL,
  `id_object` varchar(50) NOT NULL,
  PRIMARY KEY (`id_user`,`id_profile`),
  KEY `user_profile_id_user_profile` (`id_user`),
  KEY `FK_USER_PROFILE_ID_PROFILE` (`id_profile`),
  CONSTRAINT `FK_USER_PROFILE_ID_PROFILE` FOREIGN KEY (`id_profile`) REFERENCES `profile` (`id`),
  CONSTRAINT `FK_USER_PROFILE_ID_USER` FOREIGN KEY (`id_user`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



