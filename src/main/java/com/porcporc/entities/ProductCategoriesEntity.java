package com.porcporc.entities;


import javax.persistence.*;

@Entity
@Table (name = "product_categories")
public class ProductCategoriesEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer productCategoriesId;
    private Integer productId;
    private Integer categoryId;
}
