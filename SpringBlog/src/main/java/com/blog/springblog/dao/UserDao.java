package com.blog.springblog.dao;

import com.blog.springblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
