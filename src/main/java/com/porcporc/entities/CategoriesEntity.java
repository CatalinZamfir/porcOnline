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
    private String image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ProductsEntity> getProductsList() {
        return productsList;
    }

    public void setProducts(List<ProductsEntity> productsList) {
        this.productsList = productsList;
    }
}
