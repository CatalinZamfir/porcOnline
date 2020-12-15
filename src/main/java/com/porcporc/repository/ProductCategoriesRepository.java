package com.porcporc.repository;

import com.porcporc.entities.ProductCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoriesRepository extends JpaRepository<ProductCategoriesEntity,Integer> {
}
