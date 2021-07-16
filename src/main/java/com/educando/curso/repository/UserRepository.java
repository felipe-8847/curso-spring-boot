package com.educando.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educando.curso.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
