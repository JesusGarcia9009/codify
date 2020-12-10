package com.ms.codify;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuracion Conversor Dozer para Model y DTO.
 *
 * @Author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Configuration
public class DozerConfig {

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        return new DozerBeanMapper();
    }
}
