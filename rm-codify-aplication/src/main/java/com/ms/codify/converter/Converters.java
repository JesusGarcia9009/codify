package com.ms.codify.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.ms.codify.dto.CustomerDto;
import com.ms.codify.entities.Customer;

/**
 * Converters (Mapper no exposicion de las entidades en la capa rest) - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public class Converters {

    private Converters() {

    }

    public static CustomerDto convert(Customer source) {
        if(source == null) {
            return null;
        }

        return new CustomerDto(source.getId(), source.getName());
    }

    public static Customer convert(CustomerDto source) {
        if(source == null) {
            return null;
        }

        return new Customer(source.getId(), source.getName());
    }

    public static List<CustomerDto> convert(Iterable<Customer> customers) {
        return StreamSupport.stream(customers.spliterator(), false)
                .map(Converters::convert)
                .collect(Collectors.toList());
    }
}
