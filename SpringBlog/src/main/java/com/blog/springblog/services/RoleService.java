package com.blog.springblog.services;

import com.blog.springblog.dao.RoleDao;
import com.blog.springblog.exceptions.role.RoleNotFound;
import com.blog.springblog.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public List<Role> findAllRoles()
    {
      return roleDao.findAll();
    }

    public Role findRoleById(Long id) throws RoleNotFound
    {
        return roleDao.findById(id).orElseThrow(() -> new RoleNotFound("findbyid"));
    }

    public void createRole(String name)
    {
        roleDao.save(new Role(name));
    }

    public void updateRole(Role role)
    {
        roleDao.save(role);
    }

    public void deleteRole(Role role)
    {
        roleDao.delete(role);
    }


}
