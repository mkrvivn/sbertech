package com.blog.springblog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    public Post(String title, String description, String fulltext, User author)
    {
        this.title = title;
        this.description = description;
        this.fulltext = fulltext;
        this.author = author;
        this.comments = new ArrayList<Comment>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "fulltext")
    private String fulltext;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
