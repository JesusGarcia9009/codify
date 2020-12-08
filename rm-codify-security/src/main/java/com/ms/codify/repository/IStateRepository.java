package com.ms.codify.repository;

import org.springframework.data.repository.CrudRepository;

import com.ms.codify.entities.State;

/**
 * IStateRepository (operaciones CRUD de la entidad) - Spring Boot
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
public interface IStateRepository extends CrudRepository<State, Long> {

}
