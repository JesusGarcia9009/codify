package com.ms.codify;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ms.codify.config.TenantAwareRoutingSource;
import com.zaxxer.hikari.HikariDataSource;


/**
 * Inicializacion del Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableTransactionManagement
public class CodifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodifyApplication.class, args);
	}
	

	@Bean
	public DataSource dataSource() {

		AbstractRoutingDataSource dataSource = new TenantAwareRoutingSource();
		Map<Object,Object> targetDataSources = new HashMap<>();

		targetDataSources.put("codify_default", tenantDefault());
		targetDataSources.put("codify_client", tenantClient());
		targetDataSources.put("codify_client_two", tenantClientTwo());

		dataSource.setTargetDataSources(targetDataSources);

		dataSource.afterPropertiesSet();

		return dataSource;
	}
	
	public DataSource tenantDefault() {

		HikariDataSource dataSource = new HikariDataSource();

		dataSource.setInitializationFailTimeout(0);
		dataSource.setMaximumPoolSize(5);
		dataSource.setDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");
		dataSource.addDataSourceProperty("url", "jdbc:mariadb://localhost:3306/codify_default");
		dataSource.addDataSourceProperty("user", "root");
		dataSource.addDataSourceProperty("password", "root");

		return dataSource;
	}
	

	public DataSource tenantClient() {

		HikariDataSource dataSource = new HikariDataSource();

		dataSource.setInitializationFailTimeout(0);
		dataSource.setMaximumPoolSize(5);
		dataSource.setDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");
		dataSource.addDataSourceProperty("url", "jdbc:mariadb://localhost:3306/codify_client");
		dataSource.addDataSourceProperty("user", "root");
		dataSource.addDataSourceProperty("password", "root");

		return dataSource;
	}

	public DataSource tenantClientTwo() {

		HikariDataSource dataSource = new HikariDataSource();

		dataSource.setInitializationFailTimeout(0);
		dataSource.setMaximumPoolSize(5);
		dataSource.setDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");
		dataSource.addDataSourceProperty("url", "jdbc:mariadb://localhost:3306/codify_client_two");
		dataSource.addDataSourceProperty("user", "root");
		dataSource.addDataSourceProperty("password", "root");

		return dataSource;
	}
}