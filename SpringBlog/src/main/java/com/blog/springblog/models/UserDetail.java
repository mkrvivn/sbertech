package com.blog.springblog.models;


import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
@NoArgsConstructor
public class UserDetail {

    public UserDetail(String name, String lastname)
    {
        this.name = name;
        this.lastname = lastname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "last_name")
    String lastname;

    @OneToOne(mappedBy = "userDetail")
    User user;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
