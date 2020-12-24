package com.blog.springblog.services;

import com.blog.springblog.dao.UserDao;
import com.blog.springblog.exceptions.user.UserNotFound;
import com.blog.springblog.models.User;
import com.blog.springblog.models.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getAllUsers()
    {
        return userDao.findAll();
    }

    public User getUserById(Long id) throws UserNotFound
    {
       return userDao.findById(id).orElseThrow(() -> new UserNotFound("findById"));
    }

    public void createUser(String login, String password)
    {
        UserDetail userDetail = new UserDetail("", "");
        User user = new User(login, password, userDetail);
        userDetail.setUser(user);
        userDao.save(user);
    }

    public void updateUser(User user)
    {
        userDao.save(user);
    }

    public void deleteUser(User user)
    {
        userDao.delete(user);
    }

}
