package com.porcporc.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoriesEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer categoriesId;
    private String name;
    private String description;
    @OneToMany(mappedBy = "categoriesEntity")
    private List<ProductsEntity> productsList;

    public Integer getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Integer categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductsEntity> getProductsList() {
        return productsList;
    }

    public void setProducts(List<ProductsEntity> productsList) {
        this.productsList = productsList;
    }
}
