package com.Xiong.controller;

import com.Xiong.domain.Role;
import com.Xiong.domain.User;
import com.Xiong.service.UserService;
import com.Xiong.utils.DateUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pagesize", required = true, defaultValue = "4") Integer pagesize) {
        List<User> all = userService.findAll(page, pagesize);
        PageInfo pageInfo = new PageInfo(all);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String updateUser(User user) {
        String string = DateUtils.dateToString(new Date(), "yyyyMMddHHmmss");
        user.setId(string);
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userService.updateUser(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) {
        User user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) {
        List<Role> rolesNotInUser = userService.findRolesNotInUser(id);
        User user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList", rolesNotInUser);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = false) String[] roleIds) {
        if (roleIds != null) {
            userService.addRole(userId, roleIds);
        }
        return "redirect:findAll.do";
    }

    @RequestMapping("/delete.do")
    public String deleteRole(@RequestParam(name = "ids", required = false) String[] userIds) {
        System.out.println(userIds);
        if (userIds != null) {
            userService.deleteUser(userIds);
        }
        return "redirect:findAll.do";
    }
}
