package com.Ecom.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecom.api.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
