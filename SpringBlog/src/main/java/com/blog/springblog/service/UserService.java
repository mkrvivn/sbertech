package com.blog.springblog.service;

import com.blog.springblog.dao.UserDao;
import com.blog.springblog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers()
    {
        return userDao.findAll();
    }

    public User getUserById(Long id) throws Exception
    {
        Optional<User> user = userDao.findById(id);
        if(user.isPresent())
            return user.get();
        else
            throw new Exception();
    }

    public void addUser(User user)
    {
        userDao.save(user);
    }

    public void deleteUser(User user)
    {
        userDao.delete(user);
    }


}
