package com.porcporc.entities;

import org.springframework.format.annotation.DateTimeFormat;

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
    private Double price;
    private String description;
    private String image;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private Integer stockProduct;
    @ManyToOne
    @JoinColumn(name = "categoriesId",insertable = false, updatable = false)
    private CategoriesEntity categoriesEntity;
    private Integer categoriesId;
    @OneToOne(mappedBy = "products")
    private ProductOrderEntity productOrder;

    public ProductsEntity() {
    }

    public Integer getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Integer categoriesId) {
        this.categoriesId = categoriesId;
    }

    public Integer getProductsId() {
        return productsId;
    }

    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateDate(){
    return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(Integer stockProduct) {
        this.stockProduct = stockProduct;
    }

    public CategoriesEntity getCategoriesEntity() {
        return categoriesEntity;
    }

    public void setCategoriesEntity(CategoriesEntity categoriesEntity) {
        this.categoriesEntity = categoriesEntity;
    }

    public ProductOrderEntity getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrderEntity productOrder) {
        this.productOrder = productOrder;
    }


}
