package com.educando.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educando.curso.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
