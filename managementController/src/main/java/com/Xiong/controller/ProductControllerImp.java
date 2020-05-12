package com.Xiong.controller;

import com.Xiong.domain.Product;
import com.Xiong.service.ProductService;
import com.Xiong.utils.DateUtils;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

@Controller
@RequestMapping("/product")
public class ProductControllerImp {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pagesize", required = true, defaultValue = "4") Integer pagesize) {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> all = productService.findAll(page, pagesize);
        PageInfo pageInfo = new PageInfo(all);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String update(Product product) {
        String string = DateUtils.dateToString(new Date(), "yyyyMMddHHmmss");
        product.setId(string + product.getProductNum());
        System.out.println(product);
        productService.updateProduct(product);
        return "redirect:findAll.do";
    }
}
