package com.porcporc.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Date orderDate;
    private Boolean processed;
    private String paymentType;
    private String orderStatus;
    private Boolean gdprCheck;
    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity user;
    @OneToMany(mappedBy = "order")
    private List<ProductOrderEntity> productOrders;

    public OrderEntity() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Boolean getGdprCheck() {
        return gdprCheck;
    }

    public void setGdprCheck(Boolean gdprCheck) {
        this.gdprCheck = gdprCheck;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<ProductOrderEntity> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductOrderEntity> productOrders) {
        this.productOrders = productOrders;
    }

}
