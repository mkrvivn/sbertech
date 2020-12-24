package com.blog.springblog.services;


import com.blog.springblog.dao.PostDao;
import com.blog.springblog.exceptions.post.PostNotFound;
import com.blog.springblog.models.Post;
import com.blog.springblog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostDao postDao;

    public Post findPostById(Long id) throws PostNotFound
    {
        return postDao.findById(id).orElseThrow(() -> new PostNotFound("findById"));
    }

    public List<Post> findPostsByAuthor(User user)
    {
        return user.getPosts();
    }

    public void createPost(String title, String descr, String text, User author)
    {
        postDao.save(new Post(title, descr, text, author));
    }

    public void updatePost(Post post)
    {
        postDao.save(post);
    }

    public void deletePost(Post post)
    {
        postDao.delete(post);
    }
}
