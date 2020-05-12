package com.Xiong.controller;

import com.Xiong.domain.Permission;
import com.Xiong.domain.Role;
import com.Xiong.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pagesize", required = true, defaultValue = "4") Integer pagesize) {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> all = roleService.findAll(page, pagesize);
        PageInfo pageInfo = new PageInfo(all);
        List list = pageInfo.getList();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) {
        Role role = roleService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role", role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

    @RequestMapping("/deleteRole.do")
    public String deleteById(String id) {
        System.out.println(id);
        roleService.deleteById(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(String id) {
        List<Permission> notInPermission = roleService.findNotInPermission(id);
        Role role = roleService.findById(id);
        for (Permission permission : notInPermission) {
            System.out.println(permission);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", notInPermission);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    @RequestMapping("/deleteAll.do")
    public String deleteAll(@RequestParam(name = "ids", required = false) String[] ids) {
        if (ids != null) {
            for (String id : ids) {
                System.out.println(id);
            }
            roleService.deleteAll(ids);
        }
        return "redirect:findAll.do";
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = false) String roleId, @RequestParam(name = "ids", required = false) String[] permissionId) {
        if (permissionId != null) {
            roleService.addPermission(roleId, permissionId);
        }
        return "redirect:findAll.do";
    }
}
