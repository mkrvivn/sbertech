package com.blog.springblog.service;

import com.blog.springblog.dao.PostDao;
import com.blog.springblog.model.Comment;
import com.blog.springblog.model.Post;
import com.blog.springblog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostDao postDao;

    public Post getPostById(Long id)
    {
        return postDao.findById(id).orElseThrow();
    }

    public void addPost(User author, String title, String description, String text)
    {
        Post newPost = new Post(title, description, text, author);
        postDao.save(newPost);
    }

    public void deletePost(Post post)
    {
        postDao.delete(post);
    }

    public void deletePostById(Long id) throws Exception
    {
        Optional<Post> o = postDao.findById(id);
        if(o.isPresent())
            postDao.delete(o.get());
        else
            throw new Exception();
    }

    public User getAuthorOfPost(Post post)
    {
        return post.getAuthor();
    }

    public User getAuthorOfPostById(Long id) throws Exception
    {
        Optional<Post> o = postDao.findById(id);
        if(o.isPresent())
            return o.get().getAuthor();
        else
            throw new Exception();
    }

    public List<Comment> getPostComments(Post post)
    {
        return post.getComments();
    }

    public List<Comment> getPostCommentsById(Long id) throws Exception
    {
        Optional<Post> o = postDao.findById(id);
        if(o.isPresent())
            return o.get().getComments();
        else
            throw new Exception();
    }

    public void addComment(Post post, Comment comment)
    {
        post.getComments().add(comment);
    }

}
