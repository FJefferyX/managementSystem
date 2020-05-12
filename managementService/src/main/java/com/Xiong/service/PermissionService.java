package com.Xiong.service;

import com.Xiong.domain.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> findAll(int page, int pagesize);
}
