package com.assesment.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assesment.assesment.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
