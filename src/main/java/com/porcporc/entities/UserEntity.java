package com.porcporc.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String email;
    private String password;
    private String fullName;
    private String username;
    private String billingAddress;
    private String shippingAddress;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String phone;
    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders;
    @OneToMany(mappedBy = "user")
    private List<AuthorityEntity> authority;


//    @ManyToOne
//    @JoinColumn(name = "authorityId", insertable = false, updatable = false)
//    private AuthorityEntity authority;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

//    public AuthorityEntity getAuthority() {
//        return authority;
//    }
//    public void setAuthority(AuthorityEntity authority) {
//        this.authority = authority;
//    }


    public List<AuthorityEntity> getAuthority() {
        return authority;
    }

    public void setAuthority(List<AuthorityEntity> authority) {
        this.authority = authority;
    }
}
