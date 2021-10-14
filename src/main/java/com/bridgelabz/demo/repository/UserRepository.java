package com.bridgelabz.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.demo.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	Optional<UserModel> findByemailid(String emailid);
	Optional<UserModel> findByFirstName(String firstName);
	
}
