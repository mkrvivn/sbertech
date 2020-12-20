package com.blog.springblog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usersdetails")
public class UserDetail {

    public UserDetail(User user)
    {
        this.user = user;
        this.name = null;
        this.lastname = null;
    }

    public UserDetail(String name, String lastname, User user)
    {
        this.name = name;
        this.lastname = lastname;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

}
