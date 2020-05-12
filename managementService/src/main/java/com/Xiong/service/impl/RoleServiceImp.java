package com.Xiong.service.impl;

import com.Xiong.dao.Roledao;
import com.Xiong.domain.Permission;
import com.Xiong.domain.Role;
import com.Xiong.service.RoleService;
import com.Xiong.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private Roledao roledao;

    @Override
    public List<Role> findAll(int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        List<Role> all = roledao.findAll();
        return all;
    }

    @Override
    public Role findById(String id) {
        return roledao.findById(id);
    }

    @Override
    public void save(Role role) {
        String string = DateUtils.dateToString(new Date(), "yyyyMMddHHmmss");
        role.setId(string);
        roledao.save(role);
    }

    @Override
    public void deleteById(String id) {
        roledao.deleteById(id);
    }

    @Override
    public List<Permission> findNotInPermission(String id) {
        return roledao.findNotInPermission(id);
    }

    @Override
    public void deleteAll(String[] ids) {
        for (String id : ids) {
            roledao.deleteById(id);
        }
    }

    @Override
    public void addPermission(String roleId, String[] permissionId) {
        for (String s : permissionId) {
            roledao.addPermission(roleId, s);
        }
    }
}
