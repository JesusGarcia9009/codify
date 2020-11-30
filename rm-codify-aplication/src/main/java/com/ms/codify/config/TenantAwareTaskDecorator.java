
package com.ms.codify.config;

import org.springframework.core.task.TaskDecorator;

/**
 * Decorator - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public class TenantAwareTaskDecorator implements TaskDecorator {

    @Override
    public Runnable decorate(Runnable runnable) {
        String tenantName = ThreadLocalStorage.getTenantName();
        return () -> {
            try {
                ThreadLocalStorage.setTenantName(tenantName);
                runnable.run();
            } finally {
                ThreadLocalStorage.setTenantName(null);
            }
        };
    }
}