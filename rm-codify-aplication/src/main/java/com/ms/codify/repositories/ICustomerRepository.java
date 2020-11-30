package com.ms.codify.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import com.ms.codify.entities.Customer;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * ICustomerRepository (operaciones CRUD de la entidad) - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public interface ICustomerRepository extends CrudRepository<Customer, Long> {

    @Async
    @Query("select c from Customer c")
    CompletableFuture<List<Customer>> findAllAsync();

}
