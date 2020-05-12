package com.Xiong.service.impl;

import com.Xiong.dao.UserDao;
import com.Xiong.domain.Role;
import com.Xiong.domain.User;
import com.Xiong.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByUsername(s);
        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), user.getStatus() == 0 ? false : true,
                true, true, true, getAuthority(user.getRoles()));
        return user1;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> list) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : list) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return simpleGrantedAuthorities;
    }

    @Override
    public List<User> findAll(int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        List<User> all = userDao.findAll();
        return all;
    }

    @Override
    public User findByUserName(String string) {
        return userDao.findByUsername(string);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findById(String string) {
        return userDao.findById(string);
    }

    @Override
    public List<Role> findRolesNotInUser(String id) {
        return userDao.findRolesNotInUser(id);
    }

    @Override
    public void addRole(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userDao.addRole(userId, roleId);
        }
    }

    @Override
    public void deleteUser(String[] userIds) {
        for (String userId : userIds) {
            userDao.deleteRoleAndUser(userId);
            userDao.deleteUser(userId);
        }
    }
}
