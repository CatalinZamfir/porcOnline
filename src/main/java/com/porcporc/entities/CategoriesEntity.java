package com.porcporc.entities;

import javax.persistence.*;

@Entity
@Table
public class CategoriesEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer categoriesId;
    private String name;
    private String description;

}
