package com.porcporc.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
public class ProductsEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer productsId;
    private String name;
    private String sku;
    private Integer price;
    private String description;
    private String image;
    private Date createDate;
    private Integer stockProduct;



}
