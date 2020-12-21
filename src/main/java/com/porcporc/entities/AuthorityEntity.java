package com.porcporc.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authority")
public class AuthorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorityId;
    private String authority;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;


//    @OneToMany(mappedBy = "authority")
//    private List<UserEntity> users;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

//    public List<UserEntity> getUsers() {
//        return users;
//    }
//    public void setUsers(List<UserEntity> users) {
//        this.users = users;
//    }


    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
