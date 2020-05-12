package com.Xiong.service;


import com.Xiong.domain.Role;
import com.Xiong.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> findAll(int page, int pagesize);

    public User findByUserName(String string);

    public void updateUser(User user);

    public User findById(String string);

    public List<Role> findRolesNotInUser(String id);

    public void addRole(String userId, String[] roleIds);

    public void deleteUser(String[] userIds);
}

