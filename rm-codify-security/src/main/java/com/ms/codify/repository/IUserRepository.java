package com.ms.codify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.codify.entities.User;

/**
 * ICustomerRepository (operaciones CRUD de la entidad) - Spring Boot
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
public interface IUserRepository extends CrudRepository<User, String> {


	Long countByUsername(String username);
	
	@Query( "   select user "
			+ " from  User user "
			+ " join fetch user.userProfiles userprofiles "
			+ " join fetch userprofiles.profile profiles "
			+ " where user.username = :username ")
	User findByUsername(String username);
	
	
	@Query( "   select user "
			+ " from  User user "
			+ " join fetch user.languaje "
			+ " join fetch user.state ")
	List<User> findAllUsers();
	
}
