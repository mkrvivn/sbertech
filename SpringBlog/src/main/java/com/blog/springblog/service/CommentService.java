package com.blog.springblog.service;

import com.blog.springblog.dao.CommentDao;
import com.blog.springblog.model.Comment;
import com.blog.springblog.model.Post;
import com.blog.springblog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentDao commentDao;

    public void deleteCommentById(Long id)
    {
        commentDao.deleteById(id);
    }

    public void addComment(Post post, User author, String text)
    {
        post.getComments().add(new Comment(text, author, post));
    }
}
