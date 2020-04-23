package com.xian.controller;

import com.xian.domain.Product;
import com.xian.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @RequestMapping(value = "/findAll")
    @RolesAllowed("ADMIN")
    public String findAll(Model model){
        List<Product> productList = productService.findAll();
        System.out.println(1111);
        model.addAttribute("productList",productList);
        return "product-list";
    }
    @RequestMapping(value = "/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll";

    }
}
