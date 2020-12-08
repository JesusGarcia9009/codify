package com.ms.codify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.codify.entities.Languaje;

/**
 * ILanguajeRepository (operaciones CRUD de la entidad) - Spring Boot
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
public interface ILanguajeRepository extends CrudRepository<Languaje, String> {

    @Query("select c from Languaje c")
    List<Languaje> findAll();

}
