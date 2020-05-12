package com.Xiong.controller;

import com.Xiong.domain.Order;
import com.Xiong.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderControllerImp {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1", required = true) Integer page,
                                @RequestParam(name = "pagesize", defaultValue = "4", required = true) Integer pagesize) {
        ModelAndView modelAndView = new ModelAndView();
        List<Order> all = orderService.findAll(page, pagesize);
        PageInfo pageInfo = new PageInfo(all);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) {
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderService.findById(id);
        modelAndView.addObject("orders", order);
        modelAndView.setViewName("orders-show");
        System.out.println(order);
        System.out.println("_____________________________________________");
        System.out.println(order.getMember());
        System.out.println("_____________________________________________");
        System.out.println(order.getProduct());
        System.out.println("_____________________________________________");
        System.out.println(order.getTravellers());
        return modelAndView;
    }
}
