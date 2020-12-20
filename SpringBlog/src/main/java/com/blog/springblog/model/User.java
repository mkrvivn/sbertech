package com.blog.springblog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    public User(String login, String email, String password)
    {
        this.login = login;
        this.email = email;
        this.password = password;
        this.userDetail = new UserDetail(this);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    UserDetail userDetail;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    List<Post> posts;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    List<Comment> comments;

}
