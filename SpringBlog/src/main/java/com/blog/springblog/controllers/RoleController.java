package com.blog.springblog.controllers;

import com.blog.springblog.exceptions.role.RoleNotFound;
import com.blog.springblog.models.Role;
import com.blog.springblog.services.RoleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping(value = "/getroles")
    List<Role> getRoles()
    {
        return roleService.findAllRoles();
    }

    @GetMapping(value = "/getrole/{id}")
    Role getRole(@PathVariable Long id)
    {
        try
        {
            return roleService.findRoleById(id);
        }catch (RoleNotFound e)
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "role Not Found", e);
        }
    }

    @PostMapping(value = "/addrole")
    HttpStatus addRole(@RequestBody AddRole newRole)
    {
        roleService.createRole(newRole.name);
        return HttpStatus.OK;
    }

}

@Data
class AddRole
{
    String name;
}