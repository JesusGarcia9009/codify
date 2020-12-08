package com.ms.codify.repository;

import org.springframework.data.repository.CrudRepository;

import com.ms.codify.entities.UserProfile;
import com.ms.codify.entities.UserProfileId;

/**
 * IUserProfileRepository (operaciones CRUD de la entidad) - Spring Boot
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
public interface IUserProfileRepository extends CrudRepository<UserProfile, UserProfileId> {

}
