package com.Xiong.service.impl;

import com.Xiong.dao.PermissionDao;
import com.Xiong.domain.Permission;
import com.Xiong.service.PermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImp implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;


    @Override
    public List<Permission> findAll(int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        List<Permission> all = permissionDao.findAll();
        return all;
    }
}
