package com.Xiong.service;

import com.Xiong.domain.Permission;
import com.Xiong.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll(int page, int pagesize);

    public Role findById(String id);

    public void save(Role role);

    public void deleteById(String id);

    public List<Permission> findNotInPermission(String id);

    public void deleteAll(String[] ids);

    public void addPermission(String roleId, String[] permissionId);
}
