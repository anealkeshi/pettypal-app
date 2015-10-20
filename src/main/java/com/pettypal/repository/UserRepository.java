package com.pettypal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pettypal.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT u FROM user u WHERE u.firstName LIKE %:name% OR u.lastName LIKE %:name%")
	List<User> searchUserByName(@Param("name") String name);

}
