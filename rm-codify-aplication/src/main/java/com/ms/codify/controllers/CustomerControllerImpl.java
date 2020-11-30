package com.ms.codify.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.codify.converter.Converters;
import com.ms.codify.dto.CustomerDto;
import com.ms.codify.entities.Customer;
import com.ms.codify.repositories.ICustomerRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * CustomerController (Capa rest) - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Slf4j
@RestController
@RequestMapping("${api.codify.base.uri}/clientes")
public class CustomerControllerImpl implements CustomerController {

    private final ICustomerRepository repository;

    @Autowired
    public CustomerControllerImpl(ICustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('Administrador')")
    public List<CustomerDto> getAll() {
    	log.info("[getAll] ::Inicio del metodo");
        Iterable<Customer> customers = repository.findAll();
        log.info("[getAll] ::fin del metodo");
        return Converters.convert(customers);
    }

    @GetMapping("/cliente/{id}")
    @PreAuthorize("hasAuthority('Administrador')")
    public CustomerDto get(@PathVariable("id") long id) {
    	log.info("[get] ::Inicio del metodo");
        Customer customer = repository
                .findById(id)
                .orElse(null);

        log.info("[get] ::fin del metodo");
        return Converters.convert(customer);
    }

    @GetMapping("/async/clientes")
    @PreAuthorize("hasAuthority('Administrador')")
    public List<CustomerDto> getAllAsync() throws ExecutionException, InterruptedException {
    	log.info("[getAllAsync] ::Inicio/fin del metodo");
        return repository.findAllAsync()
                .thenApply(x -> Converters.convert(x))
                .get();
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasAuthority('Administrador')")
    public CustomerDto post(@RequestBody CustomerDto customer) {
    	log.info("[post] ::Inicio del metodo");
        Customer source = Converters.convert(customer);

        // Store the Entity:
        Customer result = repository.save(source);

        log.info("[post] ::fin del metodo");
        return Converters.convert(result);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('Administrador')")
    public void delete(@PathVariable("id") long id) {
    	log.info("[delete] ::Inicio/fin del metodo");
        repository.deleteById(id);
    }

}
