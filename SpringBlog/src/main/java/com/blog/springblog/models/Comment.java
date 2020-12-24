package com.blog.springblog.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@NoArgsConstructor
public class Comment {

    public Comment(String text, User author, Post post)
    {
        this.text = text;
        this.author = author;
        this.post = post;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "text", nullable = false)
    String text;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    User author;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "post_id", nullable = false)
    Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
