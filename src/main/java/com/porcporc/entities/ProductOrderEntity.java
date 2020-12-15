package com.porcporc.entities;

import javax.persistence.*;

@Entity
@Table(name = "product_order")
public class ProductOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productOrderId;
    private Integer productId;
    private Integer orderId;
    private Integer quantity;
    private Integer price;


}
