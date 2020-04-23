package com.xian.controller;

import com.xian.domain.UserInfo;
import com.xian.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserService userService;
@RequestMapping(value = "/findAll")
    public String  findAll(Model model){
       List<UserInfo> user= userService.findAll();
       model.addAttribute("userList",user);
       return "user-list";
    }

    @RequestMapping(value = "/save")
    public String save(UserInfo user){
        userService.save(user);
        return "redirect:findAll";
    }

    @RequestMapping(value = "/findById")
    public String findById(@RequestParam(name = "id",required = true) String id,Model model){
        UserInfo user= userService.findById(id);
        model.addAttribute("user",user);
        return "user-show";

    }
}
