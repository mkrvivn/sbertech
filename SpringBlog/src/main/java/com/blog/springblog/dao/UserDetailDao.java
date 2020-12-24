package com.blog.springblog.dao;

import com.blog.springblog.models.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailDao extends JpaRepository<UserDetail, Long> {
}
