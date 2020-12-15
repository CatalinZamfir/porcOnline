package com.porcporc.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
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
    private Date birthDate;
    private String phone;


}
