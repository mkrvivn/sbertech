package com.blog.springblog.models;


import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@NoArgsConstructor
public class Post {

    public Post(String title, String descr, String text, User author)
    {
        this.title = title;
        this.descr = descr;
        this.text = text;
        this.author = author;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "descr", nullable = false)
    String descr;

    @Column(name = "text", nullable = false)
    String text;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    User author;

    @OneToMany(mappedBy = "post")
    List<Comment> comments = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
