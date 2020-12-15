package com.porcporc.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer orderId;

    private Integer userId;
    private Date orderDate;
    private Boolean processed;
    private String paymentType;
    private String orderStatus;
    private Boolean gdprCheck;


}
