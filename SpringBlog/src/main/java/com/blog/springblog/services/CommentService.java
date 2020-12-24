package com.blog.springblog.services;

import com.blog.springblog.dao.CommentDao;
import com.blog.springblog.exceptions.comment.CommentNotFound;
import com.blog.springblog.models.Comment;
import com.blog.springblog.models.Post;
import com.blog.springblog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentDao commentDao;

    public Comment findCommentById(Long id) throws CommentNotFound
    {
        return commentDao.findById(id).orElseThrow(() -> new CommentNotFound("findbyid"));
    }

    public void createComment(String text, User author, Post post)
    {
        commentDao.save(new Comment(text, author, post));
    }

    public void updateComment(Comment comment)
    {
        commentDao.save(comment);
    }

    public void deleteComment(Comment comment)
    {
        commentDao.delete(comment);
    }
}
