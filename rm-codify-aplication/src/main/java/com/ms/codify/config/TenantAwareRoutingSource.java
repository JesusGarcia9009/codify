
package com.ms.codify.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Routing by tenant - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public class TenantAwareRoutingSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ThreadLocalStorage.getTenantName();
    }

}
