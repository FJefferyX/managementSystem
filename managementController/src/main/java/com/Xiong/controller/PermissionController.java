package com.Xiong.controller;

import com.Xiong.domain.Permission;
import com.Xiong.domain.Role;
import com.Xiong.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pagesize", required = true, defaultValue = "4") Integer pagesize) {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> all = permissionService.findAll(page, pagesize);
        PageInfo pageInfo = new PageInfo(all);
        List list = pageInfo.getList();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }
}
